package Domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Domain.Dao.MemberDao;
import Domain.Dao.MemberDaoImpl;
import Domain.Dao.SessionDao;
import Domain.Dao.SessionDaoImpl;
import Domain.Dto.MemberDto;
import Domain.Dto.SessionDto;



public class MemberServiceImpl implements MemberService {
	
	private List<Integer> SessionList;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private MemberDao memberDao;
	private SessionDao sessionDao;
	
	private static MemberService instance;
	public static MemberService getInstance() throws Exception{
		if(instance==null)
			instance = new MemberServiceImpl();
		return instance;
	}
	
	private MemberServiceImpl() throws Exception{
		System.out.println("MemberServiceImpl's MemberServiceImpl()");
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		memberDao = MemberDaoImpl.getInstance();
		sessionDao = SessionDaoImpl.getInstance();
		
		SessionIdList = new ArrayList();
		
		//접속중인 sessionid를 session테이블에서 list로 저장
		List<SessionDto> tmplist = sessionDao.SelectAll();
		for(SessionDto dto : tmplist) {
			SessionIdList.add(dto.getSessionId());
		}
	}
	
	//회원가입
	@Override
	public boolean UserJoin(MemberDto dto) throws Exception{
		
		String encrypt = bCryptPasswordEncoder.encode(dto.getPw());
		dto.setPw(encrypt);
		
		return MemberDao.Insert(dto);
	}
	
	//로그인
	@Override
	public Map<String,Object> login(String name,String password,int SessionId) throws Exception{
		
		Map<String,Object> result = new HashMap();
		
		
		// 동일한 세션정보 유무 확인
		for(int id : SessionIdList) {
			if(SessionId==id) {
				result.put("response", false);
				result.put("msg", "이미 해당 계정은 로그인한 상태입니다..");
				return result;
			}
		
		//로그인 상태가 아니라면 user테이블로부터 동일한 이름 user정보 가져오기
		MemberDto savedMember = getMember(name);
		if(savedMember==null) {
			result.put("response", false);
			result.put("msg", "동일 계정이 존재하지 않습니다.");
			return result;
		}
		
		//pw 일치 여부 확인
		if(!bCryptPasswordEncoder.matches(password, savedMember.getPw()));
			result.put("response",false);
			result.put("msg","Password가 일치하지 않습니다.");
			return result;		
		}
		
		//pw 일치한다면 session테이블에 세션정보 저장
		SessionDto sessionDto = new SessionDto();
		sessionDto.setUsername(savedMember.getMembername());
		sessionDto.setRole(savedMember.getRole());
		boolean isSessionSaved = sessionDao.Insert(sessionDto);
		if(!isSessionSaved) {
			result.put("response", false);
			result.put("msg", "로그인처리중 오류발생.Session생성 실패");
			return result;
		}
		// pw일치한다면 sessionlist에 id값 저장
		Integer id = sessionDao.Select(SessionDto.getName()).getSessionId();
		result.put("response", true);
		result.put("msg", "로그인성공 !");
		result.put("sessionId", id);
		SessionIdList.add(id);
		return result;
			
	}
	//로그아웃
		@Override
		public Map<String,Object> logout(int SessionId) throws Exception {
			
			Map<String,Object> response = new HashMap();
			
			//1 sessionList에 sessionId 있는지 확인
			boolean isExisted =  SessionIdList.contains(SessionId);	
			//System.out.println("isExised : " + isExised);
			if(!isExisted) {
				response.put("response", false);
				response.put("msg", "현재 로그인된 상태가 아닙니다.");
				return response;
			}
			

			//2 Session테이블에서 dto 삭제
			boolean isremoved =  sessionDao.Delete(SessionId);
			if(!isremoved) {
				response.put("response", false);
				response.put("msg","시스템 상의 문제로 세션삭제가 불가합니다.관리자에게 문의해주세요");
				return response;
			}
			//3 List에서 sessionId 제거
			boolean isremoved2 =  SessionIdList.remove(new Integer(SessionId));
			
			//4 로그아웃 성공
			response.put("response", true);
			response.put("msg", "로그아웃성공!");
			
			return response;
		}

	
	@Override
	public MemberDto getMember(String name) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.select(name);
	}
	@Override
	public List<Integer> getSessionIdlist(){
		return SessionIdList;
	}
	
	
	
	
}
