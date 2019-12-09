/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

import Controlador.Controlador;
import Modelo.Consultabd;
import Modelo.Mascota;
import Vistas.Agregar;
import Vistas.Listar;
import Vistas.Menu;
import Vistas.Modificar;

/**
 *
 * @author David pinto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mascota mascota=new Mascota();
        Menu menu=new Menu();
        Consultabd cbd=new Consultabd();
        Agregar agregar=new Agregar();
        Listar listar=new Listar();
        Modificar modificar=new Modificar();
        Controlador con=new Controlador(mascota,cbd,menu,agregar,listar,modificar);
        con.iniciar();
    }
    
}
