package br.com.ecouto.imobapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecouto.imobapp.entity.Imovel;

public interface ImovelRepository extends MongoRepository<Imovel, String> {

	List<Imovel> findByTitleLikeIgnoreCase(String title);
}
