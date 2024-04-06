package Domain.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Domain.Dao.MemberDao;
import Domain.Dao.MemberDaoImpl;
import Domain.Dao.SessionDao;
import Domain.Dto.MemberDto;
import Domain.Dto.SessionDto;


public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao;
	private List<Integer> SessionIdList;
	private MemberDao memberDao;
	private SessionDao sessionDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//싱클톤 적용
	private static MemberService instance ;
	public static MemberService getInstance() throws Exception {
		if(instance==null)
			instance=new MemberServiceImpl();
		return instance;
	}
	
	
	public MemberServiceImpl() throws Exception{
		dao=new MemberDaoImpl();
	}
	@Override
	public boolean memberInsert(MemberDto dto)throws Exception{
		return dao.insert(dto);
	}
	@Override
	public boolean memberUpdate(MemberDto dto)throws Exception{
		return dao.update(dto);
	}
	@Override
	public boolean memberDelete(MemberDto dto)throws Exception{
		return dao.delete(dto);
	}
	@Override
	public List<MemberDto> getAllmembers()throws Exception{
		return dao.SelectAll();
	}
	@Override
	public MemberDto getMember(int membercode)throws Exception{
		return dao.select(membercode);
	}

		
		//로그인
		@Override
		public Map<String,Object> login(int membercode,String password,int SessiondId) throws Exception {
			
			
			//TX 05-02
			
			Map<String,Object> result=new HashMap();
			
			//1 SessionList에 동일한 세션정보가 있는지 확인
			for(int id : SessionIdList) {
				if(SessiondId==id) {
					result.put("response", false);
					result.put("msg", "이미 해당 계정은 로그인한 상태입니다.");
					return result;
				}
			}
			
			//2 로그인 상태가 아니라면 user테이블로부터 동일한 이름의 user정보를 가져오기(getUser())
			MemberDto savedUser =  getMemberCode(membercode);
			if(savedUser==null) {
				result.put("response", false);
				result.put("msg", "동일 계정이 존재하지 않습니다.");
				return result;
			}
			
			//3 pw일치여부 확인
			if(!bCryptPasswordEncoder.matches(password, savedUser.getPw())) {
				result.put("response", false);
				result.put("msg", "Password가 일치하지 않습니다.");
				return result;
			}
			
			//4 PW일치한다면 session테이블에 세션정보 저장
			SessionDto sessionDto = new SessionDto();
			sessionDto.setName(savedUser.getName());
			sessionDto.setRole(savedUser.getRole());
			boolean isSessionSaved =  sessionDao.Insert(sessionDto);
			if(!isSessionSaved) {
				result.put("response", false);
				result.put("msg", "로그인 처리중 오류가 발생하였습니다.Session생성 실패..");
				return result;
			}
			
			
			//5 PW일치한다면 sessionList에 sessionId값 저장
			Integer id =  sessionDao.Select(sessionDto.getName()).getSessionId();
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
		
		//유저정보 가져오기
		@Override
		public MemberDto getMemberCode(int MemberCode) throws Exception {
			return memberDao.select(MemberCode);
		}
		
		
		//현재 접속중인 세션Id list 리턴
		@Override
		public List<Integer> getSessionIdList(){
			return SessionIdList;
		}
		
}
