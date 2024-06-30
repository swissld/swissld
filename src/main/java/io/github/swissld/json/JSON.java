package io.github.swissld.json;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Objects;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.function.FailableConsumer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

/**
 * <h3>JSON</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class JSON implements FailableConsumer<JsonWriter, IOException>
	{
	public static final Gson GSON = new GsonBuilder()
		.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
		.setPrettyPrinting()
		.create();

	@Override
	public void accept(final JsonWriter writer) throws IOException
		{
		throw new NotImplementedException();
		}

	/**
	 * @since 0.1.0
	 */
	public final void write(final Writer writer) throws IOException
		{
		write(writer, this);
		}

	/**
	 * @since 0.1.0
	 */
	public final String write() throws IOException
		{
		return write(this);
		}

	/**
	 * @since 0.1.0
	 */
	public final void write(final Path path) throws IOException
		{
		write(path, this);
		}

	/**
	 * @since 0.1.0
	 */
	protected static final void write(final Writer writer, final FailableConsumer<JsonWriter, IOException> consumer) throws IOException
		{
		Objects.requireNonNull(writer);
		Objects.requireNonNull(consumer);

		try (final var buffer = new BufferedWriter(writer))
			{
			try (final var jsonWriter = new JsonWriter(buffer))
				{
				consumer.accept(jsonWriter);
				}
			}
		}

	/**
	 * @since 0.1.0
	 */
	public static final String write(final FailableConsumer<JsonWriter, IOException> consumer) throws IOException
		{
		try (final var writer = new StringWriter())
			{
			write(writer, consumer);

			return writer.toString();
			}
		}

	/**
	 * @since 0.1.0
	 */
	public static final void write(final Path path, final FailableConsumer<JsonWriter, IOException> consumer) throws IOException
		{
		Objects.requireNonNull(path);

		try (final var writer = new FileWriter(path.toFile()))
			{
			write(writer, consumer);
			}
		}

	/**
	 * @since 0.1.0
	 */
	public static final String toString(final Object object)
		{
		return GSON.toJson(object);
		}
	}
