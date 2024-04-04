package main.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	private Map<String, SubController> map = new HashMap();

	public FrontController() {
		System.out.println("FrontController()");
		init();
	}

	private void init() {
		System.out.println("FrontController's init()");
		map.put("/job", new jobController());
	}

	public Map<String, Object> execute(String uri, int ServiceNo, Map<String, Object> params) {
		System.out.println("FrontController's execute()");
		SubController controller = map.get(uri);
		return controller.execute(ServiceNo, params);
	}

}