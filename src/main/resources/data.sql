INSERT INTO Actor (id, first_name, last_name, birth_year)
VALUES (1, 'Brad', 'Pitt', 1963),
       (2, 'Angelina', 'Jolie', 1975);

INSERT INTO MOVIE(id, `name`, `year`)
VALUES (1, 'Mr. & Mrs. Smith', 2005),
       (2, 'Gone in Sixty Seconds', 2000);

INSERT INTO ACTOR_MOVIE(actor_id, movie_id)
VALUES (1, 1),
       (2, 1),
       (2, 2);