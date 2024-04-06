package Domain.Service;

import java.util.List;
import java.util.Map;

import Domain.Dto.MemberDto;

public interface MemberService {

	boolean memberInsert(MemberDto dto) throws Exception;

	boolean memberUpdate(MemberDto dto) throws Exception;

	boolean memberDelete(MemberDto dto) throws Exception;

	List<MemberDto> getAllmembers() throws Exception;

	MemberDto getMember(int membercode) throws Exception;

	//회원가입
//	boolean MemberJoin(MemberDto dto) throws Exception;

	//로그인
	Map<String, Object> login(int MemberCode, String password, int SessiondId) throws Exception;

	//로그아웃
	Map<String, Object> logout(int SessionId) throws Exception;

	//유저정보 가져오기
	MemberDto getMemberCode(int MemberCode) throws Exception;

	//현재 접속중인 세션Id list 리턴
	List<Integer> getSessionIdList();
}