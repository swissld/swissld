package io.github.swissld;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.stream.Streams;

/**
 * <h3>GPS</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public record GPS(String type, LocalDateTime date, double latitude, double longitude, double altitude, float accuracy, int satellitesUsed, int satellitesInView, String name, String description)
	{
	/**
	 * @since 0.1.0
	 */
	public static final void parse(final Path path, final FailableConsumer<GPS, IOException> consumer) throws IOException
		{
		Objects.requireNonNull(path);
		Objects.requireNonNull(consumer);

		final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		final FailableFunction<CSVRecord, GPS, IOException> mapper = record ->
			{
			final var type = record.get(Header.TYPE);
			final var date = LocalDateTime.parse(record.get(Header.DATE_TIME), dateTimeFormat);
			final var latitude = Double.parseDouble(record.get(Header.LATITUDE));
			final var longitude = Double.parseDouble(record.get(Header.LONGITUDE));
			final var altitude = Double.parseDouble(record.get(Header.ALTITUDE));
			final var accuracy = Float.parseFloat(record.get(Header.ACCURACY));
			final var satellitesUsed = Integer.parseInt(record.get(Header.SATELLITES_USED));
			final var satellitesInView = Integer.parseInt(record.get(Header.SATELLITES_IN_VIEW));
			final var name = record.get(Header.NAME);
			final var description = record.get(Header.DESCRIPTION);

			return new GPS(type, date, latitude, longitude, altitude, accuracy, satellitesUsed, satellitesInView, name, description);
			};

		final var format = CSVFormat.Builder.create().setHeader(Header.class).setSkipHeaderRecord(true).build();

		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
			{
			Streams.failableStream(records.stream()).map(mapper).forEach(consumer);
			}
		}
	}

/**
 * <h3>Header</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
enum Header
	{
	TYPE,
	DATE_TIME,
	LATITUDE,
	LONGITUDE,
	ACCURACY,
	ALTITUDE,
	GEOID_HEIGHT,
	SPEED,
	BEARING,
	SATELLITES_USED,
	SATELLITES_IN_VIEW,
	NAME,
	DESCRIPTION
	}
