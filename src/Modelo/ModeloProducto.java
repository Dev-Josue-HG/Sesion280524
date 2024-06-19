package Modelo;

import Vista.VistaProducto;
public class ModeloProducto {
    
    private String nombreProduct;
    private String codigoProduct;
    private String precio;
    private String unidades;
    private VistaProducto vista;

    public ModeloProducto() {
    }
    
     public ModeloProducto(VistaProducto vista) {
        this.vista = vista;      
    }

    public String getNombreProduct() {
        return nombreProduct;
    }

    public void setNombreProduct(String nombreProduct) {
        this.nombreProduct = nombreProduct;
    }

    public String getCodigoProduct() {
        return codigoProduct;
    }

    public void setCodigoProduct(String codigoProduct) {
        this.codigoProduct = codigoProduct;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public VistaProducto getVista() {
        return vista;
    }

    public void setVista(VistaProducto vista) {
        this.vista = vista;
    }   
}
