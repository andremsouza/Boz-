public class Bozo {
	public static void main(String[] args){
		int[] dados = new int[5];
		String entrada;
		RolaDados r = new RolaDados(5);
		Placar p = new Placar();
		for(int i=0; i<10; i++){
			while(true){
				try{
					System.out.println("Pressione ENTER para iniciar a rodada: ");
					entrada = EntradaTeclado.leString();
					if(entrada.length()!=0) continue;
				}catch(Exception eIn){
					System.out.println("Entrada inválida.Digite novamente.");
					continue;
				}
				break;
			}
			dados = r.rolar();
			System.out.printf("%s", r.toString());
			while(true){
				try{
					System.out.println("Escolha os dados que serão rolados ou aperte ENTER para permanecer com os dados atuais: ");
					entrada = EntradaTeclado.leString();
				}catch(Exception eIn){
					System.out.println("Entrada inválida.Digite novamente.");
					continue;
				}
				break;
			}
			dados = r.rolar(entrada);
			System.out.printf("%s", r.toString());
			while(true){
				try{
					System.out.println("Escolha os dados que serão rolados ou aperte ENTER para permanecer com os dados atuais: ");
					entrada = EntradaTeclado.leString();
				}catch(Exception eIn){
					System.out.println("Entrada inválida.Digite novamente.");
					continue;
				}
				break;
			}
			dados = r.rolar(entrada);
			System.out.printf("%s\n", r.toString());
			System.out.printf("%s\n", p.toString());
			int posIn;
			while(true){
				try{
					System.out.print("Digite a posição que você quer ocupar: ");
					posIn = EntradaTeclado.leInt();
				}catch(Exception eIn){
					System.out.println("Valor inválido.Digite novamente.");
					continue;
				}
				break;
			}
			p.add(posIn, dados);
			System.out.printf("%s\n", p.toString());
		}
		System.out.println("Placar final: "+ p.getScore());
	}
}
