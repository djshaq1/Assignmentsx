

import java.util.List;


public class mainline {

	public static void main(String[] args) {
		try {
			students students = new students();
			student studentJones = students.get(100);
			//System.out.println(student);
			
			studentJones.firstName = "James";
			students.update(studentJones);
			studentJones = students.get(100);
			System.out.println(studentJones);
			
			student newStudent = new student();
			newStudent.firstName = "David";
			newStudent.lastName = "Jones";
			newStudent.gpa = 1.5;
			newStudent.sat = 900;
			students.insert(newStudent);
			
			List<student> moreStudents = students.getAllStudents();
			for(student aStudent : moreStudents) {
				System.out.println(aStudent);
			}
			
			students.delete(996);
			
			System.out.println("Remaining students");
			List<student> allStudents = students.getAllStudents();
			for(student aStudent : allStudents) {
				System.out.println(aStudent);
			}
		} catch (Exception ex) { ex.printStackTrace(); }
	}



		

	}


