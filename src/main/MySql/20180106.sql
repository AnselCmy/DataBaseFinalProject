USE PayrollManagement;

SELECT * FROM  Employee;

SELECT * FROM User;

ALTER TABLE Employee ADD EBirth DATE;

ALTER TABLE Employee DROP COLUMN EAge;

SELECT * FROM AttendLog WHERE ENo='2000000042';

INSERT INTO AttendLog
    VALUES ("2001008031", '2017/12/04', "02");

CREATE PROCEDURE procedure_name()
    SELECT * FROM PositionLevel;

CALL procedure_name;

SHOW PROCEDURE STATUS WHERE Db='PayrollManagement';

CREATE PROCEDURE createUser()        #构建User表所用的存储过程
BEGIN
    DECLARE pw CHAR(6);
    DECLARE noo CHAR(10);
    DECLARE i INT;
    DECLARE num INT;
    SET i = 175;
    SELECT COUNT(*) into num FROM Employee;
    WHILE i<num DO
        SELECT ENo INTO noo FROM Employee LIMIT i,1;
        SELECT SUBSTRING(EId, -6) into pw FROM Employee LIMIT i,1;
        INSERT INTO User
            VALUES (noo, pw, '0');
        SET i = i+1;
    END WHILE;
END;

CALL createUser();

CREATE PROCEDURE PERSON(IN no CHAR(10), IN mon INT, OUT money FLOAT)      #构建一个人某月的记录，param：工号，月份，return：money
BEGIN
    DECLARE search CHAR(9);
    DECLARE num INT;
    DECLARE i INT;
    set i=0;
    IF mon<10 THEN
        SELECT concat('%2017-0', mon, '%') into search;
    ELSE
        SELECT concat('%2017-', mon, '%') into search;
    END IF;
    SELECT PosPayroll INTO money FROM PositionLevel WHERE
        PositionLevel.PosNo = (SELECT PosNo FROM Employee WHERE ENo=no);
    SELECT count(*) INTO num FROM AttendLog WHERE ENo=no AND ALDate LIKE search;
    SELECT num;
    WHILE i<num DO
        set money = money + (SELECT AEMoney FROM AttendEvent WHERE
            AENo=(SELECT AENo FROM AttendLog WHERE ENo=no AND ALDate LIKE search LIMIT i,1));
        set i = i+1;
    END WHILE;
#     SELECT * FROM AttendLog WHERE ENo='2000000041' AND ALDate LIKE (SELECT concat('%2017-0', 2, '%'));
END;

CREATE PROCEDURE CREATEPay()    #每个月执行一次，记录每个职工工资
BEGIN
    DECLARE mon INT;
    DECLARE day INT;
    SELECT date_format(curdate(), '%c') INTO mon;    #获取今天的日期
    SELECT date_format(curdate(), '%d') INTO day;
    IF day=1 THEN           #每个月的第一天对上个月的工资进行统计
        DECLARE num INT;
        DECLARE i INT;
        DECLARE noo CHAR(10);
        DECLARE lastDate CHAR(10);

        SET i=0;
        DECLARE money FLOAT;
        SELECT COUNT(*) INTO num FROM Employee;
        WHILE i<num DO
            SELECT ENo INTO noo FROM Employee LIMIT i,1;
            CALL PERSON(noo, 10, money);
            INSERT INTO Payroll
                VALUES (noo, date_add(curdate(), INTERVAL -1 DAY), money);
            SET i = i+1;
        END WHILE;
    END IF;
END;

CREATE TRIGGER addUser        #addUser触发器
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
    DECLARE id CHAR(6);
    SET id = SUBSTRING(NEW.EId, -6);
    INSERT INTO User VALUES (NEW.ENo, id, '0');
END;

CREATE EVENT IF NOT EXISTS eventPay   # 创建
ON SCHEDULE EVERY 1 DAY
ON COMPLETION PRESERVE
DO CALL CREATEPay();


SET GLOBAL EVENT_SCHEDULER = 1;    #启动定时器

ALTER EVENT eventPay ON COMPLETION PRESERVE ENABLE;   #开启事件

SHOW PROCESSLIST;