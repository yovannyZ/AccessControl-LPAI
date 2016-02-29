/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Usuario;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IUsuario {

    boolean Agregar(Usuario usuario);

    boolean Actualizar(Usuario usuario);

    boolean Eliminar(int id);

    List<Usuario> getUsuarios();
}
