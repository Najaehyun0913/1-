package Ch36A.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch36A.Dto.MemberDto;
import Ch36A.Service.MemberServiceImpl;
import Ch36A.Service.memberService;

public class Membercontroller implements SubController{
	private memberService service;
	
	public Membercontroller() {
		try {
			service=new MemberServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		// TODO Auto-generated method stub
//		파라미터 받기
		System.out.println("MemberController's execute");
		if(serviceNo==1) 
		{
			//insert
			MemberDto dto=(MemberDto)params.get("MemberDto");
			System.out.println("[sc]MemberController's insert.."+dto);
			
//			2.유효성체크
			if( !isValid(dto) ) 
				return null;
//			3.서비스 실행
			boolean isREgistred=false;
			try {
				isREgistred=service.memberJoin(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 전달 or 이동
			Map<String,Object> result=new HashMap();
			result.put("response", isREgistred);
		}

		else if(serviceNo==2) {
			//Update
			MemberDto dto=(MemberDto)params.get("MemberDto");
			System.out.println("[sc]MemberController's update.."+dto);
//			2.유효성체크
			if( !isValid(dto) ) 
				return null;
//			3.서비스 실행
			boolean isREgistred=false;
			try {
				isREgistred=service.memberUpdate(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 전달 or 이동
			Map<String,Object> result=new HashMap();
			result.put("response", isREgistred);
			
		}else if(serviceNo==3) {
			//delete
			MemberDto dto=(MemberDto)params.get("MemberDto");
			System.out.println("[sc]MemberController's delete.."+dto);
//			2.유효성체크
			if( !isValid(dto) ) 
				return null;
//			3.서비스 실행
			boolean isREgistred=false;
			try {
				isREgistred=service.memberDelete(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 전달 or 이동
			Map<String,Object> result=new HashMap();
			result.put("response", isREgistred);
			
		}else if(serviceNo==4) {
			//select all
			//select all
			MemberDto dto=(MemberDto)params.get("MemberDto");
			System.out.println("[sc]MemberController's selectAll.."+dto);
//			2.유효성체크
			if( !isValid(dto) ) 
				return null;
//			3.서비스 실행
			List<MemberDto> isREgistred=new ArrayList();
			try {
				isREgistred=service.getAllmembers();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 전달 or 이동
			Map<String,Object> result=new HashMap();
			result.put("response", isREgistred);
			//selectAll
		}else if(serviceNo==5) {
//			MemberDto dto=(MemberDto)params.get("MemberDto");
//			System.out.println("[sc]MemberController's update.."+dto);
////			2.유효성체크
//			if( !isValid(dto) ) 
//				return null;
////			3.서비스 실행
//			boolean isREgistred=false;
//			try {
//				isREgistred=service.getMember(dto);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////			4.뷰로 전달 or 이동
//			Map<String,Object> result=new HashMap();
//			result.put("response", isREgistred);
			//selectOne
		}else if(serviceNo==6) {
//			1.파라미터받기
			String username=(String)params.get("username");
			String password=(String) params.get("password");
			Integer sessionId=(Integer) params.get("id");
//			2.데이터 입력값 검증
			if(!isValid(username,password,sessionId)) {
				return null;
			}
//			3.서비스 검증
			Map<String,Object> response=new HashMap();
			try {
				service.login(username, password, serviceNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 이동
			System.out.println("로그인성공");
			return response;
			
		}else if(serviceNo==7) {
//			1.파라미터받기
			Integer sessionId=(Integer) params.get("sessionId");
			
//			2.입력값 검증
			Map<String,Object> response=null;
			if(!isValid(sessionId)) {
				response.put("response", false);
				response.put("msg", "Data Validation check error.. ");
				return response;
			}
//			3.서비스 검증
			try {
				service.logout(sessionId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			4.뷰로 이동
			System.out.println("로그아웃 성공");
			return response;
			
		}
			
		
		return null;
	}
	private boolean isValid(Integer sessionId) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isValid(String username, String password, Integer sessionId) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isValid(MemberDto dto) {
		return false;
	}
}
