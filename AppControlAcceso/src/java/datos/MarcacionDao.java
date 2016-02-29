/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Marcacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Yovanny
 */
public class MarcacionDao implements IMarcacion {

    Connection cn = SimpleConnection.getConnection();

    @Override
    public void Ingreso(Marcacion marcacion) {
        try {
            String sql = "insert into Marcacion(fk_horario,ingreso,salida,tardanza) values(?,?,null,?)";
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, marcacion.getHorario().getId());
            ps.setDate(2, marcacion.getIngreso());
            ps.setBoolean(3, marcacion.isTardanza());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Salida(Marcacion marcacion) {
        try {
            String sql = "update Marcacion set salida= ? where pk_marcacion= ?";
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setDate(1, marcacion.getSalida());
            ps.setInt(2, marcacion.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date UltimoIngresoUsuario(int fk_horario) {
        Date ingreso = null;
        try {
            String sql = "select MAX(ingreso) from marcacion WHERE fk_horario=?";
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, fk_horario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingreso = rs.getDate(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingreso;
    }
}


