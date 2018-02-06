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
import sql.dao.contrato.ICurso;
import sql.rnegocio.entidades.Curso;

/**
 *
 * @author paul
 */
public class CursoImpl implements ICurso{
    @Override
    public int insertar(Curso curso) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO curso(\n"
                + "            codigo, descripcion)\n"
                + "    VALUES (?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, curso.getCodigo()));
        lstPar.add(new Parametro(2, curso.getDescripcion()));
        
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
    public int modificar(Curso curso) {
        
        int numFilasAfectadas = 0;
        String sql = "UPDATE curso\n"
                + "   SET codigo=?, descripcion=?"
                + " WHERE codigo=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, curso.getCodigo()));
        lstPar.add(new Parametro(2, curso.getDescripcion()));
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
    public int eliminar(Curso curso) {
        
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM curso\n"
                + " WHERE codigo=" + curso.getCodigo();
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
    public Curso obtener(int codigo) throws Exception{
        
        Curso curso = null;
        String sql = "SELECT codigo, descripcion\n"
                + "  FROM curso WHERE codigo=?";
        Conexion con = new Conexion();
        
        CursoImpl dao = new CursoImpl();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                curso = new Curso();
                curso.setCodigo(rst.getInt(1));
                curso.setDescripcion(rst.getString(2));        
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return curso;
        
    }

    @Override
    public List<Curso> obtener() throws Exception{
               
        CursoImpl dao = new CursoImpl();
        
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT codigo, descripcion"
                + "  FROM curso;";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Curso curso = new Curso();
                curso = new Curso();
                curso.setCodigo(rst.getInt(1));
                curso.setDescripcion(rst.getString(2));
                lista.add(curso);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
        
    }
    
}
