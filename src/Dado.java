
public class Dado {
	//parametros para geração
	private int n = -1; //número do dado
	private int l = 6; //número de lados
	private Random r = new Random();
	//Constructors
	public Dado(){
		n = rolar();
	}
	public Dado(int n){
		l = n;
		n = rolar();

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

	@Override
	public String toString(){
		String s;
		s = "+-----+\n";
		switch(getLado()){
		case 1:
			s += "|     |\n";
			s += "|  *  |\n";
			s += "|     |\n";
			break;
		case 2:
			s += "|*    |\n";
			s += "|     |\n";
			s += "|    *|\n";
			break;
		case 3:
			s += "|*    |\n";
			s += "|  *  |\n";
			s += "|    *|\n";
			break;
		case 4:
			s += "|*   *|\n";
			s += "|     |\n";
			s += "|*   *|\n";
			break;
		case 5:
			s += "|*   *|\n";
			s += "|  *  |\n";
			s += "|*   *|\n";
			break;
		case 6:
			s += "|*   *|\n";
			s += "|*   *|\n";
			s += "|*   *|\n";
			break;
		default:
			break;
		}
		s += "+-----+\n";
		return s;
	}

	public static void main(String[] args){	
	}
}
