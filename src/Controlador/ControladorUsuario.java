package Controlador;

import Modelo.ModeloUsuario;
import Vista.VistaPrincipal;
import Vista.VistaRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorUsuario implements ActionListener {

    //Crear un arralist para almacenar los usuarios con los cuales se podrá iniciar sesion.
    public static ArrayList<ModeloUsuario> baseDatos = new ArrayList<>();

    ModeloUsuario modelo;
    
    //Creamos un usuario por defecto con un nombre de usuario y su respectiva contraseña
    public ControladorUsuario(ModeloUsuario modelo) {
        this.modelo = modelo;
        //En el caso que el Array se encuentre vacio se crea un usuario por default, sicha validacion se realiza por medio
        //de un isEmpty que verifica si efectivamente se enceuntra vacio, posteriormente se cargan los datos por default
        if (baseDatos.isEmpty()) {
            baseDatos.add(new ModeloUsuario());
            baseDatos.get(0).setUsuario("JHicho");
            baseDatos.get(0).setPassword("1234");
        }
    }

    /**
     * Validar el usuario y contraseña que se ingresa desde el login
     * y verifica si es la misma registrada en mi ArrayList baseDatos
     *
     * @return
     */
    public boolean validarUsuario() {

//        if (modelo.getVista().txtUsuario.getText().equals(user) && String.valueOf(modelo.getVista().txtPassword.getPassword()).equals(pass)) {
//           return true; 
//        }else{
//            return false;
        boolean resultado = false;
        //creacion de un bucle for que itera sobre el arrayBaseDatos en busca del usuario y de su contraseña para posteriormente iniciar sesion
        //y pasar a la ejecucion de otras ventanas o vistas
        for (int i = 0; i < baseDatos.size(); i++) {
            if (modelo.getVistaLogin().txtUsuario.getText().equals(baseDatos.get(i).getUsuario()) && String.valueOf(modelo.getVistaLogin().txtPassword.getPassword()).equals(baseDatos.get(i).getPassword())) {
                resultado = true;
            }
        }
        return resultado;
    }
    
    /**
     * Método que registra la data obtenida por medio de la vistaRegistrar
     * los datos se almacenan en el ArrayList baseDatos creada anteriormente
     */
    
    public void registrarUsuario() {
        //Antes de almacenar los datos se realiza una validación sobre los dos campos
        //de password de vistaRegistro si son iguales se procede a almacenar los datos
        //Dicha validacion se realiza con el primer if
        
        
        
        if (String.valueOf(modelo.getVistaRegistrar().passwordU1.getPassword()).equals(String.valueOf(modelo.getVistaRegistrar().passwordU2OtraVez.getPassword()))) {
            ModeloUsuario usuario = new ModeloUsuario();
            usuario.setUsuario(modelo.getVistaRegistrar().txtNameUser.getText());
            usuario.setNombre(modelo.getVistaRegistrar().txtNombre.getText());
            usuario.setApellido(modelo.getVistaRegistrar().txtApellido.getText());
            usuario.setPassword(String.valueOf(modelo.getVistaRegistrar().passwordU1.getPassword()));
            baseDatos.add(usuario);

            JOptionPane.showMessageDialog(null, "Usuario registrado con exito", "Registro de usuario", JOptionPane.INFORMATION_MESSAGE);

            modelo.getVistaRegistrar().txtNameUser.setText("");
            modelo.getVistaRegistrar().passwordU1.setText("");
            modelo.getVistaRegistrar().passwordU2OtraVez.setText("");
            modelo.getVistaRegistrar().txtNombre.setText("");
            modelo.getVistaRegistrar().txtApellido.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR Contraseñas diferentes", "Registro de usuario", JOptionPane.ERROR_MESSAGE);

            modelo.getVistaRegistrar().passwordU1.setText("");
            modelo.getVistaRegistrar().passwordU2OtraVez.setText("");
        }
        //En caso que los dos campos de password sean diferentes "contraseñas diferentes se procede a"
        //mostrar un mensaje de alerta al usuario y vacian los dos campos
    }
   
    
    /**
     * Método que se encarga de verifican las acciones correspondientes de los botones asignados o creados
     * en las diferentes vistas del sistema
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Se realiza una verifiacion antes de proceder a realizar las distintas
        //validaciones por medio de las acciones de los botones de las vistas
        //La primera validacion se realiza para saber si un objeto es null y evitar problemas con el puntero y los espacios de memoria
        
         
        if (modelo.getVistaRegistrar() == null) {
            //Las siguientes validaciones se usan para verificar que se realizará en caso de presionar un botón en vistaLogin
            //Dicha accion abre una nueva vista en este caso seria vistaPrincipal
            if (e.getActionCommand().equals(modelo.getVistaLogin().btnIngresar.getActionCommand())) {
                //si el metodo validarUsuario corresponde con la base de datos procede la ejecución de vistaPrincipal
                if (validarUsuario()) {
                    Vista.VistaPrincipal vprincipal = new VistaPrincipal();
                    vprincipal.setVisible(true);
                    modelo.getVista().dispose();
                } else {
                    System.out.println("No ingreso");
                }
                //validacion para abrir una nueva vista en este caso vistaRegistrar por medio de la accion del boton registrarUser
            }else if (e.getActionCommand().equals(modelo.getVistaLogin().btnRegistrarUser.getActionCommand())) {
                Vista.VistaRegistrar vregistro = new VistaRegistrar();
                vregistro.setVisible(true);
//                modelo.getVista().dispose();
            }
            //Asi mismo se valida si vistaLogin es null con la misma intención de evitar problemas de punteros y espacios de memorias
        }else if (modelo.getVistaLogin() == null) {
            //En la siguiente validacion se busca determinar que debe hacer el programa en caso que el boton guardar
            //sea precionado por el usuario en este caso llamamos al método registarUsuario que se creo previamente
            if (e.getActionCommand().equals(modelo.getVistaRegistrar().btnGuardar.getActionCommand())){
                registrarUsuario();
            }
        }
    }
}
