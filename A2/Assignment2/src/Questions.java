import java.io.Serializable;

public abstract class Questions 
implements Serializable{
	private static final long serialVersionUID = 1L;
	public String prompt;
	public abstract void createquestion();
	public abstract void display();	
}
