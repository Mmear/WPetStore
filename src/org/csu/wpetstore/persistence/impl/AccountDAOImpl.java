package org.csu.wpetstore.persistence.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.csu.wpetstore.domain.Account;
import org.csu.wpetstore.persistence.AccountDAO;
import org.csu.wpetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by WZF on 2018/4/29.
 */
public class AccountDAOImpl implements AccountDAO{
    private String sql_getAccByUsername = "SELECT "
            +"SIGNON.USERNAME,"
            +"ACCOUNT.EMAIL,"
            +"ACCOUNT.FIRSTNAME,"
            +"ACCOUNT.LASTNAME,"
            +"ACCOUNT.STATUS,"
            +"ACCOUNT.ADDR1 AS address1,"
            +"ACCOUNT.ADDR2 AS address2,"
            +"ACCOUNT.CITY,"
            +"ACCOUNT.STATE,"
            +"ACCOUNT.ZIP,"
            +"ACCOUNT.COUNTRY,"
            +"ACCOUNT.PHONE,"
            +"PROFILE.LANGPREF AS languagePreference,"
            +"PROFILE.FAVCATEGORY AS favouriteCategoryId,"
            +"PROFILE.MYLISTOPT AS listOption,"
            +"PROFILE.BANNEROPT AS bannerOption,"
            +"BANNERDATA.BANNERNAME "
            +"FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA "
            +"WHERE ACCOUNT.USERID = ?"
            +"AND SIGNON.USERNAME = ACCOUNT.USERID "
            +"AND PROFILE.USERID = ACCOUNT.USERID "
            +"AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private String sql_getAccByUNameAndPass = "SELECT "
            +"SIGNON.USERNAME,"
            +"ACCOUNT.EMAIL,"
            +"ACCOUNT.FIRSTNAME,"
            +"ACCOUNT.LASTNAME,"
            +"ACCOUNT.STATUS,"
            +"ACCOUNT.ADDR1 AS address1,"
            +"ACCOUNT.ADDR2 AS address2,"
            +"ACCOUNT.CITY,"
            +"ACCOUNT.STATE,"
            +"ACCOUNT.ZIP,"
            +"ACCOUNT.COUNTRY,"
            +"ACCOUNT.PHONE,"
            +"PROFILE.LANGPREF AS languagePreference,"
            +"PROFILE.FAVCATEGORY AS favouriteCategoryId,"
            +"PROFILE.MYLISTOPT AS listOption,"
            +"PROFILE.BANNEROPT AS bannerOption,"
            +"BANNERDATA.BANNERNAME "
            +"FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA "
            +"WHERE ACCOUNT.USERID = ?"
            +"AND SIGNON.PASSWORD = ?"
            +"AND SIGNON.USERNAME = ACCOUNT.USERID "
            +"AND PROFILE.USERID = ACCOUNT.USERID "
            +"AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private String sql_udAccount = "UPDATE ACCOUNT SET "
            +"EMAIL = ?,"
            +"FIRSTNAME = ?,"
            +"LASTNAME = ?,"
            +"STATUS = ?,"
            +"ADDR1 = ?,"
            +"ADDR2 = ?,"
            +"CITY = ?,"
            +"STATE = ?,"
            +"ZIP = ?,"
            +"COUNTRY = ?,"
            +"PHONE = ?"
            +"WHERE USERID = ?";
    private String sql_udProfile = "UPDATE PROFILE SET " +
            "LANGPREF = ?," +
            "FAVCATEGORY = ?" +
            "WHERE USERID = ?";
    private String sql_udSignon = "UPDATE SIGNON SET PASSWORD = ?" +
            "WHERE USERNAME = ?";

    private String sql_insSignon = "INSERT INTO SIGNON (USERNAME,PASSWORD)" +
            "VALUES (?, ?)";
    private String sql_insAccount = "INSERT INTO ACCOUNT"
            +"(EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID)"
            +"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String sql_insProfile = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID)" +
            "VALUES (?, ?, ?)";
    private String sql_getBanner = "SELECT BANNERNAME FROM BANNERDATA WHERE FAVCATEGORY=?";
    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getAccByUsername);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                account = new Account(rs.getString(1),null,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
                account.setLanguagePreference(rs.getString(13));
                account.setFavouriteCategoryId(rs.getString(14));
                account.setBannerOption(Boolean.parseBoolean(rs.getString(16)));
                account.setBannerName(rs.getString(17));
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account acc = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getAccByUNameAndPass);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                acc = new Account(rs.getString(1),null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                acc.setLanguagePreference(rs.getString(13));
                acc.setFavouriteCategoryId(rs.getString(14));
                if(rs.getInt(16) == 1){
                    acc.setBannerOption(true);
                }
                acc.setBannerName(rs.getString(17));
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    @Override
    public void insertAccount(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insAccount);
            stmt.setString(1,account.getEmail());
            stmt.setString(2,account.getFirstName());
            stmt.setString(3,account.getLastName());
            stmt.setString(4,account.getStatus());
            stmt.setString(5,account.getAddress1());
            stmt.setString(6,account.getAddress2());
            stmt.setString(7,account.getCity());
            stmt.setString(8,account.getState());
            stmt.setString(9,account.getZip());
            stmt.setString(10,account.getCountry());
            stmt.setString(11,account.getPhone());
            stmt.setString(12,account.getUsername());
            stmt.execute();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insProfile);
            stmt.setString(1, account.getLanguagePreference());
            stmt.setString(2, account.getFavouriteCategoryId());
            stmt.setString(3, account.getUsername());
            stmt.execute();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignon(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_insSignon);
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.execute();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_udAccount);
            stmt.setString(1,account.getEmail());
            stmt.setString(2,account.getFirstName());
            stmt.setString(3,account.getLastName());
            stmt.setString(4,account.getStatus());
            stmt.setString(5,account.getAddress1());
            stmt.setString(6,account.getAddress2());
            stmt.setString(7,account.getCity());
            stmt.setString(8,account.getState());
            stmt.setString(9,account.getZip());
            stmt.setString(10,account.getCountry());
            stmt.setString(11,account.getPhone());
            stmt.setString(12,account.getUsername());
            stmt.executeUpdate();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_udProfile);
            stmt.setString(1, account.getLanguagePreference());
            stmt.setString(2, account.getFavouriteCategoryId());
            stmt.setString(3, account.getUsername());
            stmt.executeUpdate();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignon(Account account) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_udSignon);
            stmt.setString(1, account.getPassword());
            stmt.setString(2, account.getUsername());
            stmt.executeUpdate();
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBannerByName(String favName) {
        String result = "";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getBanner);
            stmt.setString(1, favName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getString(1);
            DBUtil.closePrepareStatement(stmt);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
