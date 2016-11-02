/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Jogo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class JogoDao {
        private final List<Jogo> listaIngresso = new ArrayList<>();

    @Override
    public void create(Jogo data) {
          try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados","root","1234");
            
            String sql;
            sql = "INSERT INTO JOGO (CAPA, PRODUTORA, TITULO, SUBTITULO, VALOR_NOVO) VALUES (?,?,?,?,?)";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1,Integer.parseInt(data.getCapa()));
            stm.setString(2,data.getProdutora());
            stm.setDouble(3,Double.parseDouble(data.getTitulo()));
            stm.setObject(4,data.getSubtitulo());
            stm.setObject(5,data.getValorNovo());

            stm.execute();

            stm.close();
            conexao.close();
        } catch (Exception e){         
        }
    }

    @Override
    public Jogo read(Object key) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados","root","1234");
                    
            String sql;
            sql = "";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, (String) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Jogo q1 = new Jogo();
                q1.setCapa(rs.getString(1));
                q1.setProdutora(rs.getString(2));
                q1.setTitulo(rs.getString(3));
                q1.setSubtitulo(rs.getString(4));
                q1.setValorNovo(rs.getFloat(5));
                return q1;
            } else {
            }

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Jogo data) {
        try {
            Connection conexao = DriverManager.getConnection ("jdbc:derby://localhost:1527/BancoDados","root","1234");                   

            String sql;
            sql = "UPDATE JOGO SET CAPA=?, PRODUTORA=?, TITULO=?, SUBTITULO=?, VALOR_NOVO=? WHERE TITULO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1,data.getCapa());
            stm.setString(2, data.getProdutora());
            stm.setString(4,data.getTitulo());
            stm.setString(5,data.getSubtitulo());
            stm.setFloat(5,data.getValorNovo());

            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Jogo data) {
        try {
            Connection conexao = DriverManager.getConnection ("jdbc:derby://localhost:1527/BancoDados","root","1234");
                    
            String sql;
            sql = "DELETE FROM JOGO WHERE TITULO=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getTitulo());

            stm.execute();

            stm.close();
            conexao.close();

        } catch (Exception e) {}
    }
    
    public List<Jogo> readAll(){
       List <Jogo> list = new ArrayList<>();
       try {
          Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados","root","1234");

            String sql;
            sql = "SELECT * FROM JOGO";
            PreparedStatement stm = conexao.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Jogo q1 = new Jogo();
                q1.setCapa(rs.getString(1));
                q1.setProdutora(rs.getString(2));
                q1.setTitulo(rs.getString(3));
                q1.setSubtitulo(rs.getString(4));
                q1.setValorNovo(rs.getFloat(5));
                list.add(q1);
            }

            stm.close();
            conexao.close();

        } catch (Exception e) {}
        return list;
   } 
    
}
