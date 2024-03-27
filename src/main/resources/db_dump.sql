create table if not exists person
(
    user_id      int auto_increment
        primary key,
    username     text null,
    email        text null,
    phone_number text null,
    password     text null,
    score        int  null
);

create table if not exists question
(
    question_id int auto_increment
        primary key,
    user_id     int                                null,
    title       text                               null,
    time        datetime default CURRENT_TIMESTAMP null,
    image       text                               null,
    text        text                               null,
    constraint user_id
        foreign key (user_id) references person (user_id)
);

create table if not exists answer
(
    answer_id   int auto_increment
        primary key,
    user_id     int      null,
    title       text     null,
    text        text     null,
    question_id int      null,
    time        datetime null,
    image       text     null,
    constraint question_id_fk
        foreign key (question_id) references question (question_id),
    constraint user_id_fk
        foreign key (user_id) references person (user_id)
);

create table if not exists tag
(
    tag_id int auto_increment
        primary key,
    text   text null
);

create table if not exists question_tag
(
    question_tag_id int auto_increment
        primary key,
    question_id     int null,
    tag_id          int null,
    constraint question_id_tag_fk
        foreign key (question_id) references question (question_id),
    constraint tag_id_fk
        foreign key (tag_id) references tag (tag_id)
);

INSERT INTO schema_name.person (user_id, username, email, phone_number, password, score) VALUES (1, 'John Overflow', 'johnoverflow@yahoo.com', '+40712345678', 'auauaua', 0);
INSERT INTO schema_name.person (user_id, username, email, phone_number, password, score) VALUES (2, 'Mike Stack', 'mike_stack@yahoo.com', '+40787654321', 'uauauau', 0);
INSERT INTO schema_name.person (user_id, username, email, phone_number, password, score) VALUES (3, 'Andrew Changed', 'andrewchanged@gmail.com', '+40712345678', 'auauaua', 0);

INSERT INTO schema_name.question (question_id, user_id, title, time, image, text) VALUES (1, 1, 'What', '2024-03-26 14:30:23', 'https://picsum.photos/300', 'What');
INSERT INTO schema_name.question (question_id, user_id, title, time, image, text) VALUES (2, 2, 'Why', '2024-03-26 14:30:53', 'https://picsum.photos/400', 'Why');
INSERT INTO schema_name.question (question_id, user_id, title, time, image, text) VALUES (3, 1, 'John''s Test Question', '2024-03-26 16:12:37', 'https://picsum.photos/500', 'Text of test question');
INSERT INTO schema_name.question (question_id, user_id, title, time, image, text) VALUES (5, 1, 'John''s Third Test Question', '2024-03-26 16:34:19', 'https://picsum.photos/500', 'Text of third test question');

INSERT INTO schema_name.tag (tag_id, text) VALUES (1, 'spooky');
INSERT INTO schema_name.tag (tag_id, text) VALUES (2, 'scary');
INSERT INTO schema_name.tag (tag_id, text) VALUES (3, 'joke');
INSERT INTO schema_name.tag (tag_id, text) VALUES (4, 'music');
INSERT INTO schema_name.tag (tag_id, text) VALUES (5, 'bugs');

INSERT INTO schema_name.answer (answer_id, user_id, title, text, question_id, time, image) VALUES (1, 2, 'This', 'Changed by update', 1, '2024-03-26 14:31:23', 'https://picsum.photos/200');
INSERT INTO schema_name.answer (answer_id, user_id, title, text, question_id, time, image) VALUES (2, 1, 'Nah', 'That', 2, '2024-03-26 14:36:42', 'https://picsum.photos/100');

INSERT INTO schema_name.question_tag (question_tag_id, question_id, tag_id) VALUES (1, 1, 2);
INSERT INTO schema_name.question_tag (question_tag_id, question_id, tag_id) VALUES (2, 1, 4);
INSERT INTO schema_name.question_tag (question_tag_id, question_id, tag_id) VALUES (3, 2, 1);
INSERT INTO schema_name.question_tag (question_tag_id, question_id, tag_id) VALUES (4, 2, 2);
