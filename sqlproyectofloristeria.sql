CREATE DATABASE progra_web;
USE progra_web;
create user 'usuario'@'%' identified by 'contrasena';
grant all privileges on progra_web.* to 'usuario'@'%';