/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David pinto
 */
public class Consultabd extends Conexion{
    
    private Connection con=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String agregar="INSERT INTO mascota(num_ficha,nombre,edad,vacunas,peso,altura,tipo,clasificacion,nom_duenno,fono) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private String modificar="UPDATE mascota set num_ficha=?,nombre=?,edad=?,vacunas=?,peso=?,altura=?,tipo=?,clasificacion=?,nom_duenno=?,fono=?" /*WHERE num_ficha=?"*/;
    private String eliminar="DELETE FROM mascota WHERE num_ficha=?";
    private String listar="SELECT * FROM mascota";
    
    public boolean Agregar(Mascota mascota){
        boolean insertar=false;
        try{
            con=getConexion();
            ps=con.prepareStatement(agregar);
            
            ps.setInt(1,mascota.getNumficha());
            ps.setString(2,mascota.getNombre());
            ps.setInt(3,mascota.getEdad());
            ps.setBoolean(4,mascota.isVacunas());
            ps.setDouble(5,mascota.getPeso());
            ps.setDouble(6,mascota.getAltura());
            ps.setObject(7,mascota.getTipomascota());
            ps.setString(8,mascota.getClasificacion());
            ps.setString(9,mascota.getNombredueno());
            ps.setInt(10,mascota.getFonodueno());
            insertar=true;
            ps.execute();
            
        }catch(SQLException ex){
            System.err.println(ex);
        
        }finally{
            close (con);
            close(rs);
            close(ps);
        }
    
        return insertar;
    }
    
    public boolean Modificar(Mascota mascota){
        boolean mod=false;
        try{
            con=getConexion();
            ps=con.prepareStatement(modificar);
            ps.setInt(1,mascota.getNumficha());
            ps.setString(2,mascota.getNombre());
            ps.setInt(3,mascota.getEdad());
            ps.setBoolean(4,mascota.isVacunas());
            ps.setDouble(5,mascota.getPeso());
            ps.setDouble(6,mascota.getAltura());
            ps.setObject(7,mascota.getTipomascota());
            ps.setString(8,mascota.getClasificacion());
            ps.setString(9,mascota.getNombredueno());
            ps.setInt(10,mascota.getFonodueno());
            mod=true;
            
        }catch(SQLException ex){
            System.err.println(ex);
            
        }finally{
            close(con);
            close(rs);
            close(ps);
        }
        return mod;
    }
    
    
    public boolean Eliminar(Mascota mascota){
        boolean delete=false;
        
        try{
            con=getConexion();
            ps=con.prepareStatement(eliminar);
            ps.setInt(1,mascota.getNumficha());
            ps.executeUpdate();
            delete=true;
            
                        
        }catch(SQLException ex){
            System.err.println(ex);
        }finally{
            close(con);
            close(rs);
            close(ps);
        }
        
        return delete;
    }
    
    public DefaultTableModel Listar(Mascota mascota){
        
        DefaultTableModel tabla=new DefaultTableModel();        
          
        
        tabla.addColumn("Nº Ficha");
        tabla.addColumn("Nombre");
        tabla.addColumn("Edad");
        tabla.addColumn("Vacunas al Día");
        tabla.addColumn("Peso");
        tabla.addColumn("Altura");
        tabla.addColumn("Tipo");
        tabla.addColumn("Clasificación");
        tabla.addColumn("Nombre Dueño");
        tabla.addColumn("Telefono Dueño");
        
        
        try{
            con=getConexion();
            ps=con.prepareStatement(listar);
            rs=ps.executeQuery();
            Object filas[]=new Object[10];
            while (rs.next()){
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                filas[2]=rs.getInt(3);
                filas[3]=rs.getBoolean(4);
                filas[4]=rs.getInt(5);
                filas[5]=rs.getInt(6);
                filas[6]=rs.getObject(7);
                filas[7]=rs.getString(8);
                filas[8]=rs.getString(9);
                filas[9]=rs.getString(10);
                tabla.addRow(filas);
                
            }
        }catch(SQLException ex){
            System.err.println(ex);
            
        }finally{
            close(con);
            close(rs);
            close(ps);
        }
        return tabla;
    }
}//Fin Clase
