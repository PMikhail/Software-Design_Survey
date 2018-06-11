import java.util.Vector;

public abstract class Car implements java.io.Serializable{

	private static final long serialVersionUID = -5088598317970034831L;
	public abstract void save();
	public abstract void Display();
	public abstract void setResponse(String a);
	public abstract void Display(outPut output);
	public abstract Vector<String> getResponse();
	public abstract boolean isCorrect(Car car);
	public void editResponse(int res1, String res) {
		// TODO Auto-generated method stub
	}
	public String getsResponse() {
		return null;
	}
}
