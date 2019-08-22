create table CONTINENT
(
    ID   number       not null,
    NAME VARCHAR2(64) NOT NULL,
    constraint PK_CONTINENT primary key (ID)
);
create sequence continent_seq start with 1 increment by 1;

create table COUNTRY
(
    ID              NUMBER       NOT NULL,
    NAME            VARCHAR2(64) NOT NULL,
    FK_CONTINENT_ID NUMBER       NOT NULL,
    constraint FK_COUNTRY_CONTINENT foreign key (FK_CONTINENT_ID) references CONTINENT (ID),
    constraint PK_COUNTRY primary key (ID)
);
create sequence country_seq start with 1 increment by 1;


create table SIGHT
(
    ID                     NUMBER       NOT NULL,
    NAME                   varchar2(64) NOT NULL,
    MAX_AMOUNT_OF_TOURISTS number       NOT NULL,
    FK_COUNTRY_ID          NUMBER       NOT NULL,
    CONSTRAINT FK_SIGHT_COUNTRY foreign key (FK_COUNTRY_ID) references COUNTRY (ID),
    constraint PK_SIGHT primary key (ID)

);
create sequence sight_seq start with 1 increment by 1;

create table TOURIST
(
    ID       NUMBER       NOT NULL,
    NAME     varchar2(64) NOT NULL,
    VISITING NUMBER,
    COUNTRY  number       not null,
    constraint FK_TOURIST_SIGHT foreign key (VISITING) references SIGHT (ID),
    constraint FK_TOURIST_COUNTRY foreign key (COUNTRY) references COUNTRY (ID),
    constraint PK_TOURIST primary key (ID)
);
create sequence tourist_seq start with 1 increment by 1;

insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'Europe');
insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'Asia');
insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'Africa');
insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'North America');
insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'South America');
insert into CONTINENT(ID, NAME)
VALUES (continent_seq.nextval, 'Australia');

insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'France', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'Italy', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'Spain', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'Kenya', (select id from CONTINENT where NAME = 'Africa'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'India', (select id from CONTINENT where NAME = 'Asia'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (country_seq.nextval, 'United States', (select id from CONTINENT where NAME = 'North America'));

insert into SIGHT(id, name, max_amount_of_tourists, fk_country_id)
values (sight_seq.nextval, 'The Louvre', 10, (select id from COUNTRY where NAME = 'France'));
insert into SIGHT(id, name, max_amount_of_tourists, fk_country_id)
values (sight_seq.nextval, 'Côte d''azur', 100, (select id from COUNTRY where NAME = 'France'));
insert into SIGHT(id, name, max_amount_of_tourists, fk_country_id)
values (sight_seq.nextval, 'The colosseum', 10, (select id from COUNTRY where NAME = 'Italy'));
insert into SIGHT(id, name, max_amount_of_tourists, fk_country_id)
values (sight_seq.nextval, 'Venice', 5, (select id from COUNTRY where NAME = 'Italy'));
insert into SIGHT(id, name, max_amount_of_tourists, fk_country_id)
values (sight_seq.nextval, 'Alhambra', 15, (select id from COUNTRY where NAME = 'Spain'));

-- drop table TOURIST;
-- drop sequence tourist_seq;
-- drop table SIGHT;
-- drop sequence sight_seq;
-- drop table COUNTRY;
-- drop sequence country_seq;
-- drop TABLE CONTINENT;
-- drop sequence continent_seq;
