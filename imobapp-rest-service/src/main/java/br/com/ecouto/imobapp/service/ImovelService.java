package br.com.ecouto.imobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecouto.imobapp.entity.ImagemImovel;
import br.com.ecouto.imobapp.entity.Imovel;
import br.com.ecouto.imobapp.repository.ImagemImovelRepository;
import br.com.ecouto.imobapp.repository.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private ImagemImovelRepository imagemImovelRepository;
	
	public List<Imovel> listaImovel() {
        return imovelRepository.findAll();
    }

    public Page<Imovel> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return imovelRepository.findAll(pages);
    }

    public List<Imovel> buscaPorTitle(String title) {
        return imovelRepository.findByTitleLikeIgnoreCase(title);
    }
    
    
    public Imovel salvarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void deleteImovel(String id) {
    	imovelRepository.delete(id);
    }

    public Imovel getById(String id) {
    	Imovel findOne = imovelRepository.findOne(id);
        return findOne;
    }
    
    public List<ImagemImovel> buscarImagemImovel(String id) {
    	List<ImagemImovel> listaImovel = null;
    	Imovel imovel = imovelRepository.findOne(id);
    	if(imovel != null) {
    		listaImovel = imovel.getListaImagem();
    	}
        return listaImovel;
    }
    
    public ImagemImovel salvarImagemImovel(ImagemImovel imagem) {
    	return imagemImovelRepository.save(imagem);
     
    }
	
	
}
