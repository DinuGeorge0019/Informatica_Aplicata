package group;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.StudentNotFoundException;

public class Group {

	private ArrayList<Student> students = new ArrayList<Student>();

	public void add_student(Student student) {
		students.add(student);
	}

	private Student search_student_after_id(int id) throws StudentNotFoundException{
		for (Student student : students) {
			if (student.get_id() == id) {
				return student;
			}
		}
		throw new StudentNotFoundException(id);
	}

	public void remove_student_after_id(int id)  {
		try {
			Student student = search_student_after_id(id);
			students.remove(student);
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void modify_student_data(int id, Scanner scanner)
	{
		
		try {
			
			Student student = search_student_after_id(id);
			
			System.out.println("\t" + "Options : ");
			System.out.println("\t" + "1. Modify name");
			System.out.println("\t" + "2. Modify final grade");
			System.out.println("\t" + "3. Modify id");
			
			int option = scanner.nextInt();
		
			try
			{
				switch (option) {
					case 1: {
						System.out.println("New name : ");
						scanner.nextLine();
						String new_name = scanner.nextLine();
						student.set_name(new_name);
						break;
					}
					
					case 2:{
						System.out.println("New grade : ");
						double new_final_grade = scanner.nextDouble();
						student.set_final_grade(new_final_grade);
						break;
					}
					
					case 3:{
						System.out.println("New ID : ");
						int new_id = scanner.nextInt();
						student.set_id(new_id);
						break;
					}
			
					default:{
						throw new IllegalArgumentException("Option "+ option + " does not exist");
					}	
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	public void print_student_data(int id)
	{
		System.out.println("- - - - - - - - - - - - -");
		
		try {
			Student student = search_student_after_id(id);
			student.print_data();
		} 
		catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("- - - - - - - - - - - - -");
		
	}
	
	public void print_group()
	{
		System.out.println("- - - - - - - - - - - - -");
		for(Student student : students)
		{
			student.print_data();
		}
		System.out.println("- - - - - - - - - - - - -");
	}
	

}
