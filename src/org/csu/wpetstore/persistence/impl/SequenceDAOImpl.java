package org.csu.wpetstore.persistence.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.csu.wpetstore.domain.Sequence;
import org.csu.wpetstore.persistence.DBUtil;
import org.csu.wpetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by WZF on 2018/4/30.
 */
public class SequenceDAOImpl implements SequenceDAO{
    private String sql_getSeq = "SELECT name, nextid " +
            "FROM SEQUENCE " +
            "WHERE NAME = ?";
    private String sql_udSeq = "UPDATE SEQUENCE " +
            "SET NEXTID = ? " +
            "WHERE NAME = ?";
    @Override
    public Sequence getSequence(Sequence sequence) {
        Sequence returnSeq = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_getSeq);
            stmt.setString(1, sequence.getName());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                returnSeq = new Sequence();
                returnSeq.setName(rs.getString(1));
                returnSeq.setNextId(rs.getInt(2));
            }
            DBUtil.closeAll(null, stmt, rs, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnSeq;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql_udSeq);
            stmt.setInt(1, sequence.getNextId());
            stmt.setString(2, sequence.getName());
            stmt.executeUpdate();
            DBUtil.closeAll(null, stmt, null, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
