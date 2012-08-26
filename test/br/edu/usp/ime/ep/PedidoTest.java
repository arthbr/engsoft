package br.edu.usp.ime.ep;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.usp.ime.modelo.Item;
import br.edu.usp.ime.modelo.Pedido;


public class PedidoTest {
  private final double epsilon = 1E-10;
  private static Pedido pedido = new Pedido();
  
  @Test
  public void testVazia() {
    assertEquals(0, pedido.calculaValorTotal(), epsilon);
  }

  @Test
  public void testUmItemQntdUm() {
    Item item1 = new Item();
    
    item1.setQuantidade(1);
    item1.setValor(2.50);
    
    pedido.getItens().add(item1);
    
    assertEquals(2.50, pedido.calculaValorTotal(), epsilon);
  }
  
  @Test
  public void testDoisItensQntdUm() {
    Item item2 = new Item();
    
    item2.setQuantidade(1);
    item2.setValor(3.75);
    
    pedido.getItens().add(item2);
    
    assertEquals(6.25, pedido.calculaValorTotal(), epsilon);
  }
  
  @Test
  public void testUmItemQntdMaior() {
    Item item1 = new Item();
    
    item1.setQuantidade(3);
    item1.setValor(2.50);
    
    pedido.removeAll();
    pedido.getItens().add(item1);
    
    assertEquals(7.50, pedido.calculaValorTotal(), epsilon);
  }
  
  @Test
  public void testDoisItensQntdMaior() {
    Item item2 = new Item();
    
    item2.setQuantidade(4);
    item2.setValor(3.75);
    
    pedido.getItens().add(item2);
       
    assertEquals(22.50, pedido.calculaValorTotal(), epsilon);
  }

}
