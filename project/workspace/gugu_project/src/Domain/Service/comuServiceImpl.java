package Domain.Service;

import java.util.List;

import Domain.Dao.comuDaoImpl;
import Domain.Dto.BoardDto;
import Domain.Dto.comuDto;

public class comuServiceImpl {

	private comuDaoImpl dao;
	
	public comuServiceImpl() throws Exception {
		dao = new comuDaoImpl();
	}
	
	public boolean comuResister(comuDto dto, BoardDto bdto) throws Exception{
		return dao.Insert(dto, bdto);
	}
	
	public List<comuDto> getAllBooks() throws Exception{
		return dao.SelectAll();
	}
	
	public comuDto getBook(int comuCode) throws Exception{
		return dao.Select(comuCode); 
	}
}
