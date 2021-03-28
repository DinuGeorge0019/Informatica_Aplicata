package group;

public class Student {

	private String name;
	private double final_grade;
	private int id;
	
	public Student(String name, double final_grade, int id) {
		this.name = name;
		this.final_grade = final_grade;
		this.id = id;
	}

	public String get_name()
	{
		return name;
	}
	
	public double get_final_grade()
	{
		return final_grade;
	}
	
	public int get_id()
	{
		return id;
	}
	
	public void set_id(int id)
	{
		this.id = id;
	}
	
	public void set_name(String name)
	{
		this.name = name;
	}
	
	public void set_final_grade(double final_grade)
	{
		this.final_grade = final_grade;
	}
	
	public void print_data()
	{
		System.out.println("Name : " + this.name);
		System.out.println("Final Grade : " + this.final_grade);
		System.out.println("ID : " + this.id);
	}
	
}
