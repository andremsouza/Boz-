import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó. 
 * Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author andre.moreira.souza@usp.br, guilherme.menegali@usp.br
 *
 */
public class Placar {
	//parametros para geração
	private int[] pontos = new int[10];
	private boolean[] pos = new boolean[10];
	//Constructors
	
	/**
	 * Preenche os arrays com valores padrões
	 */
	public Placar(){
		Arrays.fill(pontos, 0);
		Arrays.fill(pos, false);
	}
	//Methods
	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar. 
	 * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 * @param posicao - Posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados - um array de inteiros, de tamanho 5. 
	 * Cada posição corresponde a um valor de um dado. 
	 * Supões-se que cada dado pode ter valor entre 1 e 6.
	 * @throws java.lang.IllegalArgumentException
	 */
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
		int[] hash = new int[6];
		Arrays.fill(hash, 0);
		switch(posicao){
		case 1:
			for(int i=0;i<5;i++) if(dados[i] == 1) pontos[0] += 1;
			pos[0] = true;
			break;
		case 2:
			for(int i=0;i<5;i++) if(dados[i] == 2) pontos[1] += 2;
			pos[1] = true;
			break;
		case 3:
			for(int i=0;i<5;i++) if(dados[i] == 3) pontos[2] += 3;
			pos[2] = true;
			break;
		case 4:
			for(int i=0;i<5;i++) if(dados[i] == 4) pontos[3] += 4;
			pos[3] = true;
			break;
		case 5:
			for(int i=0;i<5;i++) if(dados[i] == 5) pontos[4] += 5;
			pos[4] = true;
			break;
		case 6:
			for(int i=0;i<5;i++) if(dados[i] == 6) pontos[5] += 6;
			pos[5] = true;
			break;
		case 7:
			for(int i=0;i<5;i++) hash[dados[i]-1]++;
			for(int i=0;i<5;i++){
				if(hash[i]==2) for(int j=0; j<5; j++) if(hash[j]==3) pontos[6] = 15;
			}
			pos[6] = true;
			break;
		case 8:
			for(int i=0;i<5;i++) hash[dados[i]-1]++;
			if( (hash[1]==1 && hash[2]==1 && hash[3]==1 && hash[4]==1) && (hash[0]==1 || hash[5]==1) )
				pontos[7] = 20;
			pos[7] = true;
			break;
		case 9:
			for(int i=0;i<5;i++) hash[dados[i]-1]++;
			for(int i=0; i<5; i++) if(hash[i] == 4) pontos[8] = 30;
			pos[8] = true;
			break;
		case 10:
			for(int i=0;i<5;i++) hash[dados[i]-1]++;
			for(int i=0; i<5; i++) if(hash[i] == 5) pontos[9] = 40;
			pos[9] = true;
			break;
		}
	}
	
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 * @return O valor da soma.
	 */
	public int getScore(){
		int result=0;
		for(int i=0; i<10; i++) result += pontos[i];
		return result;
	}

	/**
	 * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas. Por exemplo: 
	 * (1)    |   (7)    |   (4) 
	 * --------------------------
	 * (2)    |   20     |   (5) 
	 * --------------------------
	 * (3)    |   30     |   (6) 
	 * --------------------------
	 *        |   (10)   |
	 *        +----------+ 
	 *mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
	 */
	@Override
	public java.lang.String toString(){
		String s="";
		if(pos[0]) s += Integer.toString(pontos[0]);
		else s += "(1)";
		s += "\t|\t";
		if(pos[6]) s += Integer.toString(pontos[6]);
		else s += "(7)";
		s += "\t|\t";
		if(pos[3]) s += Integer.toString(pontos[3]);
		else s += "(4)";
		s += "\n";
		s += "---------------------------------------\n";
		
		if(pos[1]) s += Integer.toString(pontos[1]);
		else s += "(2)";
		s += "\t|\t";
		if(pos[7]) s += Integer.toString(pontos[7]);
		else s += "(8)";
		s += "\t|\t";
		if(pos[4]) s += Integer.toString(pontos[4]);
		else s += "(5)";
		s += "\n";
		s += "---------------------------------------\n";
		
		if(pos[2]) s += Integer.toString(pontos[2]);
		else s += "(3)";
		s += "\t|\t";
		if(pos[8]) s += Integer.toString(pontos[8]);
		else s += "(9)";
		s += "\t|\t";
		if(pos[5]) s += Integer.toString(pontos[5]);
		else s += "(6)";
		s += "\n";
		s += "---------------------------------------\n";
		
		s += "\t|\t";
		if(pos[9]) s += Integer.toString(pontos[9]);
		else s += "(10)";
		s += "\t|\n";
		s += "\t+---------------+\n";
		
		return s;
	}
	
}
