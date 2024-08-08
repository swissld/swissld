package io.github.swissld.parser;

import java.util.function.Function;

/**
 * <h3>ParserInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface ParserInterface<T, R> extends Function<T, R>
	{
	}
