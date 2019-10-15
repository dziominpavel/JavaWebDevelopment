package by.dziomin.trade.dao;

import com.mysql.jdbc.Statement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public abstract class AbstractDao {

    private Connection connection;

    public AbstractDao(final Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    protected PreparedStatement createPreparedStatement(String query,
                                                        Object... params) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            if (param instanceof Integer) {
                statement.setInt(i + 1, (Integer) param);
            } else if (param instanceof String) {
                statement.setString(i + 1, (String) param);
            } else if (param instanceof BigDecimal) {
                statement.setBigDecimal(i + 1, (BigDecimal) param);
            } else if (param instanceof Date) {
                Date date = (Date)param;
                statement.setDate(i + 1, new java.sql.Date(date.getTime()));
            }
        }
        return statement;
    }

    protected Integer getCreatedId(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            return (int) resultSet.getLong(1);
        }
        return null;
    }
}
