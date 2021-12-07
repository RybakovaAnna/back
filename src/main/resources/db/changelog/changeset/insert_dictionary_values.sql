--liquibase formatted sql
--changeset ruslan:dictionary_filling

INSERT INTO firm_dictionary (firm) VALUES
('ICBC'), ('Apple'), ('Amadeus '), ('ExxonMobile '), ('Magento '), ('Ubisoft'),
('Mitsubishi'), ('Wix'), ('Admixer'), ('Toyota Motor'), ('Microsoft'), ('Google'),
('Samsung'), ('IBM '), ('BMW'), ('FedEX'), ('Nike'),
('Johnson&Johnson'), ('IBS Group Holding Ltd'), ('Роскосмос'), ('Газпром'),
('Nortel');

INSERT INTO project_area_dictionary (area) VALUES
('Государственное и муниципальное управление'), ('Машиностроение и ОПК'), ('Торговля, ТНП, услуги'), ('Металлургия'),
('Наука и образование'), ('Строительство'), ('Добывающие отрасли'), ('Деревообработка и целлюлозно-бумажная промышленность'),
('Транспорт'), ('Логистика'), ('Энергетика и ЖКХ'), ('Автомобильная промышленность'),
('Химическая отрасль'), ('Страхование'), ('Банки и финансовые организации'), ('Телекоммуникации'),
('Холдинги'), ('Интернет и электронная торговля'), ('Девелопмент'), ('Аудит и консалтинг'),
('Здравоохранение и соцобеспечение'), ('Медиа');

INSERT INTO technologies_dictionary (technology) VALUES
('Laravel'), ('Yii2'), ('PHP7'), ('Python'), ('Django'),
('Golang'), ('Java SE'), ('Spring'), ('Jakarta EE'), ('MySQL'),
('PostgreSQL'), ('RabbitMQ'), ('Docker'), ('SQL'), ('JS (ES5,ES6,ESNext)'),
('TypeScript'), ('Angular'), ('React'), ('NodeJS'),
('GraphQL'), ('Swift'), ('Rx'), ('Kotlin'),
('Clean Architecture'), ('DI'), ('Google '), ('Flutter'), ('XCTest'),
('Selenium'), ('TestCaseLab'), ('Esspresso'), ('Postman'),
('SRS'), ('UML'), ('BPMN'), ('Swagger'), ('SQL / noSQL'), ('SOAP'), ('REST');


