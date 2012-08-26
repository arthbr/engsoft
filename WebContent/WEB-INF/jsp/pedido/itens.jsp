<h2>Cliente: ${pedido.cliente}</h2>

<form action="addItem">
	<fieldset>
		<legend>Adicionar Itens</legend>
		
		<input type="hidden" name="id" value="${pedido.id}" />
		
		
		<label for="descricao">Descrição:</label>
		<input id="descricao" type="text" name="descricao"/> 
		
		<label for="quantidade">Qntd.:</label>
		<input id="quantidade" type="text" name="quantidade"/>
		
		<label for="valor">Valor:</label>
		<input id="valor" type="text" name="valor"/>

		<button type="submit">Adicionar itens</button>
	</fieldset>
</form>

<form action="listaItens">
	<input type="hidden" name="id" value="${pedido.id}" />
	<button type="submit">Lista dos itens de ${pedido.cliente}</button>
</form>
