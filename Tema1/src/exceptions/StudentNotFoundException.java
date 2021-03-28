package exceptions;

public class StudentNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public StudentNotFoundException(int id)
	{
		this.id = id;
	}
	
	@Override
	public String getMessage()
	{
		return "Student with id :" + id + " not found";
	}
	
}
