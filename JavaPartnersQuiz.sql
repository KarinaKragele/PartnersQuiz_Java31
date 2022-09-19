CREATE TABLE questions (
ID int not null,
questions1 text not null,
questions2 text not null,
PRIMARY KEY (ID)
);

INSERT INTO questions ( ID, questions1, questions2)
VALUES (1, 'What is you favorite food?', 'What is your partners favorite food?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (2, 'What is your favorite TV show?', 'What is your partners favorite TV show?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (3, 'What is your favorite book?', 'What is your partners favorite book?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (4, 'Do you like to cook?' , 'Does your partner like to cook?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (5, 'Your favorite color?', 'What is your partners favorite color?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (6, 'Are you a dog or cat person?', 'Your partner is a dog or cat person?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (7, 'What color are your eyes?', 'What color are your partners eyes?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (8, 'What’s your favorite dessert?', 'What is your partners favorite dessert?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (9, 'Do you like to travel?', 'Does your partner like to travel?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (10, 'Who are the most important people in your life?', 'Who are the most important people in your partners life?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (11, 'Do you consider yourself an introvert or an extrovert?', 'Does your partner consider himself an introvert or an extrovert?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (12, 'Are you more logical or emotional?', 'Is your partner more logical or emotional?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (13, 'Do you easily identify your feelings?', 'Does your partner easily identify their feelings?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (14, 'What is your best friends name?', 'What is the name of your partners best friend?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (15, 'As a kid, what did you want to be when you grew up?', 'As a kid, what did your partner want to be when he/she grew up?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (16, 'What was your favorite subject at school?', 'What was your partners favorite subject in school?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (17, 'Do you want kids?', 'Does your partner want kids?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (18, 'What is your favorite drink?', 'What is your partners favorite drink?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (19, 'What is your favorite place you have traveled to?', 'What is your partners favorite place that he/she has traveled to?');
INSERT INTO questions ( ID, questions1, questions2)
VALUES (20, 'Where do you want to live in the future? ', 'Where does your partner want to live in the future? ');
SELECT * FROM questions;
SELECT * FROM results;
DROP TABLE questions;


SELECT questions1, questions2 FROM questions ORDER BY RAND() LIMIT 5;

SELECT * FROM questions WHERE ID = 1 OR ID = 5;

SELECT ID FROM questions ORDER BY RAND() LIMIT 5;