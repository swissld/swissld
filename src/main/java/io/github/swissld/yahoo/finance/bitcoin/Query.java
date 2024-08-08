package io.github.swissld.yahoo.finance.bitcoin;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.commons.io.function.IOBiFunction;

@FunctionalInterface
public interface Query extends IOBiFunction<String, String, String>
	{
	public static final Function<String, String> PERIOD = date ->
		{
		Objects.requireNonNull(date);

		final var epoch = LocalDateTime.parse(date + "T00:00:00")
			.atZone(ZoneId.systemDefault())
			.toInstant()
			.toEpochMilli();

		return Long.toString(epoch / 1000);
		};

	public static final BiFunction<String, String, java.net.URI> URI = (from, to) ->
		{
		//https://finance.yahoo.com/quote/BTC-USD/history/?period1=1410912000&period2=1722470400&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true&guccounter=1
		//final var template = "https://finance.yahoo.com/quote/BTC-USD/history/?period1=%s&period2=%s&interval=1d&filter=history&frequency=1d&includeAdjustedClose=true";
		//https://query1.finance.yahoo.com/v7/finance/download/BTC-USD?period1=1690840800&period2=1722463200&interval=1d&events=history&includeAdjustedClose=true

		final var template = "https://query1.finance.yahoo.com/v7/finance/download/BTC-USD?period1=%s&period2=%s&interval=1d&events=history&includeAdjustedClose=true";

		return java.net.URI.create(String.format(template, PERIOD.apply(from), PERIOD.apply(to)));
		};
	}
