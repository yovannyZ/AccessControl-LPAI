/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;


import java.sql.Time;

/**
 *
 * @author Administrador
 */
public class Horario {
    private int _id;
    private Usuario _usuario;
    private Time _ingreso;
    private int _ingresoTolera;
    private Time _salida;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Time getIngreso() {
        return _ingreso;
    }

    public void setIngreso(Time _ingreso) {
        this._ingreso = _ingreso;
    }

    public int getIngresoTolera() {
        return _ingresoTolera;
    }

    public void setIngresoTolera(int _ingresoTolera) {
        this._ingresoTolera = _ingresoTolera;
    }

    public Time getSalida() {
        return _salida;
    }

    public void setSalida(Time _salida) {
        this._salida = _salida;
    }

    public Horario() {
    }

    public Horario(Usuario _usuario, Time _ingreso, int _ingresoTolera, Time _salida) {
        this._usuario = _usuario;
        this._ingreso = _ingreso;
        this._ingresoTolera = _ingresoTolera;
        this._salida = _salida;
    }

    public Horario(int _id, Usuario _usuario, Time _ingreso, int _ingresoTolera, Time _salida) {
        this._id = _id;
        this._usuario = _usuario;
        this._ingreso = _ingreso;
        this._ingresoTolera = _ingresoTolera;
        this._salida = _salida;
    }
    
    
    
    
}
