package net.snascimento.pedeai.domain;

import lombok.Data;

@Data
public class ItemDeMenu {

  private String id;
  private String nome;
  private String descricao;
  private double preco;
  private boolean disponibilidade;
}
