package main.Service;

import java.util.List;

import main.Domain.JobDto;
import main.Domain.Dao.ConnectionPool;
import main.Domain.Dao.JobDaoImpl;

public class JobServiceImpl implements JobService {

	private JobDaoImpl dao;
	private ConnectionPool connectionPool; // 05-01Day

	private static JobService instance;

	public static JobService getInstance() throws Exception {
		if (instance == null)
			instance = new JobServiceImpl();
		return instance;
	}

	private JobServiceImpl() throws Exception {

		dao = JobDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean JobRegister(JobDto dto) throws Exception {

		// TX
		connectionPool.txStart(); // 05-01 Day TX
		boolean result = dao.Insert(dto); // 05-01 Day TX
		connectionPool.txCommit(); // 05-01 Day TX

		return result;
	};

	@Override
	public List<JobDto> getAllJobs() throws Exception {

		// TX
		connectionPool.txStart(); // 05-01 Day TX
		List<JobDto> list = dao.SelectAll(); // 05-01 Day TX
		connectionPool.txCommit(); // 05-01 Day TX
		return list;
	}

	@Override
	public JobDto getJob(int bookCode) throws Exception {

		JobDto dto = dao.Select(bookCode);

		return dto;
	}

}