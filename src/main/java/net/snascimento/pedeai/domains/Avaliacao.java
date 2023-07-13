package net.snascimento.pedeai.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "avaliacoes")
public class Avaliacao {

  @Id private String id;
  private int nota;
  private String comentario;
  private Usuario usuario;
}
