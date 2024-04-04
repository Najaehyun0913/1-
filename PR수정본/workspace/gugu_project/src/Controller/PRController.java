package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Dto.PRDto;
import Domain.Service.PRService;
import Domain.Service.PRServiceImpl;
import Domain.Service.PRServicelmpl;


public class PRController implements SubController{
	
	private PRService service;
	public PRController() {
		try {
			service = new PRServiceImpl();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("BookController's execute()");
		
		if(serviceNo==1){
			PRDto dto=(PRDto)params.get("PRDto");
			System.out.println("[SC]PRController's Insert.."+dto);
		
			if( !isVaild(dto))
				return null;
		
			boolean isRegistred = false;
			try {
				isRegistred = service.PRRegister(dto);
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		Map<String,Object> result = new HashMap();
		result.put("respnse", isRegistred);
		}
		else if(serviceNo==2) //UPDATE
		{
			System.out.println("");
		}
		else if(serviceNo==3) //DELETE
		{
			System.out.println("");
		}
		else if(serviceNo==4) //SELECTALL
		{
			System.out.println("");
		}
		else if(serviceNo==5) 
		{
			System.out.println("");
		}
		
		return null;
	}
	private boolean isVaild(PRDto dto) {
		return true;
	}

}
