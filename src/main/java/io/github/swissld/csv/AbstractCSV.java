package io.github.swissld.csv;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.function.FailableFunction;

/**
 * <h3>AbstractCSV</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractCSV<T, E extends Throwable> implements FailableFunction<CSVRecord, T, E>
	{
	/*
	protected static final Function<CSVRecord, LocalDateTime> getAsDateTime(final int column, final DateTimeFormatter format)
		{
		return record -> LocalDateTime.parse(record.get(column), format);
		}
	*/
	}
