package com.art2cat.dev.database;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;


@Component
public class BaseDao {

    private static BaseDao baseDao;
    private Connection connection;

    public BaseDao() {

    }

    public static BaseDao getAdapter(BasicDataSource devDataSource) {
        if (baseDao != null) {

        } else {
            synchronized (BaseDao.class) {
                if (baseDao == null) {
                    baseDao = new BaseDao();
                }
            }
        }

        if (baseDao.getConnection() == null) {
            try {
                baseDao.setConnection(devDataSource.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return baseDao;
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

}
