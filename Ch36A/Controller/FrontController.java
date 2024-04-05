package Ch36A.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
	private Map<String,SubController> map=new HashMap();
	public FrontController(){
		System.out.println("FrontController()");
		init();
	}
	private void init(){
		System.out.println("FrontController's init()");
//		요청 API들을 미리 저장을해야함
//		/book-BookController
//		/member-MemberController
//		/lend -LendController
		map.put("/member", new Membercontroller());
		
	}
	public Map<String,Object> execute(String url,int serviceNo,Map<String,Object> params){
		System.out.println("FrontController's execute");
		SubController controller=map.get(url);
		return controller.execute(serviceNo, params);
}
}
