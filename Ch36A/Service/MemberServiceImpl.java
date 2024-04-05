package Ch36A.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Ch36A.Dao.MemberDao;
import Ch36A.Dao.SessionDaoImpl;
import Ch36A.Dao.member;
import Ch36A.Dao.session;
import Ch36A.Dto.MemberDto;
import Ch36A.Dto.SessionDto;


public class MemberServiceImpl implements memberService {
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private member dao;
	private List<Integer> SessionIDList;
	private session sessionDao;
	
	//싱클톤 적용
	private static memberService instance ;
	public static memberService getInstance() throws Exception {
		if(instance==null)
			instance=new MemberServiceImpl();
		return instance;
	}
	
	
	public MemberServiceImpl() throws Exception{
		System.out.println("MemberServiceImpl's");
		bCryptPasswordEncoder=new BCryptPasswordEncoder();
		dao=MemberDao.getInstance();
		sessionDao=SessionDaoImpl.getinstance();
		SessionIDList=new ArrayList();
		//접속중인 sessionid를 list 테이블에저장한다
		List<SessionDto>list=sessionDao.selectAll();
		for(SessionDto dto:list) {
			SessionIDList.add(dto.getSessionId());
		}
		
		
	}
	@Override
	public boolean memberJoin(MemberDto dto)throws Exception{
		
		//패스워드 암호화
		String encrpyt=bCryptPasswordEncoder.encode(dto.getPw());
		dto.setPw(encrpyt);
		return dao.insert(dto);
	}
	@Override
//	멤버 정보 업데이트
	public boolean memberUpdate(MemberDto dto)throws Exception{
		return dao.update(dto);
	}
	@Override
//	멤버정보 삭제하기
	public boolean memberDelete(MemberDto dto)throws Exception{
		return dao.delete(dto);
	}
	@Override
//	멤버정보 전체조회
	public List<MemberDto> getAllmembers()throws Exception{
		return dao.SelectAll();
	}
	@Override
//	멤버정보 단건조회
	public MemberDto getMember(int membercode)throws Exception{
		return dao.select(membercode);
	}
	
//	로그인
	public Map<String,Object> login(String username,String pw,int sessionId) throws Exception{
		Map<String,Object> result=new HashMap();

//		1.SessionList에 동일한 정보 확인
		for(int id:SessionIDList) {
			if(id==sessionId) {
				result.put("response", false);
				result.put("msg", "이미 해당계정은 로그인상태입니다.");
				return result;
			}
		}
//		2.로그인상태가 아니면 member테이블로 동일한 member 아이디를 가져온다
			MemberDto savedMember=getMember(username);
			if(savedMember==null) {
				result.put("response", false);
				result.put("msg", "동일 계정이 존재하지 않습니다.");
				return result;
			}
//			3.pw일치여부확인하기
			if(!bCryptPasswordEncoder.matches(pw, savedMember.getPw())) {
				result.put("response", false);
				result.put("msg", "Password가 일치하지 않습니다.");
				return result;
			}
//			4.pw일치한다면 session테이블에 세션정보를저장한다
			SessionDto sessionDto = new SessionDto();
			
//			Member.dto테이블에서 이름을가져온다.
			sessionDto.setName(savedMember.getName());
			sessionDto.setTellphone(savedMember.getTellphone());	
			boolean isSessionSaved =  sessionDao.insert(sessionDto);
			if(!isSessionSaved) {
				result.put("response", false);
				result.put("msg", "로그인 처리중 오류가 발생하였습니다.Session생성 실패..");
				return result;
			}
//			pw일치한다면 sessionList에 sessionId값을 저장한다
			Integer id=sessionDao.select(sessionDto.getName()).getSessionId();
			result.put("response", true);
			result.put("msg", "로그인 성공!");
			result.put("sessionId", id);
			SessionIDList.add(id);
			
		return result;
	}
//	로그아웃
	public Map<String,Object>logout(int sessionId) throws Exception{
		Map<String,Object>response=new HashMap();
//		1.seissionList에 id가있는지 확인하기
		boolean exist=SessionIDList.contains(sessionId);
		if(!exist) {
			response.put("response", false);
			response.put("msg", "현재 로그인된 상태가아닙니다");
			return response;
		}
		
//		2.Session테이블에서 dto를삭제
		boolean removed=sessionDao.Delete(sessionId);
		if(!removed) {
			response.put("response", false);
			response.put("msg", "시스템 상의 문제로 세션삭제가 불가합니다.");
			return response;
		}
//		3.list에서 sessionId를 제거한다
		boolean removed2=SessionIDList.remove(new Integer(sessionId));
		
//		로그아웃 성공
		response.put("response", true);
		response.put("msg", "로그아웃 성공!");
		
		return response;
	}

//유저 정보가져오기
	private MemberDto getMember(String username) throws Exception {
		// TODO Auto-generated method stub
		return dao.seleect(username);
	}
	//현재 접속중인 세션Id list 리턴
		@Override
		public List<Integer> getSessionIdList(){
			return SessionIDList;
		}
}
