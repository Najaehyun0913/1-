package Ch36A.main;

import java.util.HashMap;
import java.util.Map;

import Ch36A.Controller.FrontController;
import Ch36A.Dao.MemberDao;
import Ch36A.Dto.MemberDto;
import Ch36A.Service.MemberServiceImpl;

public class Main {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
//		FrontController frontController=new FrontController();
//		Map<String,Object>parmas=new HashMap();
//		parmas.put("MemberDto", new MemberDto(2,"yws078","1234","이동환", "yws078@naver.com", "010-8600-0787"));
//		frontController.execute("/member",1,parmas);
//		System.out.println();
		
//		memberdb에 정보 삽입
		MemberDao dao=new MemberDao();
//		dao.insert(new MemberDto(1,"yws078","1234","이동환", "yws078@naver.com", "010-8600-0787","일반회원"));
//		dao.insert(new MemberDto(2,"yw","1114","김동환", "rock78@naver.com", "010-1234-0787","일반회원"));
//		dao.insert(new MemberDto(3,"078","1324","지동환", "yws078@daum.com", "010-5678-0787","일반회원"));
//		dao.insert(new MemberDto(4,"asdf","1dfs","김흥국", "78@daum.com", "010-123478-0787","관리자"));
		

//		Memberdb에 정보 변경
//		dao.update(new MemberDto(2, "alight", "7423", "박재훈", "allihght@naver.com", "010-1234-1441"));
		
//		MemberDb에 정보삭제
//		dao.delete(new MemberDto(2,"asdf","1dfs","김흥국", "78@daum.com", "010-123478-0787"));
//		MemberServiceImpl service=new MemberServiceImpl();
//		service.memberDelete(new MemberDto(1,"yws078","1234","이동환", "yws078@naver.com", "010-8600-0787"));
		
//		Memberdb에 저장된 정보들 전부 뽑아오기
//		List<MemberDto>list =dao.SelectAll();
//		list.forEach(a->{
//			System.out.println(a);
//		});

//		프론트컨트롤러에서 파라미터를 받아 정보 입력
//		FrontController frontController=new FrontController();
//		Map<String,Object>parmas=new HashMap();
//		parmas.put("MemberDto", new MemberDto(6,"asdf","1dfs","김흥국", "78@daum.com", "010-123478-0787"));
//		Map<String,Object> result=frontController.execute("/member", 1, parmas);
		
//		서비스 컨트롤러에서 비밀번호를 암호화해서 정보가 기입
		MemberServiceImpl service=new MemberServiceImpl();
//		service.memberJoin(new MemberDto(5,"yws078","991023","상동환", "yws078@naver.com", "010-8600-0787","일반회원"));
		
//		로그인성공 
//		Map<String,Object>islogin1=service.login("상동환", "991023", 0);
//		System.out.println("isLogin:"+islogin1);
		
//		로그인 실패 -패스워드가 잘못입력됐을때
//		Map<String,Object>isLogin2=service.login("상동환", "991023", 0);
//		System.out.println("isLogin2:"+isLogin2);
//		
//		로그아웃 (sessionid)를 입력시 해당 id가 로그아웃됩니다.
//		Map<String,Object> islogout01=service.logout(18);
//		System.out.println("islogout01:"+islogout01);
		
//		프론트 컨트롤러로 입력을했을때 로그인이되는 서비스
		FrontController frontController=new FrontController();
		Map<String,Object>parmas=new HashMap();
//		parmas.put("username", "상동환");
//		parmas.put("password", "991023");
//		parmas.put("id", 0);
//		frontController.execute("/member", 6, parmas);
		
//		프론트 컨트롤러에 sessionId를 입력을하면은 로그아웃되는 서비스
		parmas.put("sessionId", 5);
		frontController.execute("/member", 7, parmas);
		
	}

}
