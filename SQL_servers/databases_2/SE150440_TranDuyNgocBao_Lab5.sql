USE Assignment

IF OBJECT_ID('ass_Change_Name_Project', 'P') IS NOT NULL
	DROP PROCEDURE ass_Change_Name_Project;

GO
CREATE PROCEDURE ass_Change_Name_Project
	@Pnumber INT,
	@PnewName NVARCHAR(50)
AS
	UPDATE dbo.Project
	SET proName = @PnewName
	WHERE proID = @Pnumber

GO
SELECT* FROM dbo.Project
EXECUTE ass_Change_Name_Project 8, N'Xe đạp đến trường'

------------------------------------------------------------------------------------------

IF OBJECT_ID('ass_Count_User_SignUp', 'P') IS NOT NULL
	DROP PROCEDURE ass_Count_User_SignUp;

GO

CREATE PROC ass_Count_User_SignUp
AS
BEGIN
	

	SELECT SUM(c.count) AS 'Total'
	FROM (SELECT COUNT(*) AS 'count'
		FROM dbo.Account
		GROUP BY userID)c
END;

GO

EXEC ass_Count_User_SignUp