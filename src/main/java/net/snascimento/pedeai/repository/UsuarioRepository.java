package net.snascimento.pedeai.repository;

import net.snascimento.pedeai.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
  Usuario findByEmail(String email);
}
