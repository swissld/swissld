package io.github.swissld.util;

/**
 * <h3>Parser</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Parser
	{
	/**
	 * @since 0.1.0
	 */
	public static final int getAsInteger(final String value)
		{
		return Integer.parseInt(value);
		}

	/**
	 * @since 0.1.0
	 */
	public static final long getAsLong(final String value)
		{
		return Long.parseLong(value);
		}

	/**
	 * @since 0.1.0
	 */
	public static final float getAsFloat(final String value)
		{
		return Float.parseFloat(value);
		}

	/**
	 * @since 0.1.0
	 */
	public static final double getAsDouble(final String value)
		{
		return Double.parseDouble(value);
		}
	}
