package lesson2.labs.prob4;

public class StudentSectionFactory {
	private static StudentSectionFactory instance = new StudentSectionFactory();
	
	public static StudentSectionFactory getInstance() {
		return instance;
	}
	
	public Section createSection(int secNum, String courseName) {
		return new Section(courseName,secNum);
		
	}
	
	public Student createStudent(String id, String name) {
		return new Student(name,id);
		
	}
	public void newTranscriptEntry(Student s, Section sect, String grade) {
		if(s==null) return;
		if(sect==null) return;
		if(grade==null) return;
		
		TranscriptEntry entry = new TranscriptEntry(s, sect, grade);
		s.grades.add(entry);
		sect.gradeSheet.add(entry);
	}

}
