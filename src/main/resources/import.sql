-- Users
insert into users (email, username, password, firstname, lastname) values ('Cloud7@email.com', 'Cloud', 'pass1', 'Cloud', 'Strife');

insert into users (email, username, password, firstname, lastname, location) values ('Tifa7@email.com', 'Seventh', 'pass1', 'Tifa', 'Lockhart', 'Niblheim');

insert into users (email, username, password, firstname, lastname) values ('Holy@email.com', 'HolyMat', 'pass1', 'Aerith', 'Gainsborough');

-- Posts
insert into posts (post_body, p_user_id_fk) values ('Tifa why do you do this to me', 1);

insert into posts (post_body, p_user_id_fk) values ('You know what they say about big swords...', 1);

insert into posts (post_body, p_user_id_fk) values ('Cloud thinks he is someone else hehe xD', 2);

-- Comments
insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Do what hehe', 1, 2);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Stahp', 1, 1);

-- Likes
insert into likes (l_post_id_fk, l_user_id_fk) values (1, 2);

insert into likes (l_post_id_fk, l_user_id_fk) values (1, 3);

insert into likes (l_post_id_fk, l_user_id_fk) values (2, 3);