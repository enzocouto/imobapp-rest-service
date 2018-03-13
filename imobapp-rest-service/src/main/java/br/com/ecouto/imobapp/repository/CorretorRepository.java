package br.com.ecouto.imobapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecouto.imobapp.entity.Corretor;

public interface CorretorRepository extends MongoRepository<Corretor, String> {

}
