<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Livros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Livros livro = new Livros(id);
    ControllerLivros contLiv = new ControllerLivros();
    contLiv.excluir(livro);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PÁGINA DE CONSULTA DE LIVROS
    String url = "validaConsultarLivros.jsp?PBUSCA=" + pbusca;
    response.sendRedirect(url);
%>
