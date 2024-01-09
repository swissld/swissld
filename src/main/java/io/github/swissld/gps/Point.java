package io.github.swissld.gps;

/**
 * <h3>Point</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class Point
	{
	private final float latitude;
	private final float longitude;
	private final float altitude;

	/**
	 * @since 0.1.0
	 */
	public Point(final float latitude, final float longitude, final float altitude)
		{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		}

	/**
	 * @since 0.1.0
	 */
	public float getLatitude()
		{
		return latitude;
		}

	/**
	 * @since 0.1.0
	 */
	public float getLongitude()
		{
		return longitude;
		}

	/**
	 * @since 0.1.0
	 */
	public float getAltitude()
		{
		return altitude;
		}
	}
