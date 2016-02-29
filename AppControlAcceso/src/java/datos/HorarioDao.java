/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Horario;
import entidad.Persona;
import entidad.Rol;
import entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Yovanny
 */
public class HorarioDao implements IHorario {

    Connection cn = SimpleConnection.getConnection();
    private String sql;
    UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    public boolean Agregar(Horario horario) {
        sql = "insert into Horario(Fk_usuario,ingreso,ingreso_tolera,salida) values(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, horario.getUsuario().getId());
            ps.setTime(2, horario.getIngreso());
            ps.setInt(3, horario.getIngresoTolera());
            ps.setTime(4, horario.getSalida());
            int r = ps.executeUpdate();
            if (r != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Actualizar(Horario horario) {
        sql = "Update Horario set Fk_usuario=?, "
                + "ingreso=?, "
                + "ingreso_tolera=?, "
                + "salida=? where pk_horario=?";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, horario.getUsuario().getId());
            ps.setTime(2, horario.getIngreso());
            ps.setInt(3, horario.getIngresoTolera());
            ps.setTime(4, horario.getSalida());
            ps.setInt(5, horario.getId());
            int r = ps.executeUpdate();
            if (r != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Eliminar(int id) {
        sql = "Delete from Horario  where pk_horario=?";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, id);
            int r = ps.executeUpdate();
            if (r != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Horario> getHorarios() {
        List<Horario> lista = null;
        try {
            sql = "select * from Horario";
            PreparedStatement pstm = cn.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = usuarioDao.getUsuario(rs.getInt(2));
                Horario horario = new Horario(rs.getInt(1), usuario, rs.getTime(3), rs.getInt(4), rs.getTime(5));
                lista.add(horario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Horario getHorario(String  dni) {
        Horario horario = null;
        try {
            sql = "SELECT * FROM   dbo.Horario INNER JOIN\n"
                    + "                                     dbo.Usuario ON dbo.Horario.fk_usuario = dbo.Usuario.pk_usuario INNER JOIN\n"
                    + "                                     dbo.Persona ON dbo.Usuario.Fk_persona = dbo.Persona.DNI where dbo.Persona.DNI=?";
            PreparedStatement pstm = cn.prepareCall(sql);
            pstm.setString(1, dni);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                 Horari
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
