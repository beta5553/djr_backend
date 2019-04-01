create table biography
(
  BIOGRAPHY_ID int auto_increment
    primary key,
  USER_ID      int        null,
  LANG         varchar(2) null,
  BIO          longtext   null,
  constraint biography_user_USER_ID_fk
    foreign key (USER_ID) references user (USER_ID)
);

INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (1, null, 'SP', 'Esta es mi bio en sp');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (2, null, 'SP', 'Esta es mi bio en sp');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (4, 32, 'SP', 'Esta es mi bio en sp');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (5, 32, 'EN', 'This is my bio in English');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (6, 32, 'FR', 'C''est ma bio en anglais');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (7, null, 'EN', 'Biography here');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (14, 35, 'EN', 'This is my bio in English');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (15, 35, 'SP', 'Esta es mi bio en sp');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (16, 35, 'FR', 'C''est ma bio en anglais');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (17, 36, 'SP', 'Esta es mi bio en sp');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (18, 36, 'FR', 'C''est ma bio en anglais');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (19, 36, 'EN', 'This is my bio in English');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (20, null, 'EN', 'Biography here');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (21, 37, 'SP', 'Bio updated');
INSERT INTO db_mypresskit.biography (BIOGRAPHY_ID, USER_ID, LANG, BIO) VALUES (22, 41, 'EN', 'Edited biography 1');
create table image
(
  IMAGE_ID       int auto_increment
    primary key,
  USER_ID        int          null,
  IMAGE_NAME     varchar(255) null,
  IMAGE_FILE     longblob     null,
  IMAGE_CATEGORY varchar(255) null,
  constraint image_user_USER_ID_fk
    foreign key (USER_ID) references user (USER_ID)
);

INSERT INTO db_mypresskit.image (IMAGE_ID, USER_ID, IMAGE_NAME, IMAGE_FILE, IMAGE_CATEGORY) VALUES (1, null, 'Foto de Izzy', 0x736F6D652066696C652068657265, 'pics');
INSERT INTO db_mypresskit.image (IMAGE_ID, USER_ID, IMAGE_NAME, IMAGE_FILE, IMAGE_CATEGORY) VALUES (2, 36, 'Foto de Izzy 1', 0x736F6D652066696C6520686572652031, 'pics 1');
INSERT INTO db_mypresskit.image (IMAGE_ID, USER_ID, IMAGE_NAME, IMAGE_FILE, IMAGE_CATEGORY) VALUES (3, 36, 'Foto de Izzy 2', 0x736F6D652066696C6520686572652032, 'pics 2');
create table label
(
  LABEL_ID      int auto_increment
    primary key,
  LABEL_NAME    char(255) null,
  DESCRIPTION   char(255) null,
  EMAIL         char(255) null,
  LABEL_MANAGER char(255) null,
  COUNTRY       char(255) null,
  LOGO          char(255) null
);

INSERT INTO db_mypresskit.label (LABEL_ID, LABEL_NAME, DESCRIPTION, EMAIL, LABEL_MANAGER, COUNTRY, LOGO) VALUES (2, 'qbCrew', 'This is an edited description', 'info@qbtrance.com', 'israel Morales', 'Mexico', 'logo file here');
INSERT INTO db_mypresskit.label (LABEL_ID, LABEL_NAME, DESCRIPTION, EMAIL, LABEL_MANAGER, COUNTRY, LOGO) VALUES (3, 'qbCrew', 'qbCrew is a qbtrance branche', 'info@qbtrance.com', 'israel Morales', 'Mexico', 'logo file here');
INSERT INTO db_mypresskit.label (LABEL_ID, LABEL_NAME, DESCRIPTION, EMAIL, LABEL_MANAGER, COUNTRY, LOGO) VALUES (4, 'qbCrew', 'qbCrew is a qbtrance branche', 'info@qbtrance.com', 'israel Morales', 'Mexico', 'logo file here');
INSERT INTO db_mypresskit.label (LABEL_ID, LABEL_NAME, DESCRIPTION, EMAIL, LABEL_MANAGER, COUNTRY, LOGO) VALUES (5, 'qbCrew', 'qbCrew is a qbtrance branche', 'info@qbtrance.com', 'israel Morales', 'Mexico', 'logo file here');
INSERT INTO db_mypresskit.label (LABEL_ID, LABEL_NAME, DESCRIPTION, EMAIL, LABEL_MANAGER, COUNTRY, LOGO) VALUES (6, 'qbCrew', 'qbCrew is a qbtrance branche', 'info@qbtrance.com', 'israel Morales', 'Mexico', 'logo file here');
create table link
(
  LINK_ID       int auto_increment
    primary key,
  USER_ID       int        null,
  LINK_NAME     char(255)  null,
  DESCRIPT      char(255)  null,
  URL           char(255)  null,
  EMBEDED_CODE  longtext   null,
  IS_EVENT_LINK tinyint(1) null,
  IS_MUSIC_LINK tinyint(1) null
);

INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (1, 41, null, 'Description EDITED!', 'http://qbtrance.com', 'Embeded code', 0, 1);
INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (3, 0, null, 'Link description', 'http://qbtrance.com', 'Embeded code', 0, 1);
INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (4, 0, null, 'Link description', 'http://qbtrance.com', 'Embeded code', 0, 1);
INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (5, null, 'SoundCloud', 'SoundCloud description', 'link URL', 'EMBEDED CODE FOR PLUGINS', 0, 1);
INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (6, null, 'SoundCloud', 'SoundCloud description', 'link URL', 'EMBEDED CODE FOR PLUGINS', 0, 1);
INSERT INTO db_mypresskit.link (LINK_ID, USER_ID, LINK_NAME, DESCRIPT, URL, EMBEDED_CODE, IS_EVENT_LINK, IS_MUSIC_LINK) VALUES (7, null, 'SoundCloud', 'SoundCloud description', 'link URL', 'EMBEDED CODE FOR PLUGINS', 0, 1);
create table message
(
  MESSAGE_ID   int auto_increment
    primary key,
  FROM_USER_ID int        null,
  TO_USER_ID   int        null,
  MESSAGE      longtext   null,
  IS_DELETED   tinyint(1) null
);

INSERT INTO db_mypresskit.message (MESSAGE_ID, FROM_USER_ID, TO_USER_ID, MESSAGE, IS_DELETED) VALUES (1, 1, 2, 'Hola, este es un mensaje', 0);
INSERT INTO db_mypresskit.message (MESSAGE_ID, FROM_USER_ID, TO_USER_ID, MESSAGE, IS_DELETED) VALUES (2, 1, 2, 'Hola, este es un mensaje', 0);
INSERT INTO db_mypresskit.message (MESSAGE_ID, FROM_USER_ID, TO_USER_ID, MESSAGE, IS_DELETED) VALUES (3, 42, 23, 'Hola mensajes EDITADO', 1);
create table prefs
(
  PREF_ID  int auto_increment
    primary key,
  USER_ID  int      null,
  BG_COLOR char(10) null
);

INSERT INTO db_mypresskit.prefs (PREF_ID, USER_ID, BG_COLOR) VALUES (1, 1, 'RED');
INSERT INTO db_mypresskit.prefs (PREF_ID, USER_ID, BG_COLOR) VALUES (2, 1, 'BLACK');
create table user
(
  USER_ID         int auto_increment
    primary key,
  FIRST_NAME      char(80)   null,
  LAST_NAME       char(100)  null,
  AKA             char(100)  null,
  IS_PRODUCER     tinyint(1) null,
  IS_DJ           tinyint(1) null,
  IS_VJ           tinyint(1) null,
  IS_PROMOTER     tinyint(1) null,
  SHORT_DESC      char(200)  null,
  EMAIL           char(200)  null,
  DATE_BIRTH      date       null,
  CURRENT_COUNTRY char(100)  null,
  COUNTRY_BIRTH   char(100)  null,
  PICTURE         char(255)  null,
  LOGO            char(255)  null,
  QRCODE          char(255)  null,
  LABEL_ID        int        null
);

INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (27, 'Israel-test-userInsert1', 'Morales-test-userInsert1', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (28, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (30, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (31, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (32, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (35, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (36, 'Israel-test3', 'Morales-test3', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (37, 'Israel-test4', 'Morales-test4', null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (38, 'izzy', 'Morales Lopez', 'CX-1', 1, 1, 0, 1, 'IZZY CX-1, Psytrance DJ', 'israel@qbtrance.com', '1082-10-27', 'USA', 'Mexico', 'Picture.jpg', 'LOGO.jpg', 'No QRCode supported yet', 1);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (39, 'izzy', 'Morales Lopez', 'CX-1', 1, 1, 0, 1, 'IZZY CX-1, Psytrance DJ', 'israel@qbtrance.com', '1082-10-27', 'USA', 'Mexico', 'Picture.jpg', 'LOGO.jpg', 'No QRCode supported yet', 1);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (40, 'izzy', 'Morales Lopez', 'CX-1', 1, 1, 0, 1, 'IZZY CX-1, Psytrance DJ', 'israel@qbtrance.com', '1082-10-27', 'USA', 'Mexico', 'Picture.jpg', 'LOGO.jpg', 'No QRCode supported yet', 1);
INSERT INTO db_mypresskit.user (USER_ID, FIRST_NAME, LAST_NAME, AKA, IS_PRODUCER, IS_DJ, IS_VJ, IS_PROMOTER, SHORT_DESC, EMAIL, DATE_BIRTH, CURRENT_COUNTRY, COUNTRY_BIRTH, PICTURE, LOGO, QRCODE, LABEL_ID) VALUES (41, 'Israel - Edited', 'Morales - Edited', 'CX-1', 1, 1, 0, 1, 'IZZY CX-1, Psytrance DJ', 'israel@qbtrance.com', '1082-10-27', 'USA', 'Mexico', 'Picture.jpg', 'LOGO.jpg', 'No QRCode supported yet', 1);
create table user_label
(
  USERLABEL_ID int null,
  LABEL_ID     int null,
  USER_ID      int null
);


create table visit
(
  VISIT_ID  int auto_increment
    primary key,
  USER_ID   int       null,
  USER_IP   char(100) null,
  TIMESTAMP timestamp null
);


create table vote
(
  VOTE_ID        int auto_increment
    primary key,
  USER_ID        int null,
  VOTED_USER_ID  int null,
  VOTED_LABEL_ID int null,
  constraint VOTE_user_USER_ID_fk
    foreign key (USER_ID) references user (USER_ID),
  constraint vote_label_LABEL_ID_fk
    foreign key (VOTED_LABEL_ID) references label (LABEL_ID)
);

