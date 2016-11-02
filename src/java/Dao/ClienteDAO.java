/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
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
 * @author 31524362
 */
public class ClienteDAO extends Dao<Cliente> {

    private final List<Cliente> listaCliente = new ArrayList<>();


    @Override
    public void create(Cliente data) throws SQLException {
         Connection conexao = null;
        PreparedStatement stm = null;
        String sql;
       try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, USERNAME, TELEFONE, CELULAR,USUARIODESDE) VALUES (?,?,?,?,?,?,?)";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getNome());
            stm.setString(2, data.getEmail());
            stm.setString(3, data.getSenha());
            stm.setString(4, data.getUsername());
            stm.setString(5, data.getTelefone());
            stm.setString(6, data.getCelular());

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
    public Cliente read(Object key) throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");

            String sql;
            sql = "SELECT * FROM CLIENTE WHERE USERNAME=?";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setLong(1, (Long) key);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Cliente u1 = new Cliente();
                u1.setNome(rs.getString(1));
                u1.setCelular(rs.getString(2));
                u1.setEmail(rs.getString(3));
                u1.setSenha(rs.getString(4));
                u1.setTelefone(rs.getString(5));
                u1.setUsername(rs.getString(6));
                u1.setUsuarioDesde(rs.getDate(7));
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
    public void update(Cliente data) throws SQLException {        
        Connection conexao = null;
        String sql;
        sql = "UPDATE CLIENTE SET NOME=?, EMAIL=?, SENHA=?, USERNAME=?, TELEFONE=?, CELULAR=? where USUARIODESDE=?";
        PreparedStatement stm = null; 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {

            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
            stm = conexao.prepareStatement(sql);
            
            stm.setString(1, data.getNome());
            stm.setString(2, data.getEmail());
            stm.setString(3, data.getSenha());
            stm.setString(4, data.getCelular());
            stm.setString(5, data.getTelefone());
            stm.setString(6, sdf.format(data.getUsuarioDesde()));
            stm.setString(7, data.getUsername());
            
            stm.execute();
            conexao.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            stm.close();
        }

    }
    
    @Override
    public void delete(Cliente data) throws SQLException {
        
        Connection conexao = null;
        String sql;
        sql = "DELETE FROM CLIENTE WHERE USERNAME=?";
        PreparedStatement stm = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/BancoDados", "root", "1234");
          
            stm = conexao.prepareStatement(sql);
            stm.setString(1, data.getUsername());

            stm.execute();

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            conexao.close();
            stm.close();
        }
    }

    
}
