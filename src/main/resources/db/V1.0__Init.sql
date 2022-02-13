create table home
(
  id int auto_increment,
  label varchar(20) null,
  custom varchar(20) null,
  count float null,
  comment text null,
  type varchar(20) null,
  cusDate date null,
  constraint home_pk
    primary key (id)
);

