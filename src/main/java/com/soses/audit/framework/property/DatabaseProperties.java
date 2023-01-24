package com.soses.audit.framework.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/${hris_env}/database.properties")
public class DatabaseProperties {

	/** The driver class name. */
    @Value("${db.driverClassName}")
    protected String driverClassName;

    /** The host. */
    @Value("${db.host}")
    protected String host;

    /** The port. */
    @Value("${db.port}")
    protected String port;

    /** The db name. */
    @Value("${db.dbName}")
    protected String dbName;

    /** The username. */
    @Value("${db.username}")
    protected String username;

    /** The password. */
    @Value("${db.password}")
    protected String password;

    /** The max pool size. */
    @Value("${db.maxPoolSize}")
    protected int maxPoolSize;

    /** The minimum idle. */
    @Value("${db.minimumIdle}")
    protected int minimumIdle;

    /** The idle timeout. */
    @Value("${db.idleTimeout}")
    protected int idleTimeout;

    /** The connection test query. */
    @Value("${db.connectionTestQuery}")
    protected String connectionTestQuery;

    /** The pool name. */
    @Value("${db.poolName}")
    protected String poolName;

    /** The cache prep stmts. */
    @Value("${db.cachePrepStmts}")
    protected boolean cachePrepStmts;

    /** The prep stmt cache size. */
    @Value("${db.prepStmtCacheSize}")
    protected int prepStmtCacheSize;

    /** The prep stmt cache sql limit. */
    @Value("${db.prepStmtCacheSqlLimit}")
    protected int prepStmtCacheSqlLimit;

    /** The use server prep stmts. */
    @Value("${db.useServerPrepStmts}")
    protected boolean useServerPrepStmts;

	/**
	 * Gets the driver class name.
	 *
	 * @return the driver class name
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Gets the db name.
	 *
	 * @return the db name
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the max pool size.
	 *
	 * @return the max pool size
	 */
	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	/**
	 * Gets the minimum idle.
	 *
	 * @return the minimum idle
	 */
	public int getMinimumIdle() {
		return minimumIdle;
	}

	/**
	 * Gets the idle timeout.
	 *
	 * @return the idle timeout
	 */
	public int getIdleTimeout() {
		return idleTimeout;
	}

	/**
	 * Gets the connection test query.
	 *
	 * @return the connection test query
	 */
	public String getConnectionTestQuery() {
		return connectionTestQuery;
	}

	/**
	 * Gets the pool name.
	 *
	 * @return the pool name
	 */
	public String getPoolName() {
		return poolName;
	}

	/**
	 * Checks if is cache prep stmts.
	 *
	 * @return true, if is cache prep stmts
	 */
	public boolean isCachePrepStmts() {
		return cachePrepStmts;
	}

	/**
	 * Gets the prep stmt cache size.
	 *
	 * @return the prep stmt cache size
	 */
	public int getPrepStmtCacheSize() {
		return prepStmtCacheSize;
	}

	/**
	 * Gets the prep stmt cache sql limit.
	 *
	 * @return the prep stmt cache sql limit
	 */
	public int getPrepStmtCacheSqlLimit() {
		return prepStmtCacheSqlLimit;
	}

	/**
	 * Checks if is use server prep stmts.
	 *
	 * @return true, if is use server prep stmts
	 */
	public boolean isUseServerPrepStmts() {
		return useServerPrepStmts;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DatabaseProperties [driverClassName=" + driverClassName + ", host=" + host + ", port=" + port
				+ ", dbName=" + dbName + ", username=" + username + ", password=" + password + ", maxPoolSize="
				+ maxPoolSize + ", minimumIdle=" + minimumIdle + ", idleTimeout=" + idleTimeout
				+ ", connectionTestQuery=" + connectionTestQuery + ", poolName=" + poolName + ", cachePrepStmts="
				+ cachePrepStmts + ", prepStmtCacheSize=" + prepStmtCacheSize + ", prepStmtCacheSqlLimit="
				+ prepStmtCacheSqlLimit + ", useServerPrepStmts=" + useServerPrepStmts + "]";
	}
}
