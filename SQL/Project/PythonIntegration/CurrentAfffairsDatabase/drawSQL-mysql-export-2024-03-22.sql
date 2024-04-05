CREATE TABLE `articles`(
    `article_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(255) NOT NULL,
    `subtitle` VARCHAR(255) NOT NULL,
    `author_id` VARCHAR(255) NOT NULL,
    `pubdate` DATETIME NOT NULL,
    `category_id` BIGINT NOT NULL,
    `location_id` BIGINT NULL,
    `category_id` BIGINT NOT NULL,
    `category_id2` BIGINT NOT NULL,
    `category_id3` BIGINT NOT NULL,
    `location_id` BIGINT NOT NULL,
    `url` BIGINT NOT NULL,
    `source_id` BIGINT NOT NULL,
    `lang_id` BIGINT NOT NULL,
    `type_id` BIGINT NOT NULL
);
CREATE TABLE `locations`(
    `location_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `location` VARCHAR(255) NOT NULL,
    `location_data` VARCHAR(255) NOT NULL
);
CREATE TABLE `userprofile`(
    `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `phone` BIGINT NOT NULL,
    `regdate` DATE NOT NULL,
    `preference_id` BIGINT NOT NULL
);
CREATE TABLE `sources`(
    `sources_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `source_name` VARCHAR(255) NOT NULL,
    `source_desc` VARCHAR(255) NOT NULL,
    `source_bias` BIGINT NOT NULL,
    `source_rating` BIGINT NOT NULL
);
CREATE TABLE `type`(
    `type_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(255) NOT NULL,
    `type_desc` VARCHAR(255) NOT NULL
);
CREATE TABLE `userAuthentication`(
    `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `pass_hash` BIGINT NOT NULL
);
CREATE TABLE `UserPreferences`(
    `preference_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_id_1` BIGINT NOT NULL,
    `category_id_2` BIGINT NOT NULL,
    `category_id_3` BIGINT NOT NULL,
    `category_id_4` BIGINT NOT NULL,
    `category_id_5` BIGINT NOT NULL
);
CREATE TABLE `language`(
    `lang_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `language` VARCHAR(255) NOT NULL,
    `lang_desc` VARCHAR(255) NOT NULL
);
CREATE TABLE `authors`(
    `author_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `author_name` VARCHAR(255) NOT NULL,
    `author_desc` VARCHAR(255) NOT NULL COMMENT 'Description about the author'
);
CREATE TABLE `category`(
    `category_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_name` VARCHAR(255) NOT NULL,
    `category_desc` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `UserPreferences` ADD CONSTRAINT `userpreferences_category_id_1_foreign` FOREIGN KEY(`category_id_1`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `UserPreferences` ADD CONSTRAINT `userpreferences_category_id_2_foreign` FOREIGN KEY(`category_id_2`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_category_id3_foreign` FOREIGN KEY(`category_id3`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_source_id_foreign` FOREIGN KEY(`source_id`) REFERENCES `sources`(`sources_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_author_id_foreign` FOREIGN KEY(`author_id`) REFERENCES `authors`(`author_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_category_id2_foreign` FOREIGN KEY(`category_id2`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_lang_id_foreign` FOREIGN KEY(`lang_id`) REFERENCES `language`(`lang_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_type_id_foreign` FOREIGN KEY(`type_id`) REFERENCES `type`(`type_id`);
ALTER TABLE
    `UserPreferences` ADD CONSTRAINT `userpreferences_category_id_3_foreign` FOREIGN KEY(`category_id_3`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `userAuthentication` ADD CONSTRAINT `userauthentication_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `userprofile`(`user_id`);
ALTER TABLE
    `UserPreferences` ADD CONSTRAINT `userpreferences_category_id_5_foreign` FOREIGN KEY(`category_id_5`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `UserPreferences` ADD CONSTRAINT `userpreferences_category_id_4_foreign` FOREIGN KEY(`category_id_4`) REFERENCES `category`(`category_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_location_id_foreign` FOREIGN KEY(`location_id`) REFERENCES `locations`(`location_id`);
ALTER TABLE
    `userprofile` ADD CONSTRAINT `userprofile_preference_id_foreign` FOREIGN KEY(`preference_id`) REFERENCES `UserPreferences`(`preference_id`);
ALTER TABLE
    `articles` ADD CONSTRAINT `articles_category_id_foreign` FOREIGN KEY(`category_id`) REFERENCES `category`(`category_id`);