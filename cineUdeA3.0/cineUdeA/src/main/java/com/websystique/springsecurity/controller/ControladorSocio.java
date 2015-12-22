/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springsecurity.controller;

import com.websystique.springsecurity.dao.UsuarioDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorSocio {
    
    @Autowired
    private UsuarioDAO UsuarioDAO;

    @RequestMapping(value = {"/socio"}, method = RequestMethod.GET)
    public String socioPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "socio";
    }

    @RequestMapping(value = {"/socio/comprarBoletos"}, method = RequestMethod.GET)
    public String compraBoletosPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "comprar_boletos";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private String getRole() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String rolename = "";
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
        }
        return rolename;
    }

}
