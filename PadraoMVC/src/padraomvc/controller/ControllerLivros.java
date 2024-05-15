/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.dao.DaoLivros;
import padraomvc.util.ControllerBasico;


/**
 *
 * @author Marina
 */
public class ControllerLivros implements ControllerBasico {
    
    DaoLivros dao;

    
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLivros();
        return dao.inserir(obj);
    }

    
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLivros();
        return dao.alterar(obj);
    }

    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLivros();
        return dao.buscar(obj);
    }

    
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLivros();
        return dao.excluir(obj);
    }

    
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoLivros();
        return dao.listar(obj);
     }
}

