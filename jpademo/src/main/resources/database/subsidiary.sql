create table subsidiary (
sub_id int(11) primary key,
subsidiary_name varchar(255) not null,
entity_id int(11) not null
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