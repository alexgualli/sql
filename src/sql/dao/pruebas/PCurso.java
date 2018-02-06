/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.dao.pruebas;

import sql.dao.impl.CursoImpl;
import sql.rnegocio.entidades.Curso;

/**
 *
 * @author paul
 */
public class PCurso {
    
    public static void main(String[] args) {
        
        Curso curso = new Curso(1, "Sistemas y Computacion");
        
        CursoImpl dao = new CursoImpl();
        
        try {
            
            if(dao.insertar(curso)>0)
            {
                System.out.println("INSERTADO CORRECTAMENTE");                
            }
            else
            {
                System.out.println("ERROR AL INSERTAR");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
