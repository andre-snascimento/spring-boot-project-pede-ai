package net.snascimento.pedeai.service;

import java.util.List;
import java.util.Optional;

import net.snascimento.pedeai.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

  List<Usuario> findAll();

  Optional<Usuario> findById(String id);

  Usuario saveOrUpdateUsuario(Usuario usuario);

  Usuario findUsuarioByEmail(String email);

  void deleteUsuarioById(String id);
}
