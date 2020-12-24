INSERT IGNORE INTO role(id, name) VALUES(1,'ROLE_USER');
INSERT IGNORE INTO role(id, name) VALUES(2,'ROLE_ADMIN');
INSERT IGNORE INTO role(id, name) VALUES(3,'ROLE_WORKER');
INSERT IGNORE INTO role(id, name) VALUES(4,'ROLE_MANAGER');

INSERT IGNORE INTO role(id, name) VALUES(1,'Предзаказ');
INSERT IGNORE INTO role(id, name) VALUES(2,'Открыт');
INSERT IGNORE INTO role(id, name) VALUES(3,'Предоплата');
INSERT IGNORE INTO role(id, name) VALUES(4,'В работе');
INSERT IGNORE INTO role(id, name) VALUES(5,'В архиве');

INSERT IGNORE INTO my_users(id, username, password) VALUES (1,'admin','$2a$10$7kQ1nv74qr7CiGAouEzxUOqoD9Pylh7nKY6WXDzAV6O1IF5R21tz.');
INSERT IGNORE INTO user_role(user_id, role_id) VALUE (1,2);