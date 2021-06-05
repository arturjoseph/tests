import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Principal {

	public static void main(String[] args) throws Exception {
		TesteErros obj = new TesteErros();
		
		Class clazz = obj.getClass();
		
		try {
			Method metodo = clazz.getDeclaredMethod("metodo", String.class);
			metodo.invoke(obj, "23");
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		}
		
	}

}
