DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);


INSERT INTO meals (calories, description,datetime, user_id) VALUES
  (100,'omlet','2017-01-02 20:13', 100000),
  (400,'chicken',current_timestamp, 100000),
  (200,'potato',current_timestamp, 100000);

