package io.github.swissld;

import org.apache.commons.lang3.exception.UncheckedException;
import org.apache.jena.query.Dataset;
import org.apache.jena.tdb1.TDB1Factory;
import io.github.swissld.application.ConsoleApplication;

/**
 * <h3>SwissLD</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class SwissLD extends ConsoleApplication<SwissLD, UncheckedException> implements AutoCloseable
	{
	private final Dataset dataset;

	/**
	 * @since 0.1.0
	 */
	public SwissLD()
		{
		super();

		//dataset = TDB1Factory.assembleDataset("data/config.ttl");
		dataset = TDB1Factory.createDataset("lod");
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void run()
		{
		/*
		final var model = dataset.getDefaultModel();
		final var resource = model.createResource("http://somewhere/JohnSmith");
		final var property = ResourceFactory.createProperty("http://www.w3.org/2001/vcard-rdf/3.0#", "FN");
		resource.addProperty(property, "sdsd");
		resource.addProperty(SchemaDO.about, "sddd");
		*/

		dataset.executeRead(() ->
			{
			});

		//final var line = scanner.nextLine();
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public void close()
		{
		dataset.close();
		}

	/**
	 * @since 0.1.0
	 */
	public static void main(final String[] args)
		{
		try (final var application = new SwissLD())
			{
			application.run();
			}
		catch (final Exception ex)
			{
			ex.printStackTrace();
			}
		}
	}
