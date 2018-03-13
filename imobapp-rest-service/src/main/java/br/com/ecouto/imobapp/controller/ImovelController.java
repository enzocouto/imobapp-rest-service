package br.com.ecouto.imobapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecouto.imobapp.entity.ImagemImovel;
import br.com.ecouto.imobapp.entity.Imovel;
import br.com.ecouto.imobapp.service.ImovelService;

@RestController
public class ImovelController {


	@Autowired
	private ImovelService imovelService;
	
	@RequestMapping(value = "/imovel", method = RequestMethod.GET)
    public List<Imovel> listar() {
        return this.imovelService.listaImovel();
    }

    @RequestMapping(value = "/imovel/{id}", method = RequestMethod.GET)
    public Imovel getById(@PathVariable String id) {
    	Imovel imovel = null;
    	if(id != null) {
    		imovel = imovelService.getById(id.trim());	
    	}
        return imovel;
    }
    
    @RequestMapping(value = "/imovel/{title}/title", method = RequestMethod.GET)
    public List<Imovel> buscaPorTitle(@PathVariable String title) {
        return this.imovelService.buscaPorTitle(title);
    }
    

    @RequestMapping(value = "/imovel/{page}/{count}", method = RequestMethod.GET)
    public Page<Imovel> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.imovelService.listaPaginada(count, page);
    }


    @RequestMapping(value = "/imovel", method = RequestMethod.POST)
    public Imovel salvar(@RequestBody Imovel imovel) {
        return this.imovelService.salvarImovel(imovel);
    }

    @RequestMapping(value = "/imovel", method = RequestMethod.PUT)
    public Imovel editar(@RequestBody Imovel imovel) {
        return this.imovelService.salvarImovel(imovel);
    }

    @RequestMapping(value = "/imovel/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.imovelService.deleteImovel(id);
    }
    
    @RequestMapping(value = "/imovel/imagem/{idImovel}", method = RequestMethod.GET)
    public List<ImagemImovel> buscarImagemImovel(@PathVariable String idImovel) {
        return this.imovelService.buscarImagemImovel(idImovel);
    }
    
    @RequestMapping(value = "/imovel/imagem", method = RequestMethod.PUT)
    public ImagemImovel salvarImagemImovel(@RequestBody ImagemImovel imagem) {
        return this.imovelService.salvarImagemImovel(imagem);
    }
    
    @RequestMapping(value = "/imovel/imagem", method = RequestMethod.POST)
    public ImagemImovel editarImagemImovel(@RequestBody ImagemImovel imagem) {
        return this.imovelService.salvarImagemImovel(imagem);
    }
    
    
}
