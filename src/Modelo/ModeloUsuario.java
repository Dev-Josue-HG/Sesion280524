package Modelo;

import Vista.VistaLogin;
import Vista.VistaRegistrar;

public class ModeloUsuario {

    private String usuario;
    private String password;
    private String correo;
    private VistaLogin vista;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String contra2;
    private String nombreUser;
    private VistaLogin vistaLogin;
    private VistaRegistrar vistaRegistrar;

    public ModeloUsuario() {
    }

    public ModeloUsuario(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;      
    }
    
    public ModeloUsuario(VistaRegistrar vistaRegistrar){
        this.vistaRegistrar = vistaRegistrar;
        
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public VistaLogin getVista() {
        return vista;
    }

    public void setVista(VistaLogin vista) {
        this.vista = vista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public VistaLogin getVistaLogin() {
        return vistaLogin;
    }

    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }

    public VistaRegistrar getVistaRegistrar() {
        return vistaRegistrar;
    }

    public void setVistaRegistrar(VistaRegistrar vistaRegistrar) {
        this.vistaRegistrar = vistaRegistrar;
    }
    
    
       

}
