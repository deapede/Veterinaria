/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static java.lang.Character.toUpperCase;
import javax.swing.JOptionPane;

/**
 *
 * @author David pinto
 */
public class Mascota {
    private int numficha;
    private String nombre;
    private int edad;
    private boolean vacunas;
    private double peso;
    private double altura;
    private String tipomascota;
    private String clasificacion;
    private String nombredueno;
    private int fonodueno;

    public Mascota() {
    }

    public Mascota(int numficha, String nombre, int edad, boolean vacunas, double peso, double altura, String tipomascota, String clasificacion, String nombredueno, int fonodueno) {
        this.numficha = numficha;
        this.nombre = nombre;
        this.edad = edad;
        this.vacunas = vacunas;
        this.peso = peso;
        this.altura = altura;
        this.tipomascota = tipomascota;
        this.clasificacion = clasificacion;
        this.nombredueno = nombredueno;
        this.fonodueno = fonodueno;
    }
    
    
    //Getter

    public int getNumficha() {
        return numficha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getTipomascota() {
        return tipomascota;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getNombredueno() {
        return nombredueno;
    }

    public int getFonodueno() {
        return fonodueno;
    }
    
    //Setter

    public void setNumficha(int numficha) {
        if(numficha>=1000 || numficha<=9999){
            this.numficha = numficha;
        }else{
            System.out.println("Número de Ficha debe ser de 4 Digitos");
            JOptionPane.showMessageDialog(null,"Número de Ficha debe ser de 4 Digitos");
        }
        
    }

    public void setNombre(String nombre) {
        if(nombre.length()>0){
            this.nombre = nombre;
        }else{
            System.out.println("Campo no puede estar Vacio");
            JOptionPane.showMessageDialog(null,"Campo no puede estar Vacio");
        }
        
    }

    public void setEdad(int edad) {
        if(edad>0){
            this.edad = edad;
        }else{
            System.out.println("Edad debe ser Mayor a cero");
            JOptionPane.showMessageDialog(null,"Edad debe ser Mayor a cero");
        }
        
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setTipomascota(String tipomascota) {
        
        if(tipomascota.toUpperCase().equals("D") || tipomascota.toUpperCase().equals("G") || tipomascota.toUpperCase().equals("L") || tipomascota.toUpperCase().equals("P")){
            
            this.tipomascota = tipomascota;
            
        }else{
            System.out.println("Debe ingresar un tipo valido ( D:Perro - G: Gato - L: Loro - P: Pez");
            JOptionPane.showMessageDialog(null,"Debe ingresar un tipo valido ( D:Perro - G: Gato - L: Loro - P: Pez");
            
        }
        
    }

    public void setClasificacion(String clasificacion) {
        if(clasificacion.toUpperCase().equals("MAMIFERO") || clasificacion.toUpperCase().equals("AVE") || clasificacion.toUpperCase().equals("PEZ")){
        this.clasificacion = clasificacion;
        
        }else{
            System.out.println("Debe ingresar Clasificación según sea Mamifero, Ave, Pez");
            JOptionPane.showMessageDialog(null,"Debe ingresar Clasificación según sea Mamifero, Ave, Pez");
        }
        
    }

    public void setNombredueno(String nombredueno) {
        this.nombredueno = nombredueno;
    }

    public void setFonodueno(int fonodueno) {
        this.fonodueno = fonodueno;
    }
    
    
}
