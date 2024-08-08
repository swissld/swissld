package io.github.swissld.schema.org;

import java.net.URI;

/**
 * <h3>Context</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public enum Context
	{
	HTTP("http://schema.org"),
	HTTPS("https://schema.org");

	private final URI uri;

	private Context(final String uri)
		{
		this.uri = URI.create(uri);
		}

	public URI getURI()
		{
		return uri;
		}

	//public static final String HTTP = "http://schema.org";
	//public static final String HTTPS = "https://schema.org";
	}
