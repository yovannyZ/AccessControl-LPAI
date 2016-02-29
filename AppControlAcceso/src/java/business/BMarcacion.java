package business;

import datos.HorarioDao;
import datos.MarcacionDao;
import entidad.Horario;
import entidad.Usuario;
import entidad.Marcacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BMarcacion {

    HorarioDao horarioDao = new HorarioDao();
    MarcacionDao marcacionDao = new MarcacionDao();
    Marcacion marcacion;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void marcacion(Usuario usuario) {
        //obtengo el usuario logeado 
        Usuario usuarioLogeado = Autenticacion.Validar(usuario);

        //obtengo el horario del usuario logeado
        Horario horario = horarioDao.getHorario(usuario.getPersona().getDni());

        boolean tardanza = false;
        int horaActual, minutosActual, horaIngreso, minutosIngreso, tolerancia;
        //obteniendo la tolerancia de la tabla Horario
        tolerancia = horario.getIngresoTolera();

        //obteniendo la hora actual del sistema
        Date fechaUtil = new Date();
        java.sql.Date fechasql = new java.sql.Date(fechaUtil.getTime());
        Calendar horaSistema = Calendar.getInstance();
        horaSistema.setTime(fechaUtil);

        //obteniendo la hora de ingreso de la tabla Horario
        Calendar horaHorario = Calendar.getInstance();
        horaHorario.setTime(horario.getIngreso());

        //sumamos la tolerancia a la  hora de ingreso de la tabla Horario 
        horaHorario.add(Calendar.MINUTE, tolerancia);

        //Averiguar si ha llegado tarde
        if (!horaSistema.before(horaHorario)) {
            tardanza = true;
        }

        //obtengo la fecha del ultimo ingreso del usuario
        Date fechaUtil2 = marcacionDao.UltimoIngresoUsuario(horario.getId());
        Calendar UltimoIngresoUsuario = Calendar.getInstance();
        UltimoIngresoUsuario.setTime(fechaUtil2);

        //si retorna null es el usuario es la primera vez que ingresa al sistema -- marcar el ingreso
        if (fechaUtil2 == null) {
            marcacion = new Marcacion(horario, fechasql, null, tardanza);
            marcacionDao.Ingreso(marcacion);
        } else { 
            //comparar si es el mismo dia -- si es el mismo dia entonces  es la marcar la salida 
            if (horaSistema.get(Calendar.MONTH) == UltimoIngresoUsuario.get(Calendar.MONTH) && horaSistema.get(Calendar.DAY_OF_MONTH) == UltimoIngresoUsuario.get(Calendar.DAY_OF_MONTH)) {
                marcacion.setSalida(fechasql);
                marcacionDao.Salida(marcacion);
            } else {// si no es el mismo dia marcar el ingreso porque es otro dia por ende esta ingresando
                marcacion = new Marcacion(horario, fechasql, null, tardanza);
                marcacionDao.Ingreso(marcacion);
            }
        }

    }

}
