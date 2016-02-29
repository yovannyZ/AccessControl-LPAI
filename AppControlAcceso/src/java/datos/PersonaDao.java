/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Administrador
 */
public class PersonaDao implements IPersona {

    Connection cn = SimpleConnection.getConnection();

    @Override
    public boolean Agregar(Persona persona) {

        try {
            CallableStatement cs = cn.prepareCall("{call sp_InsertarPersona(?,?,?,?,?)}");
            cs.setString(1, persona.getNombre());
            cs.setString(2, persona.getApellido());
            cs.setString(3, persona.getEmail());
            cs.setString(4, persona.getTelefono());
            cs.setString(5, persona.getDni());
            int r = cs.executeUpdate();
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
    public boolean Actualizar(Persona persona) {

        try {
            CallableStatement cs = cn.prepareCall("{call sp_ActulizarPersona(?,?,?,?,?)}");
            cs.setString(1, persona.getNombre());
            cs.setString(2, persona.getApellido());
            cs.setString(3, persona.getEmail());
            cs.setString(4, persona.getTelefono());
            cs.setString(5, persona.getDni());
            int r = cs.executeUpdate();
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
    public boolean Eliminar(String dni) {

        try {
            CallableStatement cs = cn.prepareCall("{call sp_EliminarrPersona(?)}");
            cs.setString(5, dni);
            int r = cs.executeUpdate();
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
    public List<Persona> getPersonas() {

        List<Persona> lista = new ArrayList<>();

        try {
            CallableStatement cs = cn.prepareCall("{call sp_ListarPersona}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Persona pesrona = new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                lista.add(pesrona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
     public Persona getPersona(String dni) {

        Persona persona=null;
        String sql="select * from Persona where dni=?";
        try {
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 persona = new Persona(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }

}
