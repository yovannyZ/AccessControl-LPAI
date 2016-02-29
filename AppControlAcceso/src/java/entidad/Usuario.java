/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class Usuario {
    private int _id;
    private Persona _persona;
    private Rol _rol;
    private String _clave;
    private boolean _activo;
    private Date _fechaRegistro;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public Persona getPersona() {
        return _persona;
    }

    public void setPersona(Persona _persona) {
        this._persona = _persona;
    }

    public Rol getRol() {
        return _rol;
    }

    public void setRol(Rol _rol) {
        this._rol = _rol;
    }

    public String getClave() {
        return _clave;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
    }

    public boolean isActivo() {
        return _activo;
    }

    public void setActivo(boolean _activo) {
        this._activo = _activo;
    }

    public Date getFechaRegistro() {
        return _fechaRegistro;
    }

    public void setFechaRegistro(Date _fechaRegistro) {
        this._fechaRegistro = _fechaRegistro;
    }

    public Usuario() {
    }

    public Usuario(int _id, Persona _persona, Rol _rol, String _clave, boolean _activo, Date _fechaRegistro) {
        this._id = _id;
        this._persona = _persona;
        this._rol = _rol;
        this._clave = _clave;
        this._activo = _activo;
        this._fechaRegistro = _fechaRegistro;
    }
    
    
    
}
