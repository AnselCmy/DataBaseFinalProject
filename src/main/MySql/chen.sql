CREATE SCHEMA PayrollManagement;

USE PayrollManagement;

USE Payroll;

show variables like 'character%';

CREATE TABLE PositionLevel
(
  PosNo CHAR(1) PRIMARY KEY,
  PosName CHAR(20) NOT NULL,
  PosPayroll FLOAT(7, 1) NOT NULL
);

CREATE TABLE Department
(
  DNo CHAR(3) PRIMARY KEY,
  DName VARCHAR(20) NOT NULL
);

CREATE TABLE Employee
(
  ENo CHAR(10) PRIMARY KEY,
  EId CHAR(18) NOT NULL,
  EName VARCHAR(20) NOT NULL,
  ESex CHAR(2) NOT NULL,
  EEntryDate DATE NOT NULL,
  ETel CHAR(11) NOT NULL,
  EBirth DATE NOT NULL,
  DNo CHAR(3) REFERENCES Department(DNo),
  PosNo CHAR(2) REFERENCES PositionLevel(PosNo)
);

CREATE TABLE AttendEvent
(
  AENo CHAR(2) PRIMARY KEY,
  AEName CHAR(10) NOT NULL,
  AEMoney FLOAT(4, 1) NOT NULL
);

CREATE TABLE AttendLog
(
  ENo CHAR(10) NOT NULL,
  ALDate DATE NOT NULL,
  AENo CHAR(2) NOT NULL,
  FOREIGN KEY (ENo) REFERENCES Employee(ENo),
  FOREIGN KEY (AENo) REFERENCES AttendEvent(AENo),
  PRIMARY KEY (ENo, ALDate, AENo)
);


CREATE TABLE SubsidyEvent
(
  SENo CHAR(2) PRIMARY KEY,
  SEName CHAR(10) NOT NULL
);

CREATE TABLE SubsidyLog
(
  ENo CHAR(10) NOT NULL,
  SLDate DATE NOT NULL,
  SLMoney FLOAT(7, 1) NOT NULL,
  SENo CHAR(2) NOT NULL,
  SLComment CHAR(20),
  PRIMARY KEY (ENo, SLDate, SENo),
  FOREIGN KEY (ENo) REFERENCES Employee(ENo),
  FOREIGN KEY (SENo) REFERENCES SubsidyEvent(SENo)
);

CREATE TABLE Payroll
(
  ENo CHAR(10) NOT NULL,
  PDate DATE NOT NULL,
  PPayroll FLOAT(7, 1) NOT NULL,
  FOREIGN KEY (ENo) REFERENCES Employee(ENo),
  PRIMARY KEY (ENo, PDate)
);

CREATE TABLE User
(
  ENo CHAR(10) PRIMARY KEY REFERENCES Employee(ENo),
  UPassword CHAR(20) NOT NULL,
  ULevel CHAR(1) NOT NULL
);


INSERT INTO PositionLevel
    VALUES ('0', '部门主管', 80000.0),
      ('1', '部门副主管', 50000.0),
      ('2', '高级员工', 15000.0),
      ('3', '中级员工', 9000.0),
      ('4', '初级员工', 6000.0),
      ('5', '实习员工', 2000.0);


INSERT INTO Department
    VALUES ('000', '董事会'),
      ('001', '经理办公室'),
      ('002', '党委办公室'),
      ('003', '工会办公室'),
      ('004', '技术部'),
      ('005', '营销部'),
      ('006', '人力资源部'),
      ('007', '保卫部'),
      ('008', '后勤部'),
      ('009', '财务部');

SELECT * FROM Employee WHERE DNo='000' and PosNo='5';

INSERT INTO AttendEvent
    VALUES ('00', '迟到', -300.0),
      ('01', '早退', -300.0),
      ('02', '旷工', -500.0),
      ('03', '加班', 300.0),
      ('04', '出差', 300.0),
      ('05', '请假', -50.0);

INSERT INTO User
    VALUE ('2015216910','123','0');

INSERT INTO User
    VALUE ('2001003000','123','1');

SELECT * from PositionLevel;

SELECT * from Department;

SELECT * from Employee;

USE PayrollManagement;


SELECT * FROM Payroll;

SELECT * FROM User;

SELECT * FROM AttendLog WHERE ENo='2000000041';

SELECT * FROM AttendEvent;

SHOW TRIGGERS;

CREATE OR REPLACE VIEW v_Employee(ENo, EId, EName, ESex, EEntryDate, DName, PosName, ETel, EAge)
  AS
  SELECT ENo, EId, EName, ESex, EEntryDate, DName, PosName, ETel, (YEAR(CURDATE())-YEAR(EBirth))-(RIGHT(CURDATE(),5)) EAge
  FROM Employee, Department, PositionLevel
  WHERE Employee.DNo=Department.DNo AND Employee.PosNo=PositionLevel.PosNo;

USE PayrollManagement;

CREATE OR REPLACE VIEW v_AttendLog(ENo, ALDate, AENo, AEName, AEMoney)
  AS
  SELECT ENo, ALDate,AttendLog.AENo, AEName, AEMoney
  FROM AttendEvent, AttendLog
  WHERE AttendEvent.AENo = AttendLog.AENo;

CREATE OR REPLACE VIEW v_AttendLog2(ENo, ALDate, AENo, AEName, AEMoney)
  AS
    SELECT ENo, ALDate, AttendLog.AENo, AEName, AEMoney
    FROM AttendEvent, AttendLog
    WHERE AttendEvent.AENo = AttendLog.AENo;

CREATE OR REPLACE VIEW v_SubsidyLog(ENo, SLDate, SENo, SEName, SLMoney, SLComment)
  AS
    SELECT ENo, SLDate, SubsidyLog.SENo, SEName, SLMoney, SLComment
    FROM SubsidyEvent, SubsidyLog
    WHERE SubsidyEvent.SENo = SubsidyLog.SENo;

SELECT EBirth, (YEAR(CURDATE())-YEAR(EBirth))-(RIGHT(CURDATE(),5)) EAge FROM Employee;

SELECT * FROM v_Employee;

SELECT * FROM AttendLog;

SELECT * FROM v_AttendLog;

SELECT * FROM v_AttendLog WHERE ENo='2000000041';

SELECT * FROM v_AttendLog WHERE ENo='2007000000';

SELECT * FROM SubsidyEvent;

SELECT * FROM v_SubsidyLog WHERE ENo="2002004046";


CREATE TRIGGER PayrollController BEFORE INSERT
  ON Payroll FOR EACH ROW
  BEGIN
    IF NEW.PPayroll<0 THEN
      SET NEW.PPayroll=0;
    END IF;
  END;


SHOW TRIGGERS ;


