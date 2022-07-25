USE Assignment
GO
SELECT SUSER_SNAME(sid), * from sys.database_principals

USE [Assignment]
GO
ALTER AUTHORIZATION ON DATABASE::[Assignment] TO [sa]
GO
