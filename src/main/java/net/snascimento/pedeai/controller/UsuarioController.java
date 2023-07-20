package net.snascimento.pedeai.controller;

import java.util.List;
import java.util.Optional;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.dto.UsuarioDTO;
import net.snascimento.pedeai.service.UsuarioService;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PostMapping(value = "/usuarios")
  ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody UsuarioDTO usuarioDto) {
    Usuario usuarioRequest = modelMapper.map(usuarioDto, Usuario.class);
    Usuario usuario = usuarioService.saveOrUpdateUsuario(usuarioRequest);
    UsuarioDTO usuarioResponse = modelMapper.map(usuario, UsuarioDTO.class);
    return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
  }

  @GetMapping(value = "/usuarios")
  public List<UsuarioDTO> getAllUsuarios() {
    return usuarioService.findAll().stream()
        .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
        .toList();
  }

  @GetMapping(value = "/usuarios/email")
  public UsuarioDTO getUsuarioByEmail(@RequestParam String emailUsuario) {
    Usuario usuario = usuarioService.findUsuarioByEmail(emailUsuario);
    return modelMapper.map(usuario, UsuarioDTO.class);
  }

  @PutMapping(value = "/usuarios/{idUsuario}")
  public ResponseEntity<UsuarioDTO> updateUsuario(
      @PathVariable("idUsuario") String id, @RequestBody UsuarioDTO usuarioDto) {
    Optional<Usuario> usuario = usuarioService.findById(id);
    if (usuario.isEmpty()) {
      return ResponseEntity.badRequest().body(usuarioDto);
    }
    usuario.ifPresent(
        u -> {
          u.setNome(ObjectUtils.defaultIfNull(usuarioDto.getNome(), u.getEmail()));
          u.setEmail(ObjectUtils.defaultIfNull(usuarioDto.getEmail(), u.getEmail()));
          u.setSenha(ObjectUtils.defaultIfNull(usuarioDto.getSenha(), u.getSenha()));
          u.setPapel(ObjectUtils.defaultIfNull(usuarioDto.getPapel(), u.getPapel()));
          u.setEnderecos(ObjectUtils.defaultIfNull(usuarioDto.getEnderecos(), u.getEnderecos()));
          u.setPedidos(ObjectUtils.defaultIfNull(usuarioDto.getPedidos(), u.getPedidos()));
          u.setAvaliacoes(ObjectUtils.defaultIfNull(usuarioDto.getAvaliacoes(), u.getAvaliacoes()));
          usuarioService.saveOrUpdateUsuario(u);
        });
    return ResponseEntity.ok(usuarioDto);
  }


}
