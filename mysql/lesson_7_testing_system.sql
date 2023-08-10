USE `TestingSystem`;
/*============================== TRUY VẤN DỮ LIỆU =============================*/
/*======================================================================================*/

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 	Email, Username	, FullName, PositionID, CreateDate, A.DepartmentID, D.DepartmentName
FROM 	`Account` A INNER JOIN Department D
ON 		A.DepartmentID = D.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/03/2020
SELECT	*
FROM	`Account`
WHERE	CreateDate < '2020-03-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT	*
FROM	`Account` A INNER JOIN Position P
ON		A.PositionID = P.PositionID
WHERE	P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		D.DepartmentID, DepartmentName, COUNT(A.DepartmentID) AS 'SO LUONG'
FROM 		`Account` A INNER JOIN Department  D
ON			D.DepartmentID = A.DepartmentID
GROUP BY 	A.DepartmentID
HAVING 		COUNT(A.DepartmentID)>3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM		Question Q INNER JOIN ExamQuestion EQ
ON			Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(Q.Content) = (SELECT		MAX(CountQ)
								FROM
										(SELECT 		COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ INNER JOIN Question Q
										ON				EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.QuestionID) AS MaxContent);

-- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID)
FROM		CategoryQuestion CQ LEFT JOIN Question Q
ON			CQ.CategoryID = Q.CategoryID
GROUP BY	CQ.CategoryID
ORDER BY	CQ.CategoryID ASC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		Q.Content, COUNT(EQ.QuestionID)
FROM		Question Q LEFT JOIN ExamQuestion EQ
ON			EQ.QuestionID = Q.QuestionID
GROUP BY	Q.QuestionID
ORDER BY 	EQ.ExamID ASC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO LUONG'
FROM		Question Q INNER JOIN Answer A
ON			Q.QuestionID = A.QuestionID
GROUP BY	A.QuestionID
HAVING		COUNT(A.QuestionID) =	(SELECT 	MAX(CountQ)
									FROM		(SELECT 		COUNT(A.QuestionID) AS CountQ
												FROM			Answer A RIGHT JOIN  Question Q
												ON				A.QuestionID = Q.QuestionID
												GROUP BY		A.QuestionID) AS MaxCountQ);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT		G.GroupID, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		GroupAccount GA RIGHT JOIN `Group` G
ON			GA.GroupID = G.GroupID
GROUP BY	G.GroupID
ORDER BY	G.GroupID ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		P.PositionID, P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM		Position P INNER JOIN `Account` A
ON			P.PositionID = A.PositionID
GROUP BY 	P.PositionID
HAVING		COUNT(A.PositionID)	=	(SELECT 	MIN(CountP)
									FROM		(SELECT 	COUNT(P.PositionID) AS CountP
												FROM		Position P INNER JOIN `Account` A
												ON			P.PositionID = A.PositionID
												GROUP BY	P.PositionID) AS MinCountP);

-- Question 11: thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 		D.DepartmentID, D.DepartmentName, COUNT(P.PositionID) AS 'SO LUONG'
FROM		Position P INNER JOIN `Account` A
ON			P.PositionID = A.PositionID
INNER JOIN	Department D
ON			A.DepartmentID = D.DepartmentID
GROUP BY	A.DepartmentID
ORDER BY	A.DepartmentID ASC;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 		T.TypeName AS 'LOAI CAU HOI', Q.CreatorID AS 'ID NGUOI TAO', Q.Content AS 'CAU HOI', A.Content AS 'CAU TRA LOI', Q.CreateDate AS 'NGAY TAO'
FROM		Question Q INNER JOIN Answer A
ON			Q.QuestionID = A.QuestionID
INNER JOIN	TypeQuestion T
ON			Q.TypeID = T.TypeID;
-- Question 13: lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT		T.TypeName AS 'LOAI CAU HOI', COUNT(Q.TypeID) AS 'SO LUONG'
FROM		Question Q INNER JOIN TypeQuestion T
ON			Q.TypeID = T.TypeID
GROUP BY	Q.TypeID;
-- Question 14: lấy ra group không có account nào
SELECT		*
FROM		`Group`
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);

