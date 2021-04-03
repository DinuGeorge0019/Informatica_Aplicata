package students_grup_menu.implementation;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.StudentNotFoundException;
import reusable_menu.implementation.Menu;
import reusable_menu.abstractions.IMenuItem;
import reusable_menu.implementation.MenuItem;

public class GrupMenu {

	private Menu mainMenu;
	private ArrayList<Student> group = new ArrayList<Student>();
	
	void AddStudent()
	{
		Student newStudent = getStudent();
		group.add(newStudent);
	}
	
	void DeleteStudent()
	{
		try {
			Student student = SearchStudentAfterId(ReadStudentID());
			group.remove(student);
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	void PrintStudentData()
	{
		System.out.println("- - - - - - - - - - - - -");
		
		try {
			Student student = SearchStudentAfterId(ReadStudentID());
			student.printData();
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("- - - - - - - - - - - - -");
	}
	
	void PrintGroupData()
	{	
		if(group.isEmpty())
		{
			System.out.println("No students in this group");
			return;
		}
		
		for(Student student : group)
		{
			System.out.println("- - - - - - - - - - - - -");
			student.printData();
			System.out.println("- - - - - - - - - - - - -");
		}
	}
	
	
	private Student SearchStudentAfterId(Integer id) throws StudentNotFoundException{
		for (Student student : group) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		throw new StudentNotFoundException(id);
	}
	
	Integer ReadStudentID()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("ID of the student: ");
		Integer id = scanner.nextInt();
		return id;
	}
	
	Student getStudent()
	{
		return new Student(ReadNewName(), ReadNewFinalGrade(), ReadNewID());
	}
	
	Integer ReadNewID()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("New ID : ");
		Integer id = scanner.nextInt();
		return id;
	}
	
	String ReadNewName()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("New name : ");
		String name = scanner.nextLine();
		return name;
	}
	
	Double ReadNewFinalGrade()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("New final grade : ");
		Double finalGrade = scanner.nextDouble();
		return finalGrade;
	}
	
	void modifyStudentID()
	{
		try {
			Student student = SearchStudentAfterId(ReadStudentID());
			student.setId(ReadNewID());
			
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	void modifyStudentName()
	{
		try {
			Student student = SearchStudentAfterId(ReadStudentID());
			student.setName(ReadNewName());
			
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	void modifyStudentFinalGrade()
	{
		try {
			Student student = SearchStudentAfterId(ReadStudentID());
			student.setFinalGrade(ReadNewFinalGrade());
			
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	 public void load()
	    {
	        
	        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
	        ArrayList<IMenuItem> modifyStudentsDataOptions = new ArrayList<IMenuItem>();
	        
	        int shortCut = 1;    
	        
	         
	       IMenuItem currentItem = new MenuItem("Add student", shortCut++, (parameters)->{
	    	   	AddStudent();
	       });       
	       menuItems.add(currentItem);
	       
	       currentItem = new MenuItem("Delete student", shortCut++, (parameters)->{
	    	   	DeleteStudent();
	       });       
	       menuItems.add(currentItem);    
	       
	       currentItem = new MenuItem("Print student data", shortCut++, (parameters)->{
	    	   PrintStudentData();
	       });       
	       menuItems.add(currentItem); 
	       
	       currentItem = new MenuItem("Print group data", shortCut++, (parameters)->{
	    	   PrintGroupData();
	       });       
	       menuItems.add(currentItem); 
	       
	       modifyStudentsDataOptions.add(new MenuItem("Modify name", 1, (parameters) -> {
	    		modifyStudentName(); 
	       }));
	       
	       modifyStudentsDataOptions.add(new MenuItem("Modify final grade", 2, (parameters) -> {
	       		modifyStudentFinalGrade();
	       }));
	       
	       modifyStudentsDataOptions.add(new MenuItem("Modify final grade", 3, (parameters) -> {
	    	   	modifyStudentID();
		   }));
	       
	       
	       currentItem = new Menu("Modify student", shortCut++, modifyStudentsDataOptions);  
	       menuItems.add(currentItem);
	       
	       
	        
	        mainMenu = new Menu("Main Menu", -1, menuItems);
	        
	    }
	 
		public void execute()
		{
			mainMenu.execute();
		}
	 
	
}
