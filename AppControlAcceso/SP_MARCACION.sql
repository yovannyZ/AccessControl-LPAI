

creatE procedure sp_marcacion
@dni char(8),
@clave varchar(10)

AS
declare @fk_horario int = (SELECT dbo.Horario.pk_horario FROM   dbo.Horario INNER JOIN
                                     dbo.Usuario ON dbo.Horario.fk_usuario = dbo.Usuario.pk_usuario INNER JOIN
                                     dbo.Persona ON dbo.Usuario.Fk_persona = dbo.Persona.DNI where dbo.Persona.DNI=@dni);

declare @FechaIngreso DATETIME = GETDATE() ;
declare @FechaIngreso_hora int = DATEPART ( hh , @FechaIngreso);
declare @FechaIngreso_minuto int = DATEPART ( mi ,@FechaIngreso);
declare @FechaIngreso_dia int = DATEPART ( DD , @FechaIngreso);
declare @FechaIngreso_mes int =  DATEPART ( MM , @FechaIngreso);
declare @FechaIngreso_anio int =  DATEPART ( YYYY , @FechaIngreso)

declare @UltimoIngreso DATETIME = (select MAX(ingreso) from marcacion WHERE fk_horario=@fk_horario);
declare @UltimoIngreso_dia int = DATEPART (DD,@UltimoIngreso);
declare @UltimoIngreso_mes int = DATEPART (MM,@UltimoIngreso);

declare @pk_marcacion int = (select MAX(pk_marcacion) from Marcacion WHERE fk_horario=@fk_horario);
declare @horaIngreso int =  DATEPART ( HH, (SELECT INGRESO FROM HORARIO WHERE Pk_horario=@fk_horario))
declare @minutoIngreso int =  DATEPART ( HH, (SELECT INGRESO FROM HORARIO WHERE Pk_horario=@fk_horario))

	IF @UltimoIngreso IS NULL
		BEGIN
			IF @FechaIngreso_hora <= @horaIngreso AND @FechaIngreso_minuto <=@minutoIngreso
				insert into Marcacion(fk_horario,ingreso,salida,tardanza) values(@fk_horario,@FechaIngreso,null,0);
			ELSE
				insert into Marcacion(fk_horario,ingreso,salida,tardanza) values(@fk_horario,@FechaIngreso,null,1);
		END
	ELSE
		BEGIN
			IF @FechaIngreso_dia = @UltimoIngreso_dia AND @FechaIngreso_mes=@UltimoIngreso_mes
				update Marcacion set salida= GETDATE() where pk_marcacion= @pk_marcacion;
			ELSE
				BEGIN
					IF  @FechaIngreso_hora <= @horaIngreso AND @FechaIngreso_minuto <=@minutoIngreso
						insert into Marcacion(fk_horario,ingreso,salida,tardanza) values(@fk_horario,@FechaIngreso,null,0);
					ELSE
						insert into Marcacion(fk_horario,ingreso,salida,tardanza) values(@fk_horario,@FechaIngreso,null,1);
				END
		END

go




EXEC sp_marcacion '70123397','123'



select * FROM Marcacion
	


 
