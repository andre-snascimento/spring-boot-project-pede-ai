package net.snascimento.pedeai.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "usuarios")
public class Usuario {

  @Id private String id;
  private String nome;
  private String email;
  private String senha;
  private String papel;
  private List<Endereco> enderecos;
  private List<Pedido> pedidos;
  private List<Avaliacao> avaliacoes;

  public void adicionarPedido(Pedido pedido) {
    this.pedidos.add(pedido);
  }

  public void adicionarAvaliacao(Avaliacao avaliacao) {
    this.avaliacoes.add(avaliacao);
  }

  public void adicionaEndereco(Endereco endereco) {
    this.enderecos.add(endereco);
  }
}
