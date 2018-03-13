package br.com.ecouto.imobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecouto.imobapp.entity.Corretor;
import br.com.ecouto.imobapp.repository.CorretorRepository;

/**
 *
 * @author Enzo Couto <enzocouto@gmail.com>
 */
@Service
public class CorretorService {

    @Autowired
    CorretorRepository corretorRepository;

    public List<Corretor> listaCorretor() {
        return corretorRepository.findAll();
    }

    public Page<Corretor> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return corretorRepository.findAll(pages);
    }


    public Corretor salvarCorretor(Corretor corretor) {
        return corretorRepository.save(corretor);
    }

    public void deleteCorretor(String id) {
    	corretorRepository.delete(id);
    }

    public Corretor getById(String id) {
    	Corretor findOne = corretorRepository.findOne(id);
        return findOne;
    }

}
