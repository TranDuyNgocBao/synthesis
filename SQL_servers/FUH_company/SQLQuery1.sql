USE FUH_COMPANY

/*1*/
SELECT *
FROM tblEmployee
WHERE depNum = 
				(SELECT depNum
				FROM tblDepartment
				WHERE depName = N'Phòng phần mềm trong nước'
				)

SELECT *
FROM	tblEmployee
WHERE	empSalary > 50000;

----------------------------------------------------------
/*2*/
SELECT	empName, empSalary
FROM	tblEmployee
WHERE	empSalary > 50000;

SELECT	*
FROM	tblEmployee

SELECT	TOP 5 *
FROM	tblEmployee

SELECT	*
FROM	tblEmployee

SELECT	DISTINCT *
FROM	tblEmployee

SELECT	TOP 50 PERCENT *
FROM	tblEmployee

SELECT	empAddress
FROM	tblEmployee

SELECT	DISTINCT empAddress
FROM	tblEmployee

----------------------------------------------------------
/*3*/
SELECT	empName AS 'Họ và Tên', empSalary AS 'Lương'
FROM	tblEmployee
WHERE	empSalary > 50000;

----------------------------------------------------------
/*4*/
SELECT 	empName AS 'HỌ và tên', empSex  AS 'Giớ tính' , YEAR(GETDATE()) - YEAR(empBirthdate) AS 'Tuổi'
FROM 	tblEmployee
WHERE 	(empSex='F' AND (YEAR(GETDATE()) - YEAR(empBirthdate)) < 40)
	OR
		(empSex='M' AND (YEAR(GETDATE()) - YEAR(empBirthdate)) < 50);

----------------------------------------------------------
/*5.1*/
SELECT 	*
FROM 	tblEmployee
WHERE 	empName = N'Võ Việt Anh';

----------------------------------------------------------
/*5.2*/
SELECT 	*
FROM 	tblEmployee
WHERE 	empName LIKE N'%Anh';

SELECT 	*
FROM 	tblEmployee
WHERE 	empName LIKE N'N%' ESCAPE '!';

----------------------------------------------------------
/*5.3 chuỗi có chứa dấu %*/
SELECT 	empName AS 'HỌ và tên', empSex  AS 'Giớ tính' , YEAR(GETDATE()) - YEAR(empBirthdate) AS 'Tuổi'
FROM 	tblEmployee
WHERE 	empName LIKE '%@%%' ESCAPE '@';

SELECT 	empName AS 'HỌ và tên', empSex  AS 'Giớ tính' , YEAR(GETDATE()) - YEAR(empBirthdate) AS 'Tuổi'
FROM 	tblEmployee
WHERE 	empName LIKE '%!%%' ESCAPE '!';

/*5.4 chuỗi bắt đầu và kết thúc với dấu % */
SELECT 	empName AS 'HỌ và tên', empSex  AS 'Giớ tính' , YEAR(GETDATE()) - YEAR(empBirthdate) AS 'Tuổi'
FROM 	tblEmployee
WHERE 	empName LIKE 'x%%x%' ESCAPE 'x';

----------------------------------------------------------
/* Trong SQL Server, không chỉ định từ khóa DATE cho chuỗi giá trị hằng ngày, mà chỉ đơn thuần là chuỗi 'yyyy-mm-dd' dạng ngày */
SELECT 	empName,empBirthdate, YEAR(GETDATE()) - YEAR(empBirthdate) AS 'Tuổi'
FROM 	tblEmployee
WHERE	empBirthdate='1968-02-17';

----------------------------------------------------------
/*6*/
SELECT 	*
FROM 	tblEmployee
ORDER BY depNum ASC, empSalary DESC;

SELECT	*
FROM tblEmployee, tblDepartment
WHERE tblEmployee.depNum = tblDepartment.depNum
	AND tblDepartment.depName = N'Phòng phần mềm trong nước'

--1. Tìm người phụ thuộc của nhân viên Mai Duy An
SELECT	d.*
FROM tblEmployee e, tblDependent d
WHERE e.empSSN = d.empSSN
	AND e.empName = N'Mai Duy An'

SELECT *
FROM tblDependent
WHERE empSSN = (SELECT empSSN
				FROM tblEmployee
				WHERE empName = N'Mai Duy An'
				)

--2. Tìm người phụ thuộc của nhân viên thuộc Phòng phần mềm trong nước
SELECT	d1.*
FROM tblEmployee e, tblDependent d1, tblDepartment d2
WHERE e.depNum = d2.depNum
	AND d2.depName = N'Phòng phần mềm trong nước'
	AND e.empSSN = d1.empSSN

