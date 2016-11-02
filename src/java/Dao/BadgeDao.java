/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Badge;
import Model.Midia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class BadgeDao {
    @Override
    public void create(Badge data) throws SQLException {
         Connection conexao = null;
        PreparedStatement stm = null;
        String sql;
       try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            sql = "INSERT INTO Badge (IMAGEM,TITULO) VALUES (?,?)";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getImagem());
            stm.setString(2, data.getTitulo());


            stm.execute();
            conexao.commit();
        }catch(SQLException e) {
            Logger.getLogger(BadgeDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            stm.close();
            conexao.close();

        }
    }


    @Override
    public Badge read(Object key) throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "SELECT * FROM BADGE WHERE TITULO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setLong(1, (Long) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
               Badge u1 = new Badge();
                u1.setImagem(rs.getString(1));
                u1.setTitulo(rs.getString(2));


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
    public void update(Badge data) throws SQLException {        
        Connection conexao = null;
        String sql;
        sql = "UPDATE BADGE SET IMAGEM=?, TITULO=? where TITULO=?";
        PreparedStatement stm = null; 
        try {

            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
            stm = conexao.prepareStatement(sql);
            
            stm.setString(1, data.getImagem());
            stm.setString(2, data.getTitulo());
           
            
            stm.execute();
            conexao.commit();
        } catch (SQLException ex) {
            Logger.getLogger(BadgeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            stm.close();
        }

    }
    
    @Override
    public void delete(Badge data) throws SQLException {
        
        Connection conexao = null;
        String sql;
        sql = "DELETE FROM BADGE WHERE TITULO=?";
        PreparedStatement stm = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
          
            stm = conexao.prepareStatement(sql);
            stm.setString(1,data.getTitulo());

            stm.execute();

        } catch (SQLException e) {
            Logger.getLogger(BadgeDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.close();
            stm.close();
        }
    }

}
