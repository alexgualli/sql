/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.rnegocio.entidades;

/**
 *
 * @author paul
 */
public class Estudiante {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private Curso curso;

    public Estudiante() {
    }

    public Estudiante(int codigo, String nombre, String apellido, Curso curso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
