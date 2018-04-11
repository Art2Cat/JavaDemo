create table entity (
entity_id int(11) primary key,
entity_name varchar(255) not null,
stock varchar(50)
);

insert into entity values(1001, 'Alphabet Inc.', 'NASDAQ: GOOGL');

ALTER TABLE entity RENAME parent_entity;