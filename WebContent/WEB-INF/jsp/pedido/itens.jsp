<h2>Cliente: ${pedido.cliente}</h2>

<form action="addItem">
	<fieldset>
		<legend>Adicionar Itens</legend>
		
		<input type="hidden" name="id" value="${pedido.id}" />
		
		
		<label for="descricao">Descri��o:</label>
		<input id="descricao" type="text" name="descricao"/> 
		
		<label for="quantidade">Qntd.:</label>
		<input id="quantidade" type="text" name="quantidade"/>
		
		<label for="valor">Valor:</label>
		<input id="valor" type="text" name="valor"/>

		<button type="submit">Enviar</button>
	</fieldset>
</form>

<form action="lista">
<button type="submit">Lista de Pedidos</button>
</form>