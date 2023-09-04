package net.snascimento.pedeai.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import net.snascimento.pedeai.domain.Restaurante;
import net.snascimento.pedeai.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pedeai")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping(value="/restaurantes")
    public ResponseEntity<Restaurante> saveRestaurante(@Valid @RequestBody Restaurante restaurante){
        restauranteService.saveOrUpdateRestaurante(restaurante);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @GetMapping(value = "/restaurantes")
    public List<Restaurante> getAllRestaurantes(){
        return restauranteService.findAll();
    }

    @PutMapping(value = "/restaurantes/{idRestaurante}")
    public ResponseEntity<Restaurante> updateRestaurante(
            @PathVariable("idRestaurante") String id, @RequestBody Restaurante restaurante){
        Optional<Restaurante> restauranteOptional = restauranteService.findById(id);

        if(restauranteOptional.isEmpty()){
            return ResponseEntity.badRequest().body(restaurante);
        }
        
        restauranteService.saveOrUpdateRestaurante(restaurante);
        return ResponseEntity.ok(restaurante);
    }

    @DeleteMapping(value = "/restaurantes/{idRestaurante}")
    public ResponseEntity<Void> deleteRestaurante(
            @PathVariable("idRestaurante") String id
    ){
        Optional<Restaurante> restauranteOptional = restauranteService.findById(id);

        if(restauranteOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        restauranteService.deleteRestauranteById(id);
        return ResponseEntity.ok().build();
    }

}
