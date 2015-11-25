package br.com.estudo.cdiestudo.logger;

import br.com.estudo.cdiestudo.interceptors.Auditavel;

@Auditavel
public class Logger {
	public void info(String texto) {
		System.out.println(texto);
	}
}