-- Question 15: lấy ra group không có account nào
SELECT		*
FROM		`Group`
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);
-- Question 16: lấy ra question không có answer nào
SELECT		*
FROM		Question
WHERE		QuestionID NOT IN
						(SELECT		QuestionID
                        From		Answer);

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT A.FullName
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 1;
-- b) Lấy các account thuộc nhóm thứ 2
SELECT A.FullName
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 2;
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT A.FullName
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 1
UNION
SELECT A.FullName
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GA.GroupID = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn bằng 3 thành viên
SELECT G.GroupName, COUNT(1) AS so_luong
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY(GA.GroupID)
HAVING so_luong >= 3;
-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT G.GroupName, COUNT(1) AS so_luong
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY(GA.GroupID)
HAVING so_luong <= 7;
-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT G.GroupName, COUNT(1) AS so_luong
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY(GA.GroupID)
HAVING so_luong >= 3
UNION
SELECT G.GroupName, COUNT(1) AS so_luong
FROM `Group` G
JOIN GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY(GA.GroupID)
HAVING so_luong <= 7;

/*============================== TRUY VẤN DỮ LIỆU (DB_5_2) =============================*/
/*======================================================================================*/
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW vw_DSNV_Sale
AS
SELECT	A.*, D.DepartmentName
FROM 	`Account` A INNER JOIN `Department` D
ON		A.DepartmentID = D.DepartmentID
WHERE	D.DepartmentName = 'Sale';
SELECT * FROM vw_DSNV_Sale;

