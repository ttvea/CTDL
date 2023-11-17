package tuan9;

import java.util.Objects;

public class Student {
	private String id;
	private String name;
	private int year;

	public Student(String id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", year=" + year + "]"+"\n";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
