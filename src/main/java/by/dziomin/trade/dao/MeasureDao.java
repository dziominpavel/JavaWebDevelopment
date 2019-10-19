package by.dziomin.trade.dao;

import by.dziomin.trade.entity.MeasureEntity;

public interface MeasureDao extends BaseDao<MeasureEntity> {

    MeasureEntity getByName(String name) throws DaoException;
}
