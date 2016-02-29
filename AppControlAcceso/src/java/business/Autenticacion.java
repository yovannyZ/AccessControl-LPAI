package business;

import datos.UsuarioDao;
import entidad.Usuario;

public class Autenticacion {

    public static Usuario Validar(Usuario usu) {
        Usuario usuario = null;
        String clave = usu.getClave();
        String dni = usu.getPersona().getDni();
        if (dni.trim().equals("") || clave.trim().equals("")) {
            return usuario;
            
        } else {

            UsuarioDao usuarioDao = new UsuarioDao();
            usuario = usuarioDao.getUsuario(usu.getId());

            if (usuario != null) {
                if (usuario.getClave() == clave && usuario.getPersona().getDni() == dni) {
                    return usuario;

                }
            }
            return usuario;
        }
    }
}
