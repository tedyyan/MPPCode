package mpp.gourp2.lab2.prob2A;

class GradeReport{
	private String grade;
	private Student student;

	GradeReport(Student student){
		this.student = student;
	}

	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}
}
