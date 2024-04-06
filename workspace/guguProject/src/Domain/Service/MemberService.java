package Domain.Service;

import java.util.List;

import Domain.Dto.MemberDto;

public class MemberService {


	boolean memberInsert(MemberDto dto) throws Exception;

	boolean memberUpdate(MemberDto dto) throws Exception;

	boolean memberDelete(MemberDto dto) throws Exception;

	List<MemberDto> getAllmembers() throws Exception;

	MemberDto getMember(int membercode) throws Exception;

}
