package by.dziomin.trade.dao.impl;

import by.dziomin.trade.dao.ReceiptDao;
import by.dziomin.trade.entity.ReceiptEntity;
import by.dziomin.trade.entity.UserEntity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * DAO implementation for receipts
 *
 * @author - Pavel Dziomin
 */
public class ReceiptDaoImpl extends BaseDaoImpl<ReceiptEntity> implements ReceiptDao {

    private final static String SQL_SELECT_All = "SELECT id, user_id, date,"
            + "sum FROM RECEIPT";
    private final static String SQL_SELECT_BY_ID = "SELECT id, user_id, date," +
            "sum FROM RECEIPT WHERE id = ?";
    private final static String SQL_INSERT = "INSERT INTO RECEIPT (user_id, date, sum) VALUES (?, ?, ?)";
    private final static String SQL_DELETE = "DELETE FROM RECEIPT WHERE id = ?";
    private final static String SQL_UPDATE = "UPDATE RECEIPT SET user_id = ?," +
            " date = ?, sum = ? WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection db connection
     */
    public ReceiptDaoImpl(final Connection connection) {
        super(connection);
    }

    @Override
    String getSqlSelectAll() {
        return SQL_SELECT_All;
    }

    @Override
    String getSqlSelectById() {
        return SQL_SELECT_BY_ID;
    }

    @Override
    String getSqlInsert() {
        return SQL_INSERT;
    }

    @Override
    String getSqlUpdate() {
        return SQL_UPDATE;
    }

    @Override
    String getSqlDelete() {
        return SQL_DELETE;
    }

    @Override
    Object[] getInsertParams(final ReceiptEntity entity) {
        return new Object[]{entity.getUser().getId(),
                entity.getDate(), entity.getAmount()};
    }

    @Override
    Object[] getUpdateParams(final ReceiptEntity entity) {
        return new Object[]{entity.getUser().getId(),
                entity.getDate(), entity.getAmount(),
                entity.getId()};
    }

    @Override
    protected ReceiptEntity mapQueryResult(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        UserEntity user = new UserEntity();
        Long userId = resultSet.getLong("user_id");
        user.setId(userId);
        LocalDateTime dateTime =
                resultSet.getTimestamp("date").toLocalDateTime();
        BigDecimal amount = resultSet.getBigDecimal("sum");

        ReceiptEntity entity = new ReceiptEntity();
        entity.setId(id);
        entity.setUser(user);
        entity.setDate(dateTime);
        entity.setAmount(amount);
        return entity;
    }
}

