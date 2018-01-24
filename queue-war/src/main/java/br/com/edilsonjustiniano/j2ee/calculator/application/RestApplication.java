package br.com.edilsonjustiniano.j2ee.calculator.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.edilsonjustiniano.api.service.impl.MessageServiceImpl;

/**
 * The JAX-RS application class.
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		classes.add(MessageServiceImpl.class);

		return classes;
	}
}
