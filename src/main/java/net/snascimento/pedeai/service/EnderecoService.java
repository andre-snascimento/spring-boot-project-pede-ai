package net.snascimento.pedeai.service;

import net.snascimento.pedeai.domain.Endereco;
import org.springframework.stereotype.Service;

@Service
public interface EnderecoService {
  void saveOrUpdateEndereco(Endereco endereco);
}
