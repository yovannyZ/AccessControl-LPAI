/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Rol;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yovanny
 */
public class RolDao implements IRol{
    
    private String sql;
    Connection cn=SimpleConnection.getConnection();

    @Override
    public boolean Agregar(Rol rol) {
         
        try {
            sql="insert into Rol(Descripcion) values(?)";
            PreparedStatement pstm=cn.prepareCall(sql);
            pstm.setString(1, rol.getDescripcion());
            int r= pstm.executeUpdate();
            if (r!=0)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
 
    }

    @Override
    public boolean Actualizar(Rol rol) {
       try {
            sql="update Rol set descripcion=? where pk_rol=?";
            PreparedStatement pstm=cn.prepareCall(sql);
            pstm.setString(1, rol.getDescripcion());
            pstm.setInt(2, rol.getId());
            int r= pstm.executeUpdate();
            if (r!=0)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Eliminar(int codigo) {
       try {
            sql="delete from Rol where pk_rol=?";
            PreparedStatement pstm=cn.prepareCall(sql);
            pstm.setInt(1,codigo);
            int r= pstm.executeUpdate();
            if (r!=0)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Rol> getRoles() {
         List<Rol> lista = new ArrayList<>();

        try {
            sql="select * from Rol";
            PreparedStatement pstm=cn.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol(rs.getInt(1),rs.getString(2));
                lista.add(rol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     @Override
     public Rol getRol(int id) {
        Rol rol=null;
        sql="select * from Rol where pk_rol=?";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rol = new Rol(rs.getInt(1),rs.getString(2));    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rol;
    }
    
}