SELECT *
FROM tblDependent
WHERE empSSN IN (SELECT empSSN
				FROM tblEmployee
				WHERE depNum = (SELECT depNum
								FROM tblDepartment
								WHERE depName = N'Phòng phần mềm trong nước'
								)
				)

--3. Tìm thông tin con gái của trường Phòng phần mềm trong nước
SELECT d1. *
FROM tblDependent d1, tblDepartment d2
WHERE d1.empSSN = d2.mgrSSN
	AND d2.depName = N'Phòng phần mềm trong nước'
	AND d1.depSex = 'F'
	AND d1.depRelationship = N'Con'

--4. Tìm nhân viên của Phòng phần mềm trong nước và tham gia dự án PROJECTA
SELECT	e.*
FROM	tblEmployee e, tblDepartment dpm, 
		tblWorksOn wo, tblProject prj
WHERE dpm.depNum = e.depNum
	AND e.empSSN = wo.empSSN
	AND wo.proNum = prj.proNum
	AND prj.proName = N'ProjectA'
	AND dpm.depName = N'Phòng phần mềm trong nước'

-- T1: mọi NV thuộc PPMTN
SELECT	e.*
FROM tblEmployee e, tblDepartment dpm 
WHERE dpm.depNum = e.depNum
	AND dpm.depName = N'Phòng phần mềm trong nước'

INTERSECT

-- T2: Mọi NV tham gia ProjectA
SELECT	e.*
FROM	tblWorksOn wo, tblProject prj,
		tblEmployee e
WHERE e.empSSN = wo.empSSN
	AND wo.proNum = prj.proNum
	AND prj.proName = N'ProjectA'

--5. Tìm các dự án mà nhân viên Mai Duy An đã tham gia
SELECT prj.	*
FROM	tblProject prj, tblEmployee e, tblWorksOn wo
WHERE	e.empSSN = wo.empSSN
	AND wo.proNum = prj.proNum
	AND e.empName = N'Mai Duy An'

--6. Tìm các dự án có nhiều hơn một nhân viên tham gia
SELECT	DISTINCT wo1.proNum
FROM	tblWorksOn wo1, tblWorksOn wo2
WHERE	wo1.proNum = wo2.proNum
	AND wo1.empSSN <> wo2.empSSN

--7. Tìm nhân viên có lương thấp nhất
SELECT *
FROM tblEmployee e
WHERE e.empSalary <= ALL(SELECT e.empSalary 
						FROM tblEmployee e)

SELECT *
FROM tblEmployee
EXCEPT
SELECT DISTINCT e1.*
FROM tblEmployee e1, tblEmployee e2
WHERE e1.empSalary > e2.empSalary

--8. Tìm nhân viên không là nhân viên có lương thấp nhất
SELECT DISTINCT e1.*
FROM tblEmployee e1, tblEmployee e2
WHERE e1.empSalary > e2.empSalary

SELECT *
FROM tblEmployee e
EXCEPT
SELECT *
FROM tblEmployee e
WHERE e.empSalary <= ALL(SELECT e.empSalary 
						FROM tblEmployee e)

SELECT *
FROM tblEmployee
WHERE empSalary > ANY(SELECT empSalary
					FROM tblEmployee)

--5/ Cho biết tên, mã số, mức lương của nhân viên supervior
SELECT empName, empSSN, empSalary
FROM tblEmployee
WHERE empSSN IN
				(SELECT 	supervisorSSN 
				FROM tblEmployee)

--6/ Cho biết tên, mã số, mức lương của nhân viên normal
SELECT empName, empSSN, empSalary
FROM tblEmployee
WHERE empSSN IN
				(SELECT 	empSSN FROM tblEmployee
				EXCEPT
				SELECT 	supervisorSSN FROM tblEmployee)

SELECT e.empName, e.empSSN, e.empSalary
FROM (SELECT DISTINCT supervisorSSN 
	FROM tblEmployee) v, tblEmployee e
WHERE v.supervisorSSN=e.empSSN

--1/ Tìm trưởng phòng tham gia vào dự án ProjectC
SELECT *
FROM tblWorksOn wo, tblEmployee e, tblProject p, tblDepartment d
WHERE e.depNum = d.depNum
	AND e.empSSN = d.mgrSSN
	AND wo.empSSN = e.empSSN
	AND wo.proNum = p.proNum
	AND p.proName =  N'ProjectC'

