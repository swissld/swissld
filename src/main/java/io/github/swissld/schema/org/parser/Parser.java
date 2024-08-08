package io.github.swissld.schema.org.parser;

import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import io.github.swissld.http.Client;
import io.github.swissld.schema.org.Release;

/**
 * <h3>Parser</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class Parser extends Client
	{
	private final String get(final Release release, final String typesOrProperties) throws IOException
		{
		final var template = "https://github.com/schemaorg/schemaorg/raw/main/data/releases/%s/schemaorg-all-https-%s.csv";

		return get(String.format(template, release.getVersion(), typesOrProperties));
		}

	// https://github.com/schemaorg/schemaorg/raw/main/data/releases/27.02/schemaorg-all-https-types.csv
	// https://github.com/schemaorg/schemaorg/raw/main/data/releases/27.02/schemaorg-all-https-properties.csv

	private final void csv(final String csv) throws IOException
		{
		final var format = CSVFormat.Builder.create().setSkipHeaderRecord(true).build();

		try (final var records = CSVParser.parse(csv, format))
			{
			records.forEach(record ->
				{
				System.out.println(record.get(0));
				});
			}
		}

	public static void main(String[] args) throws Exception
		{
		final var parser = new Parser();

		final var csv = parser.get(Release.CURRENT, "types");

		parser.csv(csv);
		//System.out.println(csv);
		}
	}
