public class Bozo {
	public static void main(String[] args) throws Exception{
		RolaDados r = new RolaDados(5);
		r.rolar();
		System.out.printf("%s", r.toString());
		boolean[] b = new boolean[]{true, false, true, false, true};
		r.rolar(b);
		System.out.printf("%s", r.toString());
		String s = "2 1 5";
		r.rolar(s);
		System.out.printf("%s", r.toString());
	}
}
