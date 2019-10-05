package by.dziomin.trade.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        PreparedStatement statement = getConnection().prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            if (param instanceof Integer) {
                statement.setInt(i + 1, (Integer) param);
            } else if (param instanceof String) {
                statement.setString(i + 1, (String) param);
            } else if (param instanceof BigDecimal) {
                statement.setBigDecimal(i + 1, (BigDecimal) param);
            } else if (param instanceof Date) {
                //statement.setDate(i + 1, (Date)param);
            }
        }
        return statement;
    }
}
