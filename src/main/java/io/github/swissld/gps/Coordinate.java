package io.github.swissld.gps;

/**
 * <h3>Coordinate</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class Coordinate
	{
	private final double latitude;
	private final double longitude;
	private final double altitude;

	/**
	 * @since 0.1.0
	 */
	public Coordinate(final double latitude, final double longitude, final double altitude)
		{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		}

	/**
	 * @since 0.1.0
	 */
	public double getLatitude()
		{
		return latitude;
		}

	/**
	 * @since 0.1.0
	 */
	public double getLongitude()
		{
		return longitude;
		}

	/**
	 * @since 0.1.0
	 */
	public double getAltitude()
		{
		return altitude;
		}
	}
