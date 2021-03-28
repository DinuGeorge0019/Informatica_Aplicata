package menu;

import java.util.Scanner;

import group.Group;
import group.Student;

public class Menu {
	
	private Menu() {};
	
	private static Menu new_instance = null;
	
	public static Menu getInstance()
	{
		if(new_instance == null)
		{
			new_instance = new Menu();
		}

		return new_instance;
	}
	
	private Group myGroup = new Group();
	
	private void DisplayMenu()
	{
        
		System.out.println("Options : ");
		System.out.println("1. Add student");
		System.out.println("2. Modify student data ");
		System.out.println("3. Delete student");
		System.out.println("4. Print student data");
		System.out.println("5. Print group data");
		System.out.println("6. Exit");
		
	}
	
	public void Run() {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			DisplayMenu();

			int option = scanner.nextInt();

			switch (option) {
				case 1: {
					scanner.nextLine();
					String name;
					double final_grade;
					int id;
					System.out.print("Name of the student : ");
					name = scanner.nextLine();
					System.out.print("Final grade of the student : ");
					final_grade = scanner.nextDouble();
					System.out.print("ID of the student : ");
					id = scanner.nextInt();
	
					Student new_student = new Student(name, final_grade, id);
	
					myGroup.add_student(new_student);
					break;
				}
	
				case 2: {
					int id;
					System.out.print("ID of the student : ");
					id = scanner.nextInt();
					myGroup.modify_student_data(id, scanner);
					break;
				}
	
				case 3: {
					int id;
					System.out.print("ID of the student : ");
					id = scanner.nextInt();
					myGroup.remove_student_after_id(id);
					break;
				}
	
				case 4: {
					int id;
					System.out.print("ID of the student : ");
					id = scanner.nextInt();
					myGroup.print_student_data(id);
					break;
				}
	
				case 5: {
					myGroup.print_group();
					break;
				}
	
				case 6: {
					scanner.close();
					return;
				}
	
				default: {
					System.out.println("Invalid option");
					break;
				}
			}
		}
	}

}
