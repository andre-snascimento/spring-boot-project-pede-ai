package net.snascimento.pedeai.service;

import java.util.List;
import net.snascimento.pedeai.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

  List<Usuario> findAll();

  Usuario findUsuarioByEmail(String email);

  Usuario saveOrUpdateUsuario(Usuario usuario);

  void deleteUsuarioById(String id);
}
