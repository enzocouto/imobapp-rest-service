package br.com.ecouto.imobapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecouto.imobapp.entity.Perfil;

/**
 *
 * @author Enzo Couto <enzocouto@gmail.com>
 */
public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String nome);

}