--2/ Tìm người phụ thuộc của những 
-- nhân viên Phòng phần mềm trong nước
-- và tham gia vào dự án ProjectA
SELECT *
FROM tblDependent
WHERE empSSN IN(SELECT e.empSSN
				FROM tblEmployee e, tblDepartment d
				WHERE e.depNum = d.depNum
					AND d.depName = N'Phòng phần mềm trong nước'
				INTERSECT
				SELECT e.empSSN
				FROM tblEmployee e, tblWorksOn wo, tblProject p
				WHERE e.empSSN = wo.empSSN
					AND wo.proNum = p.proNum
					AND p.proName = N'ProjectA'
				)

--3/ Tìm người phụ thuộc của những 
-- nhân viên không tham gia vào dự án ProjectA
SELECT d.*
FROM tblEmployee e, tblDependent d
WHERE e.empSSN = d.empSSN
	AND e.empSSN NOT IN (SELECT DISTINCT e.empSSN
						FROM tblEmployee e, tblWorksOn wo, tblProject p
						WHERE wo.proNum = p.proNum
							AND p.proName = N'ProjectA'
							AND e.empSSN = wo.empSSN)

--1/ Tìm những nhân viên không tham gia bất kỳ dự án nào
-- thông tin yêu cầu: mã số, tên nhân viên, tên phòng ban của nhân viêm
SELECT 	e.empSSN, e.empName, d.depName
FROM 	tblEmployee e, tblDepartment d
WHERE	e.depNum = d.depNum 
	AND	e.empSSN IN (SELECT e.empSSN
					FROM 	tblEmployee e
					EXCEPT
					SELECT 	empSSN
					FROM 	tblWorksOn)

SELECT 	e.empSSN, e.empName, d.depName
FROM 	tblEmployee e, tblDepartment d, (SELECT e.empSSN FROM tblEmployee e
										EXCEPT
										SELECT 	empSSN FROM tblWorksOn) a
WHERE	e.depNum = d.depNum 
	AND	e.empSSN = a.empSSN 

--2/ Tìm những dự án mà nhân viên không có người phụ thuộc
--tham gia
-- thông tin yêu cầu: mã số, tên nhân viên, tên dự án
SELECT e.empSSN, e.empName, p.proName
FROM	(SELECT empSSN
		FROM tblEmployee
		EXCEPT
		SELECT empSSN
		FROM tblDependent) r1, tblWorksOn wo, tblEmployee e, tblProject p
WHERE r1.empSSN = wo.empSSN
	AND e.empSSN = r1.empSSN
	AND wo.proNum = p.proNum

--3/ Tìm hiểu lý do:
SELECT 	empSSN FROM tblEmployee
EXCEPT
SELECT 	supervisorSSN FROM tblEmployee
--
SELECT 	empSSN 
FROM tblEmployee
WHERE empSSN NOT IN (SELECT supervisorSSN 
					FROM tblEmployee
					WHERE supervisorSSN IS NOT NULL)

----------------------------------------------------------
/*7*/
SELECT 	*
FROM 	tblEmployee, tblDepartment
WHERE	tblEmployee.depNum=tblDepartment.depNum AND tblDepartment.depName LIKE N'Phòng phần mềm trong nước';


SELECT 	*
FROM 	tblEmployee e, tblDepartment d
WHERE	e.depNum=d.depNum AND d.depName LIKE N'Phòng phần mềm trong nước';

----------------------------------------------------------
/*9*/
SELECT 	DISTINCT w1.proNum AS 'Project Number'
FROM 	tblWorksOn  w1, tblWorksOn  w2
WHERE	w1.proNum=w2.proNum AND w1.empSSN<>w2.empSSN

SELECT 	e1.empName AS 'Employee Name', e2.empName AS 'Supervisor Name', e1.supervisorSSN, e2.empSSN
FROM 	tblEmployee e1, tblEmployee e2
WHERE	e1.empName=N'Mai Duy An' AND e1.supervisorSSN=e2.empSSN

----------------------------------------------------------
/*10.1*/
SELECT 	* FROM tblEmployee WHERE empName LIKE 'H%'
UNION
SELECT 	* FROM tblEmployee WHERE empSalary > 80000

--Phép trên là Hội -OR- còn dưới này là Và -AND
SELECT *
FROM tblEmployee
WHERE empName LIKE 'H%'
	AND empSalary > 80000

SELECT *
FROM tblEmployee
WHERE empName LIKE 'H%'
	OR empSalary > 80000

----------------------------------------------------------
/*10.2*/
SELECT 	empSSN FROM tblEmployee
EXCEPT
SELECT 	supervisorSSN FROM tblEmployee

