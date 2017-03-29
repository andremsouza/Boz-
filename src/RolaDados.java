import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. 
 *Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas. 
 * @author andre.moreira.souza@usp.br, guilherme.menegali@usp.br
 *
 */

public class RolaDados {

	private int nDados;
	private Dado[] vetDado;
	private Random r = new Random(); 

	/**
	 * Construtor que cria e armazena vários objetos do tipo Dado. 
	 * Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e gerando sempre uma semente aleatória para o gerador de números aleatórios. 
	 * Os dados criados podem ser referenciados por números, entre 1 e n.
	 * @param n - Número de dados a serem criados.
	 */
	public RolaDados(int n){
		nDados = n;
		vetDado = new Dado[n];					
		for(int i=0; i < n; i++){				
			vetDado[i] = new Dado();
			try{
				TimeUnit.MILLISECONDS.sleep(r.getIntRand(100)+100);
			}catch(Exception e){
				System.out.println("Erro: RolaDados: Randomização");
				System.exit(-1);
			}
		}
	}

	/**
	 * Rola todos os dados.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
	 * Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(){
		int[] novos_valores = new int[nDados];
		for(int i=0; i < nDados; i++){
			novos_valores[i] = vetDado[i].rolar();
		}
		return novos_valores;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param quais - É um array de booleanos que indica quais dados devem ser rolados. 
	 * Cada posição representa um dos dados. 
	 * Ou seja, a posição 0 do array indica se o dado 1 deve ser rolado ou não, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
	 * Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(boolean[] quais){
		int[] novos_valores = new int[nDados];
		for(int i=0; i < nDados; i++){
			if(quais[i]) novos_valores[i] = vetDado[i].rolar();
			else novos_valores[i] = vetDado[i].getLado();
		}
		return novos_valores;
	}

	/**
	 * Rola alguns dos dados.
	 * @param s - É um String que possui o número dos dados a serem rolados. 
	 * Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados. 
	 * Os números devem ser separados por espaços. 
	 * Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(java.lang.String s){
		boolean[] b = new boolean[nDados];
		String[] r = s.split(" ");

		Arrays.fill(b, false);
		if(s.length() == 0 || !Character.isDigit(s.charAt(0))) return rolar(b);
		for(int i=0; i<s.length() - s.replace(" ", "").length()+1; i++)
			if(Integer.parseInt(r[i])-1 < nDados) b[Integer.parseInt(r[i])-1] = true;

		return rolar(b);		
	}

	/**
	 * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. 
	 * Exibe os dados horisontalmente, por exemplo:
	 */
	@Override
	public java.lang.String toString(){
		String[] s = new String[nDados];
		String r="";

		for(int i=0;i<nDados;i++) s[i] = vetDado[i].toString();
		for(int i=0;i<5;i++){ //5 = numero de linhas
			for(int j=0;j<nDados;j++){
				r += s[j].substring(i*8, i*8 + 7);
				if(j<nDados-1) r += "\t";
				else r+="\n";
			}			
		}
		return r;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	public static void main(java.lang.String[] args) throws java.lang.Exception{
	}
}