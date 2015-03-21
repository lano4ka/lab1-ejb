/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import models.*;
/**
 *
 * @author пк
 */
@Stateless
public class DAOclass implements Serializable, DAORemoteInterface {
    
    @Resource (lookup="jdbc/ejb_laba")
    private DataSource ds; 
    private static final Logger logger = Logger.getLogger(DAOclass.class.getName());
    
    @Override
    public List<Procedura> selectAll()
    {
        LinkedList<Procedura> result = new LinkedList<>();
        Connection conn = null;
        try
        {
            conn = ds.getConnection();
            Statement st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("Select * from procedura");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Procedura p = new Procedura();
                p.setId_proc(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                result.add(p);
            }        
        }
        catch (SQLException sqlex)
        {
           logger.log(Level.SEVERE, "Cannot get data from DB", sqlex);
        }
        finally
        {
            try
            {
                if (conn!=null)
                    conn.close();
            }
            catch (SQLException ex) 
                {
                    logger.log(Level.SEVERE, "Cannot close connection",ex);
                }
        }
        return result;
    }
    
    
}
