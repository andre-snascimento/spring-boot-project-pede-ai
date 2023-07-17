package net.snascimento.pedeai.service.impl;

import java.util.List;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.repository.UsuarioRepository;
import net.snascimento.pedeai.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;

  public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public List<Usuario> findAll() {
    return usuarioRepository.findAll();
  }

  @Override
  public Usuario findUsuarioByEmail(String email) {
    return usuarioRepository.findByEmail(email);
  }

  @Override
  public Usuario saveOrUpdateUsuario(Usuario usuario) {

    return usuarioRepository.save(usuario);
  }

  @Override
  public void deleteUsuarioById(String id) {
    usuarioRepository.deleteById(id);
  }
}
