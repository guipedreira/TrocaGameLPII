/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import Model.Midia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vitor
 */
public class MidiaDao {
    
    private final List<Midia> listaMidia = new ArrayList<>();


    @Override
    public void create(Midia data) throws SQLException {
         Connection conexao = null;
        PreparedStatement stm = null;
        String sql;
       try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            sql = "INSERT INTO MIDIA (TIPO,STATUS_MIDIA,CODIGO) VALUES (?,?,?)";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getTipo());
            stm.setDouble(2, data.getStatusMidia());
            stm.setInt(3,data.getCod());


            stm.execute();
            conexao.commit();
        }catch(SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            stm.close();
            conexao.close();

        }
    }


    @Override
    public Midia read(Object key) throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "SELECT * FROM MIDIA WHERE CODIGO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setLong(1, (Long) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Midia u1 = new Midia();
                u1.setTipo(rs.getString(1));
                u1.setStatusMidia(rs.getDouble(2));
                u1.setCod(rs.getInt(3));

                return u1;
            } else {
            }

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
        throw new UnsupportedOperationException();
    }


    @Override
    public void update(Midia data) throws SQLException {        
        Connection conexao = null;
        String sql;
        sql = "UPDATE MIDIA SET TIPO=?, STATUS_MIDIA=?, CODIGO=? where CODIGO=?";
        PreparedStatement stm = null; 
        try {

            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
            stm = conexao.prepareStatement(sql);
            
            stm.setString(1, data.getTipo());
            stm.setDouble(2, data.getStatusMidia());
            stm.setInt(3, data.getCod());
            
            stm.execute();
            conexao.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MidiaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            stm.close();
        }

    }
    
    @Override
    public void delete(Midia data) throws SQLException {
        
        Connection conexao = null;
        String sql;
        sql = "DELETE FROM MIDIA WHERE CODIGO=?";
        PreparedStatement stm = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
          
            stm = conexao.prepareStatement(sql);
            stm.setInt(1,data.getCod());

            stm.execute();

        } catch (SQLException e) {
            Logger.getLogger(MidiaDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.close();
            stm.close();
        }
    }

    
}
