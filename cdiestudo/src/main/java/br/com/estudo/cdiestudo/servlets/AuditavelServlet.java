package br.com.estudo.cdiestudo.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.cdiestudo.interceptors.Auditavel;
import br.com.estudo.cdiestudo.logger.Logger;

@WebServlet("/auditavel")
@Auditavel
public class AuditavelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("Hello");
	}
}