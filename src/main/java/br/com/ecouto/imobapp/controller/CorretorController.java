package br.com.ecouto.imobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecouto.imobapp.entity.Corretor;
import br.com.ecouto.imobapp.service.CorretorService;

@RestController
public class CorretorController {
	
	@Autowired
    CorretorService corretorService;
	
	

    @RequestMapping(value = "/corretor", method = RequestMethod.GET)
    public List<Corretor> listar() {
        return this.corretorService.listaCorretor();
    }

    @RequestMapping(value = "/corretor/{id}", method = RequestMethod.GET)
    public Corretor getById(@PathVariable String id) {
    	Corretor corretor = null;
    	if(id != null) {
    		corretor = corretorService.getById(id.trim());	
    	}
        return corretor;
    }

    @RequestMapping(value = "/corretor/{page}/{count}", method = RequestMethod.GET)
    public Page<Corretor> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.corretorService.listaPaginada(count, page);
    }


    @RequestMapping(value = "/corretor", method = RequestMethod.POST)
    public Corretor salvar(@RequestBody Corretor corretor) {
        return this.corretorService.salvarCorretor(corretor);
    }

    @RequestMapping(value = "/corretor", method = RequestMethod.PUT)
    public Corretor editar(@RequestBody Corretor corretor) {
        return this.corretorService.salvarCorretor(corretor);
    }

    @RequestMapping(value = "/corretor/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.corretorService.deleteCorretor(id);
    }
	
	

}
