package br.com.estudo.cdiestudo.calculadora;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import br.com.estudo.cdiestudo.logger.Logger;

@Decorator @Priority(Interceptor.Priority.APPLICATION)
public class CalculadoraDeSalarios2013 implements CalculadoraDeSalarios {

	@Inject @Delegate
	private CalculadoraDeSalarios delegate;
	
	@Inject
	private Logger logger;
	
	public double calculaSalario(double x, double y) {
		logger.info("Delegate plano 2013");
		double salario = delegate.calculaSalario(x, y);

		return salario * 2;
	}

}
