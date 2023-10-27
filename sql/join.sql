/*

source (id integer primary key autoincrement, description text not null);
tag (id integer primary key autoincrement, key text not null);
data (id integer primary key autoincrement, data text not null);
indexation (text_id integer not null, tag_id integer not null, constraint fk_text_id foreign key (text_id) references text_data(id), constraint ft_key_id foreign key (tag_id) references tag(id));

*/

select text_data.data, source.description as source_description
from
text_data left join source on text_data.source_id = source.id;