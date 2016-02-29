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
public class Marcacion {
    private int _id;
    private Horario _horario;
    private Date _ingreso;
    private Date _salida;
    private boolean _tardanza;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public Horario getHorario() {
        return _horario;
    }

    public void setHorario(Horario _horario) {
        this._horario = _horario;
    }

    public Date getIngreso() {
        return _ingreso;
    }

    public void setIngreso(Date _ingreso) {
        this._ingreso = _ingreso;
    }

    public Date getSalida() {
        return _salida;
    }

    public void setSalida(Date _salida) {
        this._salida = _salida;
    }

    public boolean isTardanza() {
        return _tardanza;
    }

    public void setTardanza(boolean _tardanza) {
        this._tardanza = _tardanza;
    }

    public Marcacion() {
    }

    public Marcacion(int _id, Horario _horario, Date _ingreso, Date _salida, boolean _tardanza) {
        this._id = _id;
        this._horario = _horario;
        this._ingreso = _ingreso;
        this._salida = _salida;
        this._tardanza = _tardanza;
    }
    
    
    
}
