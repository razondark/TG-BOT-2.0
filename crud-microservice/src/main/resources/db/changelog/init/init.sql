create table users(
    id serial primary key,
    user_id int unique  not null,
    username varchar unique not null,
    is_admin boolean not null default false
);

-- insert into users (user_id, username, is_admin)
-- values
--     ('razondark2');

create table base_command(
    id serial primary key,
    command varchar unique not null,
    message varchar not null
);

insert into base_command (command, message)
values
    ('/start', 'Hello World!'),
    ('/kirill', 'Иди пиши код'),
    ('/irina', 'Иди работай'),
    ('/natasha', 'Пой песню'),
    ('/dima', 'Потом придумаю');