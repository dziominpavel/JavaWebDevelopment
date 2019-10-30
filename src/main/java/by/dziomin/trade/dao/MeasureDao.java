package by.dziomin.trade.dao;

import by.dziomin.trade.entity.MeasureEntity;

/**
 * DAO interface for measure
 *
 * @author - Pavel Dziomin
 */
public interface MeasureDao extends BaseDao<MeasureEntity> {

    /**
     * Get measure by name
     * @param name measure name
     * @return measure
     * @throws DaoException dao exception
     */
    MeasureEntity getByName(String name) throws DaoException;
}
