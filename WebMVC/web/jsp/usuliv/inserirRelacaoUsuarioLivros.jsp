<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - RELAÇÃO USUÁRIO-LIVROS</title>
    <body>
        <div class="container">
            <h1>INSERIR RELAÇÃO USUÁRIO-LIVROS</h1>
            <form name="inserirRelacaoUsuarioLivros" action="validaInserirRelacaoUsuarioLivros.jsp" method="post">
                <table>
                    <tr>
                        <td>ID do Usuário:</td>
                        <td><input type="text" name="ID_USUARIO" value=""></td>
                    </tr>
                    <tr>
                        <td>ID do Livro:</td>
                        <td><input type="text" name="ID_LIVRO" value=""></td>
                    </tr>
                    <tr>
                        <td>Data Empréstimo:</td>
                        <td><input type="text" name="DATA_EMPRESTIMO" value=""></td>
                    </tr>
                    <tr>
                        <td>Data Devolução:</td>
                        <td><input type="text" name="DATA_DEVOLUCAO" value=""></td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>
                <input type="submit" name="Enviar" value="Enviar">
            </form>
        </div>
    </body>
</html>
