package net.snascimento.pedeai.controller;

import java.util.List;
import java.util.Optional;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.dto.UsuarioDTO;
import net.snascimento.pedeai.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedeai")
public class UsuarioController {

  private final UsuarioService usuarioService;
  @Autowired private ModelMapper modelMapper;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping(value = "/usuarios")
  public List<UsuarioDTO> getAllUsuarios() {
    return usuarioService.findAll().stream()
        .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
        .toList();
  }

  @GetMapping(value = "/usuarios/{emailUsuario}")
  public UsuarioDTO getUsuarioByEmail(@RequestParam(value="emailUsuario") String emailUsuario) {
    Usuario usuario = usuarioService.findUsuarioByEmail(emailUsuario);
    return modelMapper.map(usuario, UsuarioDTO.class);
  }

  @GetMapping(value = "/usuarios/{idUsuario}")
  public UsuarioDTO getUsuarioById(@PathVariable String idUsuario) {
    Optional<Usuario> usuario = usuarioService.findUsuarioById(idUsuario);
    return modelMapper.map(usuario, UsuarioDTO.class);
  }

  @PostMapping(value = "/usuarios")
  ResponseEntity<UsuarioDTO> saveOrUpdateUsuario(@RequestBody UsuarioDTO usuarioDto) {
    Usuario usuarioRequest = modelMapper.map(usuarioDto, Usuario.class);
    Usuario usuario = usuarioService.saveOrUpdateUsuario(usuarioRequest);
    UsuarioDTO usuarioResponse = modelMapper.map(usuario, UsuarioDTO.class);
    return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
  }
}
