package net.snascimento.pedeai.repository;

import net.snascimento.pedeai.domain.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {

}
