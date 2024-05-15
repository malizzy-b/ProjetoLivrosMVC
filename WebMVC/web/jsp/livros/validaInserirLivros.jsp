<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Livros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>

<%
    String titulo = request.getParameter("TITULO");
    String isbn = request.getParameter("ISBN");
    String genero = request.getParameter("GENERO");
    String data_lancamento = request.getParameter("DATA_LANCAMENTO");
    String data_emprestimo = request.getParameter("DATA_EMPRESTIMO");
    String data_devolucao = request.getParameter("DATA_DEVOLUCAO");

    Livros livro = new Livros(titulo, isbn, genero, data_lancamento, data_emprestimo, data_devolucao);
    ControllerLivros controller = new ControllerLivros();
    controller.inserir(livro);

    // REDIRECIONA PARA A PÁGINA inserirLivro.jsp
    String url = "inserirLivros.jsp";
    response.sendRedirect(url);
%>


