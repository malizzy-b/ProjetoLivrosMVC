<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioLivros"%>
<%@page import="padraomvc.controller.ControllerUsuarioLivros"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioLivros usuLiv = new UsuarioLivros(id);
    ControllerUsuarioLivros usuLivCont = new ControllerUsuarioLivros();
    usuLivCont.excluir(usuLiv);
    String pbusca = request.getParameter("PBUSCA");
    String url = "validaConsultarRelacaoUsuarioLivros.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>
