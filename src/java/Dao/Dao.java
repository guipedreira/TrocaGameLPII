/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;

/**
 *
 * @author 31524362
 */
public abstract class Dao<T> {
    public abstract void create(T data) throws SQLException;
    public abstract T read (Object key) throws SQLException;
    public abstract void update (T data) throws SQLException;
    public abstract void delete (T data) throws SQLException;
    
}
    

