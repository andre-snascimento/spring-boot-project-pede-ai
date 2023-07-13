package net.snascimento.pedeai.domains;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pedidos")
public class Pedido {

  @Id
  private String id;
  private LocalDateTime dataHora;
  private List<ItemPedido> itens;
  private Endereco enderecoEntrega;
  private String status;
  private double valorTotal;
}
