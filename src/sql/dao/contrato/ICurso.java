package sql.dao.contrato;

import java.util.List;
import sql.rnegocio.entidades.Curso;

public interface ICurso {
    
    int insertar(Curso curso);
    
    int modificar(Curso curso);
    
    int eliminar(Curso curso);
    
    Curso obtener(int codigo) throws Exception;
    
    List<Curso> obtener() throws Exception;
    
}
