create table if not exists source (id integer primary key autoincrement, description text not null);
create table if not exists text_data (id integer primary key autoincrement, source_id integer, data text not null, constraint fk_source_id foreign key (source_id) references source(id) on delete set null);
create table if not exists tag (id integer primary key autoincrement, key text not null);
create table if not exists indexation (text_id integer not null, tag_id integer not null, constraint fk_text_id foreign key (text_id) references text_data(id) on delete cascade, constraint ft_key_id foreign key (tag_id) references tag(id) on delete cascade);

select * from source;
select * from text_data;
select * from tag;
select * from indexation;