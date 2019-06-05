package business.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import business.LibraryMember;
import dataaccess.DataAccessFacade;

public class MemberBizService implements MemberBizServiceInterface {
	DataAccessFacade data = new DataAccessFacade();
	private static MemberBizService instance = new MemberBizService();

	private MemberBizService() {

	}

	public static MemberBizServiceInterface getInstance() {
		return instance;

	}

	public Collection<LibraryMember> FindPersonLikeByMemberID(String id) {
		
		List<LibraryMember> a = getLikeByMap(data.readMemberMap(), id);

		return a;

	}
	public LibraryMember FindPersonByMemberID(String id) {
		
		return data.readMemberMap().get(id);

	}
	public List<LibraryMember> getLikeByMap(Map<String, LibraryMember> map, String keyLike) {
		List<LibraryMember> list = new Vector<>();
		for (Map.Entry<String, LibraryMember> entity : map.entrySet()) {
			if (entity.getKey().indexOf(keyLike) > -1) {
				list.add((LibraryMember) entity.getValue());
			}

		}

		return list;
	}

	@Override
	public Collection<LibraryMember> getAllPersons() {
		
		return data.readMemberMap().values();
	}

	@Override
	public void removeMember(String id) {
		data.removeMemberMap(id);
		
	}

	@Override
	public void saveNewMember(LibraryMember person) {
		data.saveNewMember(person);
		
	}

}
