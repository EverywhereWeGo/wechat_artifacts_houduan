CREATE TABLE `article_info_v2` (
  `id` int(11) DEFAULT NULL,
  `article_source` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `abstract` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `trueurl` varchar(2550) CHARACTER SET utf8mb4 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8