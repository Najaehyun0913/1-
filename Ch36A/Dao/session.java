package Ch36A.Dao;

import java.util.List;

import Ch36A.Dto.SessionDto;

public interface session {

	//	session 용 insert
	boolean insert(SessionDto dto) throws Exception;

	//	session 용 select id로 찾기
	SessionDto select(int sessionid) throws Exception;
	
//	Session용 select로 username으로찾기
	SessionDto select(String username) throws Exception;

	boolean Delete(int sessionId)throws Exception;
	//	selcet All 
	List<SessionDto> selectAll() throws Exception;
	//	session 로그아웃시 delete 삭제용 
	

}