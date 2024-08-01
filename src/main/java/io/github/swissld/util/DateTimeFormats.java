package io.github.swissld.util;

import java.time.format.DateTimeFormatter;

/**
 * <h3>DateTimeFormats</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class DateTimeFormats extends Constants
	{
	public static final DateTimeFormatter ISO_8601 = get(YYYY_MM_DD_T_HH_MM_SS);

	/**
	 * @since 0.1.0
	 */
	public static final DateTimeFormatter get(final String format)
		{
		return DateTimeFormatter.ofPattern(format);
		}
	}
