package io.github.swissld.application;

import java.util.Objects;

/**
 * <h3>ConsoleOutputInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public interface ConsoleOutputInterface
	{
	public static final String COMMAND = "\u001B[%sm";

	public static final String RED = "31";

	public static final String RESET = "0";

	/**
	 * @since 0.1.0
	 */
	public default void command(final String code)
		{
		Objects.requireNonNull(code);

		System.out.print(COMMAND.formatted(code));
		}

	/**
	 * @since 0.1.0
	 */
	public default void red()
		{
		command(RED);
		}

	/**
	 * @since 0.1.0
	 */
	public default void reset()
		{
		command(RESET);
		}

	/*
	public static enum Color
		{
		RED(31);

		private static final String sddd = "";

		private final int code;

		private Color(final int code)
			{
			this.code = code;
			}
		}
	*/

	/*
	public void color();

	public void blue();
	public void green();
	

	public void reset();
	*/
	}
