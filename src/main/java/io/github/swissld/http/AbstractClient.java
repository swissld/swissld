package io.github.swissld.http;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Objects;

/**
 * <h3>AbstractClient</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractClient<T> implements ClientInterface<T>
	{
	protected final HttpClient client;

	/**
	 * @since 0.1.0
	 */
	public AbstractClient()
		{
		this(newClient());
		}

	/**
	 * @since 0.1.0
	 */
	public AbstractClient(final HttpClient client)
		{
		super();

		this.client = Objects.requireNonNull(client);
		}

	/**
	 * @since 0.1.0
	 */
	protected final <R> R send(final HttpRequest request, final HttpResponse.BodyHandler<R> handler) throws IOException
		{
		try
			{
			return client.send(request, handler).body();
			}
		catch (final InterruptedException ex)
			{
			throw new IOException(ex);
			}
		}

	/**
	 * @since 0.1.0
	 */
	protected final String asString(final HttpRequest request) throws IOException
		{
		return send(request, BodyHandlers.ofString());
		}

	/**
	 * @since 0.1.0
	 */
	private static final HttpClient newClient()
		{
		return HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
		}
	}
