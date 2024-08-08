package io.github.swissld.lod;

import java.net.URI;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

/**
 * <h3>SwissLD</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class SwissLD extends Vocabulary<SwissLD>
	{
	/**
	 * @since 0.1.0
	 */
	public SwissLD()
		{
		super(URI.create("uri:io.github.swissld#"));
		}

	/**
	 * @since 0.1.0
	 */
	public Property name()
		{
		return createProperty("name");
		}

	/**
	 * @since 0.1.0
	 */
	public SwissLD name(final Resource resource, final String name)
		{
		return addProperty(resource, name(), name);
		}
	}
