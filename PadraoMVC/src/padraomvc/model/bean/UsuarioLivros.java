/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author Marina
 */
public class UsuarioLivros implements Serializable {
    
    private int id;
    private int idU; // Id do usuário
    private int idL; // Id do livro
    private String obs; // Observação sobre a relação
    private Object usu; // Objeto do tipo Usuario
    private Object liv; // Objeto do tipo Livros

    public UsuarioLivros(int id) {
        this.id = id;
    }

    public UsuarioLivros(String obs) {
        this.obs = obs;
    }

    public UsuarioLivros(int idU, int idL, String obs) {
        this.idU = idU;
        this.idL = idL;
        this.obs = obs;
    }

    public UsuarioLivros(int id, int idU, int idL, String obs) {
        this.id = id;
        this.idU = idU;
        this.idL = idL;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Object getUsu() {
        return usu;
    }

    public void setUsu(Object usu) {
        this.usu = usu;
    }

    public Object getLiv() {
        return liv;
    }

    public void setLiv(Object liv) {
        this.liv = liv;
    }

    @Override
    public String toString() {
        return "UsuarioLivros{" + "id=" + id + ", idU=" + idU + ", idL=" + idL + ", obs=" + obs + '}';
    }

    public String getData_devolucao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getData_lancamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getData_emprestimo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

