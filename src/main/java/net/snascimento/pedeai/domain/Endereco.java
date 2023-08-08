package net.snascimento.pedeai.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Endereco {

  @Id private String id;
  private String rua;
  private String cidade;
  private String estado;
  private String cep;
}
