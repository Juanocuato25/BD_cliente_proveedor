package org.jarenas.clientes.proveedores.bd.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConecionBDMysql {

    private static String url = "jdbc:mysql://localhost:3306/clientes_proveedores_bd";

    private static String username = "root";

    private static String password = "root";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance()throws SQLException{
        if (pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);

            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
