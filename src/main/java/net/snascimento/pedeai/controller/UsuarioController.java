package net.snascimento.pedeai.controller;

import java.util.List;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedeai/usuarios")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping(value = "")
  public List<Usuario> getAllUsuarios() {
    return usuarioService.findAll();
  }

  @PostMapping(value = "")
  ResponseEntity<?> saveOrUpdateUsuario(@RequestBody Usuario usuario) {
    usuarioService.saveOrUpdateUsuario(usuario);
    return new ResponseEntity<>("Usuario adicionado com sucesso", HttpStatus.OK);
  }
}
