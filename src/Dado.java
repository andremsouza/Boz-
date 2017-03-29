/**
 * Simula um dado de número de lados variados. 
 * Ao criar o objeto é possível estabelecer o número de lados. 
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author andre.moreira.souza@usp.br, guilherme.menegali@usp.br
 *
 */
public class Dado {
	//parametros para geração
	private int n = -1; //número do dado
	private int l = 6; //número de lados
	private Random r = new Random();
	//Constructors
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado(){
		n = rolar();
	}
	/**
	 * Cria objeto com um número qualquer de lados
	 * @param n - - número de lados do dado
	 */
	public Dado(int n){
		l = n;
		n = rolar();

	}
	//Methods
	/**
	 * Recupera o último número selecionado.
	 * @return o número do último lado selecionado.
	 */
	public int getLado(){
		return n;
	}
	/**
	 * Simula a rolagem do dado por meio de um gerador aleatório. 
	 * O número selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return o número que foi sorteado
	 */
	public int rolar(){
		n = r.getIntRand(l+1);
		while(n<=0)	n = r.getIntRand(l+1);
		return n;
	}
	/**
	 * Transforma representação do dado em String. 
	 * É mostrada uma representação do dado que está para cima. 
	 * Note que só funciona corretamente para dados de 6 lados. Exemplo:
	 * +-----+    
	 * |*   *|    
	 * |  *  |    
	 * |*   *|    
	 * +-----+
	 * Overrides: toString in class java.lang.Object
	 * @return string representando dado
	 */
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
	/**
	 * Não tem função real dentro da classe. 
	 * Foi usada apenas para testar os métodos implementados
	 * @param args - -- Sem uso
	 */
	public static void main(String[] args){	
	}
}
