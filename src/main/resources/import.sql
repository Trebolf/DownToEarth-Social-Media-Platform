-- Users
insert into users (email, username, password, firstname, lastname, profile_pic) values ('Cloud7@email.com', 'Cloud', 'pass1', 'Cloud', 'Strife', 'https://fvw-bucket-s3-1.s3.amazonaws.com/05ae1b80-ce3f-4d5f-9cde-803be5b4d8a1.jpg');

insert into users (email, username, password, firstname, lastname, profile_pic, location) values ('Tifa7@email.com', 'Seventh', 'pass1', 'Tifa', 'Lockhart', 'https://fvw-bucket-s3-1.s3.amazonaws.com/1d9a9371-3d5a-4aed-88eb-6bd018cf2d43.jpg', 'Niblheim');

insert into users (email, username, password, firstname, lastname, profile_pic) values ('Holy@email.com', 'HolyMat', 'pass1', 'Aerith', 'Gainsborough', 'https://fvw-bucket-s3-1.s3.amazonaws.com/a0673b8a-a363-4748-95a1-54192eddcd0d.jpg');

-- Posts
insert into posts (post_body, p_user_id_fk) values ('Tifa why do you do this to me', 1);

insert into posts (post_body, p_user_id_fk) values ('Won 777 Gil from the Gold Saucer today, should I buy a cactpot ticket? Mother Materia blessed me today. Feeling lucky hehe', 1);

insert into posts (post_body, post_media, p_user_id_fk) values ('When my Raise materia finally hits max level', 'https://fvw-bucket-s3-1.s3.amazonaws.com/59827e7c-7544-4574-a9d1-9538f08e1259.png', 1);

insert into posts (post_body, p_user_id_fk) values ('Alright, who stole my recipe for the Cosmo Canyon?? I have Limit Break at the ready. Seventh Heaven coming for ya!', 2);

insert into posts (post_body, post_media, p_user_id_fk) values ('The slums look gorgeous tonight!', 'https://pbs.twimg.com/media/EF5sZbtU0AAvjnD?format=jpg&name=900x900', 2);

insert into posts (post_body, p_user_id_fk) values ('Cloud thinks he is someone else hehe xD', 2);

-- Comments
insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Do what hehe', 1, 2);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Stahp', 1, 1);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Barrett says no to gambling', 2, 2);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Marlene avert your eyes!', 2, 3);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Raise? Why not Holy??', 3, 3);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('Watch out for Johnny this time of night', 5, 1);

insert into comments (comment_body, c_post_id_fk, c_user_id_fk) values ('What do you mean?', 6, 1);

-- Likes
insert into likes (l_post_id_fk, l_user_id_fk) values (1, 2);

insert into likes (l_post_id_fk, l_user_id_fk) values (1, 3);

insert into likes (l_post_id_fk, l_user_id_fk) values (2, 3);