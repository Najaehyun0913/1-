package main;

import main.Domain.JobDto;
import main.Domain.Dao.JobDaoImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		JobDaoImpl dao = JobDaoImpl.getInstance();
		JobDto dto = new JobDto(5, true);
		dao.Insert(dto);

	}

}
