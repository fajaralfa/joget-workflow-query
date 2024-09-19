package com.fajaralfa.hashvariablequery;

import org.joget.apps.app.service.AppUtil;
import org.joget.commons.util.LogUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class KaryawanEmailDAO {
    public String getEmailByNrik(String nrik) {

        DataSource dataSource = (DataSource) AppUtil.getApplicationContext().getBean("setupDataSource");

        try (Connection con = dataSource.getConnection()) {
            String sql = "SELECT * FROM app_fd_mst_karyawan WHERE c_nrik = ? LIMIT 1";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nrik);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("c_email");
            }

        } catch (Exception e) {
            LogUtil.error(getClass().getName(), e, e.getMessage());
        }

        return "";
    }
    public String getColumnByNrik(String column, String nrik) {

        DataSource dataSource = (DataSource) AppUtil.getApplicationContext().getBean("setupDataSource");

        try (Connection con = dataSource.getConnection()) {
            String sql = "SELECT " + column + " FROM app_fd_mst_karyawan WHERE c_nrik = ? LIMIT 1";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nrik);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(column);
            }

        } catch (Exception e) {
            LogUtil.error(getClass().getName(), e, e.getMessage());
        }

        return "";
    }
}
