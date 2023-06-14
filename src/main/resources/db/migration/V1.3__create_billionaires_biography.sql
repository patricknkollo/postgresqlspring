CREATE TABLE Biography(
biographyid SERIAL,
nom varchar(255),
prenom varchar(255),
biography varchar(2000),
personid SERIAL,
   CONSTRAINT fk_person
      FOREIGN KEY(personid)
	  REFERENCES Person(personid)
);