--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `data_bag`;
CREATE TABLE `data_bag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

 DROP TABLE IF EXISTS `custom_data`;
CREATE TABLE `custom_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `data_bag_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`data_bag_id`) REFERENCES `data_bag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;