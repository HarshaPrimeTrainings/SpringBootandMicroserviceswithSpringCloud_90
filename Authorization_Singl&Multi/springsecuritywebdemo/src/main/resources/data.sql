INSERT into roles(id,role) select '1','ROLE_USER' WHERE NOT EXISTS (select 1 from roles where id=1 and role='ROLE_USER');
INSERT into roles(id,role) select '2','ROLE_ADMIN' WHERE NOT EXISTS (select 1 from roles where id=2 and role='ROLE_ADMIN');
INSERT into roles(id,role) select '3','ROLE_MNGR' WHERE NOT EXISTS (select 1 from roles where id=3 and role='ROLE_MNGR');