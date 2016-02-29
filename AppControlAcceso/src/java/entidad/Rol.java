/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Administrador
 */
public class Rol {
    private int _id;
    private String _descripcion;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Rol() {
    }

    public Rol(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Rol(int _id, String _descripcion) {
        this._id = _id;
        this._descripcion = _descripcion;
    }
    
    
    
    
}
