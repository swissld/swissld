package io.github.swissld.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.function.Function;
import org.apache.commons.csv.CSVRecord;


public abstract class CSV<T> extends Parser implements Function<CSVRecord, T>
	{
	/**
	 * @since 0.1.0
	 */
	public static final String getAsString(final CSVRecord record, final int column)
		{
		return Objects.requireNonNull(record).get(column);
		}

	/**
	 * @since 0.1.0
	 */
	public static final Integer getAsInteger(final CSVRecord record, final int column)
		{
		return Integer.valueOf(getAsInteger(getAsString(record, column)));
		}

	/**
	 * @since 0.1.0
	 */
	public static final Float getAsFloat(final CSVRecord record, final int column)
		{
		return Float.valueOf(getAsFloat(getAsString(record, column)));
		}

	/**
	 * @since 0.1.0
	 */
	public static final Double getAsDouble(final CSVRecord record, final int column)
		{
		return Double.valueOf(getAsDouble(getAsString(record, column)));
		}

	/**
	 * @since 0.1.0
	 */
	public static final LocalDateTime getAsDateTime(final CSVRecord record, final int column, final DateTimeFormatter format)
		{
		Objects.requireNonNull(record);
		Objects.requireNonNull(format);

		return LocalDateTime.parse(record.get(column), format);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, String> getAsString(final int column)
		{
		return record -> record.get(column);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, Integer> getAsInteger(final int column)
		{
		return record -> getAsInteger(record, column);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, Float> getAsFloat(final int column)
		{
		return record -> getAsFloat(record, column);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, Double> getAsDouble(final int column)
		{
		return record -> getAsDouble(record, column);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, LocalDateTime> getAsDateTime(final int column, final DateTimeFormatter format)
		{
		return record -> LocalDateTime.parse(record.get(column), format);
		}
	}
