package cl.tbd.trabajo2grupo2.repositories;

import org.sql2o.Connection;

public class TablesContext {
    public Connection con;

    public TablesContext(Connection con)
    {
        this.con = con;
    }

    public void crearTablas() 
    {   
        // Creacion tabla emergencia
        con.createQuery("DROP TABLE IF EXISTS emergencia;" + "CREATE TABLE emergencia" + "(id_emergencia serial NOT NULL, asunto character varying(30) NOT NULL, descripcion character varying(500) NOT NULL, direccion character varying(500) NOT NULL, fecha date NOT NULL, activa boolean NOT NULL, id_institucion integer NOT NULL, CONSTRAINT id_emergencia PRIMARY KEY (id_emergencia))").executeUpdate();

        // Creacion tabla tarea
        con.createQuery("DROP TABLE IF EXISTS tarea;" + "CREATE TABLE tarea" + "(id_tarea serial NOT NULL, asunto_tarea character varying(30) NOT NULL, id_emergencia integer NOT NULL, id_estado_tarea integer  NOT NULL, CONSTRAINT id_tarea PRIMARY KEY (id_tarea))").executeUpdate();
    
        // Creacion tabla estado_tarea
        con.createQuery("DROP TABLE IF EXISTS estado_tarea;" + "CREATE TABLE estado_tarea" + "(id_estado_tarea serial NOT NULL, id_tarea integer NOT NULL, completada boolean NOT NULL, CONSTRAINt id_estado_tarea PRIMARY KEY (id_estado_tarea))").executeUpdate();
    }

    public void LlenarTablas()
    {
        // Llenado de tabla emergencia
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (1, 'vestibulum', 'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum.', 'direccion falsa 1', '30/9/2008', false, 1)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (2, 'a feugiat', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 'direccion falsa 2', '6/5/2009', false, 2)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (3, 'consequat metus', 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', 'direccion falsa 3', '6/6/2005', false, 3)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (4, 'erat curabitur gravida', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum.', 'direccion falsa 4', '10/6/2016', true, 4)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (5, 'nibh', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 'direccion falsa 5', '20/10/2002', false, 5)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (6, 'non pretium', 'Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 'direccion falsa 6', '5/12/2019', false, 6)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (7, 'magna', 'Nunc purus. Phasellus in felis.', 'direccion falsa 7', '20/3/2011', false, 7)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (8, 'sed', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit.', 'direccion falsa 8', '27/2/2003', false, 8)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (9, 'mi in porttitor', 'Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', 'direccion falsa 9', '7/8/2006', true, 9)").executeUpdate();
        con.createQuery("INSERT INTO emergencia (id_emergencia, asunto, descripcion, direccion, fecha, activa, id_institucion) VALUES (10, 'justo', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 'direccion falsa 10', '3/8/2006', false, 10)").executeUpdate();
    
        // Llenado de tabla tarea
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (1, 'eleifend', 5, 10)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (2, 'mi sit amet', 7, 3)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (3, 'erat fermentum', 10, 5)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (4, 'in faucibus', 6, 1)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (5, 'duis ac nibh', 7, 2)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (6, 'vel lectus in quam', 6, 8)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (7, 'faucibus', 5, 10)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (8, 'curae donec pharetra magna', 4, 9)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (9, 'rutrum at lorem integer', 7, 10)").executeUpdate();
        con.createQuery("INSERT INTO tarea (id_tarea, asunto_tarea, id_emergencia, id_estado_tarea) values (10, 'venenatis non', 3, 6)").executeUpdate();
    
        // Llenado de tabla estado_tarea
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (1, 10, false)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (2, 7, true)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (3, 5, true)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (4, 4, true)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (5, 9, false)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (6, 1, true)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (7, 2, false)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (8, 6, false)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (9, 3, true)").executeUpdate();
        con.createQuery("INSERT INTO estado_tarea (id_estado_tarea, id_tarea, completada) values (10, 8, true)").executeUpdate();
    }


}
