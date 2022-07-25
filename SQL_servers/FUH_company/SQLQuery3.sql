USE FUH_COMPANY
----------------------------------------------------------
/* Tạo stored procedure : liệt kê các dự án */
IF OBJECT_ID('sp_ListAllProject', 'P') IS NOT NULL
	DROP PROCEDURE sp_ListAllProject
GO

CREATE PROCEDURE sp_ListAllProject
AS
	SELECT * FROM tblProject;
GO

--gọi sử dụng
EXEC sp_ListAllProject;
EXECUTE sp_ListAllProject;

----------------------------------------------------------
/* Stored procedure cho phép thay đổi tên dự án */
IF OBJECT_ID('sp_ChangeProjectName', 'P') IS NOT NULL
	DROP PROCEDURE sp_ChangeProjectName
GO

CREATE PROCEDURE sp_ChangeProjectName
	@proNum INT,
	@proName varchar(50)
AS
	UPDATE tblProject
	SET proName = @proName
	WHERE proNum = @proNum;
GO

--test
SELECT * FROM tblProject
EXEC sp_ChangeProjectName 1, 'PjojectAAAA' 
SELECT * FROM tblProject
--cho phép thay đổi thứ rự tjam số bằng cách chỉ định cụ thể tên tham số
EXEC sp_ChangeProjectName @proName='ProjectA', @proNum=1

----------------------------------------------------------
/* Stored procedure trả về tên dự án thông qua tham số chỉ định bằng OUTPUT*/
IF OBJECT_ID('sp_GetProjectName', 'P') IS NOT NULL
	DROP PROCEDURE sp_GetProjectName
GO

CREATE PROCEDURE sp_GetProjectName
	@proNum INT,
	@proName varchar(50) OUTPUT
AS
	SELECT @proName=proName 
	FROM tblProject
	WHERE proNum = @proNum;
GO

--test
SELECT * FROM tblProject
--
DECLARE @pName VARCHAR(50)
EXEC sp_GetProjectName 1, @pName OUTPUT
SELECT @pName
--lấy giá trị trả về để dùng cho các mục đích khác.
EXEC sp_ChangeProjectName 2, @pName
GO

SELECT * FROM tblProject
--
EXEC sp_ChangeProjectName 2, 'ProjectB'

----------------------------------------------------------
/* nhân viên theo phòng ban chỉ định */
IF OBJECT_ID('sp_EmployeeOfDepartment', 'P') IS NOT NULL
	DROP PROCEDURE sp_EmployeeOfDepartment
GO

CREATE PROCEDURE sp_EmployeeOfDepartment
	@depNum INT
AS
	SELECT *
	FROM tblEmployee 
	WHERE depNum=@depNum
GO

--test
EXEC sp_EmployeeOfDepartment 2
GO

SELECT * FROM tblEmployee WHERE depNum=2
----------------------------------------------------------
/* Sử dụng biến cursor */
IF OBJECT_ID('sp_ListEmployee', 'P') IS NOT NULL
	DROP PROCEDURE sp_ListEmployee
GO

CREATE PROCEDURE sp_ListEmployee
AS
	DECLARE @SSN DECIMAL, @FulName NVARCHAR(50), @msg NVARCHAR(200);
	DECLARE employee_cur CURSOR
		FOR SELECT empSSN, empName FROM tblEmployee;
	OPEN employee_cur
	FETCH NEXT FROM employee_cur INTO @SSN, @FulName
	IF @@FETCH_STATUS <> 0
		PRINT '<<None>>'
	WHILE @@FETCH_STATUS = 0
	BEGIN
		SELECT @msg = CAST(@SSN as nchar(20)) + @FulName
		PRINT @msg
		FETCH NEXT FROM employee_cur INTO @SSN, @FulName
	END
	CLOSE employee_cur
	DEALLOCATE employee_cur
GO

--test
EXEC sp_ListEmployee
GO

