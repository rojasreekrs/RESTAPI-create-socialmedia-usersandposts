insert into USER_DETAILS(birth_date, id, name) values(CURRENT_DATE(), 1001, 'roja');
insert into USER_DETAILS(birth_date, id, name) values(CURRENT_DATE(), 1002, 'sriv');
insert into USER_DETAILS(birth_date, id, name) values(CURRENT_DATE(), 1003, 'sanju');

insert into POST(id, user_id, description) values(2001, 1001, 'hi');
insert into POST(id, user_id, description) values(2002, 1001, 'hello');
insert into POST(id, user_id, description) values(2003, 1001, 'how are you');

insert into POST(id, user_id, description) values(2004, 1002, 'bye');