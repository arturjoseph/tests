import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteErros {

	public void metodo(String s) {
		throw new RuntimeException("Erro metodo");
	}

	public static void chamarTestes(Object obj) throws Throwable {

		Class<?> clazz = obj.getClass();

		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("test") && m.getReturnType() == void.class
					&& m.getParameterTypes().length == 0) {
				try {
					m.invoke(obj);
				} catch (InvocationTargetException ex) {
					throw ex.getTargetException();
				}
			}
		}
	}

}
