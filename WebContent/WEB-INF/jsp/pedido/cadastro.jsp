<h1>Controle de pedidos</h1>

<script type="text/javascript">
	function getDate() {
		var currentTime = new Date()
		var month = currentTime.getMonth() + 1
		var day = currentTime.getDate()
		var year = currentTime.getFullYear()
	}
</script>

<form action="adiciona">
	<fieldset>
		<legend>Adicionar Produto</legend>

		<label for="cliente">Cliente:</label>
		<input id="cliente" type="text" name="pedido.cliente"/> 
		
<!-- 		<input id="data" type="hidden" name="pedido.data"/> -->
				
		<button type="submit">Adicionar itens</button>
	</fieldset>
</form>

<!-- <p id="data">Clique aqui para atualizar a data:</p> -->
<!-- <input type="button" onclick="displayDate()" value="Data"/> -->