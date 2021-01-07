import java.lang.reflect.Method;

public class Validador {
	public static boolean validarObjeto(Object obj) throws Exception {
		boolean resultado = true;
		Class<?> clazz = obj.getClass();

		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("validar") && m.getReturnType() == boolean.class
					&& m.getParameterTypes().length == 0) {
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}
		return resultado;
	}

	public static void chamarTestes(Object obj) throws Exception {

		Class<?> clazz = obj.getClass();

		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("test") && m.getReturnType() == void.class
					&& m.getParameterTypes().length == 0) {

				m.invoke(obj);
			}
		}
	}

}
