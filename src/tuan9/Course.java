package tuan9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> list;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> list, String lecturer) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.list = list;
		this.lecturer = lecturer;
	}
	public Map<Integer, List<Student>> createMap(){
		Map<Integer,List<Student>>map=new HashMap<>();
		for(Student s:list) {
			List<Student>listNew=new ArrayList<>();
			if(map.containsKey(s.getYear())) {
				listNew=map.get(s.getYear());
			}
			listNew.add(s);
			map.put(s.getYear(), listNew);
		}
		
		return map;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", type=" + type + ", list=" + list + ", lecturer=" + lecturer
				+ "]"+"\n";
	}

}
