package io.github.swissld.http;

import java.io.IOException;
import java.net.URI;
import java.util.Objects;

/**
 * <h3>GetInterface</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface GetInterface<T>
	{
	/**
	 * @since 0.1.0
	 */
	public default T get(final String uri) throws IOException
		{
		Objects.requireNonNull(uri);

		return get(URI.create(uri));
		}

	/**
	 * @since 0.1.0
	 */
	public T get(URI uri) throws IOException;
	}