-- CHẠY BẰNG CTE
WITH DSNV_Sale AS(
	SELECT	A.*, D.DepartmentName
	FROM 	`Account` A INNER JOIN `Department` D
	ON		A.DepartmentID = D.DepartmentID
	WHERE	D.DepartmentName = 'Sale'
)
SELECT *
FROM DSNV_Sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vw_InfAccountMaxGroup
AS
SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Account` A INNER JOIN GroupAccount GA
ON			A.AccountID = GA.AccountID
GROUP BY	A.AccountID
HAVING		COUNT(GA.AccountID) = (
									SELECT 		COUNT(GA.AccountID)
									FROM		`Account` A INNER JOIN GroupAccount GA
									ON			A.AccountID = GA.AccountID
									GROUP BY	A.AccountID
									ORDER BY	COUNT(GA.AccountID) DESC
									LIMIT		1
								  );
SELECT * FROM vw_InfAccountMaxGroup;

-- CHẠY CTE
WITH MAX_COUNT_ACCOUNTID AS(
	SELECT 		COUNT(GA.AccountID)
	FROM		`Account` A INNER JOIN GroupAccount GA
	ON			A.AccountID = GA.AccountID
	GROUP BY	A.AccountID
	ORDER BY	COUNT(GA.AccountID) DESC
	LIMIT		1
)
SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Account` A INNER JOIN GroupAccount GA
ON			A.AccountID = GA.AccountID
GROUP BY	A.AccountID
HAVING		COUNT(GA.AccountID) = (SELECT * FROM MAX_COUNT_ACCOUNTID);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 18 từ
-- được coi là quá dài) và xóa nó đi (De cu la 300 tu nhung do thiet ke db tu dau nen sua lai 18 tu de demo
CREATE OR REPLACE VIEW vw_ContenTren18Tu
AS
SELECT 	LENGTH(Content)
FROM	Question
WHERE	LENGTH(Content) > 18;
SELECT * FROM vw_ContenTren18Tu;
DROP VIEW vw_ContenTren18Tu;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW vw_DepartmentMaxAccount
AS
SELECT 		D.*, COUNT(A.DepartmentID)
FROM		Department D INNER JOIN `Account` A
ON			D.DepartmentID = A.DepartmentID
GROUP BY	D.DepartmentID
HAVING		COUNT(A.DepartmentID) = (
									SELECT 		COUNT(A.DepartmentID)
									FROM		Department D INNER JOIN `Account` A
									ON			D.DepartmentID = A.DepartmentID
									GROUP BY	D.DepartmentID
									HAVING		COUNT(A.DepartmentID)
                                    ORDER BY	COUNT(A.DepartmentID) DESC
                                    LIMIT		1
                                    );
SELECT * FROM vw_DepartmentMaxAccount;

-- CTE
WITH MAX_COUNT_DEPARTMENTID AS
(
	SELECT 		COUNT(A.DepartmentID)
	FROM		Department D INNER JOIN `Account` A
	ON			D.DepartmentID = A.DepartmentID
	GROUP BY	D.DepartmentID
	HAVING		COUNT(A.DepartmentID)
    ORDER BY	COUNT(A.DepartmentID) DESC
    LIMIT		1
),
COUNT_DEPARTMENTID AS
(
	SELECT 		D.*, COUNT(A.DepartmentID) AS COUNT_DEPARTMENT
	FROM		Department D INNER JOIN `Account` A
	ON			D.DepartmentID = A.DepartmentID
	GROUP BY	D.DepartmentID
	HAVING		COUNT(A.DepartmentID)
)
SELECT 	*
FROM	COUNT_DEPARTMENTID
WHERE	COUNT_DEPARTMENT = (SELECT * FROM MAX_COUNT_DEPARTMENTID);
-- Question 5: Tạo view có chứa tấtr các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vw_QuesHoNguyen
AS
SELECT 		Q.*, A.FullName
FROM 		Question Q INNER JOIN `Account` A
ON			Q.CreatorID = A.AccountID
WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';

SELECT * FROM vw_QuesHoNguyen;
-- Comman Table Expression
WITH QuesHoNguyen AS
(
	SELECT 		Q.*, A.FullName
	FROM 		Question Q INNER JOIN `Account` A
	ON			Q.CreatorID = A.AccountID
	WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen'
)
SELECT * FROM QuesHoNguyen;



/*============================== TRUY VẤN DỮ LIỆU (DB_6_2) =============================*/
/*======================================================================================*/
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_accountOfDepartment;
CREATE PROCEDURE sp_accountOfDepartment
(IN 		in_department_name NVARCHAR(50))
BEGIN
	SELECT 	A.Email, A.Username, A.CreateDate
    FROM	Department D INNER JOIN `Account` A
    ON		D.DepartmentID = A.DepartmentID
    WHERE	DepartmentName = in_department_name;
END$$
DELIMITER ;
Call sp_accountOfDepartment('Sale');
-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_accountOfGroup;
DELIMITER $$
CREATE PROCEDURE sp_accountOfGroup
(IN in_GroupID TINYINT UNSIGNED)
BEGIN
	SELECT 		GA.GroupID, COUNT(GA.AccountID)
    FROM		GroupAccount GA
    WHERE		GA.GroupID = in_GroupID
    GROUP BY	GA.GroupID;
END$$
DELIMITER ;
call testingsystem1.sp_accountOfGroup(1);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_typeQuestionOfMonth;
DELIMITER $$
CREATE PROCEDURE sp_typeQuestionOfMonth()
BEGIN
	SELECT		COUNT(TypeID)
    FROM		Question
    WHERE		MONTH(CreateDate) = Month(NOW());
END$$
DELIMITER ;
call testingsystem1.sp_typeQuestionOfMonth();
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_TypeID_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE sp_TypeID_MaxQuestion()
BEGIN
	WITH MAX_Count_TypeID AS(
		SELECT		COUNT(TypeID)
		FROM		Question
		GROUP BY	TypeID
        ORDER BY	COUNT(TypeID) DESC
		LIMIT 		1
    )
    SELECT 	TypeID
    FROM	Question
    GROUP BY TypeID
    HAVING	COUNT(TypeID) = (SELECT * FROM MAX_Count_TypeID);
END$$
DELIMITER ;
call sp_TypeID_MaxQuestion();
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_findNameByIDTypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_findNameByIDTypeQuestion()
BEGIN
	WITH MAX_Count_TypeID AS(
		SELECT		COUNT(TypeID)
		FROM		Question
		GROUP BY	TypeID
        ORDER BY	COUNT(TypeID) DESC
		LIMIT 		1
    )
    SELECT 	TQ.TypeName
    FROM	Question Q INNER JOIN TypeQuestion TQ
    ON		Q.TypeID = TQ.TypeID
    GROUP BY Q.TypeID
    HAVING	COUNT(Q.TypeID) = (SELECT * FROM MAX_Count_TypeID);
END$$
DELIMITER ;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của
-- người dùng nhập vào

-- Nhập:1 -- Trả về Group có tên chứa chuỗi
-- Nhập:2 -- Trả về User có username chứa chuỗi
DROP PROCEDURE IF EXISTS sp_nameOfGroupOrUserName;
DELIMITER $$
CREATE PROCEDURE sp_nameOfGroupOrUserName
(IN	in_stringInput VARCHAR(50), IN in_select TINYINT)
BEGIN
	IF in_select = 1 THEN
		SELECT 	*
        FROM	`Group`
        WHERE	GroupName LIKE in_stringInput;
	ELSE
		SELECT 	Email, Username, FullName
        FROM	`Account`
        WHERE	Username LIKE in_stringInput;
	END IF;
END$$
DELIMITER ;

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_importInf_Of_Account;
DELIMITER $$
CREATE PROCEDURE sp_importInf_Of_Account
(IN	in_email VARCHAR(50), IN in_fullName NVARCHAR(50))
BEGIN
	DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
    DECLARE PositionID TINYINT UNSIGNED DEFAULT 1;
    DECLARE DepartmentID TINYINT UNSIGNED DEFAULT 10;
    DECLARE CreateDate DATETIME DEFAULT NOW();
	INSERT INTO `Account` 	(Email		,Username, FullName		, DepartmentID,	PositionID,	CreateDate)
    VALUE					(in_email	,Username, in_fullName	, DepartmentID, PositionID, CreateDate);
    SELECT 	*
    FROM 	`Account`A
    WHERE	A.Username = Username;
END$$
DELIMITER ;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS sp_maxContentWithTypeName;
DELIMITER $$
CREATE PROCEDURE sp_maxContentWithTypeID
(IN in_TypeName VARCHAR(15))
BEGIN
	IF (in_TypeName = 'Essay') THEN
		SELECT	Content, MAX(LENGTH(Content))
		FROM	Question
		WHERE	TypeID = 1;
	ELSEIF (in_TypeName = 'Multiple-Choice') THEN
		SELECT	Content, MAX(LENGTH(Content))
		FROM	Question
		WHERE	TypeID = 2;
	END IF;
END$$
DELIMITER ;

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_DeleteExamWithID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteExamWithID
(IN in_ExamID TINYINT UNSIGNED)
BEGIN
	DELETE
    FROM 	Exam
    WHERE	ExamID = in_ExamID;
    SELECT * FROM Exam;
END$$
DELIMITER ;
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi, sau đó in số lượng record đã remove từ các table liên quan
-- trong khi removing
DROP PROCEDURE IF EXISTS sp_DeleteUser3Years;
DELIMITER $$
CREATE PROCEDURE sp_DeleteUser3Years()
BEGIN
	WITH ExamID3Year AS(
		SELECT 	ExamID
		FROM 	Exam
		WHERE	(YEAR(NOW()) - YEAR(CreateDate)) > 3
    )
	DELETE
    FROM Exam
    WHERE ExamID = (
		SELECT * FROM ExamID3Year
    );
END$$
DELIMITER ;
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng
-- ban default là phòng ban chờ việc

DROP PROCEDURE IF EXISTS sp_DeleteDepartment;
DELIMITER $$
CREATE PROCEDURE sp_DeleteDepartment
(IN	in_DepartmentName NVARCHAR(50))
BEGIN
	UPDATE 	`Account`
    SET		DepartmentID = 10
    WHERE	DepartmentID = (SELECT 	DepartmentID
							FROM	Department
							WHERE 	DepartmentName = in_DepartmentName);
	DELETE
    FROM	Department
    WHERE	DepartmentName = in_DepartmentName;
END$$
DELIMITER ;

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

DROP PROCEDURE IF EXISTS sp_CountQuesInMonth;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesInMonth()
BEGIN
		SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
                   SELECT 1 AS MONTH
                    UNION SELECT 2 AS MONTH
                    UNION SELECT 3 AS MONTH
                    UNION SELECT 4 AS MONTH
                    UNION SELECT 5 AS MONTH
                    UNION SELECT 6 AS MONTH
                    UNION SELECT 7 AS MONTH
                    UNION SELECT 8 AS MONTH
                    UNION SELECT 9 AS MONTH
                    UNION SELECT 10 AS MONTH
                    UNION SELECT 11 AS MONTH
                    UNION SELECT 12 AS MONTH
        ) AS EachMonthInYear
		LEFT JOIN Question ON EachMonthInYear.MONTH = MONTH(CreateDate)
		GROUP BY EachMonthInYear.MONTH
		ORDER BY EachMonthInYear.MONTH ASC;
