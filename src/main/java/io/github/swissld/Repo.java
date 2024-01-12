package io.github.swissld;

import java.nio.file.Path;
import com.google.gson.GsonBuilder;
import io.github.swissld.gps.GPS;

public class Repo
	{
	public static void main(String[] args) throws Exception
		{
		final var points = new GPS().parse(Path.of("gps/csv/20240106-133310 - Av General guisan.txt"));

		//System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(points));
		/*
		final var coordinates = new CSV().parse();

		coordinates.stream().filter(Coordinate::isPoint).forEach(coordinate ->
			{
			System.out.println(coordinate.description + ":" + coordinate.getPoint().getLatitude() + "," + coordinate.getPoint().getLongitude());
			});

		new JSON().writeGeoCoordinates();
		*/
		}
	}
