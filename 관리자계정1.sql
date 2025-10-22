alter user mybatis quota unlimited on users;

alter SESSION set "_oracle_script" = true;
create user mybatis identified by 1234;
grant CONNECT, RESOURCE to mybatis;
alter user mybatis quota unlimited on users;
alter user mybatis quota unlimited on users;
