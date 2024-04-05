package Domain.Service;

import java.util.List;

import Domain.Dto.PRDto;

public interface PRService {

	boolean PRRegister(PRDto dto) throws Exception;

	List<PRDto> getAllPR() throws Exception;

	PRDto getPR(int PRInfo) throws Exception;

}