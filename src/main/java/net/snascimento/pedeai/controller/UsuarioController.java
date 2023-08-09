package net.snascimento.pedeai.controller;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.snascimento.pedeai.domain.Endereco;
import net.snascimento.pedeai.domain.Usuario;
import net.snascimento.pedeai.dto.UsuarioDTO;
import net.snascimento.pedeai.service.EnderecoService;
import net.snascimento.pedeai.service.UsuarioService;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedeai")
public class UsuarioController {

  private final UsuarioService usuarioService;
  private final EnderecoService enderecoService;
  private final ModelMapper modelMapper;

  public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService, ModelMapper modelMapper) {
    this.usuarioService = usuarioService;
    this.enderecoService = enderecoService;
    this.modelMapper = modelMapper;
  }

  @PostMapping(value = "/usuarios")
  ResponseEntity<UsuarioDTO> saveUsuario(@Valid @RequestBody UsuarioDTO usuarioDto) {
    Usuario usuarioRequest = modelMapper.map(usuarioDto, Usuario.class);
    Endereco endereco = usuarioRequest.getEnderecos().get(0);
    enderecoService.saveOrUpdateEndereco(endereco);
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
    Optional<Usuario> usuarioOptional = usuarioService.findById(id);

    if (usuarioOptional.isEmpty()) {
      return ResponseEntity.badRequest().body(usuarioDto);
    }

    Usuario usuario = usuarioOptional.get();
    List<Endereco> endereco = usuario.getEnderecos();

    usuario.setNome(ObjectUtils.defaultIfNull(usuarioDto.getNome(), usuario.getEmail()));
    usuario.setEmail(ObjectUtils.defaultIfNull(usuarioDto.getEmail(), usuario.getEmail()));
    usuario.setSenha(ObjectUtils.defaultIfNull(usuarioDto.getSenha(), usuario.getSenha()));
    usuario.setPapel(ObjectUtils.defaultIfNull(usuarioDto.getPapel(), usuario.getPapel()));
    usuario.setEnderecos(ObjectUtils.defaultIfNull(endereco, endereco));
    usuario.setPedidos(ObjectUtils.defaultIfNull(usuarioDto.getPedidos(), usuario.getPedidos()));
    usuario.setAvaliacoes(ObjectUtils.defaultIfNull(usuarioDto.getAvaliacoes(), usuario.getAvaliacoes()));

    usuarioService.saveOrUpdateUsuario(usuario);

    return ResponseEntity.ok(usuarioDto);
  
  }

  @GetMapping(value = "/usuarios/{idUsuario}/enderecos")
  public ResponseEntity<?> getUsuarioEnderecos(@PathVariable("idUsuario") String id){
    return ResponseEntity.ok("Lista de Endereços");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
    Map <String, String> errors = new HashMap<>();

    ex.getBindingResult().getAllErrors().forEach(
        (error) -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        }
    );

    return errors;
  }

}
