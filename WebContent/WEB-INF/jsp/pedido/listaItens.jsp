<table>
	<caption>Cliente: ${pedido.cliente}</caption>
	<thead>
		<tr>
			<th>Item</th>
			<th>Quantidade</th>
			<th>Valor Total</th>
		</tr>
	</thead>

	<tfoot>
		<tr>
			<td>Total:</td>
			<td>${pedido.quantidadeItens}</td>
			<td>R\$ ${pedido.valorTotal}</td>
		</tr>
	</tfoot>

	<tbody>
		<c:forEach items="${pedido.itens}" var="item">
			<tr class="odd">
				<td>${item.descricao}</td>
				<td>${item.quantidade}</td>
				<td>R\$ ${item.valor}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form action="itens">
	<input type="hidden" name="pedido.id" value="${pedido.id}"/>
	<input type="hidden" name="pedido.cliente" value="${pedido.cliente}"/>
	
	<button>Adicionar item</button>
</form>