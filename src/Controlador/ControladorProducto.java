package Controlador;

import Modelo.ModeloProducto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorProducto implements ActionListener {

//    String a = "textot";
    //creacion de un array list para almacenar los productos que el usuario quiera añadir
    ModeloProducto modelo;
    ArrayList<ModeloProducto> baseDatos = new ArrayList<>();

    public ControladorProducto(ModeloProducto modelo) {
        this.modelo = modelo;

    }

    /*
    Creacion de un metodo de actionPerformed para verificar que acciones se llevaran a cabo
      si un boton de la vistaProducto es precionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //en caso de ser preccionado el btnIngresoProduct se realizará la acción de agregar producto
        //utilizando el metodo creado en la clase llamado agregarProducto
        if (e.getActionCommand().equals(modelo.getVista().btnIngresoProduct.getActionCommand())) {
            System.out.println("SE AGREGO EL PRODUCTO");
            agregarProducto();
//            for (int i = 0; i < baseDatos.size(); i++) {
//                System.out.println(baseDatos.get(i).getNombreProduct());
//                System.out.println(baseDatos.get(i).getCodigoProduct());
//                System.out.println(baseDatos.get(i).getUnidades());
//                System.out.println(baseDatos.get(i).getPrecio());
//
//            }
        //en caso que la accion no corresponda a la primera vamos a verificar si corresponde al segundo boton de la vista
        // en este caso btnbuscar, dicha action llama al metodo o funcion buscarProducto que se encuentra definido en la misma clase
        } else if (e.getActionCommand().equals(modelo.getVista().btnBuscar.getActionCommand())) {
            buscarProducto();
        }

    }

    /**
     * Método utilizado para añadir productos al array List creado anteriormente
     * en este método se accede a todos los txt de la vista pormedio de metodos
     * get y se obtienen su valores para ser almacenados posteriomente
     */
    public void agregarProducto() {
    //10/06/24 lunes cambio en la interfaz ajuste jFrame depose
    // se añadió un try catch para excepciones
    //en caso de ser necesario se utiliza un try para la captura de excepciones que puedan ocurrir
        //si el usuario ingresa datos erroneos
        try {
            ModeloProducto producto = new ModeloProducto();

            producto.setNombreProduct(modelo.getVista().txtNombre.getText());
            producto.setCodigoProduct(modelo.getVista().txtCodigoAproduct.getText());
            producto.setUnidades(modelo.getVista().txtCantidadAProduct.getText());
            producto.setPrecio(modelo.getVista().txtPrecioUnitarioCost.getText());

            baseDatos.add(producto);
            mostrarMensaje("Producto agregado con exito", "Agregar productos", JOptionPane.INFORMATION_MESSAGE);
            limpiarTexto();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        ModeloProducto producto = new ModeloProducto();

    }

    
    /**
     * Metodo que se usa para buscar un producto en el arrayList de base de datos
     * y mostrarlos en la vistaProductos en el caso de ser encontrados.
     */
    public void buscarProducto() {
        /*uso de estructuras de control for para iterar sobre el arrayList y buscar los datos almacenados
         en caso de ser encontrados se procede a setear a los campos de vista con los valores correspondientes
        teniendo en cuenta el codigo del producto.*/
        for (int i = 0; i < baseDatos.size(); i++) {
            if (baseDatos.get(i).getCodigoProduct().equals(modelo.getVista().txtCodigoB.getText())) {
                modelo.getVista().txtNombreB.setText(baseDatos.get(i).getNombreProduct());
                modelo.getVista().txtPrecioB.setText(baseDatos.get(i).getPrecio());
                modelo.getVista().txtCantidadB.setText(baseDatos.get(i).getUnidades());
            }

        }
    }
    
     /*
    Metodo encargado de limpiar los campos correspondientes a la vista para que
    se puedan añadir más productos posteriormente
    */
    public void limpiarTexto() {
        modelo.getVista().txtNombre.setText("");
        modelo.getVista().txtCodigoAproduct.setText("");
        modelo.getVista().txtCantidadAProduct.setText("");
        modelo.getVista().txtPrecioUnitarioCost.setText("");

    }
    
    
    /*
    Metodo que se usa para mostrar un mensaje al usuario en caso de que se produzca
    algun error en el sistema y que posteriormente se utilzia en el metodo agregarProducto
    en su try catch respectivo
    */
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
