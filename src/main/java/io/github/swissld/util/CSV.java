package io.github.swissld.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * <h3>CSV</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class CSV<T> implements Function<CSVRecord, T>
	{
	/**
	 * @since 0.1.0
	 */
	public final List<T> parse(final Path path) throws IOException
		{
		Objects.requireNonNull(path);

		final var format = CSVFormat.Builder.create().setHeader().setSkipHeaderRecord(true).build();

		final var list = new ArrayList<T>();

		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
			{
			records.forEach(record ->
				{
				list.add(apply(record));
				});
			}

		return list;
		}

	/**
	 * @since 0.1.0
	 */
	public static final String getAsString(final CSVRecord record, final int column)
		{
		Objects.requireNonNull(record);

		return record.get(column);
		}

	/**
	 * @since 0.1.0
	 */
	public static final Integer getAsInteger(final CSVRecord record, final int column)
		{
		Objects.requireNonNull(record);

		return Integer.valueOf(Integer.parseInt(record.get(column)));
		}

	/**
	 * @since 0.1.0
	 */
	public static final Float getAsFloat(final CSVRecord record, final int column)
		{
		Objects.requireNonNull(record);

		return Float.valueOf(Float.parseFloat(record.get(column)));
		}

	/**
	 * @since 0.1.0
	 */
	public static final Double getAsDouble(final CSVRecord record, final int column)
		{
		Objects.requireNonNull(record);

		return Double.valueOf(Double.parseDouble(record.get(column)));
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
		return record -> Integer.valueOf(Integer.parseInt(record.get(column)));
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, Float> getAsFloat(final int column)
		{
		return record -> Float.valueOf(Float.parseFloat(record.get(column)));
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, Double> getAsDouble(final int column)
		{
		return record -> Double.valueOf(Double.parseDouble(record.get(column)));
		}

	/**
	 * @since 0.1.0
	 */
	protected static final Function<CSVRecord, LocalDateTime> getAsDateTime(final int column, final DateTimeFormatter format)
		{
		return record -> LocalDateTime.parse(record.get(column), format);
		}
	}
