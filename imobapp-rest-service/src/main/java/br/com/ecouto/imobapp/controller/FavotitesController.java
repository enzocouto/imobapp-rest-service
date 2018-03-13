package br.com.ecouto.imobapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecouto.imobapp.entity.Imovel;

@RestController
public class FavotitesController {

	@SuppressWarnings("unchecked")
	@RequestMapping( value= "/favoritos" , method = RequestMethod.POST)
    public String addFavoritos(@RequestBody Imovel imovel,HttpServletRequest request) {
    	
        List<Imovel> favoritos = (List<Imovel>)request.getSession().getAttribute("favoritos");
        boolean exists = false;
        if(favoritos != null) {
        	for (Imovel obj : favoritos) {
    			if(obj.getId().equals(imovel.getId())) {
    				exists = true;
    		            break;
    			}
    		}
        }else {
        	favoritos = new ArrayList<Imovel>();
        }
        
        if (!exists) {
        	favoritos.add(imovel);
        }
        request.getSession().setAttribute("favoritos", favoritos);
    	return "sucesso";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping( value= "/favoritos" , method = RequestMethod.GET)
    public List<Imovel> getFavoritos(HttpServletRequest request) {
    	List<Imovel> listFavoritos = new ArrayList<Imovel>();
        if(request.getSession().getAttribute("favoritos") != null) {
        	listFavoritos = (List<Imovel>) request.getSession().getAttribute("favoritos");
        }
        return listFavoritos;
       
    }
}
