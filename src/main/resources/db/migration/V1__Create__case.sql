create table `case`
(
    `case_id`               int auto_increment primary key,
    `case_name`             varchar(255) not null,
    `occurrence_time`       BIGINT       not null,
    `crime_constitution_id` int          not null,
    `procuratorate_id`      int          not null
);