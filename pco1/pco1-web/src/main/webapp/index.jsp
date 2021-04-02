<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practico1</title>
</head>
<body>
<main>
	<div>
		<form action="AgregarLoteVacuna" method="post">
			<label>Nombre</label>
			<input type="text" name="nombre" placeholder="Ingresar nombre">
			<label>Cantidad Vacunas</label>
			<input type="number" name="cantidadVacunas">
			<button type="submit">Agregar</button>
		</form>
		<form action="ListarLotesVacuna" method="post">
			<button type="submit">Listar Lotes</button>
		</form>
		<form action="BuscarLoteVacuna" method="post">
			<label>Nombre</label>
			<input type="text" name="nombre" placeholder="Ingresar nombre"> 
			<button type="submit">Buscar Lote</button>
		</form> 
	</div>
</main>
</body>
</html>