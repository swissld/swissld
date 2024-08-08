package io.github.swissld.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Objects;

/**
 * <h3>Client</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Client extends AbstractClient<String>
	{
	/**
	 * @since 0.1.0
	 */
	@Override
	public final String get(final URI uri) throws IOException
		{
		Objects.requireNonNull(uri);

		return asString(HttpRequest.newBuilder().uri(uri).GET().build());
		}
	}
