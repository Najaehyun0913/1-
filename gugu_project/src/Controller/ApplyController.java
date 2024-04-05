package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Dto.ApplyDto;

public class ApplyController implements SubController {

	// 1 Insert , 2 Update , 3 Delete 4 SelectAll 5 Select

	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		System.out.println("applyController's execute()");

		if (serviceNo == 1) { // Insert

			// 1
			ApplyDto dto = (ApplyDto) params.get("jobDto");
			System.out.println("[SC]BookController's Insert.." + dto);

			// 2
			if (!isValid(dto))
				return null;

			Map<String, Object> result = new HashMap();

		} else if (serviceNo == 2) { // Update
			ApplyDto dto = (ApplyDto) params.get("jobDto");
			System.out.println("[SC]BookController's Update.." + dto);

			if (!isValid(dto))
				return null;

			Map<String, Object> result = new HashMap();
		} else if (serviceNo == 3) { // Delete
			ApplyDto dto = (ApplyDto) params.get("jobDto");
			System.out.println("[SC]BookController's Delete.." + dto);

			if (!isValid(dto))
				return null;

			Map<String, Object> result = new HashMap();
			System.out.println("");
		} else if (serviceNo == 4) { // SELECTALL

			System.out.println("");
		} else if (serviceNo == 5) // SELECTONE
		{
			System.out.println("");
		} else {
			System.out.println("");
		}

		return null;
	}

	private boolean isValid(ApplyDto dto) {
		// Null체크
		// trim제거

		return true;
	}

}
