package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Dto.BoardDto;
import Domain.Dto.comuDto;
import Domain.Service.comuServiceImpl;

public class ComuController implements SubController{

	private comuServiceImpl service;
	public ComuController() {
		try {
			service = new comuServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select 
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("ComuController's execute()");
		
		//1 파라미터 받기
		//2 입력값 검증(유효성체크(데이터), Validation Check)
		//3 서비스 실험
		//4 뷰페이지로 이동(or Rest Data 전달)
		
		if(serviceNo==1) { // insert
			
			//1
			comuDto dto = (comuDto)params.get("comuDto");
			BoardDto bdto = (BoardDto)params.get("BoardDto");
			System.out.println("[SC]ComuController's Insert.."+dto);
			//2
			if( isVaild(dto)) {
				return null;
			}
			//3 서비스 실행
			boolean isRegistred = false;
			
			try {
				isRegistred = service.comuResister(dto, bdto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4 뷰로 전달 or 이용
			Map<String, Object> result = new HashMap();
			result.put("response", isRegistred); 
			
		}else if(serviceNo==2) { // update
			System.out.println("");			
		}else if(serviceNo==3) { // delete
			System.out.println("");
		}else if(serviceNo==4) { // selectall
			System.out.println("");
		}else if(serviceNo==5){ // selectone
			System.out.println("");
		}else {
			System.out.println("");
		}
		
		return null;
	}
	
	private boolean isVaild(comuDto dto) {
		// Null 체크
		// trim 제거 (앞뒤 공백 제거)
		
		
		return true; // 일단 체크안하고 통과
	}
}
