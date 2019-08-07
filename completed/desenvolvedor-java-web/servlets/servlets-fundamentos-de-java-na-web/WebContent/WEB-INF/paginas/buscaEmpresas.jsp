<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca Empresas</title>
</head>
<body>
Resultado da busca: <br/>
<ul>
	<c:forEach var="empresa" items="${empresas}">
		<li>${empresa.id}: ${empresa.nome}</li>
	</c:forEach>
</ul>
</body>
</html>