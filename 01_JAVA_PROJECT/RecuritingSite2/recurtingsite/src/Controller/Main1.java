package Controller;

import java.util.Map;

import Domain.Dao.MemberDaoImpl;
import Domain.Service.MemberServiceImpl;

public class Main1 {
    public static void main(String[] args) throws Exception {
//	 ===================================Insert=============================================
// 	 	AD 테이블의 데이터 삽입
//    	ADDaoImpl dao = new ADDaoImpl();
//     	dao.Insert(new ADDto(1, "코리아it", "30,000", "복지없음...", "A"));
    	 
//		Apply 테이블의 데이터 삽입
//      ApplyDaoImpl dao = new ApplyDaoImpl();
//      dao.Update(new ApplyDto(1, false));
    	
//      PR 테이블의 데이터 삽입 
//    	PRDaoImpl dao = new PRDaoImpl();
////    	dao.Insert(new PRDto(300, "A", "B", "C"));
//    	dao.Insert(new PRDto(6000, "aa", "cc", "dd"));

//    	Member 테이블의 데이터 삽입
    	MemberDaoImpl dao  = new MemberDaoImpl();
//    	dao.insert(new MemberDto(300,"a","b","c","d","e"));
    	
 // 	Comu 테이블의 데이터 삽입
//    	ComuDaoImpl dao = new ComuDaoImpl();
//    	dao.Insert(new ComuDto(4,"m","b","s", "c" ));
    	
//    	Comment 테이블의 데이터 삽입
//    	CommentDaoImpl dao = new CommentDaoImpl();
//    	dao.Insert(new CommentDto(5,"a","b"));
    	
//  ===================================Update=============================================
//    	AD 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> db에 등록된 adNum를 1을 조건으로 잡고, 나머지의 내용을 바로밑에 내용으로 수정하였고 실행 후 업데이트된걸 확인
//    	dao.Update(new ADDto(1,"yto아카데미","40000", "복지있습니다.", "B"));

//    	Apply 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> applyCode의 applyclassify false값인 0이었지만 업데이트를 (1,true)로 한 후 db에 1로 변경확인
//      dao.Update(new ApplyDto(1, true)); 
    	
//    	PR 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> db에 등록된 PRnum를 6000을 조건으로 잡고, 나머지의 내용 info, edu, carrer을 수정하였고 변경확인
//    	dao.Update(new PRDto(6000, "ee","ff","ee"));
    	
//     	Member 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> db에 등록된 MemberCode를 200을 조건으로 잡고, 나머지의 내용을 소문자에서 -> 대문자로 수정하였고 실행 후 업데이트된걸 확인
//    	dao.update(new MemberDto(200,"A","B","C","D","E"));
    	
//    	Comu 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> db에 등록된 Comucode를 4을 조건으로 잡고, 나머지의 내용을 바로밑에 내용으로 수정하였고 실행 후 업데이트된걸 확인
//    	dao.Update(new ComuDto(4,"A","B","C","D"));
    	
//    	Comment 테이블 업데이트 (객체는 Insert에서 사용한 객체를 사용)
//    	=> db에 등록된 Comucode를 4을 조건으로 잡고, 나머지의 내용을 바로밑에 내용으로 수정하였고 실행 후 업데이트된걸 확인
//    	dao.Update(new CommentDto(4,"A","B"));
    	
//  ===================================Delete=============================================
//    	AD 테이블 삭제 
//    	=>
    	
    	
    	//09
		MemberServiceImpl service = new MemberServiceImpl();
//		service.UserJoin(new UserDto("user1","1234","ROLE_USER",false));
		
		//로그인실패 : 존재하지 않는계정
		Map<String,Object> islogin1= service.login(123,"1234",0 );
		System.out.println("islogin1 : " + islogin1);
		
//		//로그인실패 : 계정은 존재,패스워드 일치
//		Map<String,Object>  islogin2= service.login("user2","1235", 0);
//		System.out.println("islogin2 : " + islogin2);
//		
//		//로그인성공 : 계정은 존재하나 패스워드 불일치
//		Map<String,Object>  islogin3= service.login("user3","1234", 0);
//		System.out.println("islogin3 : " + islogin3);
//		Integer mySessionId = (Integer)islogin3.get("sessionId");
//		
//		//로그인실패 : 기존 로그인된 계정이 존재
//		Map<String,Object>  islogin4= service.login("user2","1234", mySessionId);
//		System.out.println("islogin4 : " + islogin4);
		
//		Map<String,Object>  isLogout01= service.logout(30);
//		System.out.println("isLogout01 :" + isLogout01);
    }
}

