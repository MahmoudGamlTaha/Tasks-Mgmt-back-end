
    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    create table bpm_administration.sc_roles (
       role_id number(19,0) not null,
        description varchar2(255 char),
        last_modified_by varchar2(255 char),
        parent_role_id number(19,0),
        role_name varchar2(255 char),
        primary key (role_id)
    )

    create table bpm_administration.sc_userrole (
       role_id number(19,0) not null,
        last_modified_by varchar2(255 char),
        user_id number(19,0),
        primary key (role_id)
    )

    create table ems.adm_user (
       user_id number(19,0) not null,
        user_login varchar2(255 char),
        user_pass varchar2(255 char),
        primary key (user_id)
    )

    create table ems.adm_user_permissions (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        primary key (project_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code
create sequence hibernate_sequence start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table prts_user_role (
       user_role_id number(19,0) not null,
        user_id number(19,0),
        primary key (user_role_id)
    )

    alter table prts_user_role 
       add constraint FKstwvppoxwl5wds2jxpwo605ja 
       foreign key (user_id) 
       references adm_user
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table prts_user_role (
       user_role_id number(19,0) not null,
        user_id number(19,0),
        primary key (user_role_id)
    )

    alter table prts_user_role 
       add constraint FKstwvppoxwl5wds2jxpwo605ja 
       foreign key (user_id) 
       references adm_user
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code

    create table ems.adm_user_privilege (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code

    create table ems.adm_user_privilege (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code

    create table ems.adm_user_privilege (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code

    create table ems.adm_user_privilege (
       module_id number(19,0) not null,
        rule_id number(19,0) not null,
        user_id number(19,0) not null,
        rule_name varchar2(255 char),
        user_login varchar2(255 char),
        primary key (module_id, rule_id, user_id)
    )
create sequence hibernate_sequence start with 1 increment by  1
create sequence prts_project_seq start with 1 increment by  1
create sequence prts_user_role_seq start with 1 increment by  1

    create table adm_user (
       user_id number(19,0) not null,
        user_pass varchar2(255 char),
        user_tel varchar2(255 char),
        primary key (user_id)
    )

    create table ems_city_code (
       city_id number(19,0) not null,
        country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        city_code varchar2(255 char),
        city_name_a varchar2(255 char),
        city_name_e varchar2(255 char),
        primary key (city_id, country_id, governorate_id)
    )

    create table ems_country_code (
       country_id number(19,0) not null,
        country_code varchar2(255 char),
        country_name_a varchar2(255 char),
        country_name_e varchar2(255 char),
        primary key (country_id)
    )

    create table ems_education_degree_code (
       qual_class_id number(19,0) not null,
        qual_class_name_a varchar2(255 char),
        qual_class_name_e varchar2(255 char),
        primary key (qual_class_id)
    )

    create table ems_expert (
       expert_id number(19,0) not null,
        biography varchar2(255 char),
        current_address varchar2(255 char),
        curriculum_vitae_file blob,
        expert_email varchar2(255 char),
        expert_mobil_1 varchar2(255 char),
        expert_mobil_2 varchar2(255 char),
        expert_name_a varchar2(255 char),
        expert_name_e varchar2(255 char),
        expert_short_name varchar2(255 char),
        recent_photo_file blob,
        user_id number(19,2),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        country_id_nationality number(19,0),
        primary key (expert_id)
    )

    create table ems_expert_certificate (
       certificate_id number(19,0) not null,
        expert_id number(19,0) not null,
        certificate_desc varchar2(255 char),
        certificate_enddate date,
        certificate_link varchar2(255 char),
        certificate_name varchar2(255 char),
        certificate_ref_number varchar2(255 char),
        certificate_startdate date,
        university_id number(19,0),
        primary key (certificate_id, expert_id)
    )

    create table ems_expert_education (
       education_id number(19,0) not null,
        expert_id number(19,0) not null,
        education_desc varchar2(255 char),
        education_enddate date,
        education_rating varchar2(255 char),
        education_startdate date,
        qual_class_id number(19,0),
        study_field_id number(19,0),
        university_id number(19,0),
        primary key (education_id, expert_id)
    )

    create table ems_expert_experience (
       experience_id number(19,0) not null,
        expert_id number(19,0) not null,
        experience_desc varchar2(255 char),
        experience_enddate date,
        experience_startdate date,
        industry varchar2(255 char),
        work_name varchar2(255 char),
        job_id varchar2(255 char),
        primary key (experience_id, expert_id)
    )

    create table ems_financial_request (
       request_id number(19,0) not null,
        actual_hour number(19,2),
        actual_minute number(19,2),
        hour_price number(19,2),
        payment_details varchar2(255 char),
        request_date date,
        request_status number(19,2),
        shakwa_date date,
        shakwa_text varchar2(255 char),
        expert_id number(19,0),
        primary key (request_id)
    )

    create table ems_financial_request_dtl (
       request_id number(19,0) not null,
        request_id_dtl number(19,0) not null,
        project_id number(19,0),
        task_id number(19,0),
        primary key (request_id, request_id_dtl)
    )

    create table ems_governorate_code (
       country_id number(19,0) not null,
        governorate_id number(19,0) not null,
        governorate_code varchar2(255 char),
        governorate_name_a varchar2(255 char),
        governorate_name_e varchar2(255 char),
        primary key (country_id, governorate_id)
    )

    create table ems_job_code (
       job_id varchar2(255 char) not null,
        job_name_a varchar2(255 char),
        job_name_e varchar2(255 char),
        primary key (job_id)
    )

    create table ems_project_expert (
       expert_id number(19,0) not null,
        project_id number(19,0) not null,
        hour_price number(19,2),
        primary key (expert_id, project_id)
    )

    create table ems_study_field_code (
       study_field_id number(19,0) not null,
        study_field_name_a varchar2(255 char),
        study_field_name_e varchar2(255 char),
        primary key (study_field_id)
    )

    create table ems_task (
       project_id number(19,0) not null,
        task_id number(19,0) not null,
        task_actual_hour number(19,2),
        task_actual_minute number(19,2),
        task_create_date date,
        task_desc varchar2(255 char),
        task_expected_date date,
        task_expected_hour number(19,2),
        task_expected_minute number(19,2),
        task_name varchar2(255 char),
        user_id number(19,2),
        expert_id number(19,0),
        project_id_parent number(19,0),
        task_id_parent number(19,0),
        task_status_id number(19,0),
        primary key (project_id, task_id)
    )

    create table ems_task_comment (
       project_id number(19,0) not null,
        task_comment_id number(19,0) not null,
        task_id number(19,0) not null,
        comment_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_comment_id, task_id)
    )

    create table ems_task_document (
       project_id number(19,0) not null,
        task_document_id number(19,0) not null,
        task_id number(19,0) not null,
        document_file blob,
        document_text varchar2(255 char),
        user_id number(19,2),
        primary key (project_id, task_document_id, task_id)
    )

    create table ems_task_status_code (
       task_status_id number(19,0) not null,
        task_status_name varchar2(255 char),
        primary key (task_status_id)
    )

    create table ems_university_code (
       university_id number(19,0) not null,
        university_name_a varchar2(255 char),
        university_name_e varchar2(255 char),
        city_id number(19,0),
        country_id number(19,0),
        governorate_id number(19,0),
        primary key (university_id)
    )

    create table prts_project (
       project_id number(19,0) not null,
        brochures_num number(19,2),
        initiative_code number(19,2),
        project_code varchar2(255 char),
        project_duration number(19,2),
        project_name varchar2(255 char),
        project_name_rural varchar2(255 char),
        sector_code number(19,2),
        side_code number(19,2),
        stage_code number(19,2),
        type_code number(19,2),
        primary key (project_id)
    )

    create table prts_project_description (
       fake_id number(19,0) not null,
        lookup_id_3 number(19,2),
        lookup_id_4 number(19,2),
        lookup_id_5 number(19,2),
        lookup_id_6 number(19,2),
        lookup_id_7 number(19,2),
        lookup_id_8 number(19,2),
        project_desc varchar2(255 char),
        project_goal varchar2(255 char),
        project_output varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_document (
       document_id number(19,0) not null,
        project_id number(19,0) not null,
        document_desc varchar2(255 char),
        document_file blob,
        file_full_path varchar2(255 char),
        upload_date date,
        user_id number(19,2),
        primary key (document_id, project_id)
    )

    create table prts_project_engineering_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_finance (
       fake_id number(19,0) not null,
        project_capital_expenses number(19,2),
        project_capital_value number(19,2),
        project_operational_expenses number(19,2),
        project_operational_value number(19,2),
        project_signed_value number(19,2),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_note (
       note_id number(19,0) not null,
        project_id number(19,0) not null,
        note_date date,
        note_text varchar2(255 char),
        user_id number(19,2),
        primary key (note_id, project_id)
    )

    create table prts_project_offering_componen (
       id number(19,0) not null,
        doc_actualdate date,
        doc_plandate date,
        engineer_actualdate date,
        engineer_plandate date,
        engineer_study_approval number(19,2),
        land_allocate_actualdate date,
        land_allocate_plandate date,
        land_allocation number(19,2),
        national_actualdate date,
        national_director_approval number(19,2),
        national_plandate date,
        owner_actauldate date,
        owner_approval number(19,2),
        owner_plandate date,
        program_actualdate date,
        program_approval number(19,2),
        program_plandate date,
        project_document_approval number(19,2),
        technical_actualdate date,
        technical_plandate date,
        technical_study_approval number(19,2),
        tender_actualdate date,
        tender_approval number(19,2),
        tender_plandate date,
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_person (
       project_id number(19,0) not null,
        user_role_code number(19,0) not null,
        is_visable number(19,2),
        user_id number(19,2),
        primary key (project_id, user_role_code)
    )

    create table prts_project_procedure (
       procedure_id number(19,0) not null,
        project_id number(19,0) not null,
        procedure_date date,
        procedure_text varchar2(255 char),
        procedure_type_code number(19,2),
        user_id number(19,2),
        primary key (procedure_id, project_id)
    )

    create table prts_project_purchase (
       fake_id number(19,0) not null,
        another_num varchar2(255 char),
        award_num varchar2(255 char),
        budget_reserve_num varchar2(255 char),
        competition_num varchar2(255 char),
        purchase_order_num varchar2(255 char),
        secret_letter_issued_num varchar2(255 char),
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_status (
       id number(19,0) not null,
        change_date_10 date,
        change_date_11 date,
        change_date_12 date,
        change_date_9 date,
        lookup_id_10 number(19,2),
        lookup_id_11 number(19,2),
        lookup_id_12 number(19,2),
        lookup_id_9 number(19,2),
        user_id_10 number(19,2),
        user_id_11 number(19,2),
        user_id_12 number(19,2),
        user_id_9 number(19,2),
        project_id number(19,0),
        primary key (id)
    )

    create table prts_project_technical_study (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_tender_writing (
       fake_id number(19,0) not null,
        actual_end_date date,
        actual_start_date date,
        completion_rate number(19,2),
        elapsed_time_rate number(19,2),
        plan_end_date date,
        plan_start_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_project_timing (
       fake_id number(19,0) not null,
        actual_award_date date,
        actual_confidential_letter date,
        actual_contract_date date,
        actual_decision_date date,
        actual_offering_date date,
        actual_opening_date date,
        actual_receiving_offers date,
        actual_site_receipt_date date,
        plan_award_date date,
        plan_confidential_letter date,
        plan_contract_date date,
        plan_decision_date date,
        plan_offering_date date,
        plan_opening_date date,
        plan_receiving_offers date,
        plan_site_receipt_date date,
        project_id number(19,0),
        primary key (fake_id)
    )

    create table prts_role_code (
       user_role_code number(19,0) not null,
        user_role_name varchar2(150 char) not null,
        primary key (user_role_code)
    )

    create table prts_user_role (
       user_role_id number(19,2) not null,
        is_avaliable number(19,2),
        user_id number(19,2),
        user_role_code number(19,2),
        primary key (user_role_id)
    )

    alter table ems_city_code 
       add constraint FKti2fqs2eq5gord9nd4gqehpiu 
       foreign key (country_id, governorate_id) 
       references ems_governorate_code

    alter table ems_expert 
       add constraint FKo719hibxstmmjwu1pi85ca928 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table ems_expert 
       add constraint FK2nf22psyq6s1ux0iy56n9qo76 
       foreign key (country_id_nationality) 
       references ems_country_code

    alter table ems_expert_certificate 
       add constraint FKgtvxvf0r6y4ftcyd5hquj07x7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_certificate 
       add constraint FKc1t7xaqqyhhaj6qpi0lxhlqav 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_education 
       add constraint FK92wqyj0ui62l5nwcith8pt8go 
       foreign key (qual_class_id) 
       references ems_education_degree_code

    alter table ems_expert_education 
       add constraint FKckldf3gmcpc6l04lhr7xweaaf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_education 
       add constraint FKf7gle7ah26t11nxgtphcuckmx 
       foreign key (study_field_id) 
       references ems_study_field_code

    alter table ems_expert_education 
       add constraint FKmicjda4ypvky58y5qo1q7j9fq 
       foreign key (university_id) 
       references ems_university_code

    alter table ems_expert_experience 
       add constraint FKpqpu5p2kajcjsaj6r9np0lsw7 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_expert_experience 
       add constraint FKdqiejldbxepwgo8teiwthy10b 
       foreign key (job_id) 
       references ems_job_code

    alter table ems_financial_request 
       add constraint FKc0r3x0ky3uou52vv6gj57rpvi 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_financial_request_dtl 
       add constraint FKqc3ypn5cdncro1kgp1chqf8ru 
       foreign key (request_id) 
       references ems_financial_request

    alter table ems_financial_request_dtl 
       add constraint FKb1lievw6xfw7w70p51l8mm86f 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_governorate_code 
       add constraint FKruthvsiuqp1qe45m5mhjfrwb5 
       foreign key (country_id) 
       references ems_country_code

    alter table ems_project_expert 
       add constraint FKh5tvh82067meu5txb4ftogjhf 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FK6dmxk5t5ej20fpfv4ex69k7c9 
       foreign key (expert_id) 
       references ems_expert

    alter table ems_task 
       add constraint FKd8mx8cc4x3046ofcq4rg50p0 
       foreign key (project_id_parent, task_id_parent) 
       references ems_task

    alter table ems_task 
       add constraint FKp5u2uahfao75biybnap5r48hu 
       foreign key (task_status_id) 
       references ems_task_status_code

    alter table ems_task_comment 
       add constraint FKhppmp0diweaxm8xj4i30pppey 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_task_document 
       add constraint FKp0shch1yukq5rm496rg5bh5vw 
       foreign key (project_id, task_id) 
       references ems_task

    alter table ems_university_code 
       add constraint FKt3vh7vx8dxc3c1qt9cm6t5d3v 
       foreign key (city_id, country_id, governorate_id) 
       references ems_city_code

    alter table prts_project_description 
       add constraint FKl9rhrelolma6589yyqd1reocv 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_engineering_study 
       add constraint FK25hk42k5bqm1tmvqcsi9l3m9w 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_finance 
       add constraint FK6vbn2893d4y9d0n23yixxeqba 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_note 
       add constraint FKgogmsce6450cc46qnfpfmeq7u 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_offering_componen 
       add constraint FKoregq4je5ac8usfx0pnq304xw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_person 
       add constraint FKd6gk9vg2f2263859a4e7txtx7 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_procedure 
       add constraint FKn3xtl9khmy89vn7vsqx7jfxd5 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_purchase 
       add constraint FKli4br7vuudkd4dg7yypj6vmju 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_status 
       add constraint FK3oc63u8r4xe798e4rwyb1n4mw 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_technical_study 
       add constraint FKnjab96h3uf5put7f16k0vsh3g 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_tender_writing 
       add constraint FK1vti5ne0xa4imw5qek3rl2h0f 
       foreign key (project_id) 
       references prts_project

    alter table prts_project_timing 
       add constraint FKrh0gyyvkxndyqk3ouy66dr63k 
       foreign key (project_id) 
       references prts_project

    alter table prts_role_code 
       add constraint FK63ygq6002g7o3evvg8094yegb 
       foreign key (user_role_code) 
       references prts_role_code