END$$
DELIMITER ;

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất (nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào
-- trong tháng")
/* -- Hàm DATE_SUB trả về một ngày mà sau đó một khoảng thời gian/ngày nhất định đã bị trừ */
DROP PROCEDURE IF EXISTS sp_CountQuesPrevious6Month;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesPrevious6Month()
BEGIN
		SELECT Previous6Month.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
			SELECT MONTH(CURRENT_DATE - INTERVAL 5 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 4 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 3 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 2 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 0 MONTH) AS MONTH
        ) AS Previous6Month
		LEFT JOIN Question ON Previous6Month.MONTH = MONTH(CreateDate)
		GROUP BY Previous6Month.MONTH
		ORDER BY Previous6Month.MONTH ASC;
END$$
DELIMITER ;

/*============================== TRUY VẤN DỮ LIỆU (DB_7_2) =============================*/
/*======================================================================================*/
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
DROP TRIGGER IF EXISTS trig_Not_InsertGroup1YearPrevious;
DELIMITER $$
	CREATE TRIGGER trig_Not_InsertGroup1YearPrevious
    BEFORE INSERT ON `Group`
    FOR EACH ROW
    BEGIN
		IF (NEW.CreateDate< DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR)) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Ko add được';
		END IF;
    END$$
DELIMITER ;
INSERT INTO `Group`	(  GroupName		, CreatorID		, CreateDate)
VALUE 				(N'Testing System'	,   12			,'2019-03-05');
SELECT * FROM `Group`;
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add
-- more user"
DROP TRIGGER IF EXISTS trig_Not_Accept_addUserSale;
DELIMITER $$
	CREATE TRIGGER trig_Not_Accept_addUserSale
    BEFORE INSERT ON `Department`
    FOR EACH ROW
    BEGIN
			IF (NEW.DepartmentName = 'Sale') THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
			END IF;
    END$$
