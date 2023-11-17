package tuan9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> listCourse;

	public Faculty(String name, String address, List<Course> listCourse) {
		this.name = name;
		this.address = address;
		this.listCourse = listCourse;
	}

	public Course getMaxPracticalCourse() {
		int max=0;
		Course result=null;
		for(Course c:listCourse) {
			if(c.getList().size()>=max) {
				max=c.getList().size();
				result=c;
			}
		}
		return result;
	}
	 public Set<Course> filterCourses(String type){
		 Set<Course>tree=new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				return o2.getList().size()-o1.getList().size();
			}
		}
		 );
		for(Course c:listCourse) {
			if(c.getType().equals(type)) {
				tree.add(c);
			}
		}
		 
		 return tree;
	 }
	public Map<Integer, List<Student>> groupStudentsByYear(){
		Map<Integer,List<Student>>map=new HashMap<>();
		for(Course c:listCourse) {
			Map<Integer,List<Student>>mapThongKe=c.createMap();//tạo 1 map bằng cái map đã thống kê
			Set<Map.Entry<Integer,List<Student>>>set=mapThongKe.entrySet();//tạo 1 cái set lưu cặp key-value
			for(Map.Entry<Integer,List<Student>>m:set) {	
				List<Student>list=m.getValue();//gán bằng cái list student đã phân loại
				if(map.containsKey(m.getKey())) {
//					list.addAll(map.get(m.getKey()));//chứa rồi thì lấy cái value trong map add vô
					for(Student s:map.get(m.getKey())) {//xu li neu 1 sinh vien dk 2 mon 
						if(!list.contains(s)) {
							list.add(s);
						}
					}
				}
				map.put(m.getKey(), list);
				
			}
		}
		
		
		return map;
	}
	public static void main(String[] args) {
		Student s1=new Student("A","Nguyen Van A",2004);
		Student s2=new Student("B","Nguyen Van B",2003);
		Student s3=new Student("C","Nguyen Van C",2004);
		List<Student>listStudent=new ArrayList<>();
		listStudent.add(s1);
		listStudent.add(s2);
		listStudent.add(s3);
		
		
		Student s5=new Student("E","Nguyen Van E",2002);
		
		List<Student>listStudent2=new ArrayList<>();
		listStudent2.add(s3);
		listStudent2.add(s5);
		listStudent2.add(s2);
		
		//Course
		Course c1=new Course("12","ToanA2","A", listStudent,"NguyenA");
		Course c2=new Course("13","ToanA3","A", listStudent2,"NguyenB");
		List<Course>listCourse=new ArrayList<>();
		listCourse.add(c1);
		listCourse.add(c2);
		
		Faculty f=new Faculty("Toan","NLU", listCourse);
//		System.out.println(f.getMaxPracticalCourse());
		System.out.println(f.groupStudentsByYear());
//		System.out.println(f.filterCourses("A"));
	}

}
