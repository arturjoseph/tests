<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br/> <br/>
	<c:if test="${not empty usuarioLogado}">
		Logado como ${usuarioLogado.email}<br/><br/>
	</c:if>
	<form action="novaEmpresa" method="POST">
		Nome: <input type="text" name="nome"/> 
		<input type="submit" value="Enviar"/>
	</form><br/>
	<form action="login" method="POST">
		E-mail: <input type="email" name="email"/> 
		Senha: <input type="password" name="senha"/> 
		<input type="submit" value="Enviar"/>
	</form><br/>
	<form action="fazTudo" method="POST">,
	<input type="hidden" name="tarefa" value="Logout">
		<input type="submit" value="Deslogar"/>
	</form>
</body>
</html>