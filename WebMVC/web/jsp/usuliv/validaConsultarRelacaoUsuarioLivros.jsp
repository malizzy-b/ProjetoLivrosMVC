<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.UsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerUsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerLivros"%>
<%@page import="padraomvc.model.bean.Livros"%>


<%
    // Obtém o parâmetro de busca
    String obs = request.getParameter("OBS");
    
    // Cria um objeto UsuarioSistema com a observação de busca
    UsuarioLivros usuarioLivros = new UsuarioLivros(obs);
    
    // Cria uma instância do controlador
    ControllerUsuarioLivros controllerUsuarioSistema = new ControllerUsuarioLivros();
    
    // Lista as relações usuário-livro que correspondem ao critério de busca
    List<Object> listaUsuarioSistema = controllerUsuarioSistema.listar(usuarioLivros);
    
    // Obtém o usuário logado na sessão
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    
    // Cria a URL para redirecionamento
    String url = "PBUSCA=" + usuarioLivros.getObs() + "&ID=";
%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuSist">Id</th>
                  <th data-field="IdU">IdUsuario</th>
                  <th data-field="Login">IdLivro</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaUsuarioSistema.isEmpty())) { %>    
                <tbody>
                    <% for (Object objUsuSist : listaUsuarioSistema) { 
                        UsuarioLivros usuSistSaida = (UsuarioLivros) objUsuSist;
                        Usuario usuSaida = (Usuario) usuSistSaida.getUsu();
                        Livros livSaida = (Livros) usuSistSaida.getLiv();
                    %>
                        <tr>
                            <td><%=usuSistSaida.getId()%></td>
                            <td><%=usuSistSaida.getIdU()%></td>
                            <td><%=usuSistSaida.getIdL()%></td>
                            <td><%=usuSistSaida.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoUsuarioLivros.jsp?<%=url + usuSistSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoUsuarioLivros.jsp?<%=url + usuSistSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
