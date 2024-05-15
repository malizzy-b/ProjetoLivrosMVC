<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - LIVROS</title>
    <body>
       <div class="container">
        <h1>INSERIR LIVROS</h1>
        <form name="inserirLivros" action="validaInserirLivros.jsp" method="post">
            Título: <input type="text" name="TITULO" value=""> <br>
            ISBN: <input type="text" name="ISBN" value=""> <br>
            Gênero: <input type="text" name="GENERO" value=""> <br>
            Data de Lançamento: <input type="text" name="DATA_LANCAMENTO" value=""> <br>
            Data de Empréstimo: <input type="text" name="DATA_EMPRESTIMO" value=""> <br>
            Data de Devolução: <input type="text" name="DATA_DEVOLUCAO" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
