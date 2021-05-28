INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_USER', 2);

INSERT INTO `user` (`id`, `username`, `password`) VALUES (1,'admin','admin123');
INSERT INTO `user` (`id`, `username`, `password`) VALUES (2,'rabin','rabin123');

INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (2, 2);