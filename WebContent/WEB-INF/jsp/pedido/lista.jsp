
<%-- <a href="<c:url value="/pedido/cadastro"/>">Cadastro de Pedidos</a> --%>

<h1>Lista de Pedidos</h1>

<table>
	<thead>
		<tr>
			<th>Cliente</th>
			<th>Data</th>
			<th>Qntd de itens</th>
			<th>Valor total</th>
			<th>Lista de itens</th>
			<th>Remover</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${pedidoList}" var="pedido">
			<tr>
				<td>${pedido.cliente}</td>
				<td>${pedido.data}</td>
				<td>${pedido.quantidadeItens}</td>
				<td>${pedido.valorTotal}</td>
<%-- 				<td><a href="edita?id=${pedido.id}">Editar</a></td> --%>
				<td><a href="listaItens?id=${pedido.id}">Lista de itens</a></td>
				<td><a href="remove?id=${pedido.id}">Remover</a></td>
		</c:forEach>
	</tbody>
</table>
