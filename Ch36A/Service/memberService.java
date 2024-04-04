package Ch36A.Service;

import java.util.List;

import Ch36A.Dto.MemberDto;

public interface memberService {

	boolean memberJoin(MemberDto dto) throws Exception;

	boolean memberUpdate(MemberDto dto) throws Exception;

	boolean memberDelete(MemberDto dto) throws Exception;

	List<MemberDto> getAllmembers() throws Exception;

	MemberDto getMember(int membercode) throws Exception;

}