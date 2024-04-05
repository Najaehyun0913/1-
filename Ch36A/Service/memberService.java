package Ch36A.Service;

import java.util.List;
import java.util.Map;

import Ch36A.Dto.MemberDto;

public interface memberService {

	boolean memberJoin(MemberDto dto) throws Exception;

	boolean memberUpdate(MemberDto dto) throws Exception;

	boolean memberDelete(MemberDto dto) throws Exception;

	
//	로그인
	Map<String,Object>login(String username,String pw,int sessionId) throws Exception;
	
	Map<String,Object>logout(int sessionId) throws Exception;
	
	List<MemberDto> getAllmembers() throws Exception;

	MemberDto getMember(int membercode) throws Exception;

	List<Integer> getSessionIdList();


}