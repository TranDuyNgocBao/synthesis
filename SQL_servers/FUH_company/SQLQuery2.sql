use FUH_COMPANY
----------------------------------------------------------
/* Add some reference constraints */
ALTER TABLE tblEmployee 
	ADD CONSTRAINT FK_tblEmployee_tblDepartment
		FOREIGN KEY(depNum) REFERENCES tblDepartment(depNum)

ALTER TABLE tblDepartment
	ADD CONSTRAINT FK_tblDepartment_tblEmployee
		FOREIGN KEY(mgrSSN) REFERENCES tblEmployee(empSSN)

ALTER TABLE tblEmployee
	ADD CONSTRAINT FK_tblEmployee_tblEmployee
		FOREIGN KEY(supervisorSSN) REFERENCES tblEmployee(empSSN)

----------------------------------------------------------
/* Insert some Employees tuples */
SELECT depNum FROM tblDepartment

INSERT INTO tblEmployee(empSSN, empName, empAddress, depNum, supervisorSSN)
VALUES (30121050123, 'Nguyễn Văn A', 'Long An', 10, 30121050037);

INSERT INTO tblEmployee(empSSN, empName, empAddress, depNum, supervisorSSN)
VALUES (30121050123, 'Nguyễn Văn A', 'Long An', 1, 30121050037);

DELETE tblEmployee WHERE empSSN=30121050123

----------------------------------------------------------
/* Update some values */
SELECT depNum FROM tblDepartment;
SELECT empSSN, depNum, supervisorSSN FROM tblEmployee WHERE empSSN=30121050004;

UPDATE tblEmployee
SET depNum=100
WHERE empSSN=30121050004

UPDATE tblEmployee
SET depNum=2
WHERE empSSN=30121050004

UPDATE tblEmployee
SET depNum=1
WHERE empSSN=30121050004


--
DELETE tblDepartment
WHERE depNum=1

INSERT INTO tblDepartment(depNum, depName)
VALUES(123, 'Phòng 123');

DELETE tblDepartment
WHERE depNum=123

----------------------------------------------------------
/*7.2*/
alter table tblEmployee 
	drop constraint NN_empName
alter table tblEmployee 
	add constraint NN_empName check (empName is not null)
--
alter table tblEmployee 
	drop constraint NN_empSalary
alter table tblEmployee 
	add constraint NN_empSalary check (empSalary is not null)

INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121050345, NULL, NULL, 1, 30121050037);

UPDATE tblEmployee
SET empName=NULL
WHERE empSSN=30121050004;

INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121050345, 'Nguyễn văn A', 10000, 1, 30121050037);
--
delete tblEmployee where empSSN=30121050345

alter table tblEmployee 
	drop constraint NN_empName
alter table tblEmployee 
	drop constraint NN_empSalary

----------------------------------------------------------
/*7.3*/
alter table tblEmployee 
	drop constraint CHK_empSex

alter table tblEmployee 
	add constraint CHK_empSex check (empSex in ('F', 'M'))

UPDATE tblEmployee
SET empSex='A'
WHERE empSSN=30121050004;

UPDATE tblEmployee
SET empSex='M'
WHERE empSSN=30121050004;

UPDATE tblEmployee
SET empSex='F'
WHERE empSSN=30121050004;

alter table tblEmployee 
	drop constraint CHK_empSex

----------------------------------------------------------
/**/
alter table tblEmployee 
	add constraint CHK_SexAge
	check (
		(empSex='F' and (YEAR(GETDATE()) - YEAR(empBirthdate)) <=55)
		or
		(empSex='M' AND (YEAR(GETDATE()) - YEAR(empBirthdate)) <= 60)
	)

update tblEmployee
set empSex='F', empBirthdate='1955-01-01'
where empSSn=30121050004;
--
update tblEmployee
set empSex='F', empBirthdate='1975-01-01'
where empSSn=30121050004;

alter table tblEmployee 
	drop constraint CHK_SexAge

----------------------------------------------------------
/* modifing constraints */
alter table tblEmployee 
	drop constraint CHK_SexAge
alter table tblEmployee 
	add constraint CHK_SexAge
	check (
		(empSex='F' and (YEAR(GETDATE()) - YEAR(empBirthdate)) <=55)
		or
		(empSex='M' AND (YEAR(GETDATE()) - YEAR(empBirthdate)) <= 65)
	)

