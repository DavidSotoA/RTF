
package com.websystique.springsecurity.model;

public class Programacion {

    private String idProgramacion;
    private String sala;
    private String pelicula;
    private String hora;

    public Programacion(String idProgramacion, String sala, String pelicula, String hora) {
        this.idProgramacion = idProgramacion;
        this.sala = sala;
        this.pelicula = pelicula;
        this.hora = hora;
    }
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public Programacion() {

    }

    public Programacion(String sala, String pelicula) {

        this.sala = sala;
        this.pelicula = pelicula;

    }

    public String getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(String idProgramacion) {
        this.idProgramacion = idProgramacion;
    }
    
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

}
