package io.github.swissld.ld;

import java.time.LocalDateTime;

public record Event(String name, LocalDateTime startDate, LocalDateTime endDate)
	{
	}
