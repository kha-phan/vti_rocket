DROP DATABASE IF EXISTS `TestingSystem1`;
CREATE DATABASE `TestingSystem1`;
USE `TestingSystem1`;
COMMIT;

/*============================== QUERY DATA (10 TABLES) =============================*/
/*======================================================================================*/

-- Create table 1: Department2
DROP TABLE IF EXISTS `Department2`;
CREATE TABLE `Department2` (
    `DepartmentID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `DepartmentName` NVARCHAR(20) NOT NULL UNIQUE
);

-- Create table 2: Position2
DROP TABLE IF EXISTS `Position2`;
CREATE TABLE `Position2` (
    `PositionID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `PositionName` ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL
);

-- Create table 3: Account2
DROP TABLE IF EXISTS `Account2`;
CREATE TABLE `Account2` (
    `AccountID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Email` VARCHAR(50) NOT NULL UNIQUE KEY,
    `Username` VARCHAR(50) NOT NULL UNIQUE KEY,
    `FullName` VARCHAR(50) NOT NULL,
    `DepartmentID` TINYINT UNSIGNED NOT NULL,
    `PositionID` TINYINT UNSIGNED NOT NULL,
    `CreateDate` DATETIME DEFAULT NOW (),
    FOREIGN KEY (`DepartmentID`)
        REFERENCES Department2 (`DepartmentID`),
    FOREIGN KEY (`PositionID`)
        REFERENCES Position2 (`PositionID`)
);

-- Create table 4: Group2
DROP TABLE IF EXISTS `Group2`;
CREATE TABLE `Group2` (
    `GroupID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `GroupName` NVARCHAR(50) NOT NULL,
    `CreatorID` TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    `CreateDate` DATETIME DEFAULT NOW ()
);

-- Create table 5: GroupAccount2
DROP TABLE IF EXISTS `GroupAccount2`;
CREATE TABLE `GroupAccount2` (
    `GroupAccountID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `GroupID` TINYINT UNSIGNED NOT NULL,
    `AccountID` TINYINT UNSIGNED NOT NULL,
    `JoinDate` DATETIME DEFAULT NOW (),
    FOREIGN KEY (`AccountID`)
        REFERENCES Account2 (`AccountID`),
    FOREIGN KEY (`GroupID`)
        REFERENCES Group2 (`GroupID`)
);

-- Create table 6: TypeQuestion2
DROP TABLE IF EXISTS `TypeQuestion2`;
CREATE TABLE `TypeQuestion2` (
    `TypeID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `TypeName` ENUM('Essay', 'Multiple-Choice') NOT NULL
);

-- Create table 7: CategoryQuestion2
DROP TABLE IF EXISTS `CategoryQuestion2`;
CREATE TABLE `CategoryQuestion2` (
    `CategoryID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `CategoryName` NVARCHAR(50) NOT NULL UNIQUE
);

-- Create table 8: Question2
DROP TABLE IF EXISTS `Question2`;
CREATE TABLE `Question2` (
    `QuestionID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Content` NVARCHAR(50) NOT NULL,
    `CategoryID` TINYINT UNSIGNED NOT NULL,
    `TypeID` TINYINT UNSIGNED NOT NULL,
    `CreatorID` TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    `CreateDate` DATETIME NOT NULL DEFAULT NOW (),
    FOREIGN KEY (`CategoryID`)
        REFERENCES CategoryQuestion2 (`CategoryID`),
    FOREIGN KEY (`TypeID`)
        REFERENCES TypeQuestion2 (`TypeID`)
);

