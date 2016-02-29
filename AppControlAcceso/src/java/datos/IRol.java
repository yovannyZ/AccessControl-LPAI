/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Rol;
import java.util.List;

/**
 *
 * @author Yovanny
 */
public interface IRol {

    boolean Agregar(Rol rol);

    boolean Actualizar(Rol rol);

    boolean Eliminar(int codigo);

    List<Rol> getRoles();

    Rol getRol(int id);

}
