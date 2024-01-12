package io.github.swissld;

import java.io.IOException;
import java.io.StringWriter;
import com.google.gson.stream.JsonWriter;

public class JSON
	{
	public void writeGeoCoordinates() throws IOException
		{
		try (final var writer = new StringWriter())
			{
			try (final var jsonWriter = new JsonWriter(writer))
				{
				jsonWriter.beginObject();

				jsonWriter.name("@type");
				jsonWriter.value("GeoCoordinates");

				jsonWriter.name("latitude");
				jsonWriter.value(40.75);

				jsonWriter.name("longitude");
				jsonWriter.value(-73.98);

				jsonWriter.endObject();
				}

			System.out.println(writer.toString());
			}

		/*
		{
		"@context": "https://schema.org",
		"@type": "Place",
		"geo": {
		"@type": "GeoCoordinates",
		"latitude": "40.75",
		"longitude": "-73.98"
		},
		"name": "Empire State Building"
		}
		*/
		}
	}
