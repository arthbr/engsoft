/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.edu.usp.ime.controller;

import java.util.List;

import br.com.caelum.vraptor.validator.ValidationMessage;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Message;
import br.edu.usp.ime.dao.PedidoDAO;
import br.edu.usp.ime.modelo.Pedido;

@Resource
public class PedidoController {

  private final PedidoDAO dao;
  private final Result result;
  private final Validator validator;

  public PedidoController(PedidoDAO dao, Result result, Validator validator) {
    this.dao = dao;
    this.result = result;
    this.validator = validator;
  }

  @Path("/")
  public void index() {

  }

  public List<Pedido> lista() {
    return dao.listaTudo();
  }

  public Pedido listaItens(Long id) {
    Pedido pedido = dao.carregaPedido(id);
    return pedido;
  }

  public void cadastro() {

  }

  public void adiciona(Pedido pedido) {
    if (pedido.getCliente() == null || pedido.getCliente().length() < 2) {
      validator
          .add(new ValidationMessage(
              "o nome do cliente é obrigatório e precisa de no mínimo três letras.",
              "Erro"));
    }

    validator.onErrorUsePageOf(this).cadastro();

    dao.salva(pedido);
    result.redirectTo(this).itens(pedido);
  }

  public Pedido itens(Pedido pedido) {
    return pedido;
  }

  public void addItem(Long id, String descricao, int quantidade, double valor) {
//    if (descricao == null || descricao.length() < 2) {
//      validator.add(new ValidationMessage(
//          "Nome é obrigatório e precisa de mais de três letras", "descricao"));
//    }
//    else {
//      if (quantidade <= 0) {
//        validator.add(new ValidationMessage("Quantidade deve ser positiva",
//            "quantidade"));
//      } 
//      else {
//        if (valor < 0.01) {
//          validator.add(new ValidationMessage("Valor deve ser positivo",
//              "valor"));
//        }
//      }
//    }

    Pedido pedido = dao.carregaPedido(id);

//    validator.onErrorUsePageOf(this).itens(pedido);

    dao.addItem(id, descricao, quantidade, valor);
    result.redirectTo(this).itens(pedido);
  }

  public void remove(Long id) {
    dao.remove(id);
    result.redirectTo(this).lista();
  }

}
