<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Livros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Livros livro = new Livros(id);
    ControllerLivros livroCont = new ControllerLivros();
    livro = (Livros) livroCont.buscar(livro);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LIVRO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR LIVRO</h1>
        <form name="alterarLivros" action="validaAlterarLivros.jsp" method="post">
            Título: <input type="text" name="TITULO" value="<%=livro.getTitulo()%>"> <br>
            ISBN: <input type="text" name="ISBN" value="<%=livro.getIsbn()%>"> <br>
            Gênero: <input type="text" name="GENERO" value="<%=livro.getGenero()%>"> <br>
            Data de Lançamento: <input type="text" name="DATA_LANCAMENTO" value="<%=livro.getData_lancamento()%>"> <br>
            Data de Empréstimo: <input type="text" name="DATA_EMPRESTIMO" value="<%=livro.getData_emprestimo()%>"> <br>
            Data de Devolução: <input type="text" name="DATA_DEVOLUCAO" value="<%=livro.getData_devolucao()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=livro.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
