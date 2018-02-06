/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sql.accesodatos.Conexion;
import sql.accesodatos.Parametro;
import sql.dao.contrato.*;
import sql.rnegocio.entidades.*;

/**
 *
 * @author paul
 */
public class EstudianteImpl implements IEstudiante{
    
    @Override
    public int insertar(Estudiante estudiante) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO estudiante(\n"
                + "            codigo, nombre,apellido,curso)\n"
                + "    VALUES (?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        
        CursoImpl dao = new CursoImpl();
        
        lstPar.add(new Parametro(1, estudiante.getCodigo()));
        lstPar.add(new Parametro(2, estudiante.getNombre()));
        lstPar.add(new Parametro(3, estudiante.getApellido()));
        lstPar.add(new Parametro(4, estudiante.getCurso().getCodigo()));
        
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
        
    }

    @Override
    public int modificar(Estudiante estudiante) {
        
        int numFilasAfectadas = 0;
        String sql = "UPDATE estudiante\n"
                + "   SET codigo=?, nombre=?,apellido=?,curso=?"
                + " WHERE codigo=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, estudiante.getCodigo()));
        lstPar.add(new Parametro(2, estudiante.getNombre()));
        lstPar.add(new Parametro(3, estudiante.getApellido()));
        lstPar.add(new Parametro(4, estudiante.getCurso().getCodigo()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
        
    }

    @Override
    public int eliminar(Estudiante estudiante) {
        
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM estudiante\n"
                + " WHERE codigo=" + estudiante.getCodigo();
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
        
    }

    @Override
    public Estudiante obtener(int codigo) throws Exception{
        
        /*
                Estudiante estudiante = null;
        String sql = "SELECT codigo, nombre,apellido,curso\n"
                + "  FROM estudiante WHERE codigo=?";
        Conexion con = new Conexion();
        
        EstudianteImpl dao = new EstudianteImpl();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                estudiante = new Estudiante();
                estudiante.setCodigo(rst.getInt(1));
                estudiante.setNombre(rst.getString(2));
                estudiante.setApellido(rst.getString(3));
                estudiante.setCurso(dao.obtener(rst.getInt(4)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
*/
        return null;

        
    }

    @Override
    public List<Estudiante> obtener() throws Exception{
               
       /*
EstudianteImpl dao = new EstudianteImpl();
        
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT codigo, nombre,apellido,curso"
                + "  FROM estudiante;";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante = new Estudiante();
                estudiante.setCodigo(rst.getInt(1));
                estudiante.setNombre(rst.getString(2));
                estudiante.setApellido(rst.getString(3));
                estudiante.setCurso(dao.obtener(rst.getInt(4)));
                lista.add(estudiante);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
*/
        return null;
        
    }
    
}
