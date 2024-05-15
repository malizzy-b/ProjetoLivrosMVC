<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerUsuarioLivros"%>

<%
    try {
        // Obtém os parâmetros do formulário
        int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
        int idL = Integer.parseInt(request.getParameter("ID_LIVRO")); // Corrigido para ID_LIVRO
        String obs = request.getParameter("OBS");

        // Cria um objeto UsuarioLivros com os dados fornecidos
        UsuarioLivros usuarioLivros = new UsuarioLivros(idU, idL, obs);

        // Cria uma instância do controlador
        ControllerUsuarioLivros controllerUsuarioLivros = new ControllerUsuarioLivros();

        // Insere a relação usuário-livro no banco de dados
        controllerUsuarioLivros.inserir(usuarioLivros);

        // Redireciona para a página de inserção de relação usuário-livro
        String url = "inserirRelacaoUsuarioLivros.jsp";
        response.sendRedirect(url);
    } catch (Exception e) {
        // Se ocorrer algum erro, redirecione para uma página de erro ou exiba uma mensagem
        response.getWriter().println("Erro ao inserir relação usuário-livro: " + e.getMessage());
    }
%>
