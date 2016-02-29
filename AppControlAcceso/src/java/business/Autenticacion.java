package business;

import datos.UsuarioDao;
import entidad.Usuario;

public class Autenticacion {

    //Este metodo retorna el usuario logeado
    
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
                if (usuario.getClave().equals(clave) && usuario.getPersona().getDni().equals(dni)) {
                    return usuario;

                }
            }
            return usuario;
        }
    }
}
