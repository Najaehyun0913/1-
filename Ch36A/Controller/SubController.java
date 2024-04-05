package Ch36A.Controller;

import java.util.Map;

public interface SubController {

//	파라미터를 맵으로 받기는하는데 key벨류형태로 받겠다.objcet에 관련 api들이 다들어갈수다.
//	1.insert 2.update 3.delete 4. selectALl 5.select 기본적인 crud를 serviceNo으로받겠다.
	Map<String,Object> execute(int serviceNo,Map<String,Object> params);
}
