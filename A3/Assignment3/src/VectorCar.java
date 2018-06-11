import java.util.Vector;

public class VectorCar extends Car implements java.io.Serializable{

	private static final long serialVersionUID = 5574394059954342639L;

	Vector<String> Response;

	public VectorCar(){
		super();
		Response=new Vector<String>();
	}

	public void setResponse(String a){
		Response.add(a);
	}
	public void editResponse(int a,String abc){
		Response.set(a, abc);
	}
	public Vector<String> getResponse(){
		return Response;
	}

	@Override
	public void Display(){
		for(int n=0;n<Response.size();n++)
			System.out.print("    "+Response.get(n)+"  ");
			System.out.println();
	}

	public int getSize(){
		return Response.size();
	}

	public boolean isCorrect(Car corr){

		for(int n = 0; n < this.Response.size(); n++)
		{
			if(!(corr.getResponse().get(n).equals(this.Response.get(n))))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Display(outPut output) {
		for(int n=0;n<Response.size();n++)
			output.displaystring("    "+Response.get(n)+"  ");
	}
}
