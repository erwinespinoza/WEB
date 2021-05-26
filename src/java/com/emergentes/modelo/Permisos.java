
package com.emergentes.modelo;

public class Permisos {
    
    private int id;
    private String usuario;
    private String correo;
    private String clave;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Permisos{" + "id=" + id + ", usuario=" + usuario + ", correo=" + correo + ", clave=" + clave + ", descripcion=" + descripcion + '}';
    }
    
    
}
