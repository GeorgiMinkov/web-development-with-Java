CREATE TABLE `jdbc_students` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT ,
    `first_name` varchar(255) DEFAULT NULL,
    `family_name` varchar(255) DEFAULT NULL,
    `created_date` datetime DEFAULT now(),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;