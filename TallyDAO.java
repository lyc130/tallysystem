package tallysystem;

import java.sql.*;
import java.util.*;

public class TallyDAO {

    //插入数据
    public int insert(TallyBean bean) {
        ConDB cd = new ConDB();
        int i = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into tally values(?,?,?,?,?,?)";
        con = cd.toconnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, bean.getId());
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getNecessity());
            ps.setInt(4, bean.getMoney());
            ps.setInt(5, bean.getTime());
            ps.setString(6, bean.getDescribe());
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "1111111111");
        }
        return i;
    }

    //按学号id查询一个账务的信息
    public ArrayList searchById(TallyBean bean) {
        ConDB cd = new ConDB();
        ArrayList arr = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tally where id=?";
        con = cd.toconnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, bean.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                arr.add(rs.getInt(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getInt(4));
                arr.add(rs.getInt(5));
                arr.add(rs.getString(6));
            }
            cd.toClose(rs, ps, con);
            return arr;
        } catch (SQLException ex) {
        }
        return arr;
    }

    //按姓名name查询一个账务的信息
    public ArrayList searchByName(TallyBean bean) {
        ConDB cd = new ConDB();
        ArrayList a = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tally where name=?";
        con = cd.toconnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, bean.getName());
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(rs.getInt(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getInt(4));
                a.add(rs.getInt(5));
                a.add(rs.getString(6));
            }
            cd.toClose(rs, ps, con);
            return a;
        } catch (SQLException ex) {
        }
        return a;
    }

//修改
    public int update(TallyBean bean,int id) {
        int i = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ConDB cd=new ConDB();
        con=cd.toconnection();
        String sql="update tally set id=?,name=?,necessity=?,money=?,time=?,describe=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ps.setString(2,bean.getName());
            ps.setString(3,bean.getNecessity());
            ps.setInt(4,bean.getMoney());
            ps.setInt(5,bean.getTime());
            ps.setString(6,bean.getDescribe());
            ps.setInt(7,id);
            i=ps.executeUpdate();
            cd.toClose(null,ps,con);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+"2222");
        }
        return i;
    }

//删除

    public int delete(TallyBean bean){
        int i=0;
        Connection con = null;
        PreparedStatement ps = null;
        ConDB cd=new ConDB();
        con=cd.toconnection();
        String sql="delete from tally where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            i=ps.executeUpdate();
            cd.toClose(null,ps,con);
            return i;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+"77777");
        }
        return i;
    }

    //查询所有账务信息
    public StringBuffer search() {
        StringBuffer result = new StringBuffer();
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ConDB cd=new ConDB();
 
        try {
            s = con.createStatement();
            String sql = "select * from tally";
            rs = s.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                result.append(metaData.getColumnName(i) + "\t");
            }
            result.append("\n");
            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    result.append(rs.getObject(i) + "\t");
                }
                result.append("\n");
            }
            rs.close();
            s.close();
            con.close();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "4444444");
        }
        return result;
    }


}
