package main.Service;

import java.util.List;

import main.Domain.JobDto;

public interface JobService {

	boolean JobRegister(JobDto dto) throws Exception;

	List<JobDto> getAllJobs() throws Exception;

	JobDto getJob(int applyCode) throws Exception;

}