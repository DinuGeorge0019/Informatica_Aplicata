package students_grup_menu.implementation;

public class Student {

	private String name;
	private Double finalGrade;
	private Integer id;

	public Student(String name, Double finalGrade, Integer id) {
		this.name = name;
		this.finalGrade = finalGrade;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Double finalGrade) {
		this.finalGrade = finalGrade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public void printData()
	{
		System.out.println("Name : " + this.name);
		System.out.println("Final Grade : " + this.finalGrade);
		System.out.println("ID : " + this.id);
	}
	
}
