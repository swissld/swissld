package io.github.swissld.parser;

import io.github.swissld.util.Constants;

/**
 * <h3>NumberParserInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface NumberParserInterface<T extends Number> extends ParserInterface<String, T>
	{
	public static final String SIGN = "(%s|%s)".formatted(Constants.PLUS, Constants.MINUS);

	public static final String SEPARATOR = "(%s|%s)".formatted(Constants.DOT, Constants.COMMA);
	}
