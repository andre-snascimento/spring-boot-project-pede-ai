package net.snascimento.pedeai.domains;

import lombok.Data;

@Data public class Endereco {

  private String rua;
  private String cidade;
  private String estado;
  private String cep;
}
