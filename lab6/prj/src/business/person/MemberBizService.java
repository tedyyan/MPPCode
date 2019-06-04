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

	public Collection<LibraryMember> FindPersonByMemberID(String id) {
		
		Collection<LibraryMember> rr = new ArrayList<LibraryMember>();
		List<LibraryMember> a = getLikeByMap(data.readMemberMap(), id);

		return a;

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

}
