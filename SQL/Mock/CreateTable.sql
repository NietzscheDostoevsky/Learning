CREATE TABLE LIBRARY
(
	USERID NUMBER NOT NULL,
	FIRSTNAME VARCHAR(20) NOT NULL,
	LASTNAME VARCHAR(20) NOT NULL,
	REGNO VARCHAR(20) NOT NULL,
	PHONENUMBER CHAR(13) NOT NULL,
	BOOKID NUMBER ,

	CONSTRAINT  PK01    PRIMARY KEY(USERID),
	CONSTRAINT  U11     UNIQUE(PHONENUMBER),
	CONSTRAINT  U12     UNIQUE(REGNO), 
	CONSTRAINT  CK12    CHECK(regexp_like(FIRSTNAME,'[a-zA-Z]{2,20}$')),
	CONSTRAINT  CK13    CHECK(regexp_like(LASTNAME,'[a-zA-Z]{2,20}$')),
	CONSTRAINT  CK15    CHECK(regexp_like(PHONENUMBER,'^\+91[6-9][0-9]{9}$'))

) ; 

CREATE TABLE BOOKS 

(
	BOOKID NUMBER NOT NULL , 
	BOOKNAME VARCHAR(50) NOT NULL, 
	AUTHORNAME VARCHAR(50) NOT NULL, 
	YEARPUBLISHED NUMBER(4), 
	CONSTRAINT U21 UNIQUE(BOOKID) , 
	CONSTRAINT CK21 CHECK(regexp_like(BOOKNAME, '[a-z A-Z]{2,50}')) , 
	CONSTRAINT CK22 CHECK(YEARPUBLISHED > 1800) , 

) ; 



ALTER TABLE LIBRARY
        ADD CONSTRAINT FK01 
        FOREIGN KEY (BOOKID)
        REFERENCES BOOKS(BOOKID)
      
