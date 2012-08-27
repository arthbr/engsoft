<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> --%>

<h1>Controle de pedidos</h1>

<form action="adiciona">
	<fieldset>
		<legend>Adicionar um cliente</legend>

		<label for="cliente">Cliente: ${pedido.cliente}</label>
		<input id="cliente" type="text" name="pedido.cliente"/> 
		
<%-- 		<fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy" /> --%>
		
		<label for="data">Data (dd/mm/aaaa): ${pedido.data}</label>
		<input id="data" type="text" name="pedido.data"/>
		
		<button type="submit">Adicionar itens</button>
	</fieldset>
</form>