# OlaAutoQueuingSystem



# Database checklist
  1. create database ola;
  2. create user 'youplus'@'localhost' IDENTIFIED BY 'youplus@123'
  3. grant all privileges on ola.* TO 'youplus'@'%' IDENTIFIED BY 'youplus@123';

# Tables structures

  CREATE TABLE `driver` (
    `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
    `email` varchar(50) DEFAULT NULL,
    `mobile` bigint(20) DEFAULT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_active` tinyint(1) NOT NULL DEFAULT '1',
    `first_name` varchar(20) DEFAULT NULL,
    `last_name` varchar(20) DEFAULT NULL,
    `gender` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1234 DEFAULT CHARSET=latin1;