----------------------------------------------------------
/*10.3*/
SELECT 	empSSN 
FROM 	tblWorksOn w, tblProject p
WHERE 	w.proNum=p.proNum AND p.proName='ProjectB'
INTERSECT
SELECT 	empSSN 
FROM 	tblWorksOn w, tblProject p
WHERE 	w.proNum=p.proNum AND p.proName='ProjectC'
--INTERSECT = AND
SELECT 	w1.empSSN 
FROM 	tblWorksOn w1, tblProject p1, tblWorksOn w2, tblProject p2
WHERE 	w1.proNum = p1.proNum 
	AND p1.proName = 'ProjectB' 
	AND w2.proNum = p2.proNum
	AND p2.proName = 'ProjectC'
	AND w1.empSSN = w2.empSSN

----------------------------------------------------------
/*11*/
SELECT 	*
FROM 	tblEmployee e, tblDepartment d
WHERE	e.depNum=d.depNum AND d.depName LIKE N'Phòng phần mềm trong nước';
--
SELECT 	*
FROM 	tblEmployee
WHERE 	depNum = (SELECT depNum 
					FROM tblDepartment 
					WHERE depName=N'Phòng phần mềm trong nước');
SELECT 	*
FROM 	tblEmployee
WHERE 	depNum = ANY (SELECT depNum 
					FROM tblDepartment 
					WHERE depName=N'Phòng phần mềm trong nước');
SELECT 	*
FROM 	tblEmployee
WHERE 	depNum IN (SELECT depNum 
					FROM tblDepartment 
					WHERE depName=N'Phòng phần mềm trong nước');


--Nhân viên lương cao nhất/thấp nhất
SELECT 	*
FROM 	tblEmployee
WHERE 	empSalary>=ALL (SELECT  empSalary
					FROM  tblEmployee);

SELECT 	*
FROM 	tblEmployee
WHERE 	empSalary<=ALL (SELECT  empSalary
					FROM  tblEmployee);
----------------------------------------------------------
/*12*/
SELECT *
FROM 	tblProject 
WHERE 	locNum = (SELECT locNum
				FROM tblProject 
				WHERE proName='ProjectA');

----------------------------------------------------------
/*13*/
SELECT 	*
FROM 	tblEmployee
WHERE 	depNum = (SELECT depNum 
					FROM tblDepartment 
					WHERE depName=N'Phòng phần mềm trong nước');
--cùng kết quả
SELECT 	*
FROM 	tblEmployee e, (SELECT depNum 
					FROM tblDepartment 
					WHERE depName=N'Phòng phần mềm trong nước') d
WHERE 	e.depNum=d.depNum

----------------------------------------------------------
/*15.1 theta join with equation condition */
SELECT *
FROM tblDepartment d JOIN tblEmployee e ON d.depNum=e.depNum

SELECT *
FROM	tblDependent d JOIN tblEmployee e ON d.empSSN=e.empSSN

----------------------------------------------------------
/*15.2 theta join with other condition */
SELECT *
FROM	tblDependent d JOIN tblEmployee e ON d.empSSN<>e.empSSN

SELECT *
FROM	tblDependent d JOIN tblEmployee e ON d.empSSN>e.empSSN

----------------------------------------------------------
/*15.3 cross join */
SELECT *
FROM	tblDependent CROSS JOIN tblEmployee

----------------------------------------------------------
/*17.1*/
SELECT l.locNum, l.locName, p.proNum, p.proName
FROM tblLocation l LEFT OUTER JOIN tblProject p ON l.locNum=p.locNum

SELECT *
FROM	tblEmployee e LEFT OUTER JOIN tblDependent d ON e.empSSN=d.empSSN

SELECT *
FROM	tblDependent d RIGHT OUTER JOIN tblEmployee e ON e.empSSN=d.empSSN

----------------------------------------------------------
/*17.2*/
SELECT d.depName, p.proName
FROM tblDepartment d LEFT OUTER JOIN tblProject p ON d.depNum=p.depNum

----------------------------------------------------------
/*17.3*/
SELECT l.locNum, l.locName
FROM tblLocation l JOIN tblProject p ON l.locNum=p.locNum

SELECT l.locNum, l.locName
FROM tblLocation l JOIN tblProject p ON l.locNum=p.locNum

----------------------------------------------------------
/*18.1*/
SELECT AVG(empSalary) AS Average_Of_Salary
FROM tblEmployee

--Cho biết tổng lương phải trả cho mỗi phòng ban
SELECT depNum, SUM(empSalary) AS TongLuong
FROM tblEmployee
GROUP BY depNum

