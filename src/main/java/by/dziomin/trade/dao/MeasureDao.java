package by.dziomin.trade.dao;

import by.dziomin.trade.entity.Measure;

public interface MeasureDao extends BaseDao<Measure> {

    Measure getByName(String name) throws DaoException;
}
