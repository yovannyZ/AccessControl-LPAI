/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Horario;
import java.util.List;

/**
 *
 * @author Yovanny
 */
public interface IHorario {

    boolean Agregar(Horario horario);

    boolean Actualizar(Horario horario);

    boolean Eliminar(int id);

    List<Horario> getHorarios();

}
