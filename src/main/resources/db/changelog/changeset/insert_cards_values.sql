--liquibase formatted sql
--changeset ruslan:project_card_filling

INSERT INTO project_management (id, day_end, day_start, is_office, is_time_change, team_start_date,
                                over_time, description, tasks, office_location, comment)
VALUES (-1, '11:00', '20:00', false, true, '17.12.2020', 'Нет', 'Описание проблемы – на данный момент сотрудники колл-центра тратят много времени на регистрацию обращений пользователей в системе, а сотрудники тех. поддержки на решение типовых проблем. Также существует вероятность, что сроки решения обращения могут быть нарушены из-за несвоевременного оповещения сотрудниками тех. поддержки менеджера, который по согласованию с пользователем может продлить сроки работы по обращению.
Цель проекта – снижение времязатрат по регистрации обращений в системе и по решению типовых проблем пользователей за счет внедрения
', 'Необходимо внедрить автоматическую систему для общения с пользователями (Далее Чат-бот).
Чат-бот — виртуальный помощник, программа, имитирующая поведение человека при общении с пользователем. Он отвечает на вопросы ответами из базы знаний и реагирует на конкретные команды, и выдает с ее помощью ответы на конкретные обращения пользователей.
Так же он должен обеспечивать простое (человеческое) общение с пользователем на различные темы (погода, уточнение времени, уточнение информации о компании или решениях), уведомлять сотрудников тех. поддержки о приближении дедлайнов по обращениям и помогать в поиске типовых обращений пользователей в системе для их быстрого решения.
Все диалоги (логика) в чат-боте должна выстраиваться с помощью простого инструмента (конструктора). Бот должен обеспечить возможность регистрации обращения. Бот должен обеспечить хранение всей истории переписки с пользователем.
', '', ''),
       (-2, '', '', false, false, '', 'Иногда', 'Апробация и ввод в эксплуатацию экспертно-аналитической системы прогнозирования потребностей в профессиональном кадровом обеспечении социально-экономического развития Российской Федерации в целях проведения экспертизы формирования контрольных цифр приема в учреждения профессионального образования Российской Федерации.
Необходимым условием успешной реализации запланированных мероприятий в сфере профессионального образования является адекватное изменение (совершенствование) системы управления данной сферой, затрагивающее различные аспекты деятельности в сфере профессионального образования, в том числе прогнозирование потребности в подготовке кадров в системе профессионального образования и формирование государственного задания на подготовку кадров (контрольных цифр приема).
Государственный заказ должен стать действенным механизмом, способствующим обеспечению работодателей рабочей силой в необходимом количестве и требуемой квалификации, что является одной из приоритетных задач. Ключевые моменты в решении задачи: совершенствование системы мониторинга и прогнозирования ситуации на рынке труда и обеспечение сбалансированности спроса и предложения на специалистов с профессиональным образованием.
', 'Создать единую экспертно-аналитической систему прогнозирования оптимального выпуска учреждений профессионального образования и формирования контрольных цифр приема (далее – система прогнозирования) для:
o	экспертизы и анализа потребности экономики Российской Федерации и субъектов Российской Федерации в специалистах с профессиональным образованием;
o	экспертизы соответствия существующей структуры подготовки по программам профессионального образования прогнозу потребности экономики Российской Федерации и субъектов Российской Федерации в специалистах с профессиональным образованием;
o	прогнозирования оптимального выпуска учреждений профессионального образования и формирования контрольных цифр приема при различных сценариях социально-экономического развития Российской Федерации и субъектов Российской Федерации.
', '', ''),
       (-3, '08:00', '17:00', true, false, '20.12.2021', 'Постоянно',
        'Руководство одного из ведущих мировых сталелитейных предприятий инициировало проект «Создание системы внутреннего контроля за подготовкой финансовой отчетности с использованием решения Oracle Internal Controls Manager.', 'В рамках проекта по созданию Системы внутреннего контроля за подготовкой финансовой отчетности (СВКФО) на комбинате уже реализовано:
•	автоматизированный документооборот в рамках СВКФО;
•	обеспечение хранения информации и необходимой степени ее защиты;
•	создание единого информационного поля для работы всех заинтересованных лиц (владельцы бизнес-процессов, внутренние и внешние аудиторы, топ-менеджмент), с разделением полномочий в рамках СВКФО.
В рамках проекта необходимо доработать - интеграцию процессов СВКФО с процессами корпоративной информационной системы ММК, действующей на основе приложений Oracle E-Business Suite.
', 'г. Ульяновск, Комсомольский пер., 22', 'Случайный комментарий'),
       (-4, '11:00', '20:00', false, true, '30.12.2021', 'Иногда', 'Реализация проекта создания портала поставщиков и электронной торговой площадки на Магнитогорском металлургическом комбинате. Целью проекта являлось повышение прозрачности и эффективности логистических процессов комбината, вовлечение клиентов и поставщиков ММК в рациональные отношения сотрудничества.
Портал поставщиков будет позволять создавать поставщику предварительные уведомления о поставках с указанием, даты отгрузки, прибытия на комбинат, объема продукции, данные транспортной накладной. Все данные автоматически попадают в КИС ММК, что позволяет использовать оперативные данные поставщиков для анализа и планирования деятельности комбината.
', 'В рамках проекта на ММК будет развернута электронная торговая площадка. В ходе ее создания будут реализованы все методы конкурентной проработки: конкурентные карты, тендеры, электронные торги. Система будет давать возможность проводить анализ и контроль объективности и правильности процесса выбора поставщика.
Будет внедрен юридически значимый документооборот в рамках корпоративной ЭТП на основе приложений Oracle E-Business Suite. Также реализован полный спектр функциональности корпоративной ЭТП в сочетании с, возможно, наиболее многослойной и полной защитой информации в такого рода проектах в России. Повышение прозрачности и эффективности логистических процессов комбината.
', '', 'Я люблю IBS');

INSERT INTO project_team (id, is_product_develop, methodology, analytics, developers, testers, tech_writers,
                          stake_holders_count, developer_requirements, analytics_requirements, dev_ops,
                          designers, is_team_formed, team_count)
VALUES (-1, true, 'Agile', '1', '1', '0', '0', '30', '1.React, Vue. js, NodeJS, REST API.
2.	Другие языки программирования;
3.	Умение работать с unit, интеграционными и e2e тестами;
4.	Знание как работать в большой команде;
5.	Английский язык.
', '1.Собирать и формулировать бизнес-требования.
2.	Выявлять функциональные и нефункциональные требования из бизнес-требований.
3.	Подготавливать техническую документацию (ГОСТы и стандарты, UML-диаграммы, семейство IDEF, BPMN и другие подходы).
4.	SQL, СУБД, REST/SOAP, основы ООП и любого языка программирования.
', '0,5', '0,2',
        true, '4'),
       (-2, true, 'Agile', '1', '2', '1', '1', '', '1.	Сопровождение разработки.
2.	Собирать и формулировать бизнес-требования.
3.	Выявлять функциональные и нефункциональные требования из бизнес-требований.
4.	Подготавливать техническую документацию (ГОСТы и стандарты, UML-диаграммы, семейство IDEF, BPMN и другие подходы).
5.	SQL, СУБД, REST/SOAP, основы ООП и любого языка программирования.
', '1.	Сопровождение разработки.
2.	Собирать и формулировать бизнес-требования.
3.	Выявлять функциональные и нефункциональные требования из бизнес-требований.
4.	Подготавливать техническую документацию (ГОСТы и стандарты, UML-диаграммы, семейство IDEF, BPMN и другие подходы).
5.	SQL, СУБД, REST/SOAP, основы ООП и любого языка программирования.
', '1', '1',
        false, '7'),
       (-3, true, 'Agile', '1', '2', '1', '0', '107', '1.	Работа с Javascript(ES6), HTML5/CSS, React/Redux и системами контроля версий.
2.	React, REST API, Web API, Redux, GraphQL.
3.	Другие языки программирования.
4.	Как работать с unit, интеграционными и e2e тестами.
5.	Работал с трекерами задач (JIRA, Redmine и прочее).
6.	Английский язык.
', '1.	Опыт разработки диаграмм UML.
2.	Знание принципов REST/Web сервисов, очередей сообщений, XML/JSON, XSD/JSON Schema.
3.	Собирать и формулировать бизнес-требования.
4.	Выявлять функциональные и нефункциональные требования из бизнес-требований.
5.	Подготавливать техническую документацию (ГОСТы и стандарты, UML-диаграммы, семейство IDEF, BPMN и другие подходы).
6.	SQL, СУБД, REST/SOAP, основы ООП и любого языка программирования.
', '1', '1',
        true, '6'),
       (-4, true, 'Agile', '1', '2', '1', '0', '75', '1.	Работа с ООП, принципами SOLID, паттернами проектирования, Java, SQL и системами контроля версий.
2.	Spring (DI/IoC, Data, WebMVC), Spring Boot, Web (Servlets, REST, SOAP), XML (JAXB / SAX, XSL), Oracle/PostgreSQL, Jakarta EE, Docker.
3.	Как разбираться в чужом коде и вносить в него изменения.
4.	Английский язык.
5.	Знание как работать в большой команде.
', '1.	Коммуникация с аналитиками смежных систем на всех этапах реализации задачи.
2.	Собирать и формулировать бизнес-требования.
3.	Выявлять функциональные и нефункциональные требования из бизнес-требований.
4.	Подготавливать техническую документацию (ГОСТы и стандарты, UML-диаграммы, семейство IDEF, BPMN и другие подходы).
5.	SQL, СУБД, REST/SOAP, основы ООП и любого языка программирования.
', '1', '0,5',
        true, '6');

INSERT INTO recruiting_card (id, full_name, contacts)
VALUES (-1, 'Рекрутер', 'Контакт рекрутера'),
       (-2, 'Рекрутер2', 'Контакт рекрутера'),
       (-3, 'Рекрутер3', 'Контакт рекрутера'),
       (-4, 'Рекрутер', 'Контакт рекрутера');

INSERT INTO employee (id, full_name, contacts, recruiting_card_id)
VALUES (-1, 'Сотрудник1', 'Контакт сотрудника', -1),
       (-2, 'Сотрудник2', 'Контакт сотрудника', -1),
       (-3, 'Сотрудник3', 'Контакт сотрудника', -1),
       (-4, 'Сотрудник1', 'Контакт сотрудника', -2),
       (-6, 'Сотрудник2', 'Контакт сотрудника', -2),
       (-8, 'Сотрудник3', 'Контакт сотрудника', -2),
       (-5, 'Сотрудник1', 'Контакт сотрудника', -3),
       (-7, 'Сотрудник2', 'Контакт сотрудника', -3),
       (-15, 'Сотрудник1', 'Контакт сотрудника', -4),
       (-9, 'Сотрудник2', 'Контакт сотрудника', -4),
       (-10, 'Сотрудник3', 'Контакт сотрудника', -4);

INSERT INTO project_card (id, project_name, creator_name, firm, finishing_date, project_stage, is_document_required,
                          card_create_date, functional_direction, project_area, status, project_management_id,
                          project_team_id, recruiting_card_id)
VALUES (-1, 'Чат-бот', 'Петров А.И.', 'МФЦ ', '15.02.2021', 'Середина', true, '2021-11-21T18:34:15.857Z',
        'Внедрение автоматической системы для общения с пользователями', 'Государственное и муниципальное управление',
        'В архиве', - 1, -1, -1),
       (-2, '', 'Игорев П.С.', 'Минобрнауки России', '', 'Инициация', true, '2021-10-11T18:34:15.857Z',
        'Внедрение экспертно-аналитической системы прогнозирования', 'Государственное и муниципальное управление',
        'Черновик', - 2, -2, -2),
       (-3, 'Система контроля', 'Сергеев В.И.', 'ММК', '13.02.2022', 'Завершение', true, '2021-12-01T18:34:15.857Z',
        'Создание системы внутреннего контроля', 'Металлургия',
        'Активна', - 3, -3, -3),
       (-4, 'Торговая площадка', 'Сергеев В.И.', 'ММК', '10.04.2022', 'Начало', true, '2021-12-07T18:34:15.857Z',
        'Создание портала поставщиков и электронной торговой площадки', 'Металлургия',
        'В архиве', - 4, -4, -4);

INSERT INTO project_technologies(id, technologies, project_card_id)
VALUES (-1, 'Python', -2),
       (-2, 'SQL', -2),
       (-3, 'UML', -2),
       (-4, 'SOAP', -2),
       (-5, 'RESТ', -2),
       (-6, 'Docker', -2),
       (-7, 'RabbitMQ', -2),
       (-8, 'React', -1),
       (-9, 'Vue.js', -1),
       (-10, 'UML', -1),
       (-11, 'SOAP', -1),
       (-12, 'RESТ', -1),
       (-13, 'NodeJS', -1),
       (-14, 'Python', -1),
       (-15, 'React', -3),
       (-16, 'JS (ES5,ES6,ESNext)', -3),
       (-17, 'GraphQL', -3),
       (-18, 'HTML5', -3),
       (-19, 'UML', -3),
       (-20, 'BPMN', -3),
       (-21, 'REST ', -3),
       (-22, 'Jakarta EE ', -4),
       (-23, 'UML ', -4),
       (-24, 'SOAP ', -4),
       (-25, 'Java ', -4),
       (-26, 'Spring ', -4),
       (-27, 'Docker ', -4),
       (-28, 'REST ', -4);

INSERT INTO project_type (id, text, project_card_id)
VALUES (-1, 'Фикс', -1),
       (-2, 'ПО', -1),
       (-3, 'Модернизация системы', -1),
       (-4, 'Полный функционал', -1),
       (-5, 'Фикс', -2),
       (-6, 'ПО', -2),
       (-7, 'Разработка с нуля', -2),
       (-8, 'Полный функционал', -2),
       (-9, 'Фикс', -3),
       (-10, 'ПО', -3),
       (-11, 'Разработка с нуля', -3),
       (-12, 'Полный функционал', -3),
       (-13, 'T&M', -4),
       (-14, 'T&M', -4),
       (-15, 'Разработка с нуля', -4),
       (-16, 'Полный функционал', -4);