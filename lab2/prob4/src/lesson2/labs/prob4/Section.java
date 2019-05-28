package lesson2.labs.prob4;

import java.util.*;

public class Section {
	String courseName;
	int sectionNumber;
	List<TranscriptEntry> gradeSheet;

	public String getCourseName() {
		return courseName;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public List<TranscriptEntry> getGradeSheet() {
		return gradeSheet;
	}

	Section(String courseName,int sectionNumber){
		this.sectionNumber = sectionNumber;
		this.courseName = courseName;
		gradeSheet = new ArrayList<TranscriptEntry>();
	}
}
