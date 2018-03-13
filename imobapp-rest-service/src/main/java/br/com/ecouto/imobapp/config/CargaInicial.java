package br.com.ecouto.imobapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.ecouto.imobapp.entity.Perfil;
import br.com.ecouto.imobapp.entity.Usuario;
import br.com.ecouto.imobapp.repository.PerfilRepository;
import br.com.ecouto.imobapp.repository.UsuarioRepository;

/**
 *
 * @author Enzo Couto <enzocouto@gmail.com>
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        List<Perfil> perfis = perfilRepository.findAll();

        if (perfis.isEmpty()) {
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            perfilRepository.save(new Perfil("ROLE_USUARIO"));

            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

            List<Perfil> novosPerfis = new ArrayList<Perfil>();

            novosPerfis.add(perfil);

            usuarioRepository.save(new Usuario("ADMIN", "admin", "123", novosPerfis));

        }

    }

}
