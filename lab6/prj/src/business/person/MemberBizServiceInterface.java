package business.person;

import java.util.Collection;

import business.LibraryMember;

public interface MemberBizServiceInterface {
	public LibraryMember FindPersonByMemberID(String id);
	public Collection<LibraryMember> getAllPersons();
	public Collection<LibraryMember> FindPersonLikeByMemberID(String id);
	public void removeMember(String id);
}
