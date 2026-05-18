-- schema.sql 파일은 스프링 실행시 create table sql 문장을 실행한다.

CREATE TABLE IF NOT EXISTS swimpool (
  id integer NOT NULL AUTO_INCREMENT,
  addr1 varchar(100) DEFAULT NULL,
  addr2 varchar(100) DEFAULT NULL,
  lanes varchar(100) DEFAULT NULL,
  name varchar(50) NOT NULL,
  size integer DEFAULT 0,
  tel varchar(15) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;

CREATE TABLE IF NOT EXISTS teacher (
  id integer NOT NULL AUTO_INCREMENT,
  birth_year integer DEFAULT 0,
  main varchar(20) NOT NULL,
  name varchar(50) NOT NULL,
  swim_pool_id integer DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_swimpool (swim_pool_id),
  CONSTRAINT FK_swimpool FOREIGN KEY (swim_pool_id) REFERENCES swimpool (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;
