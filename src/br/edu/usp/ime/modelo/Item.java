package br.edu.usp.ime.modelo;

//import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Min;
import org.hibernate.validator.NotNull;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@Min(0)
	private int quantidade;
//	private BigDecimal valor;
	
	@Min(0)
	private double valor;
	
	@ManyToOne
	private Pedido pedido;

	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
      return descricao;
    }
	
	public int getQuantidade() {
      return quantidade;
    }
	
	public double getValor() {
      return valor;
    }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
}
