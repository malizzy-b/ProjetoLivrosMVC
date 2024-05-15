/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Livros;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioLivros;
import padraomvc.model.dao.DaoUsuarioLivros;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author Marina
 */
public class ControllerUsuarioLivros implements ControllerBasico {
    
DaoUsuarioLivros dao;
    ControllerUsuario contUsu;
    ControllerLivros contLiv;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioLivros();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioLivros();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioLivros();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioLivros();
        UsuarioLivros objSaida = (UsuarioLivros) dao.buscar(obj);
        Object usu = new Usuario(objSaida.getIdU());
        Object liv = new Livros(objSaida.getIdL());
        contUsu = new ControllerUsuario();
        contLiv = new ControllerLivros();
        objSaida.setUsu(contUsu.buscar(usu));
        objSaida.setLiv(contLiv.buscar(liv));
        return objSaida;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioLivros();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objLista : listaAux) {
            lista.add(buscar(objLista));
        }
        return lista;
    }
}

