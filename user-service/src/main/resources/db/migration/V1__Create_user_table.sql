CREATE TABLE user (
  id                    int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name                  VARCHAR(100),
  age                   INT,
  create_at            TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
  update_at            TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARACTER SET = UTF8MB4
  COLLATE UTF8MB4_GENERAL_CI;