/*
----VTI ACCADEMY HOMEWORK
----CREATE BY DANGBLACK
*/
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;
COMMIT;

/*============================== TẠO BẢNG DỮ LIỆU (10 BẢNG) =============================*/
/*======================================================================================*/

-- Tao bang 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(20) NOT NULL UNIQUE
);

-- Tao bang 2: `Position`
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			VARCHAR(50) NOT NULL
);

-- Tao bang 3: `Account`
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID) ON DELETE SET NULL
);

-- Tao bang 4: `Group`
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATETIME DEFAULT NOW()
);

-- Tao bang 5: Group`Account`
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupAccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,			
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED,
    JoinDate				DATETIME DEFAULT NOW(),
	FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE SET NULL,
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID)
);
                            
-- Tao bang 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay','Multiple-Choice') NOT NULL
);

-- Tao bang 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE
);

-- Tao bang 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 	REFERENCES TypeQuestion(TypeID)
);

-- Tao bang 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT NOT NULL, -- 0: Sai, 1: Đúng
    FOREIGN KEY(QuestionID) 	REFERENCES Question(QuestionID)
);

-- Tao bang 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Code					CHAR(7) UNIQUE KEY NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID)
);

-- Tao bang 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED AUTO_INCREMENT,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(ExamID,QuestionID)
);

/*============================== THÊM DỮ LIỆU VÀO BẢNG =================================*/
/*======================================================================================*/
-- Thêm dữ liệu cho bảng Department
INSERT INTO Department	(DepartmentName) VALUE 
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
    
-- Thêm dữ liệu cho bảng `Position`
INSERT INTO `Position`	( PositionName	) 
VALUE 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			); 


-- Thêm dữ liệu cho bảng `Account`
INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUE 				('haidang29productions@gmail.com'	, 'dangblack'		,'Nguyen Hai Dang'		,   '5'			,   '1'		,'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Tong Quang Anh'		,   '1'			,   '2'		,'2020-03-05'),
                    ('`Account`@gmail.com'				, 'vanchien'		,'Nguyen Van Chien'		,   '2'			,   '3'		,'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Duong Do'				,   '3'			,   '4'		,'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Nguyen Chien Thang'	,   '5'			,   '4'		,'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Ngo Ba Kha'			,   '5'			,   '3'		,'2020-04-05'),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Bui Xuan Huan'		,   '7'			,   '2'		,'2020-04-05'),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Nguyen Thanh Tung'	,   '5'			,   '1'		,'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Duong Van Huu'		,   '9'			,   '2'		,'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Vi Ti Ai'				,   '10'		,   '1'		,'2020-04-09');

-- Thêm dữ liệu cho bảng `Group`
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
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

-- Thêm dữ liệu cho bảng Group`Account`
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUE 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');


-- Thêm dữ liệu cho bảng TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUE 						('Essay'			), 
							('Multiple-Choice'	); 


-- Thêm dữ liệu cho CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
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
													
-- Thêm bảng Question
INSERT INTO Question	(Content			, CategoryID, TypeID	, CreatorID	, CreateDate )
VALUE 					(N'Câu hỏi về Java'	,	10		,   '1'		,   '1'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'		,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	10		,   '2'		,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'		,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	1		,   '1'		,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'		,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'		,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'		,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'		,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'		,   '10'	,'2020-04-07');

-- Thêm bảng Answers2
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUE 				(N'Trả lời 01'	,   2			,	0		),
					(N'Trả lời 02'	,   2			,	1		),
                    (N'Trả lời 03'	,   2			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);
	
-- Thêm bảng Exam
INSERT INTO Exam	(Code			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
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
                    
-- Thêm bảng ExamQuestion
INSERT INTO ExamQuestion(QuestionID) 
VALUE 						(1),
							(10), 
							(1), 
							(1), 
							(5), 
							(10), 
							(7), 
							(8), 
							(9), 
							(10); 
-- create procedure
DROP PROCEDURE IF EXISTS sp_delete_department;
DELIMITER $$
	CREATE PROCEDURE sp_delete_department (IN in_DepartmentID TINYINT UNSIGNED)
	BEGIN
		DELETE 
        FROM 	`Account` 
        WHERE 	DepartmentID = in_DepartmentID;
    
		DELETE 
        FROM 	Department 
        WHERE 	DepartmentID = in_DepartmentID;
	END$$
DELIMITER ;

