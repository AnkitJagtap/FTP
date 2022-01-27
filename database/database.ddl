--Create database using DATABASE FTP71
use ftp71;


-- Create table EMPLOYEE
create table EMPLOYEES(

EMP_ID int  primary key,

EMP_NAME varchar(50) not null,

DEPT_NAME varchar(50) not null,

EMP_DOJ DATE NOT NULL,

EMAIL_ID varchar(50) not null unique,

CONTACT varchar(10) not null unique,

MANAGER_ID INT,

AVAILABLE_LEAVE_BALANCE int not null

);



--Create LEAVE_DETAILS table
create table LEAVE_DETAILS(

LEAVE_ID int auto_increment PRIMARY KEY,

EMP_ID int not null,

START_DATE date not null,

END_DATE date not null,

NO_OF_LEAVES int not null,

LEAVE_REASON varchar(255),

APPLIED_ON date,

APPROVED_ON date,

LEAVE_TYPE enum('EL','SL','PL','OL') default 'EL',

LEAVE_STATUS enum('approved','pending','denied') default 'pending',

MANAGER_COMMENTS VARCHAR(30),

Foreign key (EMP_ID) references EMPLOYEES(EMP_ID)

);

