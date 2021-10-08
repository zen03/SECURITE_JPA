<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>LISTE DE TOUS LES UTILISATUERS</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
   <!--  Menu -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<ul class="nav navbar-nav">
			<li><a href="User?page=add">Ajout d'un user </a></li>
			<li><a href="User?page=Liste">Liste des users </a></li>
		    <li><a href="Role?page=add">Ajout d'un role</a></li>
			<li><a href="Role?page=Liste">Liste des roles </a></li>
		</ul>
	</div>
	<!--  Contenu -->
	<div class="container" style="margin-top:75px;">
		<div class="panel panel-default">
			<div class="panel-heading"> Liste des users</div>
			<div class="panel-body" >
				<table class="table table-bordered table-striped">
					 <tr>
					 		<td>identifiant du user</td>
					 		<td>nom du user</td>
					 		<td>prenom du user</td>
					 		<td>login du user</td>
					 		<td>pasword du user</td>
					 		<td>Action</td>
					 		<td>Action</td>
					 		<td>Action</td>
					 </tr>

					<c:forEach items="${users}" var="user">
					
						 <tr>
						 		<td>${user.idU}</td>
						 		<td>${user.nom}</td>
						 		<td>${user.prenom}</td>
						 		<td>${user.login}</td>
						 		<td>${user.password}</td>
						 		<td><a href="User?page=edit&idU=${user.idU }">Ajouter un role</a></td>
						 		<td><a href="User?page=edit&idU=${user.idU }">Editer</a></td>
						 		<td><a href="User?page=delete&idU=${user.idU }" onclick="return confirmation();">Supprimer</a></td>
						 	
						 </tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>