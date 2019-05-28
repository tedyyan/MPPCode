package lesson2.labs.prob4;

import java.util.*;

public class Student {
	String id;
	String name;
	List<TranscriptEntry> grades;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<TranscriptEntry> getGrades() {
		return grades;
	}
	Student(String name, String id){
		this.name = name;
		this.id = id;
		grades = new ArrayList<TranscriptEntry>();
	}
	public Transcript getTranscript() {
		return new Transcript(grades);
		
	}
	
}
