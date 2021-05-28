INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_ADMIN', null);
INSERT INTO `role`(`name`, `id`) VALUES ('ROLE_USER', null);

INSERT INTO `user` (`id`, `username`, `password`) VALUES (null,'admin','$2a$10$GN5hCTzObChSk0XUV1mNweIifx6cB9H3UJHze1yKe3CShRBoFnqCK');
-- INSERT INTO `user` (`id`, `username`, `password`) VALUES (null,'rabin','rabin123');

INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role`(`user_id`, `role_id`) VALUES (2, 2);