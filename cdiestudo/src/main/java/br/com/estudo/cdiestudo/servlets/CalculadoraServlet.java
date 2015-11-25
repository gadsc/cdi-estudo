package br.com.estudo.cdiestudo.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.cdiestudo.calculadora.CalculadoraDeSalarios;
import br.com.estudo.cdiestudo.interceptors.Auditavel;

@WebServlet("/calculadora")
@Auditavel
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraDeSalarios calc;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println(calc.calculaSalario(2, 2));
	}
}