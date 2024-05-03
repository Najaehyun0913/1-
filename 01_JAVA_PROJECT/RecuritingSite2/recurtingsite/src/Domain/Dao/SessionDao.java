package Domain.Dao;

import java.util.List;

import Domain.Dto.SessionDto;

public interface SessionDao {

	//SESSION용
	boolean Insert(SessionDto sessionDto) throws Exception;

	SessionDto Select(int sessiondId) throws Exception;

	SessionDto Select(String username) throws Exception;

	boolean Delete(int sessionId) throws Exception;

	//SELECTALL
	List<SessionDto> SelectAll() throws Exception;

}