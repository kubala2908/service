INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_ADMIN', null);
INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_USER', null);

INSERT INTO `user` (`id`, `username`, `password`) VALUES (null,'admin','$2a$10$GN5hCTzObChSk0XUV1mNweIifx6cB9H3UJHze1yKe3CShRBoFnqCK');
INSERT INTO `user` (`id`, `username`, `password`, `email`, `firstName`, `lastName`) VALUES (null,'kuba','$2a$10$DqiV76moY1MTi0WucYP6fuwZP.0xy43l5eQOO1c90V8HRkEPS8kie','kuba@gmail.com','Jakub', 'Tum');

INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (2, 2);

INSERT INTO `producer`(`address`, `name`, `notes`, `taxId`) VALUES ('Pesaro', 'Biesse', 'notatka1', '12345');
INSERT INTO `producer`(`address`, `name`, `notes`, `taxId`) VALUES ('Bolonia', 'Magnys', 'notatka2', '67890');

INSERT INTO `client`(`address`, `name`, `notes`, `taxId`, `overdraft`) VALUES ('Warszawa', 'KubalaDrew', 'notatka1', '31341', false);
INSERT INTO `client`(`address`, `name`, `notes`, `taxId`, `overdraft`) VALUES ('Lublin', 'PolDrew', 'notatka2', '13414', true);

INSERT INTO `machine`(`address`, `model`, `notes`, `serialNumber`, `warrantyEndDate`, `warrantyStartDate`, `producer_id`, `client_id`) VALUES ('Warszawa', 'Skipper', 'notatka skipper', '1869', '2022-03-09','2021-03-09', 1, 1);
INSERT INTO `machine`(`address`, `model`, `notes`, `serialNumber`, `warrantyEndDate`, `warrantyStartDate`, `producer_id`, `client_id`) VALUES ('Radom', 'Rover', 'notatka rover', '1872', '2022-05-15','2021-05-15', 2, 2);
