<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Livros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>

<%
    String titulo = request.getParameter("TITULO");
    Livros livro = new Livros(titulo);
    ControllerLivros controller = new ControllerLivros();
    List<Object> listaLivros = controller.listar(livro);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA LIVROS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Título">Título</th>
                  <th data-field="ISBN">ISBN</th>
                  <th data-field="Gênero">Gênero</th>
                  <th data-field="Data de Lançamento">Data de Lançamento</th>
                  <th data-field="Data de Empréstimo">Data de Empréstimo</th>
                  <th data-field="Data de Devolução">Data de Devolução</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaLivros.isEmpty())) { %>    
                <tbody>
                    <% for (Object livroObj : listaLivros) {
                        Livros livroSaida = (Livros) livroObj;
                    %>
                    <tr>
                            <td><%=livroSaida.getId()%></td>
                            <td><%=livroSaida.getTitulo()%></td>
                            <td><%=livroSaida.getIsbn()%></td>
                            <td><%=livroSaida.getGenero()%></td>
                            <td><%=livroSaida.getData_lancamento()%></td>
                            <td><%=livroSaida.getData_emprestimo()%></td>
                            <td><%=livroSaida.getData_devolucao()%></td>
                            <td><a href="excluirLivro.jsp?ID=<%=livroSaida.getId()%>">Excluir</a></td>
                            <td><a href="alterarLivro.jsp?ID=<%=livroSaida.getId()%>">Alterar</a></td>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
