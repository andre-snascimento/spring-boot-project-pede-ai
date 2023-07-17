package net.snascimento.pedeai.dto;

import java.util.List;
import lombok.Data;
import net.snascimento.pedeai.domain.Avaliacao;
import net.snascimento.pedeai.domain.Endereco;
import net.snascimento.pedeai.domain.Pedido;
import net.snascimento.pedeai.domain.Usuario;

@Data
public class UsuarioDTO {
  private String nome;
  private String email;
  private String senha;
  private String papel;
  private List<Endereco> enderecos;
  private List<Pedido> pedidos;
  private List<Avaliacao> avaliacoes;

  public Usuario transformaParaObjeto() {
    return new Usuario(nome, email, senha, papel, enderecos, pedidos, avaliacoes);
  }
}
