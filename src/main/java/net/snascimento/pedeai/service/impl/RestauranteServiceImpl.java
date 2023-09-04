package net.snascimento.pedeai.service.impl;

import net.snascimento.pedeai.domain.Restaurante;
import net.snascimento.pedeai.repository.RestauranteRepository;
import net.snascimento.pedeai.service.RestauranteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

  private final RestauranteRepository restauranteRepository;

  public RestauranteServiceImpl(RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  public List<Restaurante> findAll() {
    return restauranteRepository.findAll();
  }

  @Override
  public void saveOrUpdateRestaurante(Restaurante restaurante) {
    restauranteRepository.save(restaurante);
  }

  @Override
  public Optional<Restaurante> findById(String id) {
    return restauranteRepository.findById(id);
  }

  @Override
  public void deleteRestauranteById(String id) {
    restauranteRepository.deleteById(id);
  }
}
