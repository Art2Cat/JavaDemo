create table role(
id int(11) not null AUTO_INCREMENT,
role_name varchar(60) not null,
create_date datetime not null default current_timestamp,
note varchar(255) default null,
primary key (id)
) engine=innodb;

create table users (
id int(11) not null auto_increment,
user_name varchar(60) not null,
birthday date not null,
sex varchar(2) not null,
mobile varchar(60) not null,
email varchar(60) default null,
note varchar(255) default null,
primary key (id)
) engine=innodb;