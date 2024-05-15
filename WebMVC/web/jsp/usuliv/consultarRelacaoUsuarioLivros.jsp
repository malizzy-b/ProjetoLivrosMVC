<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../../inc/materalizeWeb.inc" %>
<head>
    <title>CONSULTAR - RELAÇÃO USUÁRIO-LIVRO</title>
</head>
<body>
<div class="container"/>
    <h1>CONSULTAR RELAÇÃO USUÁRIO-LIVRO</h1>
    <form name="consultarRelacaoUsuarioLivros" action="validaConsultarRelacaoUsuarioLivros.jsp" method="post">
        Observação: <input type="text" name ="OBS" value=""> <br>
        <input type="submit" name ="Enviar" value="Enviar"> <br>
    </form>
</div>
</body>
</html>
