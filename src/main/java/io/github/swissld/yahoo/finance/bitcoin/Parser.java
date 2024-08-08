package io.github.swissld.yahoo.finance.bitcoin;

import java.util.stream.Stream;
import org.apache.commons.io.function.IOFunction;

@FunctionalInterface
public interface Parser extends IOFunction<String, Stream<String>>
	{
	}
