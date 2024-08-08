package io.github.swissld.csv;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h3>CSV</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class CSV<T, E extends Throwable> extends AbstractCSV<T, E>
	{
	@Override
	public T apply(final CSVRecord record) throws E
		{
		throw new NotImplementedException();
		}
	}
