import java.util.Calendar;

public class Random {
	//parametros para geracao
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023; //seed
	//Constructors
	public Random(int k){
		xi = k;
	}
	public Random(){
		xi=Calendar.getInstance().getTimeInMillis();
	}
	//Methods
	public double getRand() {//calcula o proximo valor xi //calcula valor entre 0 e 1, dividindo por p
		xi = (a + m*xi) % p;
		return (double)xi/(double)p;
	}
	public int getIntRand(int max) {//gera valor entre[0, 1) //multiplica por max
		return (int)(getRand() * max);
	}
	public void setSemente(int semente) {
		xi = semente;
	}
/*
	@Override
		public String toString(){
			return xi + "";
		}
*/
}
