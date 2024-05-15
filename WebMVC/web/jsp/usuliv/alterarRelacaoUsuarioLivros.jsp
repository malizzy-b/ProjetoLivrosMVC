<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerUsuarioLivros"%>

<%
    // Obtendo o ID da relação usuário-livros a ser alterada
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);

    // Buscando a relação usuário-livros a partir do ID
    UsuarioLivros usuarioLivros = new UsuarioLivros(id);
    ControllerUsuarioLivros usuarioLivrosCont = new ControllerUsuarioLivros();
    usuarioLivros = (UsuarioLivros) usuarioLivrosCont.buscar(usuarioLivros);
    
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - RELAÇÃO USUÁRIO-LIVROS</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR RELAÇÃO USUÁRIO-LIVROS</h1>
        <form name="alterarUsuarioLivros" action="validaAlterarUsuarioLivros.jsp" method="post">
            ID Usuário: <input type="text" name="ID_USUARIO" value="<%=usuarioLivros.getIdU()%>"> <br>
            ID Livro: <input type="text" name="ID_LIVRO" value="<%=usuarioLivros.getIdL()%>"> <br>          
            Observação: <input type="text" name="OBS" value="<%=usuarioLivros.getObs()%>"> <br>
            <input type="hidden" name="ID" value="<%=usuarioLivros.getId()%>">
            <input type="hidden" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
