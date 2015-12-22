
package com.websystique.springsecurity.controller;

import com.websystique.springsecurity.dao.UsuarioDAO;
import com.websystique.springsecurity.dao.ProgramacionDAO;
import com.websystique.springsecurity.model.Programacion;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorFuncionario {
    
    @Autowired
    @Qualifier("programacionBean")
    private ProgramacionDAO ProgramacionDAO;

    @Autowired
    @Qualifier("usuarioBean")
    private UsuarioDAO UsuarioDAO;


    @RequestMapping(value = {"/funcionario/gestionarSalas"}, method = RequestMethod.GET)
    public String compraBoletosPage(ModelMap model) {
    
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "gestionar_salas";
    }
    
    
// ____________________________________________________________________________________________________________________________________________
    
    @RequestMapping (value = {"/funcionario/gestionar_cartelera"},  method = RequestMethod.GET )
     public ModelAndView  Cartelera(ModelAndView model){
     
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addObject("info", UsuarioDAO.get(cedula));
        }
        model.addObject("user", getPrincipal());
        model.addObject("rol", getRole());

        List<Programacion> listaProgramacion = ProgramacionDAO.listar();
        model.addObject("listaProgramacion", listaProgramacion);
        model.setViewName("gestionar_cartelera");
        //model.setViewName("redirect:/");
        return model;
    }
     
    @RequestMapping (value = {"/funcionario/gestionar_cartelera/nuevaProgramacion"} , method = RequestMethod.GET)
    public ModelAndView nuevaProgramacion(ModelAndView model){
        System.out.println("GETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT5");
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addObject("info", UsuarioDAO.get(cedula));
        }       
        model.addObject("user", getPrincipal());
        model.addObject("rol", getRole());
        Programacion nuevaProgramacion = new Programacion();
        model.addObject("programacion", nuevaProgramacion);
        model.setViewName("insertarProgramacion");       
            
        return model;
    }
    

    @RequestMapping
     (value = "/funcionario/gestionar_cartelera/nuevaProgramacion", method = RequestMethod.POST)     // revisar el link
    public @ResponseBody Programacion informacionIngresada( HttpServletRequest request, HttpServletResponse response) {
        Programacion programacion;
        System.out.println("POSTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
        String id = request.getParameter("id");
        String hora = request.getParameter("hora");
        String sala = request.getParameter("sala");
        String pelicula = request.getParameter("pelicula");
        programacion= new Programacion();

        programacion.setHora(hora);
        programacion.setIdProgramacion(id);
        programacion.setPelicula(pelicula);
        programacion.setSala(sala);
        return programacion;
    }
    
    
    @RequestMapping(value = {"/funcionario/gestionar_cartelera/guardarProgramacion"}, method = RequestMethod.POST)
    public ModelAndView guardarProgramacion(@ModelAttribute Programacion programacion){

        ProgramacionDAO.insertar_actualizar(programacion);
        return new ModelAndView("redirect:/funcionario/gestionar_cartelera");           // se invoca en el formulario, no antes
    }
    
    @RequestMapping (value = {"/funcionario/gestionar_cartelera/eliminarProgramacion"}, method = RequestMethod.GET)
    public ModelAndView eliminarProgramacion(HttpServletRequest request){
        
        int programacionID = Integer.parseInt(request.getParameter("id"));      // cuidado con esta variable, no es idProgramacion.
        ProgramacionDAO.eliminar(programacionID);
        ModelAndView model = new ModelAndView();
        
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addObject("info", UsuarioDAO.get(cedula));
        }
        model.addObject("user", getPrincipal());
        model.addObject("rol", getRole());
        
        model.setViewName("redirect:/funcionario/gestionar_cartelera");
        
        return model;
    }
    
    @RequestMapping (value = {"/funcionario/gestionar_cartelera/editarProgramacion"}, method = RequestMethod.GET)
    public ModelAndView editarProgramacion(HttpServletRequest request){
        
        int programacionID = Integer.parseInt(request.getParameter("id"));
        Programacion programacion = ProgramacionDAO.buscar(programacionID);
        ModelAndView model = new ModelAndView();
        model.addObject("programacion", programacion);
        
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addObject("info", UsuarioDAO.get(cedula));
        }
        model.addObject("user", getPrincipal());
        model.addObject("rol", getRole());
        
        model.setViewName("formulario_Programacion");
        return model;
    }
   
// ____________________________________________________________________________________________________________________________________________
    
    @RequestMapping(value = {"/funcionario/consultarBoletas"}, method = RequestMethod.GET)
    public String consultarBoletasPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "consultar_reserva_de_boletas";
    }

    @RequestMapping(value = {"/funcionario/gestionarEventos"}, method = RequestMethod.GET)
    public String gestionarEventosPasage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        return "gestionar_eventos";
    }

    @RequestMapping(value = {"/funcionario/encuestas"}, method = RequestMethod.GET)
    public String encuestasPage(ModelMap model) {
        String rol=getRole();
        String cedula=getPrincipal();
        if(!rol.equals("ROLE_ANONYMOUS")){
            model.addAttribute("info", UsuarioDAO.get(cedula));
        }
        model.addAttribute("user", getPrincipal());
        model.addAttribute("rol", getRole());
        //return "encuestas";
        return "formulario_Programacion";
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
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) 
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String rolename = "";
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
        }
        return rolename;
    }

}
