public class questionfactory {

	public Tf makeTf(){
		return new Tf(); 
	}
	public MultiChoice createMultiChoice(){
		return new MultiChoice(); 
	}
	public Essay makeEssay(){
		return new Essay(); 
	}
	public shortAnswer makeshortAns(){
		return new shortAnswer(); 
	}
	public MultiChoice Ranking(){
		return new MultiChoice(); 
	}
	public Ranking makeRanking(){
		return new Ranking(); 
	}
	public Matching makeMatching(){
		return new Matching(); 
	}

}
