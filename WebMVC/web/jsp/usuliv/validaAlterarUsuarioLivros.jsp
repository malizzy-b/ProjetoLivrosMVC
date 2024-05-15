<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerUsuarioLivros"%>

<%
    try {
        // Obtendo os parâmetros do formulário
        String cod = request.getParameter("ID");
        int id = Integer.parseInt(cod);
        int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
        int idL = Integer.parseInt(request.getParameter("ID_LIVRO"));
        String dataEmprestimo = request.getParameter("DATA_EMPRESTIMO");
        String dataDevolucao = request.getParameter("DATA_DEVOLUCAO");
        String obs = request.getParameter("OBS");
        String pbusca = request.getParameter("PBUSCA");

        // Criando um objeto UsuarioLivros com os dados fornecidos
        UsuarioLivros usuarioLivros = new UsuarioLivros(id, idU, idL, obs);

        // Criando uma instância do controlador
        ControllerUsuarioLivros controllerUsuarioLivros = new ControllerUsuarioLivros();

        // Alterando a relação usuário-livro no banco de dados
        controllerUsuarioLivros.alterar(usuarioLivros);

        // Redirecionando para a página de consulta de usuário-livro
        String url = "validaConsultarRelacaoUsuarioLivros.jsp?ID=" + pbusca;
        response.sendRedirect(url);
    } catch (Exception e) {
        // Exibindo informações de erro
        out.println("Erro ao alterar relação usuário-livro: " + e.getMessage());
        e.printStackTrace();
    }
%>
