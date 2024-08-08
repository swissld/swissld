package io.github.swissld.parser;

import org.apache.commons.lang3.NotImplementedException;

/**
 * <h3>NumberParser</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class NumberParser
	{
	public static final NumberParserInterface<Integer> INTEGER = new IntegerParser();

	private NumberParser()
		{
		throw new UnsupportedOperationException();
		}

	public static int parseInt(final String text)
		{
		throw new NotImplementedException();
		}
	}