-- xem các ràng buộc có trong bảng tblEmployee
exec sp_helpconstraint tblEmployee 

alter table tblEmployee 
	drop constraint CHK_SexAge
-- kiểm tra có thì mới drop
IF EXISTS (SELECT * FROM sysobjects WHERE name='CHK_SexAge')
	alter table tblEmployee 
		drop constraint CHK_SexAge
GO

----------------------------------------------------------
/* Short introduction to T-SQL programming */
----------------------------------------------------------
-- Assign a value into a variable : using SET or SELECT
DECLARE @empName NVARCHAR(20), @empSSN AS DECIMAL, @empSalary DECIMAL=1000
SET @empName=N'Mai Duy An'
SET @empSalary=2000
PRINT @empName
PRINT @empSalary

-- Assign a value into a variable using SQL command : SELECT or UPDATE
USE FUH_COMPANY
DECLARE @empName NVARCHAR(20), @empSalary DECIMAL=1000
SELECT	@empName=empName, @empSalary=empSalary
FROM	tblEmployee
WHERE	empName=N'Mai Duy An'
PRINT @empName
PRINT @empSalary

UPDATE	tblEmployee
SET		@empName=empName, @empSalary=empSalary
WHERE	empName=N'Mai Duy An'
PRINT @empName
PRINT @empSalary + 1000

-- Converts an expression from one data type to a different data type : using CAST or CONVERT function
DECLARE @empName NVARCHAR(20), @empSalary DECIMAL
SET @empName=N'Mai Duy An'
SET @empSalary=1000
PRINT @empName + '''s salary is ' + CAST(@empSalary AS VARCHAR)
PRINT @empName + '''s salary is ' + CONVERT(VARCHAR, @empSalary)

-- using IF statement
DECLARE @workHours DECIMAL, @bonus DECIMAL

SELECT	@workHours=SUM(workHours)
FROM	tblWorksOn
WHERE	empSSN=30121050027
GROUP BY empSSN

IF (@workHours > 300)
	SET @bonus=1000
ELSE
	SET @bonus=500
PRINT @bonus

-- CASE ... WHEN statement
DECLARE	@depNum DECIMAL, @str NVARCHAR(30)
--SET @depNum = 2
SET @str=
	CASE @depNum 
		WHEN 1 THEN N'Phòng ban số 1'
		WHEN 2 THEN N'Phòng ban số 2'
		ELSE N'Mã phòng ban khác 1, 2'
	END 
PRINT @str

DECLARE	@depNum DECIMAL, @str NVARCHAR(30)
SET @depNum=10
SET @str=
	CASE  
		WHEN @depNum >= 1 AND @depNum <= 2 THEN N'Phòng ban số 1 hoặc 2'
		WHEN @depNum >= 3 THEN N'Phòng ban lớn >= 3'
	END 
PRINT @str

-- using CASE ... WHEN statement with SELECT SQL statement
DECLARE @womanDayBonus DECIMAL
SELECT @womanDayBonus =
	CASE empSex 
		WHEN 'F' THEN 500
		WHEN 'M' THEN 0
	END
FROM tblEmployee
WHERE empSSN=30121050004
PRINT @womanDayBonus

DECLARE @womanDayBonus DECIMAL
SELECT @womanDayBonus =
	CASE  
		WHEN empSex='F' THEN 500
		WHEN empSex='M' THEN 0
	END
FROM tblEmployee
WHERE empSSN=30121050037
PRINT @womanDayBonus

DECLARE @womanDayBonus DECIMAL
SELECT @womanDayBonus =
	CASE  
		WHEN empSex='F' THEN 
			CASE 
				WHEN empSalary > 50000 then 500
				ELSE 100
			END
		WHEN empSex='M' THEN 0
	END
FROM tblEmployee
WHERE empSSN=30121050004
PRINT @womanDayBonus


DECLARE @womanDayBonus DECIMAL
SELECT @womanDayBonus =
	CASE  
		WHEN empSex='F' AND empSalary > 50000 THEN 500 
		WHEN empSex='F' AND empSalary <= 50000 THEN 100
		ELSE 0
	END
FROM tblEmployee
WHERE empSSN=30121050004
PRINT @womanDayBonus


-- WHILE statement
DECLARE @factorial INT, @n INT
SET @n=5
SET @factorial=1

