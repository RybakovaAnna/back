--liquibase formatted sql
--changeset ruslan:project_card_filling

INSERT INTO project_management (id, day_end, day_start, is_office, is_time_change, team_start_date,
                                over_time, description, tasks, office_location, comment)
VALUES (-1, 'string', 'string', true, true, 'string', 'string', 'string', 'string', 'string', 'string'),
       (-2, 'string', 'string', true, true, 'string', 'string', 'string', 'string', 'string', 'string'),
       (-3, 'string', 'string', true, true, 'string', 'string', 'string', 'string', 'string', 'string');

INSERT INTO project_team (id, is_product_develop, methodology, analytics, developers, testers, tech_writers,
                          stake_holders_count, developer_requirements, analytics_requirements, dev_ops,
                          designers, is_team_formed)
VALUES (-1, true, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string',
        true),
       (-2, true, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string',
        true),
       (-3, true, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string',
        true);

INSERT INTO recruiting_card (id, full_name, contacts)
VALUES (-1, 'string', 'string'),
       (-2, 'string', 'string'),
       (-3, 'string', 'string');

INSERT INTO employee (id, full_name, contacts, recruiting_card_id)
VALUES (-1, 'string', 'string', -1),
       (-2, 'string', 'string', -1),
       (-3, 'string', 'string', -1),
       (-4, 'string', 'string', -2),
       (-6, 'string', 'string', -2),
       (-8, 'string', 'string', -2),
       (-5, 'string', 'string', -3),
       (-7, 'string', 'string', -3),
       (-9, 'string', 'string', -3);

INSERT INTO project_card (id, project_name, creator_name, firm, finishing_date, project_stage, is_document_required,
                          card_create_date, functional_direction, project_area, status, project_management_id,
                          project_team_id, recruiting_card_id)
VALUES (-1, 'string', 'string', 'string', 'string', 'string', true, '2021-12-01T18:34:15.857Z', 'string', 'string',
        'string', - 1, -1, -1),
       (-2, 'string', 'string', 'string', 'string', 'string', true, '2021-12-01T18:34:15.857Z', 'string', 'string',
        'string', - 2, -2, -2),
       (-3, 'string', 'string', 'string', 'string', 'string', true, '2021-12-01T18:34:15.857Z', 'string', 'string',
        'string', - 3, -3, -3);
