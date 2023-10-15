package net.snascimento.pedeai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoDTO {

  @NotNull(message = "Rua: Não pode ser vazio")
  @NotBlank(message = "Rua: Não pode ser em branco")
  @Size(min = 5, max = 200, message = "Nome: deve ter de 5 a 200 caracteres")
  private String rua;
  
  @NotNull(message = "Cidade: Não pode ser vazio")
  @NotBlank(message = "Cidade: Não pode ser em branco")
  @Size(min = 3, max = 200, message = "Cidade: deve ter de 3 a 200 caracteres")
  private String cidade;
  
  @NotNull(message = "Estado: Não pode ser vazio")
  @NotBlank(message = "Estado: Não pode ser em branco")
  @Size(min = 4, max = 20, message = "Estado: deve ter de 4 a 20 caracteres")
  private String estado;
  
  @NotNull(message = "CEP: Não pode ser vazio")
  @NotBlank(message = "CEP: Não pode ser em branco")
  @Size(min = 9, max = 9, message = "CEP: deve ter 9 caracteres")
  private String cep;

}
