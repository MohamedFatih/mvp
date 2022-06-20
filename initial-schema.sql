INSERT INTO `users` (`username`, `password`, `enabled`, `token_expired` ) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', 1,0);
INSERT INTO `users` (`username`, `password`, `enabled`, `token_expired` ) VALUES ('merchant', '$2a$12$/k9wO9idJO1jlwwp.CfRKOaaRKZ09sTRLZSqKxG3c7F2aao8aPP9W', 1,0);
INSERT INTO `users` (`username`, `password`, `enabled`, `token_expired` ) VALUES ('merchant2', '$2a$12$D54Bhqtuh44NakTa2sazsu6cpU3e9dAUxrKuxKrS.DRTPKy.TuyvS', 1,0);

INSERT INTO `roles` (`name`) VALUES ('ADMIN');
INSERT INTO `roles` (`name`) VALUES ('MERCHANT');


INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user admin has role ADMIN
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2); -- user namhm has role MERCHANT
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 2); -- user namhm has role MERCHANT

INSERT INTO `merchants` (`id`, `first_name`, `last_name`) VALUES(1, 'Merchant 1', 'last');
INSERT INTO `merchants` (`id`, `first_name`, `last_name`) VALUES(2, 'Merchant 2', 'Second Merchant');

INSERT INTO `products` (`id`, `description`, `name`, `merchant_id`) VALUES(1, 'First Product Description', 'First Product', 1);
INSERT INTO `products` (`id`, `description`, `name`, `merchant_id`) VALUES(2, 'Second Product Description', 'Second Product', 1);
INSERT INTO `products` (`id`, `description`, `name`, `merchant_id`) VALUES(3, 'Thrid  Product Description', 'Thrid Product', 2);
INSERT INTO `products` (`id`, `description`, `name`, `merchant_id`) VALUES(4, '4th Product Description', '4th Product', 2);