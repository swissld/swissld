package io.github.swissld.gps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSV
	{
	protected static final int TYPE = 0;
	protected static final int DATETIME = 1;
	protected static final int LATITUDE = 2;
	protected static final int LONGITUDE = 3;
	protected static final int ACCURACY = 4;
	protected static final int ALTITUDE = 5;
	protected static final int GEOID = 6;
	protected static final int SPEED = 7;
	protected static final int BEARING = 8;
	protected static final int SATELLITES_USED = 9;
	protected static final int SATELLITES_IN_VIEW = 10;
	protected static final int NAME = 11;
	protected static final int DESCRIPTION = 12;

	protected static final String[] HEADERS =
		{
		"type",
		"date time",
		"latitude",
		"longitude",
		"accuracy(m)",
		"altitude(m)",
		"geoid_height(m)",
		"speed(m/s)",
		"bearing(deg)",
		"sat_used",
		"sat_inview",
		"name",
		"desc"
		};

	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void parse(final Path path, final Consumer<CSVRecord> consumer) throws IOException
		{
		Objects.requireNonNull(path);
		Objects.requireNonNull(consumer);

		final var format = CSVFormat.Builder.create().setHeader(HEADERS).setSkipHeaderRecord(true).build();

		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
			{
			records.forEach(consumer);
			}
		}

	public List<Coordinate> parse(final Path path) throws IOException
		{
		final var coordinates = new ArrayList<Coordinate>();

		parse(path, record -> coordinates.add(parse(record)));

		return coordinates;
		}

	public static final Coordinate parse(final CSVRecord record)
		{
		Objects.requireNonNull(record);

		final var type = Type.parse(record.get(TYPE));

		final var latitude = Float.parseFloat(record.get(LATITUDE));
		final var longitude = Float.parseFloat(record.get(LONGITUDE));
		final var altitude = Float.parseFloat(record.get(ALTITUDE));

		final var point = new Point(latitude, longitude, altitude);

		final var coordinate = new Coordinate(type, point);

		coordinate.date = LocalDateTime.parse(record.get(DATETIME), FORMAT);
		coordinate.accuracy = Float.parseFloat(record.get(ACCURACY));
		coordinate.satellitesUsed = Integer.parseInt(record.get(SATELLITES_USED));
		coordinate.satellitesInView = Integer.parseInt(record.get(SATELLITES_IN_VIEW));
		coordinate.name = record.get(NAME);
		coordinate.description = record.get(DESCRIPTION);

		return coordinate;
		}
	}