--Cho biết trung binh lương phải trả cho mỗi phòng ban
SELECT depNum, AVG(empSalary) AS TBLuong
FROM tblEmployee
GROUP BY depNum

--0. Cho biết trung bình lương phải trả cho nam nhân viên của mỗi phòng ban
SELECT depNum, AVG(empSalary) AS TBLuong
FROM tblEmployee
WHERE tblEmployee.empSex = 'M'
GROUP BY depNum

-- 1/ Cho biết trung bình lương phải trả
-- cho nam nhân viên của mỗi phòng ban
-- Thông tin yêu cầu: mã phòng ban, tên phòng ban, TB lương
SELECT d.depNum, d.depName , AVG(empSalary) AS TBLuong
FROM tblEmployee e, tblDepartment d
WHERE e.empSex = 'M'
	AND e.depNum = d.depNum
GROUP BY d.depNum, d.depName

--Cách kỳ
SELECT d.depNum, MIN(d.depName) , AVG(empSalary) AS TBLuong
FROM tblEmployee e, tblDepartment d
WHERE e.empSex = 'M'
	AND e.depNum = d.depNum
GROUP BY d.depNum

--Tìm cách khác tốt hơn (truy vấn con)
SELECT d.depName, ed.depNum, ed.TBLuong
FROM tblDepartment d, (SELECT d.depNum, AVG(empSalary) AS TBLuong
						FROM tblEmployee e, tblDepartment d
						WHERE e.empSex = 'M'
							AND e.depNum = d.depNum
						GROUP BY d.depNum) ed
WHERE d.depNum = ed.depNum

SELECT d.depNum, d.depName, r1.TBLuong
FROM (SELECT depNum, AVG(empSalary) AS TBLuong
	FROM tblEmployee
	WHERE empSex = 'M'
	GROUP BY depNum)r1, tblDepartment d
WHERE r1.depNum = d.depNum

-- 2/ Cho biết phòng ban nào có trung bình lương phải trả
-- cho nam nhân viên nhiều hơn 90000
-- Thông tin yêu cầu: mã phòng ban, tên phòng ban, TB lương
SELECT depNum, AVG(empSalary) AS TBLuong
FROM tblEmployee
WHERE empSex = 'M'
GROUP BY depNum
HAVING AVG(empSalary) > 90000
--Suy ra
SELECT r1.TBLuong, d.depNum, d.depName
FROM (SELECT depNum, AVG(empSalary) AS TBLuong
FROM tblEmployee
WHERE empSex = 'M'
GROUP BY depNum
HAVING AVG(empSalary) > 90000)r1, tblDepartment d
WHERE r1.depNum = d.depNum


--1/ Cho biết tổng số giờ làm của nhân viên
-- không có người phụ thuộc
-- mã số, họ tên, tổng giờ làm, phòng ban

SELECT r1.empSSN, SUM(w.workHours) AS TGL
FROM (SELECT empSSN
		FROM tblEmployee
		EXCEPT
		SELECT empSSN
		FROM tblDependent)r1, tblWorksOn w
WHERE r1.empSSN = w.empSSN
GROUP BY r1.empSSN

SELECT n.empSSN, e.empName, n.TGL, d.depName
FROM tblEmployee e, tblDepartment d, (SELECT r1.empSSN, SUM(w.workHours) AS TGL
									FROM (SELECT empSSN
											FROM tblEmployee
											EXCEPT
											SELECT empSSN
											FROM tblDependent)r1, tblWorksOn w
									WHERE r1.empSSN = w.empSSN
									GROUP BY r1.empSSN) n
WHERE e.empSSN = n.empSSN
	AND e.depNum = d.depNum

--2/ Cho biết nhân viên không có người phụ thuộc nào
-- Là nhân viên có tổng số giờ làm nhiều nhất
-- mã số, họ tên, tổng giờ, phòng ban
SELECT empSSN
FROM tblEmployee
EXCEPT
SELECT empSSN
FROM tblDependent
--
SELECT r1.empSSN, SUM(w.workHours) AS TG
FROM (SELECT empSSN
	FROM tblEmployee
	EXCEPT
	SELECT empSSN
	FROM tblDependent) r1, tblWorksOn w
WHERE r1.empSSN = w.empSSN
GROUP BY r1.empSSN
--
SELECT MAX(r1.TG)
FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
		FROM (SELECT empSSN
			FROM tblEmployee
			EXCEPT
			SELECT empSSN
			FROM tblDependent) r1, tblWorksOn w
		WHERE r1.empSSN = w.empSSN
		GROUP BY r1.empSSN)r1
