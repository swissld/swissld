package io.github.swissld.yahoo.finance.bitcoin;

import java.io.IOException;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOBiFunction;
import org.apache.commons.lang3.NotImplementedException;
//import io.github.swissld.http.Client;

public class Bitcoin
	{
	public static final Query QUERY = Bitcoin::query;

	public static final Parser PARSER = csv -> null;

	public static final IOBiFunction<String, String, Stream<String>> PARSE = QUERY.andThen(PARSER);

	/*
	public static final ParserInterface LKJKLJ = Bitcoin::sdsds;

	public static final Stream<String> sdsds(final String sdsd) throws IOException
		{
		return null;
		}
	*/

	public static void asa() throws Exception
		{
		//	Query.URI.andThen(QUERY);
		PARSE.apply("2023-08-01", null).filter(null);
		}

	public static final String query(final String from, final String to) throws IOException
		{
		//return new Client().get(Query.URI.apply(from, to)).get();

		throw new NotImplementedException();

		/*
		try
			{
			final var uri = Query.URI.apply(from, to);

			final var request = HttpRequest.newBuilder().uri(uri).GET().build();

			final var client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();

			return client.send(request, BodyHandlers.ofString()).body();
			}
		catch (final InterruptedException ex)
			{
			throw new IOException(ex);
			}
		*/
		}
	}
