create table jpa_event_publication
(
    # id               BINARY(16) not null,  --> This works
    id               varchar(36) not null, # --> This does not work
    completion_date  TIMESTAMP(6),
    event_type       varchar(512),
    listener_id      varchar(512),
    publication_date TIMESTAMP(6),
    serialized_event varchar(4000),
    primary key (id)
);