/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Persona;
import entidad.Rol;
import entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class UsuarioDao implements IUsuario {

    Connection cn = SimpleConnection.getConnection();
    private String sql;
    PersonaDao personaDao = new PersonaDao();
    RolDao rolDao = new RolDao();

    @Override
    public boolean Agregar(Usuario usuario) {
        sql = "insert into Usuario(Fk_persona,Fk_rol,Clave,Activo,fecha_registro) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setString(1, usuario.getPersona().getDni());
            ps.setInt(2, usuario.getRol().getId());
            ps.setString(3, usuario.getClave());
            ps.setBoolean(4, usuario.isActivo());
            ps.setDate(5, usuario.getFechaRegistro());
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
    public boolean Actualizar(Usuario usuario) {
        sql = "Update Usuario set Fk_persona=?, "
                + "Fk_rol=?, "
                + " Clave=?, "
                + "Activo=?, "
                + "fecha_registro=? where pk_usuario=?";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setString(1, usuario.getPersona().getDni());
            ps.setInt(2, usuario.getRol().getId());
            ps.setString(3, usuario.getClave());
            ps.setBoolean(4, usuario.isActivo());
            ps.setDate(5, usuario.getFechaRegistro());
            ps.setInt(6, usuario.getId());
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
        sql = "Delete from Usuario where pk_usuario=?";
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
    public List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        try {
            sql = "select * from Usuario";
            PreparedStatement pstm = cn.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Persona persona = personaDao.getPersona(rs.getString(2));
                Rol rol = rolDao.getRol(rs.getInt(3));
                Usuario usuario = new Usuario(rs.getInt(1), persona, rol, rs.getString(4), rs.getBoolean(5), rs.getDate(6));
                lista.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     public Usuario getUsuario(int id) {
        Usuario usuario = null;
        try {
            sql = "select * from Usuario where pk_usuario=?";
            PreparedStatement pstm = cn.prepareCall(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Persona persona = personaDao.getPersona(rs.getString(2));
                Rol rol = rolDao.getRol(rs.getInt(3));
                usuario = new Usuario(rs.getInt(1), persona, rol, rs.getString(4), rs.getBoolean(5), rs.getDate(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}



