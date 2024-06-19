package Controlador;

import Vista.VistaProducto;
import Modelo.ModeloPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener{
    
    
    Modelo.ModeloPrincipal modelo;
    //creacion de un constructor para utilizar el modelo creado para la vista principal
    public ControladorPrincipal(Modelo.ModeloPrincipal modelo){
        this.modelo = modelo;
    }
    
    /*
    Metodo que se encarga de la accion que se llevará a cabo cuando el usuario
    precione un boton o elemento que se encuentre creado en la vistaPrincipal del sistema
    que posteriormente abrirá dicha ventana en este caso la vistaprodcuto
    */
    public void actionPerformed(ActionEvent e){
        Vista.VistaProducto vproducto = new VistaProducto();
        vproducto.setVisible(true);
        modelo.getVista().dispose();
    }
    
    
}