-- Create table 9: Answer2
DROP TABLE IF EXISTS Answer2;
CREATE TABLE Answer2 (
    `AnswerID` TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Content` NVARCHAR(50) NOT NULL,
    `QuestionID` TINYINT UNSIGNED NOT NULL,
    `isCorrect` BIT NOT NULL,
    FOREIGN KEY (QuestionID)
        REFERENCES Question2 (QuestionID)
)

-- Create table 10: Exam2
DROP TABLE IF EXISTS `Exam2`;
CREATE TABLE `Exam2`(
    `ExamID`					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(7) UNIQUE KEY NOT NULL,
    `Title`					NVARCHAR(50) NOT NULL,
    `CategoryID`				TINYINT UNSIGNED NOT NULL,
    `Duration`				TINYINT UNSIGNED NOT NULL,
    `CreatorID`				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    `CreateDate`				DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY(`CategoryID`) 	REFERENCES CategoryQuestion2(`CategoryID`)
);

-- Create table 11: ExamQuestion2
DROP TABLE IF EXISTS `ExamQuestion2`;
CREATE TABLE `ExamQuestion2`(
    `ExamID`				TINYINT UNSIGNED AUTO_INCREMENT,
	`QuestionID`			TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY(`ExamID`) 	REFERENCES Exam2(`ExamID`),
	FOREIGN KEY(`QuestionID`) 	REFERENCES Question2(`QuestionID`)
);

/*============================== ADD DATA INTO TABLE =================================*/
/*======================================================================================*/
-- Add data into Department2
INSERT INTO Department2(DepartmentName) VALUE
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);

-- Add data into position2
INSERT INTO Position2	(PositionName	)
VALUE 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			);


-- Add data into Account2
INSERT INTO Account2(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUE 				('haidang29productions@gmail.com'	, 'dangblack'		,'Nguyen Hai Dang'		,   '5'			,   '1'		,'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Tong Quang Anh'		,   '1'			,   '2'		,'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Nguyen Van Chien'		,   '2'			,   '3'		,'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Duong Do'				,   '3'			,   '4'		,'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Nguyen Chien Thang'	,   '4'			,   '4'		,'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Ngo Ba Kha'			,   '6'			,   '3'		,'2020-04-05'),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Bui Xuan Huan'		,   '7'			,   '2'		,'2020-04-05'),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Nguyen Thanh Tung'	,   '8'			,   '1'		,'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Duong Van Huu'		,   '9'			,   '2'		,'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Vi Ti Ai'				,   '10'		,   '1'		,'2020-04-09');

-- Add data into Group2
INSERT INTO Group2	(  GroupName			, CreatorID		, CreateDate)
VALUE 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Developement'		,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 02'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Add data into GroupAccount2
INSERT INTO GroupAccount2	(  GroupID	, AccountID	, JoinDate	 )
VALUE 						(	1		,    1		,'2019-03-05'),
							(	2		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	4		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	6		,    6		,'2020-04-06'),
							(	7		,    7		,'2020-04-07'),
							(	8		,    8		,'2020-04-08'),
							(	9		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');


-- Add data into TypeQuestion2
INSERT INTO TypeQuestion2	(TypeName			)
VALUE 						('Essay'			),
							('Multiple-Choice'	);


-- Add data into CategoryQuestion2
INSERT INTO CategoryQuestion2		(CategoryName	)
VALUE 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);

-- Add data into Question2
INSERT INTO Question2	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUE 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '1'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data into Answers2
INSERT INTO Answer2	(  Content		, QuestionID	, isCorrect	)
VALUE 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   1			,	1		),
                    (N'Trả lời 03'	,   1			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);

-- Add data into Exam2
INSERT INTO Exam2	(Code			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUE 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '1'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');

-- Add data into ExamQuestion2
INSERT INTO ExamQuestion2(QuestionID)
VALUE 						(1),
							(2),
							(3),
							(4),
							(5),
							(6),
							(7),
							(8),
							(9),
							(10);


/*============================== QUERY DATA ======================================*/
/*======================================================================================*/


-- Question 2: Lấy tất cả các phòng ban
SELECT * FROM Department2;

-- Question 3: Lấy ra id của phòng ban "Sale"
SELECT 	DepartmentID
FROM 	Department2
WHERE 	DepartmentName = N'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất và sắp xếp chúng theo thứ tự giảm dần
SELECT 	*
FROM 	Account2
WHERE 	LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM Account2)
ORDER BY Fullname DESC;

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM Account2
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM Account2) AND DepartmentID = 3
ORDER BY Fullname DESC;

-- Question 6: lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName FROM Group2
WHERE CreateDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID
FROM Answer2
GROUP BY QuestionID
HAVING COUNT(QuestionID)>=4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT Code FROM Exam2
WHERE Duration >= 60 AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM Group2
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID) AS 'SO NHAN VIEN' FROM Account2
WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT Fullname FROM Account2
WHERE (SUBSTRING_INDEX(FullName, ' ', -1)) LIKE 'D%o' ;

-- Question 12: xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam2 WHERE CreateDate < '2019-12-20';

-- Question 13: xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- SET FOREIGN_KEY_CHECKS=0;
-- SET SQL_SAFE_UPDATES=0;
DELETE FROM Question2
WHERE (SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';
-- SET SQL_SAFE_UPDATES=0;
-- SET FOREIGN_KEY_CHECKS=1;

-- Question 14: update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE Account2 SET Fullname = N'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
SET FOREIGN_KEY_CHECKS=0;
UPDATE GroupAccount2 SET AccountID = 5 WHERE GroupID = 4;
SET FOREIGN_KEY_CHECKS=1;