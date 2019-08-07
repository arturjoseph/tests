package cap8;

public class Programa {

	public static void main(String[] args) {
		
		EmpresaFacade fachada = new EmpresaFacadeSingleton().getInstancia();
				fachada.buscaPorCpf("");
				Fatura fatura = fachada.criaFatura(new Cliente(), 150.0);
				fachada.geraCobranca(fatura);
		
	}

}
