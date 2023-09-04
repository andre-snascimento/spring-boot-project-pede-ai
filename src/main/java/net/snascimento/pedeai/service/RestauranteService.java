package net.snascimento.pedeai.service;

import net.snascimento.pedeai.domain.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RestauranteService {
    List<Restaurante> findAll();

    void saveOrUpdateRestaurante(Restaurante restaurante);

    Optional<Restaurante> findById(String id);

    void deleteRestauranteById(String id);
}
