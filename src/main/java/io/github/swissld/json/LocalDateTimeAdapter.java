package io.github.swissld.json;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.NotImplementedException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.github.swissld.util.DateTimeFormats;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime>
	{
	private final DateTimeFormatter formatter = DateTimeFormats.ISO_8601;

	/**
	 * @since 0.1.0
	 */
	@Override
	public LocalDateTime read(final JsonReader reader) throws IOException
		{
		throw new NotImplementedException();
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void write(final JsonWriter writer, final LocalDateTime date) throws IOException
		{
		try
			{
			final var value = formatter.format(date);

			writer.value(value);
			}
		catch (final DateTimeException ex)
			{
			// TODO: Quelle erreur pour format date ????
			throw new JsonSyntaxException(ex);
			}
		}
	}
