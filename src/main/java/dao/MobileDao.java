package dao;

import dto.MobileDto;

import java.sql.*;
import java.util.ArrayList;

public class MobileDao {
    static Connection con=null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Abhi@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int insertMobile(MobileDto mdt) {
        PreparedStatement ps=null;
        int count=0;
        String query="insert into mobile_shop values(?,?,?,?,?,?)";
        try {
            ps= con.prepareStatement(query);
            ps.setInt(1,mdt.getModelNo());
            ps.setString(2,mdt.getModelName());
            ps.setString(3,mdt.getCompany());
            ps.setInt(4,mdt.getRam());
            ps.setInt(5,mdt.getCamera());
            ps.setDouble(6,mdt.getPrice());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<MobileDto> displayModelName(String companyName) {
        Statement stmt=null;
        ResultSet rs;
        ArrayList<MobileDto> mobileList=new ArrayList<>();
        String query="select * from mobile_shop where company='"+companyName+"'";
        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                String model= rs.getString(2);
                // store into DTO class object
                MobileDto mdt=new MobileDto();
                mdt.setModelName(model);
                // add object into list
                mobileList.add(mdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobileList;
    }

    public int deleteRecord(MobileDto mdt) {
        PreparedStatement ps=null;
        int count=0;
        String query="delete from mobile_shop where model_no=?";
        try {
            ps= con.prepareStatement(query);
            ps.setInt(1,mdt.getModelNo());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<MobileDto> displayByPrice(double start, double end) {
        Statement stmt=null;
        ResultSet rs;
        ArrayList<MobileDto> mobileList=new ArrayList<>();
        String query="SELECT * FROM mobile_shop WHERE price BETWEEN "+start+" AND "+end+"";
        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName= rs.getString(2);
                String company= rs.getString(3);
                int ram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);
                // store into DTO class object
                MobileDto mdt=new MobileDto();
               mdt.setModelNo(modelNo);
               mdt.setModelName(modelName);
               mdt.setCompany(company);
               mdt.setRam(ram);
               mdt.setCamera(camera);
               mdt.setPrice(price);
               // add object into list
                mobileList.add(mdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobileList;
    }

    public ArrayList<MobileDto> displayByRam(int size) {
        Statement stmt=null;
        ResultSet rs;
        ArrayList<MobileDto> mobileList=new ArrayList<>();
        String query="SELECT * FROM mobile_shop WHERE ram ="+size+" ";
        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName= rs.getString(2);
                String company= rs.getString(3);
                int ram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);
                // store into DTO class object
                MobileDto mdt=new MobileDto();
                mdt.setModelNo(modelNo);
                mdt.setModelName(modelName);
                mdt.setCompany(company);
                mdt.setRam(ram);
                mdt.setCamera(camera);
                mdt.setPrice(price);
                // add object into list
                mobileList.add(mdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobileList;
    }

    public ArrayList<MobileDto> displayByCamera(double start, double end) {
        Statement stmt=null;
        ResultSet rs;
        ArrayList<MobileDto> mobileList=new ArrayList<>();
        String query="SELECT * FROM mobile_shop WHERE ram BETWEEN "+start+" AND "+end+"";
        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int modelNo=rs.getInt(1);
                String modelName= rs.getString(2);
                String company= rs.getString(3);
                int ram=rs.getInt(4);
                int camera=rs.getInt(5);
                double price=rs.getDouble(6);
                // store into DTO class object
                MobileDto mdt=new MobileDto();
                mdt.setModelNo(modelNo);
                mdt.setModelName(modelName);
                mdt.setCompany(company);
                mdt.setRam(ram);
                mdt.setCamera(camera);
                mdt.setPrice(price);
                // add object into list
                mobileList.add(mdt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobileList;
    }
}
