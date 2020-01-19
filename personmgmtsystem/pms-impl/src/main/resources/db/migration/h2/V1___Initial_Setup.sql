CREATE TABLE persons(
    id varchar(50) NOT NULL,
    first_name varchar(200) NOT NULL,
    last_name varchar(200) NOT NULL,
    gender varchar(20) NOT NULL,
    age integer DEFAULT 0,
    favourite_color varchar(100) DEFAULT NULL,
    hobbies blob DEFAULT NULL,
    created_on timestamp NOT NULL,
    modified_on timestamp NOT NULL,
    created_by varchar(200),
    modified_by varchar(200),
    CONSTRAINT PK_persons PRIMARY KEY (
        id
    )
);