package Domain.Dao;

import java.util.List;

import Ch36.Domain.Dto.SessionDto;

public interface SessionDao {

	//SESSION용
	boolean Insert(Domain.Dto.SessionDto sessionDto) throws Exception;

	Domain.Dto.SessionDto Select(int sessiondId) throws Exception;

	Domain.Dto.SessionDto Select(String username) throws Exception;

	boolean Delete(int sessionId) throws Exception;

	//SELECTALL
	List<Domain.Dto.SessionDto> SelectAll() throws Exception;

}