--
SELECT r2.*
FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
		FROM (SELECT empSSN
			FROM tblEmployee
			EXCEPT
			SELECT empSSN
			FROM tblDependent) r1, tblWorksOn w
		WHERE r1.empSSN = w.empSSN
		GROUP BY r1.empSSN)r2
WHERE r2.TG = (SELECT MAX(r1.TG)
				FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
						FROM (SELECT empSSN
							FROM tblEmployee
							EXCEPT
							SELECT empSSN
							FROM tblDependent) r1, tblWorksOn w
						WHERE r1.empSSN = w.empSSN
						GROUP BY r1.empSSN)r1)
--
SELECT e.empSSN, e.empName, n.TG, d.depName
FROM tblEmployee e, tblDepartment d, (SELECT r2.*
										FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
												FROM (SELECT empSSN
													FROM tblEmployee
													EXCEPT
													SELECT empSSN
													FROM tblDependent) r1, tblWorksOn w
												WHERE r1.empSSN = w.empSSN
												GROUP BY r1.empSSN)r2
										WHERE r2.TG = (SELECT MAX(r1.TG)
														FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
																FROM (SELECT empSSN
																	FROM tblEmployee
																	EXCEPT
																	SELECT empSSN
																	FROM tblDependent) r1, tblWorksOn w
																WHERE r1.empSSN = w.empSSN
																GROUP BY r1.empSSN)r1)) n
WHERE e.empSSN = n.empSSN
	AND e.depNum = d.depNum

--3/ Cho biết nhân viên có người phụ thuộc nào
-- Là nhân viên có tổng số giờ làm nhiều nhất
-- mã số, họ tên, tổng giờ, phòng ban, tổng người phụ thuộc
SELECT empSSN, COUNT(*) AS TSNPT
FROM tblDependent
GROUP BY empSSN
--
SELECT MAX(r1.TG)
FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
		FROM (SELECT empSSN
			FROM tblDependent) r1, tblWorksOn w
		WHERE r1.empSSN = w.empSSN
		GROUP BY r1.empSSN) r1
--
SELECT r2.*
FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
	FROM (SELECT empSSN
		FROM tblDependent) r1, tblWorksOn w
	WHERE r1.empSSN = w.empSSN
	GROUP BY r1.empSSN)r2
WHERE r2.TG = (SELECT MAX(r1.TG)
				FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
						FROM (SELECT empSSN
							FROM tblDependent) r1, tblWorksOn w
						WHERE r1.empSSN = w.empSSN
						GROUP BY r1.empSSN) r1)
--
SELECT e.empSSN, e.empName, n.TG, d.depName, m.TSNPT
FROM tblEmployee e, tblDepartment d, (SELECT r2.*
									  FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
										    FROM (SELECT empSSN FROM tblDependent) r1, tblWorksOn w
										    WHERE r1.empSSN = w.empSSN
										    GROUP BY r1.empSSN)r2
									  WHERE r2.TG = (SELECT MAX(r1.TG)
													 FROM (SELECT r1.empSSN, SUM(w.workHours) AS TG
															FROM (SELECT empSSN FROM tblDependent) r1, tblWorksOn w
															WHERE r1.empSSN = w.empSSN
															GROUP BY r1.empSSN) r1)) n, (SELECT empSSN, COUNT(*) AS TSNPT
																						 FROM tblDependent
																						 GROUP BY empSSN) m
WHERE e.empSSN = n.empSSN
	AND e.depNum = d.depNum
	AND e.empSSN = m.empSSN

----------------------------------------------------------
/*18.2*/
SELECT COUNT(*) AS Count_Of_Employees
FROM tblEmployee

----------------------------------------------------------
/*19.1, 19.2*/
SELECT *
FROM tblEmployee
ORDER BY depNum

SELECT depNum, COUNT(empSSN) AS Num_Of_Employees
FROM 	tblEmployee
GROUP BY depNum
ORDER BY COUNT(*) ASC

SELECT depNum, COUNT(*) AS Num_Of_Employees
FROM 	tblEmployee
GROUP BY depNum
ORDER BY COUNT(*) ASC

----------------------------------------------------------
/*20*/
SELECT proNum, COUNT(empSSN) AS Number_Of_Employees, SUM(workHours) AS Total_OfworkHours
FROM  tblWorksOn 
GROUP BY proNum

----------------------------------------------------------
/*21*/
SELECT depNum, AVG(empSalary)  AS Average_Of_Salary
FROM  tblEmployee
GROUP BY depNum
HAVING AVG(empSalary) > 80000

