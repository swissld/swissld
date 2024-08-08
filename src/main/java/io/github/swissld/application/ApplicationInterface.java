package io.github.swissld.application;

import org.apache.commons.lang3.function.FailableRunnable;

/**
 * <h3>ApplicationInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface ApplicationInterface<T extends ApplicationInterface<T, E>, E extends Exception> extends FailableRunnable<E>
	{
	}
