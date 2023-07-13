package net.snascimento.pedeai.domain;

import lombok.Data;

@Data
public class ItemPedido {

  private String nome;
  private int quantidade;
  private double preco;
}
