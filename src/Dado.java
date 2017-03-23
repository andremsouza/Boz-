
public class Dado {
	//Constructors
	public Dado(){
		
	}
	public Dado(int n){
		
	}
	//Methods
	public int getLado(){
		
	}
	public int rolar(){
		
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
	}
	
	
	public static void main(String[] args){
		
	}
}
