import java.util.Map;

public class Principal {

	public static void main(String[] args) throws Exception {
		Mapeador mapeador = new Mapeador();
		mapeador.load("classes.prop");
		
		InterfaceExemplo i = mapeador.getInstacia(InterfaceExemplo.class, "teste");
		
		System.out.println(i.getClass());
		System.out.println(mapeador.getImplementacao(Map.class));
	}
}
