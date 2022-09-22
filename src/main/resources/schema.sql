drop table if exists Actor, Movie, Actor_Movie;

create TABLE Actor
(
    id         int auto_increment primary key,
    first_name varchar(150) not null,
    last_name  varchar(150) not null,
    birth_year int          not null
);

create TABLE Movie
(
    `id`   int auto_increment primary key,
    `name` varchar(150) not null,
    `year` int          check (`year` >= 1900) not null
);

create TABLE Actor_Movie
(
    actor_id int references Actor (id),
    movie_id int references Movie (id),
    primary key (actor_id, movie_id)
);