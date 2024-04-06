package Domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Domain.Dao.MemberDao;
import Domain.Dao.MemberDaoImpl;
import Domain.Dto.MemberDto;

public class MemberServiceImpl {
	
	private List<Integer> SessionIdList;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private MemberDao MemberDao;
	private SessionDao sessionDao;
	
	private static MemberService instance ;
	public static MemberService getInstance() throws Exception {
		if(instance==null)
			instance=new MemberServiceImpl();
		return instance;
	}
	
	private MemberServiceImpl() throws Exception {
		System.out.println("MemberServiceImpl's MemberServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		MemberDao = MemberDaoImpl.getInstance();
		sessionDao = SessionDaoImpl.getInstance();
		
		SessionIdList=new ArrayList();
		
		//접속중인 sessionid를 session테이블에서 list로 저장
		List<SessionDto> tmpList =sessionDao.SelectAll();
		for(SessionDto dto : tmpList) {
			SessionIdList.add(dto.getSessionId());
		}
		
			
		
	}
	
	//회원가입
	@Override
	public boolean MemberJoin(MemberDto dto) throws Exception {
		
		String encrypt= bCryptPasswordEncoder.encode(dto.getPassword());
		dto.setPassword(encrypt);
		boolean isJoined =  MemberDao.Insert(dto);
		
	 	return isJoined;
	}
	
	//로그인
	@Override
	public Map<String,Object> login(String name,String password,int SessiondId) throws Exception {
		
		Map<String,Object> result=new HashMap();
		
		for(int id : SessionIdList) {
			if(SessiondId==id) {
				result.put("response", false);
				result.put("msg", "이미 해당 계정은 로그인한 상태입니다.");
				return result;
			}
		}
		
		MemberDto savedMember =  getMember(name);
		if(savedMember==null) {
			result.put("response", false);
			result.put("msg", "동일 계정이 존재하지 않습니다.");
			return result;
		}
		
		//3 pw일치여부 확인
		if(!bCryptPasswordEncoder.matches(password, savedMember.getPassword())) {
			result.put("response", false);
			result.put("msg", "Password가 일치하지 않습니다.");
			return result;
		}
		
		//4 PW일치한다면 session테이블에 세션정보 저장
		SessionDto sessionDto = new SessionDto();
		sessionDto.setMembername(savedMember.getMembername());
		sessionDto.setRole(savedMember.getRole());
		boolean isSessionSaved =  sessionDao.Insert(sessionDto);
		if(!isSessionSaved) {
			result.put("response", false);
			result.put("msg", "로그인 처리중 오류가 발생하였습니다.Session생성 실패..");
			return result;
		}
		
		
		//5 PW일치한다면 sessionList에 sessionId값 저장
		Integer id =  sessionDao.Select(sessionDto.getMembername()).getSessionId();
		result.put("response", true);
		result.put("msg", "로그인 성공!");
		result.put("sessionId", id);
		SessionIdList.add(id);
		return result;
		
	}
	//로그아웃
	@Override
	public Map<String,Object> logout(int SessionId) throws Exception {
		
		Map<String,Object> response = new HashMap();
		
		//sessionList에 sessionId 있는지 확인
		boolean isExisted =  SessionIdList.contains(SessionId);
		if(!isExisted) {
			response.put("response", false);
			response.put("msg", "현재 로그인된 상태가 아닙니다.");
			return response;
		}
		

		// Session테이블에서 dto 삭제
		boolean isremoved =  sessionDao.Delete(SessionId);
		if(!isremoved) {
			response.put("response", false);
			response.put("msg","시스템 상의 문제로 세션삭제가 불가합니다.관리자에게 문의해주세요");
			return response;
		}
		// List에서 sessionId 제거
		boolean isremoved2 =  SessionIdList.remove(new Integer(SessionId));
		
		// 로그아웃 성공
		response.put("response", true);
		response.put("msg", "로그아웃성공!");
		
		return response;
	}
	
	//유저정보 가져오기
	@Override
	public MemberDto getMemberCode(String memberCode) throws Exception {
		return MemberDao.Select(memberCode);
	}
	
	
	//현재 접속중인 세션Id list 리턴
	@Override
	public List<Integer> getSessionIdList(){
		return SessionIdList;
	}
	
	
}
