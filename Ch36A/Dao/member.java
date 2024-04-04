package Ch36A.Dao;

import java.util.List;

import Ch36A.Dto.MemberDto;

public interface member {

	//	insert
	boolean insert(MemberDto dto) throws Exception;

	//		update
	boolean update(MemberDto dto) throws Exception;

	//		Delete
	boolean delete(MemberDto dto) throws Exception;

	//		SelectAll
	List<MemberDto> SelectAll() throws Exception;

	//		selectOne
	MemberDto select(int membercode) throws Exception;

}