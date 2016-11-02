/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Plataforma;
import Model.Proposta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class PropostaDao {

    private final List<Proposta> listaProposta = new ArrayList<>();
    
    @Override
    public void create(Proposta data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "INSERT INTO PROPOSTA (DESCRICAO, TIPO) VALUES (?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getStatus());
            stm.setDate(2, (Date) data.getDataHoraCriacao());
            stm.setInt(3,data.getId());
                       

            stm.execute();

            stm.close();
            conexao.close();
        } catch (Exception e) {
        }
    }

    @Override
    public Proposta read(Object key) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "SELECT * FROM PROPOSTA WHERE ID=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, (String) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Proposta h1 = new Proposta();
                h1.setStatus(rs.getString(1));
                h1.setDataHoraCriacao(rs.getDate(2));
                h1.setId(rs.getInt(3));
               
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
    public void update(Proposta data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "UPDATE PROPOSTA SET DESCRICAO=?, TIPO=? WHERE DESCRICAO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getStatus());
            stm.setDate(2, (Date) data.getDataHoraCriacao());
            stm.setInt(3,data.getId());
            
            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Proposta data) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "DELETE FROM PROPOSTA WHERE ID=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, data.getId());

            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
    }

    
}
