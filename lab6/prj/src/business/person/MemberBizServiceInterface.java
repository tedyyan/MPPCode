package business.person;

import java.util.Collection;

import business.LibraryMember;

public interface MemberBizServiceInterface {
	public Collection<LibraryMember> FindPersonByMemberID(String id);
	public Collection<LibraryMember> getAllPersons();
}
