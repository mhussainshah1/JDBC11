create table EMP
(
    ID   INTEGER,
    NAME VARCHAR(20),
    DEPT VARCHAR(20)
);

INSERT into EMP
VALUES (101, 'SMITH', 'HR');

INSERT into EMP
VALUES (102, 'JONES', 'ENG');

INSERT into EMP
VALUES (103, 'WEAVER', 'HR');

select *
from EMP;

create table RECRUITING
(
    ID   INTEGER,
    NAME VARCHAR(20)
);