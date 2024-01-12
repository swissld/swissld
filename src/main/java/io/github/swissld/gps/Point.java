package io.github.swissld.gps;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <h3>Point</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class Point
	{
	private final String type;
	private final LocalDateTime date;
	private final Coordinate coordinate;
	private final float accuracy;
	private final String name;
	private final String description;

	/**
	 * @since 0.1.0
	 */
	public Point(final String type, final LocalDateTime date, final Coordinate coordinate, final float accuracy, final String name, final String description)
		{
		super();

		this.type = Objects.requireNonNull(type);
		this.date = Objects.requireNonNull(date);
		this.coordinate = Objects.requireNonNull(coordinate);
		this.accuracy = accuracy;
		this.name = Objects.requireNonNull(name);
		this.description = Objects.requireNonNull(description);
		}

	/**
	 * @since 0.1.0
	 */
	public String getType()
		{
		return type;
		}

	/**
	 * @since 0.1.0
	 */
	public LocalDateTime getDateTime()
		{
		return date;
		}

	/**
	 * @since 0.1.0
	 */
	public Coordinate getCoordinate()
		{
		return coordinate;
		}

	/**
	 * @since 0.1.0
	 */
	public float getAccuracy()
		{
		return accuracy;
		}

	/**
	 * @since 0.1.0
	 */
	public String getName()
		{
		return name;
		}

	/**
	 * @since 0.1.0
	 */
	public String getDescription()
		{
		return description;
		}
	}
