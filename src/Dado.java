
public class Dado {
	//parametros para geração
	private int n = -1;
	private int l = 6;
	private Random r = new Random();
	//Constructors
	public Dado(){
		n = rolar();
		//n = r.getIntRand(l+1);
		//while(n<=0)	n = r.getIntRand(l+1);
	}
	public Dado(int n){
		l = n;
		n = rolar();
		//n = r.getIntRand(l+1);
		//while(n<=0)	n = r.getIntRand(l+1);
	}
	//Methods
	public int getLado(){
		return n;
	}
	public int rolar(){
		n = r.getIntRand(l+1);
		while(n<=0)	n = r.getIntRand(l+1);
		return n;
	}
	public String toString(){
		String s;
		s = "+-----+\n";
		switch(getLado()){
		case 1:
			s.concat("|     |\n");
			s.concat("|  *  |\n");
			s.concat("|     |\n");
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			break;
		}
		//|*   *|\n
		//|  *  |\n
		//|*   *|\n
		s.concat("+-----+\n");
		return s;
	}
	
	
	public static void main(String[] args){
		
	}
}
