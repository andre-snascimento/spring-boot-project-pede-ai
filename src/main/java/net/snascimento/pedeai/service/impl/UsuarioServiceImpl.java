package net.snascimento.pedeai.service.impl;

import java.util.List;
import java.util.Optional;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.repository.UsuarioRepository;
import net.snascimento.pedeai.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioRepository usuarioRepository;


  public UsuarioServiceImpl(
      UsuarioRepository usuarioRepository) {
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
  
//  @Override
//  public Endereco addEndereco(String idUsuario, Endereco newAddress) throws Exception {
//    Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
//    if (optionalUsuario.isPresent()) {
//      Usuario usuario = optionalUsuario.get();
//      this.saveEndereco(newAddress);
//      usuario.adicionaEndereco(newAddress);
//      this.saveOrUpdateUsuario(usuario);
//      return newAddress;
//    } else {
//      throw new Exception("User not found with id: " + idUsuario);
//    }
//  }



  @Override
  public void deleteUsuarioById(String id) {
    usuarioRepository.deleteById(id);
  }

  @Override
  public Optional<Usuario> findById(String id) {
    return usuarioRepository.findById(id);
  }
}
