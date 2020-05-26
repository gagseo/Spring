select * from tb_member;

alter table tb_notice drop column original_filepath;
alter table tb_notice drop column rename_filepath;
commit

--파일테이블
CREATE TABLE TB_FILE ( 
F_IDX NUMBER, 
NOTICENO NUMBER NOT NULL, 
originFileName VARCHAR2(260 BYTE), 
renameFileName VARCHAR2(260 BYTE), 
savePath varchar2(260 byte),
PRIMARY KEY (F_IDX));

--파일인덱스시퀀스
CREATE SEQUENCE 
S_TB_FILE_IDX 
START WITH 100000 
INCREMENT BY 1 
NOMAXVALUE 


select * from tb_file;