package br.com.estudo.cdiestudo.interceptors;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Auditavel
@Priority(Interceptor.Priority.APPLICATION)
public class Auditor {

	@AroundInvoke
	public Object auditar(InvocationContext context) throws Exception {
		// faz processamento anterior
		System.out.println("faz processamento anterior");
		Method method = context.getMethod();

		Object target = context.getTarget();

		Object[] params = context.getParameters();

		System.out.println(String.format("auditando o m�todo: '%s' "
				+ "do objeto: '%s' " + "com os par�metros: '%s'", method,
				target, params));

		// chama o m�todo original
		System.out.println("chama m�todo original");
		Object retorno = context.proceed();

		// faz processamento posterior
		System.out.println("faz processamento posterior");

		return retorno;
	}
	
	
	
	
	
	
	@PostConstruct
	public void postConstruct(InvocationContext context) throws Exception {
		System.out.println("Loga alguma coisa ao criar");
		Object target = context.getTarget();

		// chama m�todo anotado com @PostConstruct, se houver
		context.proceed();
	}

	@PreDestroy
	public void preDestroy(InvocationContext context) throws Exception {
		System.out.println("Loga alguma coisa ao destruir");
		Object target = context.getTarget();
		
		// chama m�todo anotado com @PreDestroy, se houver
		context.proceed();

	}
}
