package com.websystique.springsecurity.model;

public class Usuario {
    private String apellidos;
    private String cedula;
    private String contrasena;
    private boolean enabled;
    private String correoElectronico;
    private String direccion;
    private String nombre;
    private String puntos;
    private String tarjetaDeCredito;
    private String telefono;
 
    public Usuario() {
    }

    public Usuario(String apellidos, String cedula, String correoElectronico, 
            String direccion, String nombre, String puntos, 
            String tarjetaDeCredito, String telefono) {
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.nombre = nombre;
        this.puntos = puntos;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.telefono = telefono;
    }

    public Usuario(String apellidos, String cedula, String contrasena, boolean enabled, String correoElectronico, String direccion, String nombre, String puntos, String tarjetaDeCredito, String telefono) {
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.enabled = enabled;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.nombre = nombre;
        this.puntos = puntos;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.telefono = telefono;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(String tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}