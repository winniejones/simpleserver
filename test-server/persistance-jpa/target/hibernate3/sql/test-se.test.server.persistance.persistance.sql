
    alter table employee 
        drop 
        foreign key FK4722E6AE2094DDF0;

    alter table employee 
        drop 
        foreign key FK4722E6AE54A1E92F;

    drop table if exists address;

    drop table if exists employee;

    create table address (
        id bigint not null auto_increment,
        city varchar(255),
        country varchar(255),
        postcode varchar(255),
        province varchar(255),
        street varchar(255),
        primary key (id)
    );

    create table employee (
        id bigint not null auto_increment,
        endDate date,
        firstname varchar(255),
        lastname varchar(255),
        salary double precision,
        startDate date,
        addressId_id bigint,
        managerId_id bigint,
        primary key (id)
    );

    alter table employee 
        add index FK4722E6AE2094DDF0 (managerId_id), 
        add constraint FK4722E6AE2094DDF0 
        foreign key (managerId_id) 
        references employee (id);

    alter table employee 
        add index FK4722E6AE54A1E92F (addressId_id), 
        add constraint FK4722E6AE54A1E92F 
        foreign key (addressId_id) 
        references address (id);