WHILE (@n > 1)
	BEGIN
		SET @factorial = @factorial*@n
		SET @n = @n -1
	END
PRINT @factorial

-- Handling Error with @@ERROR function
SELECT *
FROM tblDepartment

BEGIN TRANSACTION
	INSERT INTO tblDepartment(depNum,depName)
	VALUES(5, N'Phòng Kế Toán');
	-- Lần 1 đã bắt lỗi, error chỉ xử lý lỗi hàm gần nhất, cho nên xuống dưới chạy bình thường

	INSERT INTO tblDepartment(depNum,depName)
	VALUES(6, N'Phòng Kế Toán Và Tài Chính');

	IF @@ERROR<>0
		BEGIN
			ROLLBACK TRANSACTION
			PRINT @@ERROR
		END
COMMIT TRANSACTION

DELETE
FROM tblDepartment
WHERE depNum = 6

-- Handling Error with TRY ... CATCH
SELECT *
FROM tblDepartment

BEGIN TRANSACTION	--begin transaction
BEGIN TRY
	--oparations
	INSERT INTO tblDepartment(depNum,depName)
	VALUES(5, N'Phòng Kế Toán');

	INSERT INTO tblDepartment(depNum,depName)
	VALUES(6, N'Phòng Kế Toán');
	COMMIT TRANSACTION	--commit the transaction
END TRY	
BEGIN CATCH
	ROLLBACK TRANSACTION
	PRINT ERROR_NUMBER()
	PRINT ERROR_MESSAGE()
	PRINT 'False Found'
END CATCH

----------------------------------------------------------
/* Implement Trigger with T-SQL */
----------------------------------------------------------
-- create trigger
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
	drop trigger Tr_Employee_Insert
go
CREATE TRIGGER Tr_Employee_Insert ON tblEmployee
AFTER INSERT
AS
	RAISERROR('Insert trigger is awakened',16,1)
go

--test 
INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121050345, N'Nguyễn Văn Tý', 10000, 1, 30121050037);
SELECT * FROM tblEmployee WHERE empSSN=30121050345

--delete trigger
IF OBJECT_ID('Tr_Employee_Delete', 'TR') is not null
	drop trigger Tr_Employee_Delete
go
CREATE TRIGGER Tr_Employee_Delete ON tblEmployee
AFTER DELETE
AS
	RAISERROR('Delete trigger is awakened',16,1)
go
--test
DELETE FROM tblEmployee WHERE empSSN=30121050345

--update trigger
IF OBJECT_ID('Tr_Employee_Update', 'TR') is not null
	drop trigger Tr_Employee_Update
go
CREATE TRIGGER Tr_Employee_Update ON tblEmployee
AFTER Update
AS
	RAISERROR('Update trigger is awakened',16,1)
go
--test
UPDATE tblEmployee 
SET empName=N'Trần Văn X'
WHERE empSSN=30121050345

----------------------------------------------------------
/* Abort Transaction */
--Có thể hủy bỏ các tác động trên dữ liệu của lệnh kích hoạt trigger thông qua lệnh ROLLBACK
--insert trigger
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
	drop trigger Tr_Employee_Insert
go
CREATE TRIGGER Tr_Employee_Insert ON tblEmployee
AFTER INSERT
AS
	RAISERROR('Insert trigger is awakened',16,1)
	ROLLBACK TRANSACTION
go
--test 
INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121050345, N'Nguyễn Văn Tý', 10000, 1, 30121050037);
--not found employee whose empSSN is 30121050345
SELECT * FROM tblEmployee WHERE empSSN=30121050345

----------------------------------------------------------
/* Hai bảng đặc biệt INSERTED and DELETED 
Các bộ được thêm mới sẽ lưu trong bảng INSERTED
Các bộ bị xóa sẽ lưu trong bảng DELETED
Trường hợp cập nhật: các bộ ứng với giá trị cũ sẽ lưu trong DELETED và giá trị mới sẽ lưu trong INSERTED
*/
IF OBJECT_ID('Tr_Employee_Insert', 'TR') is not null
	drop trigger Tr_Employee_Insert
