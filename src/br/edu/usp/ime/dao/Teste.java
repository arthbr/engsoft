package br.edu.usp.ime.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.usp.ime.modelo.Item;
import br.edu.usp.ime.modelo.Pedido;

public class Teste {
  
  public static void main(String[] args) {
    PedidoDAO dao = new PedidoDAO();
    
    List<Item> itens = new ArrayList<Item>();

    Pedido pedido = new Pedido();
    pedido.setCliente("João");
    pedido.setData(0);

    Item item = new Item();
    item.setDescricao("Martelo");
    item.setQuantidade(1);
    item.setValor(2.5);
    item.setPedido(pedido);
    
    Item item1 = new Item();
    item1.setDescricao("Chave de fenda");
    item1.setQuantidade(1);
    item1.setValor(2.5);
    item1.setPedido(pedido);

    itens.add(item);
    itens.add(item1);

    pedido.setItens(itens);

    dao.salva(pedido);
  }
  
}
