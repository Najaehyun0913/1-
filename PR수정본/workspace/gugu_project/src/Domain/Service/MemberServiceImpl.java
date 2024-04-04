package Domain.Service;

import java.util.List;

import Domain.Dao.MemberDao;
import Domain.Dto.MemberDto;


public class MemberServiceImpl {
	
	private MemberDao dao;
	public MemberServiceImpl() throws Exception{
		dao=new MemberDao();
	}
	public boolean memberRegister(MemberDto dto)throws Exception{
		return dao.insert(dto);
	}
	public boolean memberUpdate(MemberDto dto)throws Exception{
		return dao.update(dto);
	}
	public boolean memberDelete(MemberDto dto)throws Exception{
		return dao.delete(dto);
	}
	public List<MemberDto> getAllmembers()throws Exception{
		return dao.SelectAll();
	}
	public MemberDto getMember(int membercode)throws Exception{
		return dao.select(membercode);
	}
}