SELECT proNum, COUNT(empSSN) AS Number_Of_Employees, SUM(workHours) AS Total_OfworkHours
FROM  tblWorksOn 
GROUP BY proNum
HAVING COUNT(empSSN)>4

SELECT proNum, COUNT(empSSN) AS Number_Of_Employees, SUM(workHours) AS Total_OfworkHours
FROM  tblWorksOn 
GROUP BY proNum
HAVING AVG(workHours)>20

GO

SELECT proNum, COUNT(empSSN) AS Number_Of_Employees, SUM(workHours) AS Total_OfworkHours
FROM  tblWorksOn 
GROUP BY proNum
HAVING proNum=4

----------------------------------------------------------
/*22*/
SELECT	* 
FROM	tblDepartment

INSERT INTO tblDepartment(depNum,depName)
VALUES(6, N'Phòng Kế Toán');

SELECT	* 
FROM	tblDepartment

INSERT INTO tblDepartment
VALUES(7, N'Phòng Nhân Sự', NULL, NULL);

SELECT	* 
FROM	tblDepartment

----------------------------------------------------------
/*23*/
DELETE 
FROM	tblDepartment
WHERE	depName=N'Phòng Kế Toán'

DELETE 
FROM	tblDepartment
WHERE	depNum=7

SELECT	* 
FROM	tblDepartment

DELETE FROM tblEmployee
WHERE depNum IN (SELECT depNum
				FROM tblDepartment
				WHERE depName = N'Phòng phần mềm trong nước')

----------------------------------------------------------
/*24*/
SELECT	*
FROM	tblEmployee
WHERE	empName=N'Mai Duy An'

UPDATE	tblEmployee
SET		empSalary=empSalary+5000, depNum=2
WHERE	empName=N'Mai Duy An'

-- Chuyển nhân viên thuộc phòng phần mềm trong nước sang phòng Kế Toán đồng thời tăng lương lên 1000
UPDATE tblEmployee
SET depNum = (SELECT depNum
			FROM tblDepartment
			WHERE depName LIKE N'Phòng kế toán'), empSalary += 1000
WHERE depNum IN (SELECT depNum
				FROM tblDepartment
				WHERE depName = N'Phòng phần mềm trong nước')

----------------------------------------------------------
/*25*/
SELECT	empName, empSalary
FROM	tblEmployee
WHERE	depNum IN
				(SELECT	depNum
				FROM	tblDepartment
				WHERE	depName=N'Phòng Phần mềm trong nước')

UPDATE	tblEmployee
SET	empSalary=empSalary*1.1
WHERE	depNum IN
				(SELECT	depNum
				FROM	tblDepartment
				WHERE	depName=N'Phòng Phần mềm trong nước')


---------------------------------------------------------------
-- LAB4
-- 1. Cho biết phòng ban nào làm việc cùng vị trí với phòng Phòng Nghiên cứu và phát triển
-- Thông tin yêu cầu: mã số, tên phòng ban
SELECT DISTINCT d1.depNum, d1.depName
FROM tblDepartment d1, tblDepLocation d2
WHERE d1.depNum = d2.depNum
	AND d2.locNum IN (SELECT DISTINCT d2.locNum
					FROM tblDepartment d1, tblDepLocation d2
					WHERE d1.depNum = d2.depNum
						AND d1.depName = N'Phòng Nghiên cứu và phát triển')

-- 2. Tìm những người phụ thuộc của nhân viên giữ vai trò supervior
-- Thông tin yêu cầu: họ tên, giới tính của người phụ thuộc
SELECT d.depName, d.depSex
FROM tblEmployee e, tblDependent d
WHERE d.empSSN = e.empSSN
	AND e.supervisorSSN IN (SELECT supervisorSSN
							FROM tblEmployee)

-- 3. Cho biết những trưởng phòng nào tham gia nhiều hơn ba dự án
-- Thông tin yêu cầu: mã số, họ tên , tên phòng ban quản lý
SELECT e.empSSN, e.empName, d.depName
FROM tblEmployee e, tblDepartment d, (SELECT e.empSSN, COUNT(w.proNum) AS projects
									FROM tblEmployee e, tblWorksOn w, tblProject p
									WHERE e.empSSN = w.empSSN
										AND w.proNum = p.proNum
										AND e.empSSN IN (SELECT mgrSSN
														FROM tblDepartment)
									GROUP BY e.empSSN) ewp
WHERE e.empSSN = ewp.empSSN
	AND d.mgrSSN = e.empSSN
	AND ewp.projects > 3

