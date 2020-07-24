-- DB 생성 쿼리
CREATE DATABASE searlution;
-- 계정 및 권한 설정 쿼리
CREATE USER 'yang'@'localhost' IDENTIFIED BY '1234'; --> 서버 들어오면 바꿀거임 아이디 비번은 각자 설정할 것.
GRANT ALL PRIVILEGES ON searlution.* TO 'yang'@'localhost';
FLUSH PRIVILEGES;