go
CREATE TRIGGER Tr_Employee_Insert ON tblEmployee
AFTER INSERT
AS
	DECLARE @vEmpSSN DECIMAL, @vEmpName NVARCHAR(50)
	SELECT @vEmpSSN=empSSN FROM inserted
	SELECT @vEmpName=empName FROM inserted
	PRINT 'new tuple:'
	PRINT 'empSSN=' + CAST(@vEmpSSN AS nvarchar(11)) + ' empName=' + @vEmpName
go
--test
delete tblEmployee where empSSN=30121050345
INSERT INTO tblEmployee(empSSN, empName, empSalary, depNum, supervisorSSN)
VALUES (30121050345, N'Nguyễn Văn Tý', 10000, 1, 30121050037);

----------------------------------------------------------
/* Không ký hợp đồng với nhân viên dưới 18 tuổi */
IF OBJECT_ID('Tr_Employee_Under18', 'TR') is not null
	drop trigger Tr_Employee_Under18
go

CREATE TRIGGER Tr_Employee_Under18 ON tblEmployee
AFTER INSERT, UPDATE
AS
	DECLARE @empBirthdate DATETIME, @age INT
	SELECT @empBirthdate=empBirthdate 
	FROM inserted
	
	SET @age=YEAR(GETDATE()) - YEAR(@empBirthdate)
	IF (@age < 18)
	BEGIN
		RAISERROR('This employee is under 18 years old. 
					We can not sign a contact with him/her.',16,1)
		ROLLBACK TRANSACTION
	END
go

--test for INSERT action
DELETE tblEmployee WHERE empSSN=30121050345
INSERT INTO tblEmployee(empSSN, empName, empBirthdate, depNum, supervisorSSN)
VALUES (30121050345, N'Nguyễn Văn Tý', '1998-01-01', 1, 30121050037);
SELECT * FROM tblEmployee WHERE empSSN=30121050345

--test for UPDATE action
SELECT * FROM tblEmployee WHERE empSSN=30121050004
UPDATE tblEmployee
SET empBirthdate='1999-01-01'
WHERE empSSN=30121050004

/* Không ký hợp đồng với nhân viên dưới 18 tuổi */
-- Dùng EXISTS
IF OBJECT_ID('Tr_Employee_Under18', 'TR') is not null
	drop trigger Tr_Employee_Under18
go

CREATE TRIGGER Tr_Employee_Under18 ON tblEmployee
AFTER INSERT, UPDATE
AS
	IF EXISTS(SELECT * 
				FROM inserted 
				WHERE (YEAR(GETDATE())- YEAR(empBirthdate)) < 18
			)
	BEGIN
		RAISERROR('This employee is under 18 years old. 
					We can not sign a contact with him/her.',16,1)
		ROLLBACK TRANSACTION
	END
go

--test for INSERT action
DELETE tblEmployee WHERE empSSN=30121050345
INSERT INTO tblEmployee(empSSN, empName, empBirthdate, depNum, supervisorSSN)
VALUES (30121050345, N'Nguyễn Văn Tý', '1998-01-01', 1, 30121050037);
SELECT * FROM tblEmployee WHERE empSSN=30121050345

--test for UPDATE action
SELECT * FROM tblEmployee WHERE empSSN=30121050004
UPDATE tblEmployee
SET empBirthdate='1998-02-17'
WHERE empSSN=30121050004


----------------------------------------------------------
/* 
	Mỗi nhân viên chỉ cho phép tối đa 2 người phụ thuộc
*/
IF OBJECT_ID('Tr_Dependent_AtMost2', 'TR') is not null
	drop trigger Tr_Dependent_AtMost2
go

CREATE TRIGGER Tr_Dependent_AtMost2 ON tblDependent
AFTER INSERT, UPDATE
AS
	DECLARE @vNumOfDependent INT
	SELECT @vNumOfDependent=COUNT(*)
		FROM tblDependent d JOIN INSERTED i ON d.empSSN=i.empSSN
--PRINT @vNumOfDependent
IF (@vNumOfDependent>2)
	BEGIN
		RAISERROR('Each employee has at most 2 dependents.',16,1)
		ROLLBACK TRANSACTION
	END
go

--test
select * from tblDependent where empSSN=30121050004;
insert into tblDependent(depName, empSSn, depRelationship)
values(N'Vương Thị A', 30121050004, 'Em');
insert into tblDependent(depName, empSSn, depRelationship)
values(N'Vương Thị B', 30121050004, 'Em');


