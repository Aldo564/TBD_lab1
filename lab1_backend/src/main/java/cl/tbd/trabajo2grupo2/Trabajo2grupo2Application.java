package cl.tbd.trabajo2grupo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;

import cl.tbd.trabajo2grupo2.repositories.DatabaseContext;
import cl.tbd.trabajo2grupo2.repositories.TablesContext;

@SpringBootApplication
public class Trabajo2grupo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Trabajo2grupo2Application.class, args);
		Sql2o sql2o = DatabaseContext.sql2o();
		try
		{
			Connection con = sql2o.open();
			TablesContext tablas = new TablesContext(con);
			try
			{
				tablas.crearTablas();
				System.out.println("Se crearon las tablas");
				tablas.LlenarTablas();
				System.out.println("Se llenaron las tablas");
			}
			catch(Sql2oException e)
			{
				System.out.println("Error al crear y llenar tablas "+ e);

			}

		}
		catch(Sql2oException e)
		{
			System.out.println(e);
		}
	}

}
