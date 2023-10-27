insert into source (description) values ('some_address867867@email.com');
insert into source (description) values ('address666@email.com');
insert into source (description) values ('+380985566719');
insert into source (description) values ('+380935880711');
insert into source (description) values ('other_address_t@email.com');
insert into source (description) values ('+380509711628');

insert into tag (key) values ('some info');
insert into tag (key) values ('tag');
insert into tag (key) values ('very important');
insert into tag (key) values ('other important stuff');

insert into text_data (data, source_id) values ('This is some text', 1);
insert into text_data (data, source_id) values ('Other very important text', 2);
insert into text_data (data, source_id) values ('Sample sample', 3);
insert into text_data (data, source_id) values ('The text of texts', 4);
insert into text_data (data, source_id) values ('Hey you!', 5);
insert into text_data (data, source_id) values ('Data 7575757575', 6);

insert into indexation (text_id, tag_id) values (1, 1);
insert into indexation (text_id, tag_id) values (1, 2);
insert into indexation (text_id, tag_id) values (1, 3);
insert into indexation (text_id, tag_id) values (2, 4);
insert into indexation (text_id, tag_id) values (3, 1);
insert into indexation (text_id, tag_id) values (3, 4);
insert into indexation (text_id, tag_id) values (4, 3);
insert into indexation (text_id, tag_id) values (4, 4);
insert into indexation (text_id, tag_id) values (4, 2);
insert into indexation (text_id, tag_id) values (5, 3);
insert into indexation (text_id, tag_id) values (6, 2);
insert into indexation (text_id, tag_id) values (6, 1);




