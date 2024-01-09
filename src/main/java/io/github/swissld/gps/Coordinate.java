package io.github.swissld.gps;

import java.time.LocalDateTime;
import java.util.Objects;

public class Coordinate
	{
	protected final Type type;
	public LocalDateTime date;
	protected final Point point;
	public float accuracy;
	public int satellitesUsed;
	public int satellitesInView;
	public String name;
	public String description;

	/**
	 * @since 0.1.0
	 */
	public Coordinate(final Type type, final Point point)
		{
		super();

		this.type = Objects.requireNonNull(type);
		this.point = Objects.requireNonNull(point);
		}

	/**
	 * @since 0.1.0
	 */
	public final Type getType()
		{
		return type;
		}

	/**
	 * @since 0.1.0
	 */
	public final Point getPoint()
		{
		return point;
		}

	/**
	 * @since 0.1.0
	 */
	public final boolean isTrackPoint()
		{
		return type == Type.TRACK;
		}

	/**
	 * @since 0.1.0
	 */
	public final boolean isPoint()
		{
		return type == Type.POINT;
		}
	}
