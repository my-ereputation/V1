Some informations

Database

Create DB and user  :
CREATE DATABASE UserManagement ;
GRANTE SELECT, INSERT, UPDATE, DELETE ON UserManagement.* TO admUser IDENTIFIED BY ‘admpwd’ ;

Create table :
use UserManagement;
CREATE TABLE IF NOT EXISTS  role (
  id_role INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NULL,
  PRIMARY KEY(id_role)
);
CREATE TABLE IF NOT EXISTS  user (
  id_user INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  ROLE_id_role INTEGER UNSIGNED NOT NULL,
  first_name VARCHAR(255) NULL,
  last_name VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  password VARCHAR(255) NULL,
  PRIMARY KEY(id_user),
  INDEX Materials_FKIndex1(ROLE_id_role),
  FOREIGN KEY(ROLE_id_role)
    REFERENCES role(id_role)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

Build project :
mvn clean install

:)