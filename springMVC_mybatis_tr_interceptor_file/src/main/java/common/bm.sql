select * from tb_member;

alter table tb_notice drop column original_filepath;
alter table tb_notice drop column rename_filepath;
commit

--�������̺�
CREATE TABLE TB_FILE ( 
F_IDX NUMBER, 
NOTICENO NUMBER NOT NULL, 
originFileName VARCHAR2(260 BYTE), 
renameFileName VARCHAR2(260 BYTE), 
savePath varchar2(260 byte),
PRIMARY KEY (F_IDX));

--�����ε���������
CREATE SEQUENCE 
S_TB_FILE_IDX 
START WITH 100000 
INCREMENT BY 1 
NOMAXVALUE 


select * from tb_file;