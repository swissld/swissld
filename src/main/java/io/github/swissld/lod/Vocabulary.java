package io.github.swissld.lod;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 * <h3>Vocabulary</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Vocabulary<T extends Vocabulary<T>>
	{
	protected final URI uri;

	/**
	 * @since 0.1.0
	 */
	@SuppressWarnings("unused")
	private Vocabulary()
		{
		throw new UnsupportedOperationException();
		}

	/**
	 * @since 0.1.0
	 */
	public Vocabulary(final URI uri)
		{
		super();

		this.uri = Objects.requireNonNull(uri);
		}

	/**
	 * @since 0.1.0
	 */
	public Vocabulary(final String uri) throws URISyntaxException
		{
		this(new URI(Objects.requireNonNull(uri)));
		}

	/**
	 * @since 0.1.0
	 */
	public final Property createProperty(final String localName)
		{
		return ResourceFactory.createProperty(uri.toString(), Objects.requireNonNull(localName));
		}

	/**
	 * @since 0.1.0
	 */
	public final T addProperty(final Resource resource, final Property property, final String value)
		{
		Objects.requireNonNull(resource);
		Objects.requireNonNull(property);
		Objects.requireNonNull(value);

		resource.addProperty(property, value);

		return getT();
		}

	@SuppressWarnings("unchecked")
	protected final T getT()
		{
		return (T) this;
		}
	}
