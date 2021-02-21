CREATE domain IF NOT EXISTS jsonb AS clob;

CREATE TABLE feature
(
    id               INT AUTO_INCREMENT,
    type             varchar(100),
    company_id       INT,
    name_ru          varchar(65535),
    name_ua          varchar(65535),
    name_en          varchar(65535),
    work_hours       jsonb,
    is_online        boolean,
    is_visible       boolean,

    vip              boolean,
    all_hours        boolean,
    pi               boolean,
    entities         boolean,
    premium          boolean,
    english_speaking boolean,
    PRIMARY KEY (id)
);
