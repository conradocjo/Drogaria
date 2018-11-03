package br.com.drogaria.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestConfig extends ResourceConfig {
	public void drogariaResourceConfig() {
		packages("br.com.drogaria.servicos");
	}
}
