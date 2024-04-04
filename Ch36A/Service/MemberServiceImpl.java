package Ch36A.Service;

import java.util.List;

import Ch36.Domain.Service.UserService;
import Ch36.Domain.Service.UserServiceImpl;
import Ch36A.Dao.MemberDao;
import Ch36A.Dao.member;
import Ch36A.Dto.MemberDto;


public class MemberServiceImpl implements memberService {
	
	private member dao;
	
	//싱클톤 적용
	private static memberService instance ;
	public static memberService getInstance() throws Exception {
		if(instance==null)
			instance=new MemberServiceImpl();
		return instance;
	}
	
	
	public MemberServiceImpl() throws Exception{
		dao=new MemberDao();
	}
	@Override
	public boolean memberJoin(MemberDto dto)throws Exception{
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
}
