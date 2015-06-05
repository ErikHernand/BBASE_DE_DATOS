package com.example.usuario.bbase_de_datos;

public class modelobitacora {

    private String matricula;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String email;
    private String carrera;
    private String semestre;
    private String grupo;
    private String maquina;

    public modelobitacora(String matricula, String nombre, String apellidop, String apellidom, String email, String carrera, String semestre, String grupo, String maquina) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.email = email;
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
        this.maquina = maquina;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public String getEmail() {
        return email;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getMaquina() {
        return maquina;
    }
}
