import java.util.concurrent.TimeUnit;

public class RolaDados {

	private int nDados;
	private Dado[] vetDado;
	private Random r = new Random(); 

	public static void main(java.lang.String[] args) throws java.lang.Exception{
	}

	public RolaDados(int n){
		nDados = n;
		vetDado = new Dado[n];					//Cria o vetor de dados de tamanho N
		for(int i=0; i < n; i++){				//Inicializa cada elemento do vetor
			vetDado[i] = new Dado();
			try{
				TimeUnit.MILLISECONDS.sleep(r.getIntRand(100)+100);
			}catch(Exception e){
				System.out.println("Erro: RolaDados: Randomização");
				System.exit(-1);
			}
		}
	}

	public int[] rolar(){ 						//Rola todos os dados
		int[] novos_valores = new int[nDados];
		for(int i=0; i < nDados; i++){
			novos_valores[i] = vetDado[i].rolar();
		}
		return novos_valores;
	}

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

}
