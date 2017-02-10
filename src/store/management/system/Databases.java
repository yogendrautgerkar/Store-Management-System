/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management.system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author forest
 */
public class Databases {
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    void startDb() throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store_management_system","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    boolean flag=false;
    ResultSet displayRecords(String s){
        try {
            rs=st.executeQuery(s);
            flag=true;
        } 
        catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    void changeRecords(String s){
        try {
            st.executeUpdate(s);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void endDb(){
        if(flag){
        try {
            rs.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
