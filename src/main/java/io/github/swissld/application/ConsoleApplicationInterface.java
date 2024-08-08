package io.github.swissld.application;

/**
 * <h3>ConsoleApplicationInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public interface ConsoleApplicationInterface<T extends ConsoleApplicationInterface<T, E>, E extends Exception> extends ApplicationInterface<T, E>, ConsoleInputInterface, ConsoleOutputInterface
	{
	}
