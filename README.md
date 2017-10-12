# OlaAutoQueuingSystem



# Database checklist
  1. create database ola;
  2. create user 'youplus'@'localhost' IDENTIFIED BY 'youplus@123'
  3. grant all privileges on ola.* TO 'youplus'@'%' IDENTIFIED BY 'youplus@123';

# Tables structures

  CREATE TABLE `driver` (
    `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `mobile` bigint(20) DEFAULT NULL,
    `is_active` tinyint(1) NOT NULL DEFAULT '1',
    `created_at` datetime NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=latin1;

  CREATE TABLE `customer` (
    `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `mobile` bigint(20) DEFAULT NULL,
    `is_active` tinyint(1) NOT NULL DEFAULT '1',
    `created_at` datetime NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=3011 DEFAULT CHARSET=latin1;


  CREATE TABLE `rides` (
    `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
    `customer_id` int(8) NOT NULL,
     `driver_id` int(8) DEFAULT NULL,
    `status` tinyint(4) NOT NULL,
    `requested_at` datetime NOT NULL,
    `pickedup_at` datetime DEFAULT NULL,
    `completed_at` datetime DEFAULT NULL,
     PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=latin1;



  INSERT INTO `driver` (`id`, `name`, `mobile`, `is_active`, `created_at`, `updated_at`)
  VALUES
  	(230, 'Raj', 9892423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:20:08'),
  	(231, 'Siva', 8892423153, 1, '2017-10-13 00:00:00', '2017-10-13 00:20:00'),
  	(232, 'prasad', 8892423183, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:53'),
  	(233, 'Nag', 8892423121, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:43'),
  	(234, 'Sam', 8892423124, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:38'),
  	(235, 'vamsi', 8892423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:26');


 INSERT INTO `customer` (`id`, `name`, `mobile`, `is_active`, `created_at`, `updated_at`)
 VALUES
 	(3450, 'kiran', 9893423128, 1, '2017-10-13 00:00:00', '2017-10-13 00:23:52'),
 	(3451, 'subramanyam', 9812423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:20:08'),
 	(3452, 'Raj', 9892421123, 1, '2017-10-13 00:00:00', '2017-10-13 00:20:08'),
 	(3453, 'kamal', 9892426153, 1, '2017-10-13 00:00:00', '2017-10-13 00:20:00'),
 	(3454, 'rajini', 9892423183, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:53'),
 	(3455, 'chiru', 9892423121, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:43'),
 	(3456, 'Sam', 9892423124, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:38'),
 	(3457, 'vamsi', 9892423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:26'),
 	(3458, 'divakar', 9892423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:26'),
 	(3459, 'krishna', 9892423123, 1, '2017-10-13 00:00:00', '2017-10-13 00:19:26');

