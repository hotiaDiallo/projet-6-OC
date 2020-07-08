
-- ================================== user =================================== --

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (1, 'John', 'Doe', null, null, null, null, "jonh.doe@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (2, 'ibrahima', 'Diallo', null, null, null, null, "ibrahima.diallo@gmail.com", "1234", null);

INSERT INTO user (id, first_name, last_name, birth_date, local_adress, postal_code, city, email, password, phone_number) VALUES (3, 'Paul', 'Walker', null, null, null, null, "paul.walker@gmail.com", "1234", null);

-- ================================== author =================================== --
INSERT INTO author (id, first_name, last_name, full_name) VALUES (1, 'Paulo', 'Coelho', 'Paulo Coelho');
INSERT INTO author (id, first_name, last_name, full_name) VALUES (2, 'J. R. R.', 'Tolkien', 'J. R. R Tolkien');
INSERT INTO author (id, first_name, last_name, full_name) VALUES (3, 'Philip K.', 'Dick', 'Philip Dick');
INSERT INTO author (id, first_name, last_name, full_name) VALUES (4, 'Stephen', 'King', 'Stephen King');
INSERT INTO author (id, first_name, last_name, full_name) VALUES (5, 'Henri', 'Troyat', 'Henri Troyat');
INSERT INTO author (id, first_name, last_name, full_name) VALUES (6, 'Henri', 'Gougaud', 'Henri Gougaud');

-- ==================================  library =================================== --

INSERT INTO library (id, name) VALUES (1, "library1");
INSERT INTO library (id, name) VALUES (2, "library2");

-- ================================== work =================================== --
INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (1, 1, 1, 'Le Pèlerin de Compostelle', '« A cette époque, ma quête spirituelle était liée à l’idée qu’il existait des secrets, des chemins mystérieux… Je croyais que ce qui est difficile et compliqué mène toujours à la compréhension du mystère et de la vie… » Lorsque, en 1986, Paulo Coelho entreprend le pèlerinage de Saint-Jacques-de-Compostelle', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (2, 1, 1, 'L''Alchimiste', 'Santiago, un jeune berger andalou, part à la recherche d''un trésor enfoui au pied des Pyramides. Lorsqu''il rencontre l''Alchimiste dans le désert, celui-ci lui apprend à écouter son cœur, à lire les signes du destin et, par-dessus tout, à aller au bout de son rêve.', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (3, 1, 2, 'Sur le bord de la rivière Piedra', 'Une histoire d''amour renferme tous les secrets du monde. Pilar et son compagnon se sont connus dans l''enfance, éloignés au cours de leur adolescence, et voici qu''ils se retrouvent onze ans plus tard.', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (4, 3, 2, 'La Cinquième Montagne', 'Au IXe siècle avant notre ère, Dieu ordonne au prophète Élie de quitter Israël. Son chemin le mène alors à Sarepta, une petite cité phénicienne. Là, dans la ville assiégée par les Assyriens, Élie perdra tout, notamment la femme aimée', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (5, 3, 1, 'Manuel du guerrier de la lumière', 'Les guerriers de la lumière se reconnaissent au premier regard. Ils sont au monde, ils font partie du monde. Souvent ils trouvent que leur vie n''a pas de sens. C''est pour cela qu''ils sont des guerriers de la lumière.', '2017-12-27');


INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (6, 3, 1, 'Veronika décide de mourir', 'Une après-midi d''hiver, à sa fenêtre, une jeune femme observe la ville. Pour la première fois, son regard est serein. Veronika vient d''avaler quatre boîtes de somnifères. Elle ne veut plus subir l''insupportable monotonie des jours et l''angoisse des nuits. ', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (7, 2, 1, 'Le Seigneur des Anneaux, Tome 1 : La Communauté de l''Anneau', 'Le Tiers Age touche à sa fin, et la Terre du Milieu à son crépuscule. La Compagnie de l''Anneau va donc tâcher de déjouer les projets infernaux de Sauron, force du mal d''autant plus difficile à combattre qu''elle est désincarnée. Qui, des cinq héros, mènera à bien la mission ?', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (8, 2, 2, 'Le Seigneur des Anneaux, Tome 2 : Les Deux tours', 'Frodon le Hobbit et ses Compagnons se sont engagés, au Grand Conseil d''Elrond, à détruire l''Anneau de Puissance dont Sauron de Mordor cherche à s''emparer pour asservir tous les peuples de la terre habitée : Elfes et Nains, Hommes et Hobbits.', '2017-12-27');

INSERT INTO work (id, author_id, library_id, title, summary, release_date)
VALUES (9, 2, 2, 'Le Seigneur des Anneaux, Tome 3 : Le Retour du Roi', 'Avec "Le Retour du Roi" s''achèvent dans un fracas d''apocalypse les derniers combats de la guerre de l''Anneau.
Tandis que le continent se couvre de ténèbres, annonçant pour le peuple des Hobbits l''aube d''une ère nouvelle, Frodon poursuit son entreprise. Alors qu''il n''a pu franchir la Porte Noire, il se demande comment atteindre le Mont du Destin. Peut-être est-il trop tard : le Seigneur des Ténèbres mobilise ses troupes.', '2017-12-27');

-- ==================================  book =================================== --

INSERT INTO book (id, isbn, book_status) VALUES (1, '2290148172', true);

INSERT INTO book (id, isbn, book_status) VALUES (2, '2253153958', false);

INSERT INTO book (id, isbn, book_status) VALUES (3, '2290315419', true);

INSERT INTO book (id, isbn, book_status) VALUES (4, '2253152277', true);

INSERT INTO book (id, isbn, book_status) VALUES (5, '2266154117', true);

INSERT INTO book (id, isbn, book_status) VALUES (6, '2070612899', true);

INSERT INTO book (id, isbn, book_status) VALUES (7, '2070612902', true);

INSERT INTO book (id, isbn, book_status) VALUES (8, '2253049417', true);

INSERT INTO book (id, isbn, book_status) VALUES (9, '2290157287', true);

INSERT INTO book (id, isbn, book_status) VALUES (10, '2290123417', true);

INSERT INTO book (id, isbn, book_status) VALUES (11, '2253153789', false);

INSERT INTO book (id, isbn, book_status) VALUES (12, '2290315465', true);

INSERT INTO book (id, isbn, book_status) VALUES (13, '2253152795', true);

INSERT INTO book (id, isbn, book_status) VALUES (14, '2266154468', true);

INSERT INTO book (id, isbn, book_status) VALUES (15, '2070612135', true);

INSERT INTO book (id, isbn, book_status) VALUES (16, '2070612465', true);

INSERT INTO book (id, isbn, book_status) VALUES (17, '2253049495', true);

INSERT INTO book (id, isbn, book_status) VALUES (18, '2290157136', true);

INSERT INTO book (id, isbn, book_status) VALUES (19, '2290157796', true);

INSERT INTO book (id, isbn, book_status) VALUES (20, '2290157436', true);


-- ==================================  work-book =================================== --

INSERT INTO work_books (work_id, books_id) VALUES (1,1);
INSERT INTO work_books (work_id, books_id) VALUES (1,2);
INSERT INTO work_books (work_id, books_id) VALUES (1,3);

INSERT INTO work_books (work_id, books_id) VALUES (2,4);
INSERT INTO work_books (work_id, books_id) VALUES (2,5);
INSERT INTO work_books (work_id, books_id) VALUES (2,6);

INSERT INTO work_books (work_id, books_id) VALUES (3,7);
INSERT INTO work_books (work_id, books_id) VALUES (3,8);
INSERT INTO work_books (work_id, books_id) VALUES (3,9);

INSERT INTO work_books (work_id, books_id) VALUES (4,10);
INSERT INTO work_books (work_id, books_id) VALUES (4,11);
INSERT INTO work_books (work_id, books_id) VALUES (4,12);

INSERT INTO work_books (work_id, books_id) VALUES (5,13);
INSERT INTO work_books (work_id, books_id) VALUES (5,14);

INSERT INTO work_books (work_id, books_id) VALUES (6,15);
INSERT INTO work_books (work_id, books_id) VALUES (6,16);

INSERT INTO work_books (work_id, books_id) VALUES (7,17);
INSERT INTO work_books (work_id, books_id) VALUES (7,18);

INSERT INTO work_books (work_id, books_id) VALUES (8,19);
INSERT INTO work_books (work_id, books_id) VALUES (8,20);


-- ==================================  loan =================================== --

INSERT INTO loan (id, user_id, book_id, borrowing_date, returning_date, loan_status) VALUES (1, 1, 2, '2019-12-27', '2020-03-21', "activated");

INSERT INTO loan (id, user_id, book_id, borrowing_date, returning_date, loan_status) VALUES (2, 2, 2, '2017-12-27', '2020-03-25', "activated");