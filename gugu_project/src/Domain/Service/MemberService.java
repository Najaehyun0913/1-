package Domain.Service;

import java.util.List;
import java.util.Map;

import Domain.Dto.MemberDto;

public interface MemberService {

	//회원가입
	boolean UserJoin(MemberDto dto) throws Exception;

	//로그인
	Map<String, Object> login(String name, String password, int SessionId) throws Exception;

	//로그아웃
	Map<String, Object> logout(int SessionId) throws Exception;

	MemberDto getMember(String name) throws Exception;

	List<Integer> getSessionIdlist();

}