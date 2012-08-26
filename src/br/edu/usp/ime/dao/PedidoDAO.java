package br.edu.usp.ime.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

import br.com.caelum.vraptor.ioc.Component;
import br.edu.usp.ime.modelo.Pedido;

@Component
public class PedidoDAO {

  private EntityManagerFactory emf;

  private static EntityManager em;

  public PedidoDAO() {
    emf = Persistence.createEntityManagerFactory("sample-persistence-unit");
    em = emf.createEntityManager();
  }

  public void salva(Pedido pedido) {
    em.getTransaction().begin();
    em.persist(pedido);
    em.getTransaction().commit();
  }

  public Pedido carregaPedido(Long id) {
    return em.find(Pedido.class, id);
  }

  public void remove(Long id) {
    Pedido pedido = carregaPedido(id);

    em.getTransaction().begin();
    em.remove(pedido);
    em.getTransaction().commit();
  }

  public void addItem(Long id, String descricao, int quantidade, double valor) {
    Pedido pedido = carregaPedido(id);
    pedido.addItem(descricao, quantidade, valor);
    em.getTransaction().begin();
    em.persist(pedido);
    em.getTransaction().commit();
  }

  public List<Pedido> listaTudo() {
    Session session;

    if (em.getDelegate() instanceof EntityManagerImpl) {
      EntityManagerImpl entityManagerImpl = (EntityManagerImpl) em
          .getDelegate();
      session = entityManagerImpl.getSession();
    } else {
      session = (Session) em.getDelegate();
    }
    return session.createCriteria(Pedido.class).list();
  }

}
