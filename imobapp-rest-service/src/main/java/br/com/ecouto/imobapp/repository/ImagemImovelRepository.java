package br.com.ecouto.imobapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecouto.imobapp.entity.ImagemImovel;

public interface ImagemImovelRepository extends MongoRepository<ImagemImovel, String> {

}
