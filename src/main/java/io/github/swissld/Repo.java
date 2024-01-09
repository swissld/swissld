package io.github.swissld;

import java.nio.file.Path;
import io.github.swissld.gps.CSV;
import io.github.swissld.gps.Coordinate;

public class Repo
	{
	public static void main(String[] args) throws Exception
		{
		final var coordinates = new CSV().parse(Path.of("../gps/20240106-133310 - Av General guisan.txt"));

		coordinates.stream().filter(Coordinate::isPoint).forEach(coordinate ->
			{
			System.out.println(coordinate.description + ":" + coordinate.getPoint().getLatitude() + "," + coordinate.getPoint().getLongitude());
			});
		}
	}
