create table subsidiary(
id int(11) unsigned NOT NULL AUTO_INCREMENT,
sub_id int(11) not null,
subsidiary_name varchar(255) not null,
entity_id int(11) not null，
PRIMARY KEY (`id`),
  KEY `fk_sub_parententity_idx` (`entity_id`),
  CONSTRAINT `fk_sub_parententity_id` FOREIGN KEY (`entity_id`) REFERENCES `parent_entity` (`entity_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into subsidiary values(1001001, 'Calico', 1001);
insert into subsidiary values(1001002, 'CapitalG', 1001);
insert into subsidiary values(1001003, 'Chronicle', 1001);
insert into subsidiary values(1001004, 'DeepMind', 1001);
insert into subsidiary values(1001005, 'Google', 1001);
insert into subsidiary values(1001006, 'Google Fiber', 1001);
insert into subsidiary values(1001007, 'GV', 1001);
insert into subsidiary values(1001008, 'Jigsaw', 1001);
insert into subsidiary values(1001009, 'Sidewalk Labs', 1001);
insert into subsidiary values(1001010, 'Verily', 1001);
insert into subsidiary values(1001011, 'Waymo', 1001);
insert into subsidiary values(1001012, 'X', 1001);