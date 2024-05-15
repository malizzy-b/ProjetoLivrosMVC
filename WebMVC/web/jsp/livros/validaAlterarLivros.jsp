<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Livros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String titulo = request.getParameter("TITULO");
    String isbn = request.getParameter("ISBN");
        String data_lancamento = request.getParameter("DATA_LANCAMENTO");
    String genero = request.getParameter("GENERO");
 // Verifique se o nome do parâmetro está correto
    String data_emprestimo = request.getParameter("DATA_EMPRESTIMO");
    String data_devolucao = request.getParameter("DATA_DEVOLUCAO");
    
    // Certifique-se de que data_lancamento seja uma data válida no formato esperado pelo banco de dados
    // Se necessário, faça a validação da data aqui
    
    Livros livro = new Livros(id, titulo, isbn, data_lancamento, genero, data_emprestimo, data_devolucao);
    
    ControllerLivros controller = new ControllerLivros();
    controller.alterar(livro);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PÁGINA DE CONSULTA DE LIVROS
    String url = "validaConsultarLivros.jsp?TITULO=" + pbusca;
    response.sendRedirect(url);
%>
