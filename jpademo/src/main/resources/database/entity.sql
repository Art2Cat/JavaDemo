create table parent_entity(
id int(11) unsigned NOT NULL AUTO_INCREMENT,
entity_id int(11) NOT NULL,
entity_name varchar(255) not null,
stock varchar(50)
);

insert into entity values(1001, 'Alphabet Inc.', 'NASDAQ: GOOGL');