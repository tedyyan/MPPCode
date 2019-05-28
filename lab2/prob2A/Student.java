package mpp.gourp2.lab2.prob2A;

class Student{
	private String name;
	private GradeReport gradeReport;

	public Student(String name){
		this.name = name;
		this.gradeReport = new GradeReport(this);
	}

}
