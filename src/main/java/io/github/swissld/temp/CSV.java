package io.github.swissld.temp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
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
public class CSV
	{
	/**
	 * @since 0.1.0
	 */
	public static final <T> List<T> parse(final Path path, final Function<CSVRecord, T> mapper) throws IOException
		{
		Objects.requireNonNull(mapper);

		final var list = new ArrayList<T>();

		parse(path, record ->
			{
			list.add(mapper.apply(record));
			});

		return list;
		}

	/**
	 * @since 0.1.0
	 */
	public static final void parse(final Path path, final Consumer<CSVRecord> consumer) throws IOException
		{
		Objects.requireNonNull(path);
		Objects.requireNonNull(consumer);

		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, defaultFormatWithSkipHeader()))
			{
			//records.stream().map(null)
			records.forEach(consumer);
			}
		}

	/**
	 * @since 0.1.0
	 */
	public static final CSVFormat defaultFormatWithSkipHeader()
		{
		return skipHeader(CSVFormat.Builder.create()).build();
		}

	/**
	 * @since 0.1.0
	 */
	public static final CSVFormat.Builder skipHeader(final CSVFormat.Builder builder)
		{
		Objects.requireNonNull(builder);

		return builder.setHeader().setSkipHeaderRecord(true);
		}
	}
