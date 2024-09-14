create table registration (
	id integer generated by default as identity,
	course varchar(20) not null,
	fees integer,
	regist_at timestamp default CURRENT_TIMESTAMP,
	student varchar(20) not null,
	phone varchar(20),
	email varchar(40)
);