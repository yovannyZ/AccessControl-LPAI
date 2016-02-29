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
public class Persona {
    
    private String _dni;
    private String _nombre;
    private String _apellido;
    private String _email;
    private String _telefono;

    public String getDni() {
        return _dni;
    }

    public void setDni(String _dni) {
        this._dni = _dni;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellido() {
        return _apellido;
    }

    public void setApellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public Persona() {
    }

    public Persona(String _dni, String _nombre, String _apellido, String _email, String _telefono) {
        this._dni = _dni;
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._email = _email;
        this._telefono = _telefono;
    }
    
   
}
