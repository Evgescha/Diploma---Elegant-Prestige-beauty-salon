INSERT IGNORE INTO role(id, name) VALUES(1,'ROLE_USER');
INSERT IGNORE INTO role(id, name) VALUES(2,'ROLE_ADMIN');
INSERT IGNORE INTO role(id, name) VALUES(3,'ROLE_WORKER');
INSERT IGNORE INTO role(id, name) VALUES(4,'ROLE_MANAGER');

INSERT IGNORE INTO status(id, name) VALUES(1,'���������');
INSERT IGNORE INTO status(id, name) VALUES(2,'������');
INSERT IGNORE INTO status(id, name) VALUES(3,'����������');
INSERT IGNORE INTO status(id, name) VALUES(4,'� ������');
INSERT IGNORE INTO status(id, name) VALUES(5,'� ������');

INSERT IGNORE INTO my_users(id, username, password) VALUES (1,'admin','$2a$10$7kQ1nv74qr7CiGAouEzxUOqoD9Pylh7nKY6WXDzAV6O1IF5R21tz.');
INSERT IGNORE INTO user_role(user_id, role_id) VALUE (1,2);nKY6WXDzAV6O1IF5R21tz.');
INSERT IGNORE INTO user_role(user_id, role_id) VALUE (1,2);