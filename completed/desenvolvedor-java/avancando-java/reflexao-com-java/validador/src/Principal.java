
public class Principal {
	
	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario();
		u.setLogin("artur1");
		u.setSenha("SenhaA1234");
		u.setEmail("artu@remail.com");
		u.setPapel("DEV");
		u.setAtivo(true);
		
		boolean valido = Validador.validarObjeto(u);
		
		if (valido) {
			System.out.println("O objeto é valido");
		}else {
			System.out.println("O objeto é invalido");
		}
	}

}
