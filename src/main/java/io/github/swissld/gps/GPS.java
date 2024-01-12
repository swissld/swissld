package io.github.swissld.gps;

import java.time.format.DateTimeFormatter;
import org.apache.commons.csv.CSVRecord;
import io.github.swissld.util.CSV;

/**
 * <h3>GPS</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class GPS extends CSV<Point>
	{
	private static final int TYPE = 0;
	private static final int DATETIME = 1;
	private static final int LATITUDE = 2;
	private static final int LONGITUDE = 3;
	private static final int ACCURACY = 4;
	private static final int ALTITUDE = 5;
	//private static final int GEOID = 6;
	//private static final int SPEED = 7;
	//private static final int BEARING = 8;
	//private static final int SATELLITES_USED = 9;
	//private static final int SATELLITES_IN_VIEW = 10;
	private static final int NAME = 11;
	private static final int DESCRIPTION = 12;

	/*
	private static final String[] HEADERS =
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
	*/

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public Point apply(final CSVRecord record)
		{
		final var type = getAsString(record, TYPE);
		final var date = getAsDateTime(record, DATETIME, DATE_TIME_FORMAT);

		final var latitude = getAsDouble(record, LATITUDE).doubleValue();
		final var longitude = getAsDouble(record, LONGITUDE).doubleValue();
		final var altitude = getAsDouble(record, ALTITUDE).doubleValue();

		final var coordinate = new Coordinate(latitude, longitude, altitude);

		final var accuracy = getAsFloat(record, ACCURACY);
		final var name = getAsString(record, NAME);
		final var description = getAsString(record, DESCRIPTION);

		final var point = new Point(type, date, coordinate, accuracy, name, description);

		return point;
		}
	}
