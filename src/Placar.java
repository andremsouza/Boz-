import java.util.Arrays;


public class Placar {
	//parametros para geração
	private int[] pontos = new int[10];
	private boolean[] pos = new boolean[10];
	//Constructors
	public Placar(){
		Arrays.fill(pontos, 0);
		Arrays.fill(pos, false);
	}
	//Methods
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

	public int getScore(){
		int result=0;
		for(int i=0; i<10; i++) result += pontos[i];
		return result;
	}

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
