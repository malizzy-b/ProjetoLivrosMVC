<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR LIVROS</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LIVROS</h1>
       <form name="consultarLivros" action="validaConsultarLivros.jsp" method="post">
           Título: <input type="text" name="TITULO" value=""> <br>
           <input type="submit" name="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
