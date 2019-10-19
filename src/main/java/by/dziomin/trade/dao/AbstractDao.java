package by.dziomin.trade.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract DAO
 *
 * @author - Pavel Dziomin
 */
public abstract class AbstractDao {

    private Connection connection;

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public AbstractDao(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Get db connection
     *
     * @return db connection
     */
    protected Connection getConnection() {
        return connection;
    }

    /**
     * Set query parameters
     *
     * @param statement prepared statement
     * @param params    parameters
     * @throws SQLException sql exception
     */
    protected void setParameters(final PreparedStatement statement, final Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            if (param instanceof Integer) {
                statement.setInt(i + 1, (Integer) param);
            } else if (param instanceof Long) {
                statement.setLong(i + 1, (Long) param);
            } else if (param instanceof String) {
                statement.setString(i + 1, (String) param);
            } else if (param instanceof BigDecimal) {
                statement.setBigDecimal(i + 1, (BigDecimal) param);
            } else if (param instanceof LocalDateTime) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                statement.setString(i + 1, ((LocalDateTime) param).format(formatter));
            }
        }
    }

    /**
     * Get generated id while entity created
     *
     * @param statement prepared statement
     * @return generated entity id
     * @throws SQLException sql exception
     */
    protected Long getCreatedId(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        }
        return null;
    }
}
