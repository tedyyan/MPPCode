package lesson2.labs.prob4;

public class TranscriptEntry {
	Student student;
	public Student getStudent() {
		return student;
	}
	public Section getSection() {
		return section;
	}
	public String getGrade() {
		return grade;
	}
	Section section;
	String grade;
	TranscriptEntry(Student student,Section section,String grade){
		this.section =section;
		this.grade = grade;
		this.student = student;
	}
	public String toString() {
		return "Student: " + student.name + "\n"
				+ "Course name: " + section.courseName + "\n"
				+ "Section number: " + section.sectionNumber + "\n"
				+ "Grade: " + grade + "\n";
	}
}
