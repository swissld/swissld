package io.github.swissld.gps;

/**
 * <h3>Type</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public enum Type
	{
	POINT,
	TRACK;

	/**
	 * @since 0.1.0
	 */
	public static final Type parse(final String value)
		{
		if (value == null || value.isBlank()) return null;

		if (value.equalsIgnoreCase("T")) return Type.TRACK;

		if (value.equalsIgnoreCase("W")) return Type.POINT;

		throw new IllegalArgumentException("Type: " + value);
		}
	}
