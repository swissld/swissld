package io.github.swissld.schema.org;

/**
 * <h3>SchemaOrg</h3>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class SchemaOrg
	{
	/**
	 * @since 0.1.0
	 */
	public static final Context getContext()
		{
		return Context.HTTPS;
		}

	/**
	 * @since 0.1.0
	 */
	public static final Release getCurrentRelease()
		{
		return Release.CURRENT;
		}
	}
