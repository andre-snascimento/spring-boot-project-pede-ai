package net.snascimento.pedeai.service.impl;

import net.snascimento.pedeai.domain.Endereco;
import net.snascimento.pedeai.repository.EnderecoRepository;
import net.snascimento.pedeai.service.EnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

  private final EnderecoRepository enderecoRepository;


  public EnderecoServiceImpl(
      EnderecoRepository enderecoRepository) {
    this.enderecoRepository = enderecoRepository;

  }

  @Override
  public void saveOrUpdateEndereco(Endereco endereco){
    enderecoRepository.save(endereco);
  }
}
