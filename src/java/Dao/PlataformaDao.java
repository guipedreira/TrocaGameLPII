/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Plataforma;
import java.io.IOException;
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
public class PlataformaDao {
    
    

    @Override
    public void create(Plataforma data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "INSERT INTO PLATAFORMA (DESCRICAO, TIPO) VALUES (?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getDescricao());
            stm.setString(2, data.getTipo());
                       

            stm.execute();

            stm.close();
            conexao.close();
        } catch (Exception e) {
        }
    }

    @Override
    public Plataforma read(Object key) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "SELECT * FROM PLATAFORMA WHERE DESCRICAO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, (String) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Plataforma h1 = new Plataforma();
                h1.setDescricao(rs.getString(1));
                h1.setTipo(rs.getString(2));
               
                return h1;
            } else {
            }

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Plataforma data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "UPDATE PLATAFORMA SET DESCRICAO=?, TIPO=? WHERE DESCRICAO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getDescricao());
            stm.setString(2, data.getTipo());
            
            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Plataforma data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "DELETE FROM PLATAFORMA WHERE DESCRICAO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getDescricao());

            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
    }

    
}
