-- schema.sql 파일은 스프링 실행시 create table sql 문장을 실행한다.

CREATE TABLE IF NOT EXISTS swimpool (
  id bigint NOT NULL AUTO_INCREMENT,
  addr1 varchar(200) DEFAULT NULL,
  addr2 varchar(200) DEFAULT NULL,
  lanes varchar(200) DEFAULT NULL,
  name varchar(20) NOT NULL,
  size varchar(50) DEFAULT NULL,
  tel varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;

CREATE TABLE IF NOT EXISTS teacher (
  id bigint NOT NULL AUTO_INCREMENT,
  birth_year integer DEFAULT NULL,
  main varchar(30) NOT NULL,
  name varchar(20) NOT NULL,
  swim_pool_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_swimpool (swim_pool_id),
  CONSTRAINT FK_swimpool FOREIGN KEY (swim_pool_id) REFERENCES swimpool (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;
