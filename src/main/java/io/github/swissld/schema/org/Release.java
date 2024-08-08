package io.github.swissld.schema.org;

/**
 * <h3>Release</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public enum Release
	{
	RELEASE_20("20.0"),
	RELEASE_21("21.0"),
	RELEASE_22("22.0"),
	RELEASE_23("23.0"),
	RELEASE_24("24.0"),
	RELEASE_25("25.0"),
	RELEASE_26("26.0"),
	RELEASE_27("27.0"),
	RELEASE_27_01("27.01"),
	RELEASE_27_02("27.02");

	public static final Release CURRENT = RELEASE_27_02;

	private final String version;

	private Release(final String version)
		{
		this.version = version;
		}

	public String getVersion()
		{
		return version;
		}
	}
