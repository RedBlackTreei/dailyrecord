-- Created on 2014/12/24 by Justin.Ji 
-- 随机生成100个用户
declare
  i          integer;
  id         varchar2(64);
  userId     varchar2(64);
  password   varchar2(64);
  name       varchar2(64);
  email      varchar2(64);
  createtime TIMESTAMP(0);
  updatetime TIMESTAMP(0);
  modifier   VARCHAR2(36);
begin
  for i in 1..100 loop
    id         := sys_guid();
    userId     := DBMS_RANDOM.STRING('L', 5);
    password   := DBMS_RANDOM.STRING('L', 5);
    name       := DBMS_RANDOM.STRING('L', 5);
    email      := DBMS_RANDOM.STRING('L', 5) || '@qq.com';
    createtime := sysdate;
    updatetime := sysdate;
    insert into dr_user
      (id, user_id, password, name, email, createtime, updatetime, modifier)
    values
      (id, userId, password, name, email, createtime, updatetime, '');
  end loop;
  commit;
end;
