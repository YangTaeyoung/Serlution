USE searlution;

CREATE TABLE user_info(
	user_no INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(30) NOT NULL,
	user_nickname VARCHAR(20) NOT NULL UNIQUE,
	user_email VARCHAR(30) NOT NULL UNIQUE,
	user_pw VARCHAR(15) NOT NULL,
	user_phone VARCHAR(12) NOT NULL
);

CREATE TABLE search_info(
	ser_no INT PRIMARY KEY AUTO_INCREMENT,
	ser_title TEXT,
	ser_content TEXT,
	ser_link TEXT,
	ser_date DATE
);

CREATE TABLE history_info(
	history_no INT PRIMARY KEY,
	user_no INT,
	history_key TEXT,
	history_count INT,
	history_date DATE 
);

