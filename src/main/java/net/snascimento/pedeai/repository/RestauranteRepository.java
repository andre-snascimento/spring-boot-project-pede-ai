package net.snascimento.pedeai.repository;

import net.snascimento.pedeai.domain.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestauranteRepository extends MongoRepository<Restaurante, String> {
    
}
