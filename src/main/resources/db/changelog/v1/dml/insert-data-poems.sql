--liquibase formatted sql
--changeset ananan:insert-data-poems

insert into poems (name, content, author_id)
VALUES ('Prophet', 'Since the eternal judge The omniscience of the prophet gave me, ' ||
                   'I read in people''s eyes Pages of malice and vice.', 2);
insert into poems (name, content, author_id)
VALUES ('The night', 'The crimson and white were discarded and crumpled, handfuls of ducats were thrown into the green, ' ||
                     'and burning yellow cards were distributed to the black palms of the windows that ran down.', 2);
insert into poems (name, content, author_id)
VALUES ('A talisman', 'Where the sea is forever lapping To the deserted cliffs, Where the moon shines warmer ' ||
                      'In the sweet hour of the evening gloom, Where, in the harems enjoying, The days are spent by Muslims, ' ||
                      'There is a sorceress, caressing, She handed me a talisman.', 2);
insert into poems (name, content, author_id)
VALUES ('Still-life', 'Things and people surround us. Both of them torment the eye. It''s better to live in the dark. ' ||
                      'I''m sitting on a park bench, looking after a passing family. I''m sick of the light. ' ||
                      'It''s January. Winter According to the calendar. When the darkness gets sick of it. Then I''ll talk.', 4);
insert into poems (name, content, author_id)
VALUES ('In the evening', 'In the evening, a couple is sitting on a bench. ' ||
                          'The ringing of the taglianochka is heard, the whole village is asleep', 6);
insert into poems (name, content, author_id)
VALUES ('Terenty', 'The old bdsm-man Terenty sweeps his hut with a whip', 6);