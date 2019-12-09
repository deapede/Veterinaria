/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consultabd;
import Modelo.Mascota;
import Vistas.Agregar;
import Vistas.Menu;
import Vistas.Listar;
import Vistas.Modificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David pinto
 */
public class Controlador implements ActionListener {

private Mascota mascota;
private Consultabd cbd;
private Menu menu;
private Agregar agregar;
private Listar listar;
private Modificar modificar;

    public Controlador(Mascota mascota, Consultabd cbd, Menu menu, Agregar agregar, Listar listar, Modificar modificar) {
        this.mascota = mascota;
        this.cbd = cbd;
        this.menu = menu;
        this.agregar = agregar;
        this.listar =new Listar();
        this.modificar=modificar;
        this.agregar.btnGuardar.addActionListener(this);
        this.agregar.btnLimpiar.addActionListener(this);
        this.agregar.btnSalir.addActionListener(this);
        this.listar.btnBuscar.addActionListener(this);
        this.listar.btnEliminar.addActionListener(this);
        this.listar.btnModificar.addActionListener(this);
        this.menu.MenuAgregar.addActionListener(this);
        this.menu.MenuListar.addActionListener(this);
        this.menu.MenuSalir.addActionListener(this);
        this.modificar.btnGuardar.addActionListener(this);
        this.modificar.btnLimpiar.addActionListener(this);
        this.modificar.btnSalir.addActionListener(this);
        
    }

   
    
    
   public void iniciar(){
       menu.setTitle("Menu Principal");
       menu.setLocationRelativeTo(null);
       menu.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botones Salir
        if(e.getSource()==menu.MenuSalir){
            System.exit(0);
        }
        
        if(e.getSource()==agregar.btnSalir){
            agregar.dispose();
        }
        
        if(e.getSource()==modificar.btnSalir){
            modificar.dispose();
        }
        
        //Vista Agregar
        if(e.getSource()==menu.MenuAgregar){
            agregar.setTitle("Agregar Mascota");
            agregar.setLocationRelativeTo(null);
            agregar.setVisible(true);
        }
        
        if(e.getSource()==agregar.btnLimpiar){
            agregar.txtFicha.setText(null);
            agregar.txtEdad.setText(null);
            agregar.txtPeso.setText(null);
            agregar.txtAltura.setText(null);
            agregar.txtTipo.setText(null);
            agregar.txtClasificacion.setText(null);
            agregar.txtNombre.setText(null);
            agregar.txtDueno.setText(null);
            agregar.txtTelDueno.setText(null);
            
        }
        
        if(e.getSource()==agregar.btnGuardar){
            mascota.setNumficha(Integer.parseInt(agregar.txtFicha.getText()));
            mascota.setNombre(agregar.txtNombre.getText());
            mascota.setEdad(Integer.parseInt(agregar.txtEdad.getText()));
            mascota.setPeso(Double.parseDouble(agregar.txtPeso.getText()));
            mascota.setAltura(Double.parseDouble(agregar.txtAltura.getText()));
            mascota.setVacunas(agregar.boxVacunas.getSelectedItem().equals("Si")?true : false);
            mascota.setTipomascota(agregar.txtTipo.getText());
            mascota.setClasificacion(agregar.txtClasificacion.getText());
            mascota.setNombredueno(agregar.txtDueno.getText());
            mascota.setFonodueno(Integer.parseInt(agregar.txtTelDueno.getText()));
            
            
            if(cbd.Agregar(mascota)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                agregar.txtFicha.setText(null);
                agregar.txtEdad.setText(null);
                agregar.txtPeso.setText(null);
                agregar.txtAltura.setText(null);
                agregar.txtTipo.setText(null);
                agregar.txtClasificacion.setText(null);
                agregar.txtNombre.setText(null);
                agregar.txtDueno.setText(null);
                agregar.txtTelDueno.setText(null);
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
            
        }
        
        
        //Vista Listar
        if(e.getSource()==menu.MenuListar){
            listar.setTitle("Listar Mascotas");
            listar.setLocationRelativeTo(null);
            listar.setVisible(true);
        }
        
        if(e.getSource()==listar.btnBuscar){
            
            String campo=listar.txtBuscar.getText();
            String where="";
            //System.out.println("entrando");
            
            
            if(!listar.txtBuscar.equals("")){
                //System.out.println("entrando 2");
                where="SELECT * FROM mascota WHERE num_ficha= '"+campo+"'";
            }
            
            mascota.setNumficha((Integer.parseInt(listar.txtBuscar.getText().equals("") ? "0" : listar.txtBuscar.getText())));     
                         
            listar.tablaMascotas.setModel(cbd.Listar(mascota));
                
             
            
                                    
            
        }
        
        if(e.getSource()==listar.btnEliminar){
            int fila=listar.tablaMascotas.getSelectedRow();
            String codigo=listar.tablaMascotas.getValueAt(fila,0).toString();
           
            if(cbd.Eliminar(mascota)){
                
                JOptionPane.showMessageDialog(null,"Registro Borrado");
            }else{
                JOptionPane.showMessageDialog(null,"Registro no pudo ser borrado");
            }
            
        }
        
        
        //Vista modificar
        if(e.getSource()==listar.btnModificar){
            modificar.setTitle("Modificar Datos");
            modificar.setLocationRelativeTo(null);
            modificar.setVisible(true);
            
            modificar.txtFicha.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 0).toString());
            modificar.txtFicha.disable();
            modificar.txtNombre.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 1).toString());
            modificar.txtEdad.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 2).toString());
            modificar.boxVacunas.setSelectedItem(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 3).toString());
            modificar.txtPeso.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 4).toString());
            modificar.txtAltura.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 5).toString());
            modificar.txtTipo.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 6).toString());
            modificar.txtClasificacion.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 7).toString());
            modificar.txtDueno.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 8).toString());
            modificar.txtTelDueno.setText(listar.tablaMascotas.getValueAt(listar.tablaMascotas.getSelectedRow(), 9).toString());
        }
        
        if(e.getSource()==modificar.btnLimpiar){
            modificar.txtFicha.setText(null);
            modificar.txtEdad.setText(null);
            modificar.txtPeso.setText(null);
            modificar.txtAltura.setText(null);
            modificar.txtTipo.setText(null);
            modificar.txtClasificacion.setText(null);
            modificar.txtNombre.setText(null);
            modificar.txtDueno.setText(null);
            modificar.txtTelDueno.setText(null);   
        }
        
        if(e.getSource()==modificar.btnGuardar){
            mascota.setNumficha(Integer.parseInt(agregar.txtFicha.getText()));
            mascota.setNombre(agregar.txtNombre.getText());
            mascota.setEdad(Integer.parseInt(agregar.txtEdad.getText()));
            mascota.setPeso(Double.parseDouble(agregar.txtPeso.getText()));
            mascota.setAltura(Double.parseDouble(agregar.txtAltura.getText()));
            mascota.setVacunas(agregar.boxVacunas.getSelectedItem().equals("Si")? true : false);
            mascota.setTipomascota(agregar.txtTipo.getText());
            mascota.setClasificacion(agregar.txtClasificacion.getText());
            mascota.setNombredueno(agregar.txtDueno.getText());
            mascota.setFonodueno(Integer.parseInt(agregar.txtTelDueno.getText()));
            
            
            if(cbd.Modificar(mascota)){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                modificar.txtFicha.setText(null);
                modificar.txtEdad.setText(null);
                modificar.txtPeso.setText(null);
                modificar.txtAltura.setText(null);
                modificar.txtTipo.setText(null);
                modificar.txtClasificacion.setText(null);
                modificar.txtNombre.setText(null);
                modificar.txtDueno.setText(null);
                modificar.txtTelDueno.setText(null);
            }else{
                JOptionPane.showMessageDialog(null,"Error al Guardar");
            }
        }
        
    }//Fin actionPerformed


    
    
}//Fin Clase
