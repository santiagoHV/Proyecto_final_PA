create database proyecto;
use proyecto;
create table profesor (
materia varchar(20) NOT NULL  PRIMARY KEY,
contrasena_p varchar(30),
nombre_p varchar(30),
apellido_p varchar(30),
correo_p varchar(30),
contacto_p varchar(12),
id_p int(11)
);
create table alumno (
id_a int(11) NOT NULL PRIMARY KEY,
contrasena_a varchar(30),
nombre_a varchar(30),
apellido_a varchar(30),
correo_a varchar(30),
contacto_a varchar(11)
);
create table materia(
cont int(20) auto_increment primary key,
materia_p varchar(40), 
codigo_e int(11),
corte1 double,
corte2 double,
corte3 double,
corteFinal double, 
foreign key(codigo_e) references alumno(id_a),
foreign key(materia_p) references profesor(materia)
);
create table generador_id(
pk_cargo int(3) primary key,
id_g varchar(15)
);

insert into generador_id values (2,'10020000');

insert into profesor (materia,nombre_p) values ('Teoría de sistemas','Por Asignar');
insert into profesor (materia,nombre_p) values ('Calculo Multivariado','Por Asignar');
insert into profesor (materia,nombre_p) values ('Ecuaciones diferenciales','Por Asignar');
insert into profesor (materia,nombre_p) values ('Fisica (Electromagnetismo)','Por Asignar');
insert into profesor (materia,nombre_p) values ('Programación avanzada','Por Asignar');
insert into profesor (materia,nombre_p) values ('Ingles II','Por Asignar');

select  pk_cargo, id_g from generador_id WHERE pk_cargo = 2; 
drop table profesor;
drop database proyecto 