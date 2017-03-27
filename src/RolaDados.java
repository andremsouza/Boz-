public class RolaDados {
	
	private int copia_do_n;
	private Dado[] vetDado;
	
	public static void main(java.lang.String[] args) throws java.lang.Exception{
	}
	
	public RolaDados(int n){
		copia_do_n = n;
		vetDado = new Dado[n];					//Cria o vetor de dados de tamanho N
		for(int i=0; i < n; i++){				//Inicializa cada elemento do vetor
			vetDado[i] = new Dado();
		}
	}
	
	public int[] rolar(){ 						//Rola todos os dados
		int[] novos_valores = new int[copia_do_n];
		for(int i=0; i < copia_do_n; i++){
			novos_valores[i] = vetDado[i].rolar();
		}
		return novos_valores;
	}
	
	@Override
	public java.lang.String toString(){
		String s;
		s = vetDado[0].toString();
		s += "\n";
		for(int i=1; i < copia_do_n; i++){
			s += vetDado[i].toString();
			s += "\n";
		}
		return s;
	}

}
