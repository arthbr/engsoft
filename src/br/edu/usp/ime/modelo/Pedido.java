package br.edu.usp.ime.modelo;

import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @NotNull
  private String cliente;
  
  private String data;
//  private Calendar data = Calendar.getInstance();
  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<Item> itens = new ArrayList<Item>();
  
  private int quantidadeItens;
  private double valorTotal;

  public Pedido() {
    this.quantidadeItens = 0;
    this.valorTotal = 0;
  }

  public double calculaValorTotal() {
    double soma = 0;

    if (itens != null) {
      for (Item item : itens) {
        soma += item.getQuantidade() * item.getValor();
      }
    }

    return soma;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void addItem(String descricao, int quantidade, double valor) {
    Item item = new Item();
    
    item.setDescricao(descricao);
    item.setQuantidade(quantidade);
    item.setValor(valor);
    item.setPedido(this);
    
    this.quantidadeItens += quantidade;
    this.valorTotal += quantidade * valor;
    
    this.itens.add(item);
  }

  public void removeLastItem() {
    if (itens != null) {
      this.itens.remove(itens.size()-1);
    }
  }
  
  public void removeAll() {
    if (itens != null) {
      itens.removeAll(itens);
    }
  }

  public List<Item> getItens() {
    return itens;
  }

  public String getCliente() {
    return cliente;
  }

  public String getData() {
    return data;
  }
  
//  public Calendar getData() {
//    return data;
//  }
  
  public int getQuantidadeItens() {
    return quantidadeItens;
  }
  
  public double getValorTotal() {
    return valorTotal;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public void setData(String data) {
    this.data = data;
  }
  
//  public void setData(Calendar data) {
//    this.data = data;
//  }
  
  public void setItens(List<Item> itens) {
    this.itens = itens;
  }

  public void setQuantidadeItens(int quantidadeItens) {
    this.quantidadeItens = quantidadeItens;
  }
  
  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }
}
