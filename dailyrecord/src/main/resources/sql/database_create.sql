
--”√ªß±Ì
create table DR_USER
(
  id         VARCHAR2(36) not null,
  user_id    VARCHAR2(36) not null,
  password   VARCHAR2(36) not null,
  createtime TIMESTAMP(0),
  updatetime TIMESTAMP(0),
  email      VARCHAR2(64),
  name       VARCHAR2(32),
  modifier   VARCHAR2(36)
)