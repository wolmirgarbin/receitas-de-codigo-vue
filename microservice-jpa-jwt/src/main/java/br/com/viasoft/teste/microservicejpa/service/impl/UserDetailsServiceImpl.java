package br.com.viasoft.teste.microservicejpa.service.impl;

import br.com.viasoft.teste.microservicejpa.data.UsuarioData;
import br.com.viasoft.teste.microservicejpa.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UsuarioData usuarioData;

    @Autowired
    public UserDetailsServiceImpl(UsuarioData usuarioData) {
        this.usuarioData = usuarioData;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioData.findByUsuario(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_BASE"));
        //}

        return new User(user.getUsuario(), user.getSenha(), grantedAuthorities);
    }

}