package net.snascimento.pedeai.domain;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "restaurantes")
public class Restaurante {

  @Id private String id;
  private String nome;
  private String endereco;
  private String horariosFuncionamento;
  private String tipoCozinha;
  private List<ItemDeMenu> itensDeMenu;
  private List<Pedido> pedidosRecebidos;
}
