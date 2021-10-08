<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Edit</title>
		<link rel="stylesheet" href="./css/bootstrap.min.css">
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
				<div class="panel-heading"> Modification d'un User</div>
				<div class="panel-body" >
				<form method="Post" action="User">
				<div class="form-group">
						<label class="control-label"> Identifiant User </label>
						<input class="form-control" readonly type="text" name="idU" value="${user.idU }"/>
					</div>
					<div class="form-group">
						<label class="control-label"> Nom User </label>
						<input class="form-control" type="text" name="nomU" value="${user.nom }"/>
					</div>
					<div class="form-group">
						<label class="control-label"> Prenom User</label>
						<input class="form-control" type="text" name="prenomU" value="${user.prenom }"/>
					</div>
					<div class="form-group">
						<label class="control-label"> Login User</label>
						<input class="form-control" type="text" name="loginU" value="${user.login }"/>
					</div>
					<div class="form-group">
						<label class="control-label"> Password User</label>
						<input class="form-control" type="text" name="passwordU" value="${user.password }"/>
					</div>
					<div class="form-group">
						<input class="btn btn-success " type="submit" name="action" value="Modifier"/>
						<a class="btn btn-danger " href="User?page=liste"> Retour à la liste </a>
						
					</div>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>