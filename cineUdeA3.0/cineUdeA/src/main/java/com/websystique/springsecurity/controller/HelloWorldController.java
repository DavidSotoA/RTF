package com.websystique.springsecurity.controller;

import com.websystique.springsecurity.dao.UsuarioDAO;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
    
@Autowired
    private UsuarioDAO UsuarioDAO;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", cedula);
        model.addAttribute("rol", rol);
        return "welcome";
    }
    
    @RequestMapping(value = {"/registrarse"}, method = RequestMethod.GET)
    public String registrarsePage(ModelMap model) {
        String role = getRole();
        if (role.equals("ROLE_ANONYMOUS")) {
            model.addAttribute("user", getPrincipal());
            model.addAttribute("rol", role);
        return "registrarse";
        }
        else 
            return "redirect:/";
    }
    

    @RequestMapping(value = {"/redimir"}, method = RequestMethod.GET)
    public String redimirPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "redimir_puntos";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "access_denied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        String role = getRole();
        if (role.equals("ROLE_ANONYMOUS")) {
            model.addAttribute("user", getPrincipal());
            model.addAttribute("rol", role);
            return "login";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good idea to show login screen again.
    }

    @RequestMapping(value = "/iniciarSesion", method = RequestMethod.GET)
    public String iniciarSesionPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "redirect:/login";
    }

    private String getRole() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String rolename = "";
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
        }
        return rolename;
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
}
