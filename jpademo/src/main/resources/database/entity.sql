create table parent_entity(
id int(11) unsigned primary key NOT NULL AUTO_INCREMENT,
entity_id int(11) NOT NULL,
entity_name varchar(255) not null,
stock varchar(50)
);

CREATE UNIQUE INDEX entity_id_idxx
ON parent_entity (entity_id);

insert into parent_entity values(null, 1001, 'Alphabet Inc.', 'NASDAQ: GOOGL');