----------------------------------------------------------
/* Tính phần trăm nhân viên theo phòng ban */
IF OBJECT_ID('sp_PercentageEmpDep', 'P') IS NOT NULL
	DROP PROCEDURE sp_PercentageEmpDep
GO

CREATE PROCEDURE sp_PercentageEmpDep
AS

declare @depNum int, @depName nvarchar(50), @NumOfEmpDep int,
		@TotalOfEmp int, @percentage real, @msg nvarchar(200)
select @TotalOfEmp=count(*) from tblEmployee
declare cur cursor for 
			select r.depNum, dep.depName, r.NumOfEmpDep
			from tblDepartment dep,
				(select d.depNum, count(empSSN) as NumOfEmpDep
				 from tblEmployee e, tblDepartment d
				 where e.depNum=d.depNum
				 group by d.depNum) r
			where dep.depNum=r.depNum
open cur
fetch next from cur into @depNum, @depName, @NumOfEmpDep
while @@fetch_status = 0
begin
	select @percentage=cast(@NumOfEmpDep as real)*100.0/cast(@TotalOfEmp as real)
	select @msg = @depName + ': (' + cast(@NumOfEmpDep as nvarchar(10)) + '/' + 
			cast(@TotalOfEmp as nvarchar(10)) + ') --> ' + 
			cast(@percentage as nvarchar(10)) + '%'
	print @msg
	fetch next from cur into @depNum, @depName, @NumOfEmpDep
end 

close cur
deallocate cur

GO

----------------------------------------------------------
/* Tính phần trăm nhân viên theo phòng ban 
và chỉ xuất ra phòng ban có tỷ lệ % > p*/
IF OBJECT_ID('sp_PercentageEmpDep', 'P') IS NOT NULL
	DROP PROCEDURE sp_PercentageEmpDep
GO

CREATE PROCEDURE sp_PercentageEmpDep
				@p int
AS

declare @depNum int, @depName nvarchar(50), @NumOfEmpDep int,
		@TotalOfEmp int, @percentage real, @msg nvarchar(200)
select @TotalOfEmp=count(*) from tblEmployee
declare cur cursor for 
			select r.depNum, dep.depName, r.NumOfEmpDep
			from tblDepartment dep,
				(select d.depNum, count(empSSN) as NumOfEmpDep
				 from tblEmployee e, tblDepartment d
				 where e.depNum=d.depNum
				 group by d.depNum) r
			where dep.depNum=r.depNum
open cur
fetch next from cur into @depNum, @depName, @NumOfEmpDep
while @@fetch_status = 0
begin
	select @percentage=cast(@NumOfEmpDep as real)*100.0/cast(@TotalOfEmp as real)
	if @percentage > @p
	begin
		select @msg = @depName + ': (' + cast(@NumOfEmpDep as nvarchar(10)) + '/' + 
				cast(@TotalOfEmp as nvarchar(10)) + ') --> ' + 
				cast(@percentage as nvarchar(10)) + '%'
		print @msg
	end
	fetch next from cur into @depNum, @depName, @NumOfEmpDep
end 

close cur
deallocate cur

GO

exec sp_PercentageEmpDep 20


----------------------------------------------------------
/**/

IF OBJECT_ID('sp_Sort', 'P') IS NOT NULL
	DROP PROCEDURE sp_Sort
GO

CREATE PROCEDURE sp_Sort 
	@TableName varchar(20), 
	@ColName varchar(20)
AS
	DECLARE @sqlStr varchar(200)
	
	SET @sqlStr = ''
	SET @sqlStr = @sqlStr + 'SELECT * FROM ' + @TableName
	SET @sqlStr = @sqlStr + ' ORDER BY ' + @ColName
	
	PRINT @sqlStr
	EXECUTE(@sqlStr) 
GO

use I2DBCOMPANY_AD
EXEC sp_Sort 'tblEmployee', 'empName'
EXEC sp_Sort 'tblEmployee', 'empSex'

----------------------------------------------------------
/**/

----------------------------------------------------------
/**/

----------------------------------------------------------
/**/

----------------------------------------------------------
/**/

