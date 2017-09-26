package com.art2cat.dev.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@Profile("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class DataBaseTest extends ADatabaseTest{

    private BasicDataSource devDataSource;
    private BaseDao baseDao;

    @Before
    public void _init() {
        super._init();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("database/spring.xml");
        devDataSource = (BasicDataSource) ctx.getBean("dataSource");
        baseDao = BaseDao.getAdapter(devDataSource);
    }

    @Test
    public void testQuery() {
        Connection connection = baseDao.getConnection();

        String sql = "select * from vendors where vend_id = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Vendor o = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 12222);
            rs = statement.executeQuery();

            if (rs != null && rs.next()) {
                o = new Vendor();
                o.setId(rs.getLong("VEND_ID"));
                o.setName(rs.getString("VEND_NAME"));
                o.setAddress(rs.getString("VEND_ADDRESS"));
                o.setCity(rs.getString("VEND_CITY"));
                o.setState(rs.getString("VEND_STATE"));
                o.setZip(rs.getString("VEND_ZIP"));
                o.setCountry(rs.getString("VEND_COUNTRY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        assertNotNull(o);
        assertEquals(vendor.getName(), o.getName().trim());
        assertEquals(vendor.getCountry(), o.getCountry().trim());
        assertEquals(vendor.getAddress(), o.getAddress().trim());
    }

    @Test
    public void testDelete() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = devDataSource.getConnection();
            String sql = "delete from vendors where vend_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 12222);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testInsert() throws SQLException {
        Connection connection = devDataSource.getConnection();
        String sql = "insert into vendors values(?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1, vendor.getId());
        statement.setObject(2, vendor.getName());
        statement.setObject(3, vendor.getAddress());
        statement.setObject(4, vendor.getCity());
        statement.setObject(5, vendor.getState());
        statement.setObject(6, vendor.getZip());
        statement.setObject(7, vendor.getCountry());
        statement.execute();

        statement.close();
        connection.close();
    }
}