-- 4. Cho biết tổng số giờ làm của các nhân viên, mà các nhân viên này không có người phụ thuộc
-- Thông tin yêu cầu: mã nhân viên, họ tên nhân viên, tổng số giờ làm
SELECT ee.empSSN, ee.empName, ewt.tonggio
FROM (SELECT e.empSSN, SUM(w.workHours) AS tonggio
	FROM tblEmployee e JOIN tblWorksOn w ON e.empSSN = w.empSSN
	GROUP BY e.empSSN) ewt JOIN (SELECT e.empSSN, e.empName
								FROM tblEmployee e JOIN (SELECT empSSN
														FROM tblEmployee
														EXCEPT
														SELECT empSSN
														FROM tblDependent) ee ON e.empSSN = ee.empSSN) ee ON ewt.empSSN = ee.empSSN

-- 5. Cho biết nhân viên giữ vai trò supervior nào chưa hề tham gia bất kỳ dự án nào
-- Thông tin yêu cầu: mã số, họ tên, mức lương
SELECT empSSN, empName, empSalary
FROM tblEmployee
WHERE empSSN IN (SELECT empSSN
				FROM tblEmployee
				WHERE empSSN NOT IN (SELECT DISTINCT empSSN
									FROM tblWorksOn w JOIN tblProject p ON w.proNum = p.proNum)
				EXCEPT
				SELECT empSSN
				FROM tblEmployee
				WHERE supervisorSSN IN (SELECT supervisorSSN
										FROM tblEmployee))
---------------------------------------------------------------------------------------------------------------

-- 1.
use FUH_COMPANY

SELECT d.depName, d.depBirthdate, e.empName
FROM tblDependent d JOIN tblEmployee e on e.empSSN = d.empSSN
WHERE YEAR(GETDATE())-YEAR(d.depBirthdate) > 18

-- 2.
SELECT d.depNum, l.locName
FROM tblDepLocation d JOIN tblLocation l on d.locNum = l.locNum

SELECT d.depNum, d.depName, dl.locName
FROM tblDepartment d JOIN (SELECT d.depNum, l.locName
						   FROM tblDepLocation d JOIN tblLocation l on d.locNum = l.locNum) dl on d.depNum = dl.depNum
WHERE d.depName = N'Phòng Nghiên cứu và phát triển'

-- 3
SELECT depRelationship, COUNT(*) AS 'Số lượng người phụ thuộc'
FROM tblDependent
GROUP BY depRelationship


-- 4
SELECT e.empSSN
FROM tblWorksOn w, tblEmployee e, tblProject p
WHERE e.empSSN = w.empSSN
	AND w.proNum = p.proNum
	AND p.proName != N'ProjectA'

SELECT DISTINCT d.depNum, d.depName
FROM tblDepartment d, tblEmployee e JOIN (SELECT e.empSSN
										FROM tblWorksOn w, tblEmployee e, tblProject p
										WHERE e.empSSN = w.empSSN
											AND w.proNum = p.proNum
											AND p.proName != N'ProjectA') wep on e.empSSN = wep.empSSN
WHERE d.depNum = e.depNum


-- 5
SELECT d.depNum ,COUNT(*) AS 'Số dự án'
FROM tblProject p JOIN tblDepartment d on p.depNum = d.depNum
GROUP BY d.depNum

SELECT MIN(pd.[Số dự án]) AS 'min'
FROM (SELECT d.depNum ,COUNT(*) AS 'Số dự án'
	FROM tblProject p JOIN tblDepartment d on p.depNum = d.depNum
	GROUP BY d.depNum) pd

SELECT d.depNum, d.depName, pd.[Số dự án]
FROM tblDepartment d, (SELECT MIN(pd.[Số dự án]) AS 'min'
					FROM (SELECT d.depNum ,COUNT(*) AS 'Số dự án'
						FROM tblProject p JOIN tblDepartment d on p.depNum = d.depNum
						GROUP BY d.depNum) pd) m, (SELECT d.depNum ,COUNT(*) AS 'Số dự án'
												FROM tblProject p JOIN tblDepartment d on p.depNum = d.depNum
												GROUP BY d.depNum) pd
WHERE d.depNum = pd.depNum
	AND pd.[Số dự án] = m.min

GO

select top 1 with ties d.depNum, d.depName, count(p.proNum) as 'Số lượng dự án' 
from tblDepartment as d join tblProject as p on d.depNum=p.depNum 
group by d.depNum, d.depName 
order by count(p.proNum) asc








