/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.util.DaoBasico;
import padraomvc.model.bean.Livros;
import padraomvc.util.ConexaoDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marina
 */
public class DaoLivros implements DaoBasico {
    
    private final Connection c;
    
    public DaoLivros() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    @Override
    public Object inserir(Object obj) throws SQLException {
        Livros livros = (Livros) obj;
        String sql = "insert into livros" + " (titulo, isbn, genero, data_lancamento, data_emprestimo, data_devolucao)" + " values (?,?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, livros.getTitulo());
        stmt.setString(2, livros.getIsbn());
        stmt.setString(3, livros.getGenero());
        stmt.setString(4, livros.getData_lancamento());
        stmt.setString(5, livros.getData_emprestimo());
        stmt.setString(6, livros.getData_devolucao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            livros.setId(id);
        }
        stmt.close();
        return livros;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Livros livros = (Livros) obj;
        String sql = "UPDATE livros SET titulo = ?, isbn = ?, genero = ?, data_lancamento = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, livros.getTitulo());
        stmt.setString(2, livros.getIsbn());
        stmt.setString(3, livros.getGenero());
        stmt.setString(4, livros.getData_lancamento());
        stmt.setString(5, livros.getData_emprestimo());
        stmt.setString(6, livros.getData_devolucao());
        stmt.setInt(7, livros.getId());
        // executa
        stmt.execute();
        stmt.close();
        return livros;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Livros livros = (Livros) obj;
        String sql = "delete from livros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, livros.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return livros;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Livros livros = (Livros) obj;
        String sql = "select * from livros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, livros.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Livros livrosSaida = null;
        while (rs.next()) {      
            // criando o objeto Livros
            livrosSaida = new Livros(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
            );
            // adiciona o livros à lista de livross
        }
        stmt.close();
        return livrosSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Livros livros = (Livros) obj;
        // livross: array armazena a lista de registros
        List<Object> livross = new ArrayList<>();
        
        String sql = "select * from livros where titulo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + livros.getTitulo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Livros
            Livros livro = new Livros(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
            );
            // adiciona o livros à lista de livross
            livross.add(livro);
        }
        
        rs.close();
        stmt.close();
        return livross;
    }
}
