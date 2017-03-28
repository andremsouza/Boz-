public class Bozo {
	public static void main(String[] args) throws Exception{
		int[] dados = new int[5];
		String entrada;
		RolaDados r = new RolaDados(5);
		Placar p = new Placar();
		int total=0;
		for(int i=0; i<10; i++){
			System.out.println("Pressione ENTER para iniciar a rodada: ");
			while(EntradaTeclado.leString().length()!=0);
			dados = r.rolar();
			System.out.printf("%s", r.toString());
			System.out.println("Escolha os dados que serão rolados ou aperte ENTER para permanecer com os dados atuais: ");
			entrada = EntradaTeclado.leString();
			dados = r.rolar(entrada);
			System.out.printf("%s", r.toString());
			System.out.println("Escolha os dados que serão rolados ou aperte ENTER para permanecer com os dados atuais: ");
			entrada = EntradaTeclado.leString();
			dados = r.rolar(entrada);
			System.out.printf("%s\n", r.toString());
			System.out.printf("%s\n", p.toString());
			System.out.println("Digite a posição que você quer ocupar: ");
			int posIn = EntradaTeclado.leInt();
			p.add(posIn, dados);
			System.out.printf("%s\n", p.toString());
			total += p.getScore();
		}
		System.out.println("Placar final: "+total); //bug?
	}
}
