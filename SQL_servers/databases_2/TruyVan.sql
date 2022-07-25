--Trần Duy Ngọc Bảo--
USE Assignment

-- Liệt kê tên, id, mật khẩu(trong quản lý)
SELECT a.name, a.userID, s.password
FROM dbo.Account a JOIN dbo.signUp s ON a.userID = s.userID

-- Liệt kê ten những người tham gia dự án và số CMND, vai trò, số tiền đóng góp, tên dự án
SELECT a.name, a.CMND, ac.contMoney, p.proName
FROM dbo.Account a, dbo.Activity ac, dbo.Project p
WHERE a.userID = ac.userID
	AND ac.proID = p.proID

-- Tổng số tiền nhận được của các dự án đã bắt đầu nhận tiền hỗ trợ
SELECT p.proID, SUM(a.contMoney) AS 'Tổng tiền'
FROM dbo.Activity a JOIN dbo.Project p ON a.proID = p.proID
GROUP BY p.proID

-- In SAO KÊ và nội dung
SELECT b.proID,b.content, a.[Sao kê ] 
FROM dbo.Bank_statement b JOIN (SELECT p.proID, SUM(b.usedMoney) AS 'Sao kê '
								FROM dbo.Bank_statement b JOIN dbo.Project p ON b.proID = p.proID
								GROUP BY p.proID
								) a ON b.proID = a.proID

-- Tính số tiền còn lại của dự án
DECLARE @sumMoney MONEY, @used MONEY, @left MONEY
SELECT @sumMoney = SUM(contMoney)
FROM dbo.Activity
WHERE proID = 7
GROUP BY proID

SELECT @used = SUM(usedMoney)
FROM dbo.Bank_statement
WHERE proID = 7
GROUP BY proID

SET @left = 
	CASE @sumMoney
		WHEN 0 THEN 0
		ELSE @sumMoney-@used
	END
PRINT @left