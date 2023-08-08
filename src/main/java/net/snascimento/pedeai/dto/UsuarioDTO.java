package net.snascimento.pedeai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;
import net.snascimento.pedeai.domain.Avaliacao;
import net.snascimento.pedeai.domain.Endereco;
import net.snascimento.pedeai.domain.Pedido;

@Data
public class UsuarioDTO {

  @NotNull(message = "Nome: Não pode ser vazio")
  @NotBlank(message = "Nome: Não pode ser em branco")
  @Size(min = 3, max = 200, message = "Nome: deve ter de 3 a 200 caracteres")
  private String nome;

  @NotNull(message = "E-mail: Não pode ser vazio")
  @NotBlank(message = "E-mail: Não pode ser em branco")
  private String email;

  @NotNull(message = "Senha: Não pode ser vazio")
  @NotBlank(message = "Senha: Não pode ser em branco")
  @Size(min = 5, max = 30, message = "Senha: Deve ter de 5 a 20 caracteres")
  private String senha;

  @NotNull(message = "Papel: Não pode ser vazio")
  @NotBlank(message = "Papel: Não pode ser em branco")
  private String papel;

  private List<Endereco> enderecos;
  private List<Pedido> pedidos;
  private List<Avaliacao> avaliacoes;
  
}
