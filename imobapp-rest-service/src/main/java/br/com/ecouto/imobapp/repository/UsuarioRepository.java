package br.com.ecouto.imobapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecouto.imobapp.entity.Usuario;

/**
 *
 * @author Enzo Couto <enzocouto@gmail.com>
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    
    Usuario findByEmail(String email);
}
