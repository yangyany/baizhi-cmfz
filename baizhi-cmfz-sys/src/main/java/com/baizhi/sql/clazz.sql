/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/11 17:34:28                           */
/*==============================================================*/


drop table article;

drop table if exists city;

drop table if exists counter;

drop table if exists music;

drop table if exists musicfile;

drop table if exists picture;

drop table if exists province;

drop table if exists record;

drop table if exists rfc;

drop table if exists teacher;

drop table if exists teachersay;

drop table if exists user;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   varchar(36) not null,
   title                varchar(100),
   author               varchar(100),
   creatdate            date,
   content              text(20000),
   type                 varchar(2),
   primary key (id)
);

/*==============================================================*/
/* Table: city                                                  */
/*==============================================================*/
create table city
(
   id                   varchar(36) not null,
   name                 varchar(50),
   provinceid           varchar(36),
   primary key (id)
);

/*==============================================================*/
/* Table: counter                                               */
/*==============================================================*/
create table counter
(
   id                   varchar(36) not null,
   name                 varchar(50),
   creatdate            date,
   count                integer,
   recordid             varchar(36),
   primary key (id)
);

/*==============================================================*/
/* Table: music                                                 */
/*==============================================================*/
create table music
(
   id                   varchar(36) not null,
   title                varchar(50),
   count                integer(3),
   author               varchar(50),
   broadcast            varchar(50),
   picpath              varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: musicfile                                             */
/*==============================================================*/
create table musicfile
(
   id                   varchar(36) not null,
   title                varchar(50),
   name                 varchar(100),
   size                 integer,
   musicid              varchar(36),
   primary key (id)
);

/*==============================================================*/
/* Table: picture                                               */
/*==============================================================*/
create table picture
(
   id                   varchar(36) not null,
   title                varchar(50),
   name                 varchar(100),
   type                 varchar(2),
   primary key (id)
);

/*==============================================================*/
/* Table: province                                              */
/*==============================================================*/
create table province
(
   id                   varchar(36) not null,
   name                 varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: record                                                */
/*==============================================================*/
create table record
(
   id                   varchar(36) not null,
   name                 varchar(50),
   userid               varchar(36),
   primary key (id)
);

/*==============================================================*/
/* Table: rfc                                                   */
/*==============================================================*/
create table rfc
(
   id                   varchar(36) not null,
   userid               varchar(36),
   content              varchar(1500),
   pushdate             date,
   primary key (id)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   id                   varchar(36) not null,
   name                 varchar(100),
   picpath              varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: teachersay                                            */
/*==============================================================*/
create table teachersay
(
   id                   varchar(36) not null,
   userid               varchar(36),
   articleid            varchar(36),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(36) not null,
   name                 varchar(100),
   legalname            varchar(100),
   tel                  varchar(20),
   sex                  varchar(2),
   signature            varchar(100),
   picpath              varchar(100),
   provinceid           varchar(36),
   cityid               varchar(36),
   password             varchar(36),
   salt                 varchar(6),
   teacherid            varchar(36),
   primary key (id)
);


SELECT * FROM accordion