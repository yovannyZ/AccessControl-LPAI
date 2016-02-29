/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Persona;
import java.util.List;


/**
 *
 * @author Administrador
 */
public interface IPersona {

    boolean Agregar(Persona persona);

    boolean Actualizar(Persona persona);

    boolean Eliminar(String dni);

    List<Persona> getPersonas();
    
    Persona getPersona(String dni);
}
