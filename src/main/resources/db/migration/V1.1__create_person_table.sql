  CREATE TABLE Person (
                   personid SERIAL,
                   prenom varchar(255),
                   nom varchar(255),
                   age int,
                   networth int,
                   unite varchar(10),
                   pays varchar(255),
                   PRIMARY KEY (personid)
               );