package experimento;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println("Deu erro na thread " + thread + ", " + throwable.getMessage());
	}

}
