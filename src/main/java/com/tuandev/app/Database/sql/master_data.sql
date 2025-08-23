INSERT INTO role (`name`)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO permission (`name`)
VALUES ('user:create'),
       ('user:getAll'),
       ('user:update'),
       ('user:deactivate'),
       ('user:delete');