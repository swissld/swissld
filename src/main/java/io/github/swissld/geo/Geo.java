package io.github.swissld.geo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import io.github.swissld.GPS;
import io.github.swissld.json.JSON;
import io.github.swissld.jsonld.JSONLD;
import io.github.swissld.schema.org.Properties;

/**
 * <h3>Geo</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Geo
	{
	/**
	 * @since 0.1.0
	 */
	public static final String parse(final Path path) throws IOException
		{
		return JSON.write(writer ->
			{
			writer.setIndent("  ");

			writer.beginArray();

			GPS.parse(path, point ->
				{
				writer.beginObject();

				writer.name(JSONLD.TYPE);
				writer.value("GeoCoordinates");

				writer.name(Properties.NAME);
				writer.value(point.description());

				writer.name(Properties.LATITUDE);
				writer.value(point.latitude());

				writer.name(Properties.LONGITUDE);
				writer.value(point.longitude());

				writer.endObject();
				});

			writer.endArray();
			});
		}

	/**
	 * @since 0.1.0
	 */
	public static final void points() throws IOException
		{
		try (final var paths = Files.newDirectoryStream(Path.of("gps", "csv")))
			{
			for (final var path : paths)
				{
				System.out.println(parse(path));
				}
			}
		}

	/*
	public static final String pointsAsGeoCoordinates(final Path path) throws IOException
		{
		}
	*/
	}