DELIMITER ;
INSERT INTO Department	(DepartmentName)
VALUE					(N'Sale'	);

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user.
DROP TRIGGER IF EXISTS Max_Question_In_Exam;
DELIMITER $$
CREATE TRIGGER Max_Question_In_Exam
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN
		IF (SELECT 	GroupID FROM GroupAccount GROUP BY GroupID HAVING Count(AccountID) >= 5) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Một group có nhiều nhất 5 User';
        END IF;
END $$
DELIMITER ;

INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUE 						(	1		,    1		,'2019-03-05');
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
 -- Số lượng câu hỏi trong 1 đề thi

DROP TRIGGER IF EXISTS Max_Question_In_Exam;
DELIMITER $$
CREATE TRIGGER Max_Question_In_Exam
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN
		IF (SELECT 		ExamID
			FROM		ExamQuestion
			GROUP BY 	QuestionID
			HAVING		Count(QuestionID) >= 5) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Một group có nhiều nhất 5 User';
        END IF;
END $$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài
-- khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS trigger_delete_account;
DELIMITER $$
CREATE TRIGGER trigger_delete_account
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	IF OLD.Email = 'admin@gmail.com'
    THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cannot delete data';
	END IF;

END $$
DELIMITER ;

INSERT INTO `Account`(Email				, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUE 				('admin@gmail.com'	, 'dangblacky'		,'Nguyen Hai Dang'		,   '5'			,   '1'		,'2020-03-05');

DELETE
FROM `Account`
WHERE Email = 'admin@gmail.com';


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào
-- departmentID thì sẽ được phân vào phòng ban "Phòng chờ"
DROP TRIGGER IF EXISTS trigger_create_account;
DELIMITER $$
	CREATE TRIGGER trigger_create_account
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
		DECLARE WaitingDepartment_ID TINYINT UNSIGNED;
			SELECT DepartmentID INTO WaitingDepartment_ID
            FROM Department
            WHERE DepartmentName = 'Phòng chờ';
		IF NEW.DepartmentID IS NULL
        THEN SET NEW.DepartmentID = WaitingDepartment_ID;
		END IF;
	END $$
    DELIMITER ;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS trigger_create_answer;
DELIMITER $$
	CREATE TRIGGER trigger_create_answer
    BEFORE INSERT ON Answer
    FOR EACH ROW
    BEGIN
		DECLARE NumberAnswer TINYINT UNSIGNED;
        DECLARE NumberCorrectAnswer TINYINT UNSIGNED;
			SELECT COUNT(AnswerID) INTO NumberAnswer
            FROM Answer
            WHERE QuestionID = New.QuestionID;

			SELECT COUNT(AnswerID) INTO NumberCorrectAnswer
            FROM Answer
            WHERE QuestionID = New.QuestionID AND isCorrect = 'Yes';

		IF NumberAnswer >=4 OR NumberCorrectAnswer>=2 THEN
        SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cannot insert data';
		END IF;

	END $$
    DELIMITER ;
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: nếu người dùng nhập vào gender
-- của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu
-- hình ở database
DROP TRIGGER IF EXISTS Auto_Gender_Update;
DELIMITER $$
CREATE TRIGGER Auto_Gender_Update
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
      IF NEW.Gender = 'Nam' THEN
         SET NEW.Gender = 'M';
	  ELSEIF NEW.Gender = 'Nu' THEN
         SET NEW.Gender = 'F';
	  ELSEIF NEW.Gender = 'Chưa xác định' THEN
         SET NEW.Gender = 'U';
	  END IF ;
END $$
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Delete_Exam;
DELIMITER $$
CREATE TRIGGER Delete_Exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
      IF (NEW.CreateDate = DATE_SUB(NOW(),INTERVAL 2 DAY)) THEN
         SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Không được xóa Exam vừa tạo 2 ngày trước';
	  END IF ;
END $$
DELIMITER ;
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Delete_Update;
DELIMITER $$
CREATE TRIGGER Delete_Update
BEFORE UPDATE  ON Question
FOR EACH ROW
BEGIN
	DECLARE Not_On_Exam TINYINT;
	SELECT q.QuestionID INTO Not_On_Exam
	FROM Question q
	LEFT JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
	WHERE eq.ExamID IS NULL;
		IF NEW.QuestionID != Not_On_Exam THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể INSERT';
		END IF ;
END $$
DELIMITER ;
-- Question 12: Lấy ra thông tin exam trong đó
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- duration >60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID,
		CASE
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 AND Duration >30 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID,
		CASE
			WHEN COUNT(AccountID) <=5 THEN 'Few'
            WHEN COUNT(AccountID) <=20 AND COUNT(AccountID)>5 THEN 'Normal'
            ELSE 'Higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;


-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT d.DepartmentName,
		CASE
			WHEN COUNT(a.AccountID) = 0 THEN 'Khong co User'
            ELSE COUNT(a.AccountID)
		END AS Number_of_Account
FROM Department d
JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentName;