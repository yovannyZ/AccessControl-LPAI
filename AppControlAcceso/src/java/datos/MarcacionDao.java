/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Yovanny
 */
public class MarcacionDao implements IMarcacion{

    Connection cn=SimpleConnection.getConnection();
    @Override
    public void Ingreso(Usuario usuario) {
        try {
            String sql="";
            PreparedStatement ps=cn.prepareCall(sql);
            cs.setString(1, usuario.getPersona().getDni());
            cs.setString(2, usuario.getClave());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
