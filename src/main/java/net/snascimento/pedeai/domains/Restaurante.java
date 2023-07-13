package net.snascimento.pedeai.domains;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pedeai_restaurantes")
public class Restaurante {

  @Id
  private String id;
  private String nome;
  private String endereco;
  private String horariosFuncionamento;
  private String tipoCozinha;

  @DBRef
  private List<ItemDeMenu> itensDeMenu;

  @DBRef
  private List<Pedido> pedidosRecebidos;}
