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
public class Livros implements Serializable {
    
    private int id;
    private String titulo;
    private String isbn;
    private String genero;
    private String data_lancamento;
    private String data_emprestimo;
    private String data_devolucao;

    public Livros(int id) {
        this.id = id;
    }

    public Livros(String titulo) {
        this.titulo = titulo;
    }

    public Livros(String titulo, String isbn, String genero, String data_lancamento, String data_emprestimo, String data_devolucao) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.genero = genero;
        this.data_lancamento = data_lancamento;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Livros(int id, String titulo, String isbn, String genero, String data_lancamento, String data_emprestimo, String data_devolucao) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.genero = genero;
        this.data_lancamento = data_lancamento;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Override
    public String toString() {
        return "Livros{" + "id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", genero=" + genero + ", data_lancamento=" + data_lancamento + ", data_emprestimo=" + data_emprestimo + ", data_devolucao=" + data_devolucao + '}';
    }
}

