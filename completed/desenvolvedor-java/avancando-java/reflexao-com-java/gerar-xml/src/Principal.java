
public class Principal {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Usuario u = new Usuario();
		u.setLogin("artur");
		u.setSenha("SenhaArtur");
		u.setEmail("artur@email.com");
		u.setPapel("DEV");
		u.setAtivo(true);
		
		String xml = GeradorXml.getXml(u);
		
		System.out.println(xml);
		
	}
}
