/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.dao.contrato;

import java.util.List;
import sql.rnegocio.entidades.Estudiante;

/**
 *
 * @author paul
 */
public interface IEstudiante {
    
    int insertar(Estudiante estudiante);
    
    int modificar(Estudiante estudiante);
    
    int eliminar(Estudiante estudiante);
    
    Estudiante obtener(int codigo) throws Exception;
    
    List<Estudiante> obtener() throws Exception;
    
}
