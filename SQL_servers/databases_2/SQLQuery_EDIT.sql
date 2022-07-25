USE Assignment

IF OBJECT_ID ('INSERT_Account', 'P') IS NOT NULL
	DROP PROCEDURE INSERT_Account;
GO
CREATE PROCEDURE INSERT_Account
	@Aemail NVARCHAR(50),
	@Aphone INT,
	@Aname NVARCHAR(50),
	@AuserID INT,
	@Acmnd INT,
	@Abankacc INT
AS
	INSERT INTO dbo.Account
	VALUES(@Acmnd,@AuserID ,@Aname, @Aemail,@Aphone,@Abankacc );

GO
EXEC INSERT_Account N'baodeptrai@gmail.com', 123, N'Bao Tran', 1, 324, 4543 
EXEC INSERT_Account N'lamlangnhang@gmail.com', 3345, N'Lam Dinh', 2, 435, 5508
EXEC INSERT_Account N'thanhngugat@gmail.com', NULL, N'Thanh Dang', 3, 546, NULL
EXEC INSERT_Account N'vinhdaigia@gmail.com', 8874, N'Vinh Giau', 4, 948, NULL
EXEC INSERT_Account N'khaithe@gmail.com',2342,	N'Khai The', 5 ,	 NULL,3224
EXEC INSERT_Account N'hangnguyen@gmail.com',3438, N'Nguyen Hang',	6,333,2222
EXEC INSERT_Account N'chaubui@gmail.com',1345, N'Chau Bui',	7, 123, 4543
EXEC INSERT_Account N'LisaBlackPink@gmail.com', 45,N'Lisa',	8,	123,4543

ALTER TABLE dbo.Account
ADD CONSTRAINT UC_ID UNIQUE (userID, CMND)

SELECT * FROM dbo.Account
-----------------------------------------------------------------------------------
IF OBJECT_ID ('Insert_Project', 'P') IS NOT NULL
	DROP PROCEDURE Insert_Project;
GO
CREATE PROCEDURE Insert_Project
	@PproName NVARCHAR(150),
	@Pid INT,
	@Pstart DATE,
	@Pend DATE,
	@Pogani NVARCHAR(50),
	@PproId INT
AS
	INSERT INTO dbo.Project
	VALUES(@PproName,@Pid,@Pstart,@Pend,@Pogani,@PproId );

GO
EXEC Insert_Project N'Hỗ trợ lương thực', 1, '2021-08-28', '2021-10-31', N'Trao tiền', 1
EXEC Insert_Project N'Mua sách cho bé', 2, '2021-06-15', '2021-10-25', N'Trao vật chất', 2
EXEC Insert_Project N'Trái tim cho em', 5, '2001-08-27', '2200-12-31', N'Trao tiền', 3
EXEC Insert_Project N'Laptop cho sinh viên', 1, '2020-05-15', '2021-10-12', N'Trao vật chất', 4
EXEC Insert_Project N'Quà tặng cuộc sống'	,NULL,	NULL,	NULL,	N'Trao vật chất',	5
EXEC Insert_Project N'Lương thực cho dân',	8,	'2018-06-23',	'2021-12-12',	N'Trao vật chất',	6
EXEC Insert_Project N'Hỗ trợ sinh viên FPT học phí',	6,	'2021-01-01',	NULL,	N'Trao tiền',	7
EXEC Insert_Project N'Xe đạp cho em',	NULL,	'2007-02-02',	'2022-02-02',	N'Trao vật chất',	8


SELECT * FROM dbo.Project

--------------------------------------------------------------------------
IF OBJECT_ID ('Insert_Activity', 'P') IS NOT NULL
	DROP PROCEDURE Insert_Activity;
GO
CREATE PROCEDURE Insert_Activity
	@ACmoney MONEY,
	@ACrole NVARCHAR(50),
	@ACuserID INT,
	@ACproID INT
AS
	INSERT INTO dbo.Activity
	VALUES(@ACmoney,@ACrole,@ACuserID,@ACproID);

GO
EXEC Insert_Activity 500000, N'Nhà Thiện Nguyện', 1, 1
EXEC Insert_Activity 0, N'Tình nguyện viên', 1, 5
EXEC Insert_Activity 30000000, N'Nhà tài trợ', 8, 7
EXEC Insert_Activity 0, N'Nhà Thiện Nguyện', 4, 8

SELECT * FROM dbo.Activity

ALTER TABLE dbo.Activity
ADD CONSTRAINT UC_ACTII UNIQUE (proID)

ALTER TABLE dbo.Activity
DROP CONSTRAINT UC_ACTI;

---------------------------------------------------------------------------------
IF OBJECT_ID ('Insert_signUp', 'P') IS NOT NULL
	DROP PROCEDURE Insert_signUp;
GO
CREATE PROCEDURE Insert_signUp
	@SuserID INT,
	@Spass NCHAR(50)
AS
	INSERT INTO dbo.signUp
	VALUES(@SuserID, @Spass);

GO
EXEC Insert_signUp 1, weirioweu
EXEC Insert_signUp 2, weirioweu
EXEC Insert_signUp 4, dgdsgsdfwe
EXEC Insert_signUp 5, 2523234
EXEC Insert_signUp 6, werwere
EXEC Insert_signUp 7, 3523324
EXEC Insert_signUp 8, fsdfd523
EXEC Insert_signUp 3, y324hjh23u

SELECT * FROM dbo.signUp

------------------------------------------------------------------------------
IF OBJECT_ID ('Insert_Bank', 'P') IS NOT NULL
	DROP PROCEDURE Insert_Bank;
GO
CREATE PROCEDURE Insert_Bank
	@Btime DATE,
	@Bcontent NVARCHAR(50),
	@BusedMon MONEY,
	@BproID INT,
	@Bstt INT
AS
	INSERT INTO dbo.Bank_statement
	VALUES(@Btime, @Bcontent, @BusedMon, @BproID,@Bstt );

GO

EXEC Insert_Bank '2020-08-06', N'Chuyen tien Dong A', 500000, 1, 1
EXEC Insert_Bank '2021-10-15', N'Chuyen tien mua dung cu', 700000, 8, 2


SELECT * FROM dbo.Bank_statement