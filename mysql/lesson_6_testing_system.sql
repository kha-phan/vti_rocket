USE TestingSystem;
/*============================== TRUY VẤN DỮ LIỆU  =============================*/
/*======================================================================================*/

/*
DETERMINISTIC
READS SQL DATA

By default, for a CREATE FUNCTION statement to be accepted, at least one of DETERMINISTIC, NO SQL, or READS SQL DATA must be specified explicitly. Otherwise an error occurs:

ERROR 1418 (HY000): This function has none of DETERMINISTIC, NO SQL,
or READS SQL DATA in its declaration and binary logging is enabled
(you *might* want to use the less safe log_bin_trust_function_creators
variable)
*/

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_accountOfDepartment;
CREATE PROCEDURE sp_accountOfDepartment(IN in_department_name NVARCHAR(50))
BEGIN

	SELECT 		A.Email, A.Username, A.CreateDate
    FROM		Department D
	INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
    WHERE		DepartmentName = in_department_name;

END$$
DELIMITER ;

Call sp_accountOfDepartment('Sale');


-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_accountOfGroup;
DELIMITER $$
CREATE PROCEDURE sp_accountOfGroup(IN in_GroupID TINYINT UNSIGNED)
BEGIN

	SELECT 		GroupID, COUNT(AccountID)
    FROM		GroupAccount
    WHERE		GroupID = in_GroupID
    GROUP BY	GroupID;

END$$
DELIMITER ;

call sp_accountOfGroup(1);


-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_typeQuestionOfMonth;
DELIMITER $$
CREATE PROCEDURE sp_typeQuestionOfMonth()
BEGIN

	SELECT		COUNT(TypeID)
    FROM		Question
    WHERE		MONTH(CreateDate) = Month(NOW());

END$$
DELIMITER ;

call testingsystem.sp_typeQuestionOfMonth();


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
    SELECT 		TypeID
    FROM		Question
    GROUP BY 	TypeID
    HAVING		COUNT(TypeID) = (SELECT * FROM MAX_Count_TypeID);

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
    SELECT 		TQ.TypeName
    FROM		Question Q
	INNER JOIN 	TypeQuestion TQ ON Q.TypeID = TQ.TypeID
    GROUP BY 	Q.TypeID
    HAVING		COUNT(Q.TypeID) = (SELECT * FROM MAX_Count_TypeID);

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
CREATE PROCEDURE sp_importInf_Of_Account(	IN	in_email VARCHAR(50),
											IN in_fullName NVARCHAR(50))
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
CREATE PROCEDURE sp_maxContentWithTypeID(IN in_TypeName VARCHAR(15))
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
CREATE PROCEDURE sp_DeleteExamWithID (IN in_ExamID TINYINT UNSIGNED)
BEGIN
	DELETE
    FROM 	Exam
    WHERE	ExamID = in_ExamID;
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
    FROM 	Exam
    WHERE 	ExamID = (SELECT * FROM ExamID3Year);
END$$
DELIMITER ;


-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng
-- ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_DeleteDepartment;
DELIMITER $$
CREATE PROCEDURE sp_DeleteDepartment(IN	in_DepartmentName NVARCHAR(50))
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