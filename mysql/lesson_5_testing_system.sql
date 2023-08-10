USE TestingSystem;
/*============================== TRUY VẤN DỮ LIỆU =============================*/
/*======================================================================================*/
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW vw_DSNV_Sale
AS
	SELECT		A.*, D.DepartmentName
	FROM 		`Account` A
	INNER JOIN 	`Department` D ON A.DepartmentID = D.DepartmentID
	WHERE		D.DepartmentName = 'Sale';

SELECT 	*
FROM 	vw_DSNV_Sale;

-- CHẠY BẰNG CTE
WITH DSNV_Sale AS(
	SELECT		A.*, D.DepartmentName
	FROM 		`Account` A
	INNER JOIN `Department` D	ON	A.DepartmentID = D.DepartmentID
	WHERE		D.DepartmentName = 'Sale'
)
SELECT 	*
FROM 	DSNV_Sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vw_InfAccountMaxGroup
AS
SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Account` A
INNER JOIN 	GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY	A.AccountID
HAVING		COUNT(GA.AccountID) = (
									SELECT 		COUNT(GA.AccountID)
									FROM		`Account` A
									INNER JOIN 	GroupAccount GA ON A.AccountID = GA.AccountID
									GROUP BY	A.AccountID
									ORDER BY	COUNT(GA.AccountID) DESC
									LIMIT		1
								  );

SELECT 	*
FROM 	vw_InfAccountMaxGroup;

-- CHẠY CTE
WITH MAX_COUNT_ACCOUNTID AS(
	SELECT 		COUNT(GA.AccountID)
	FROM		`Account` A
	INNER JOIN 	GroupAccount GA ON A.AccountID = GA.AccountID
	GROUP BY	A.AccountID
	ORDER BY	COUNT(GA.AccountID) DESC
	LIMIT		1
)
SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Account` A
INNER JOIN 	GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY	A.AccountID
HAVING		COUNT(GA.AccountID) = (SELECT * FROM MAX_COUNT_ACCOUNTID);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 18 từ
-- được coi là quá dài) và xóa nó đi (De cu la 300 tu nhung do thiet ke db tu dau nen sua lai 18 tu de demo
CREATE OR REPLACE VIEW vw_ContenTren18Tu
AS
	SELECT 	LENGTH(Content)
	FROM	Question
	WHERE	LENGTH(Content) > 18;

SELECT 	*
FROM 	vw_ContenTren18Tu;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW vw_DepartmentMaxAccount
AS
	SELECT 		D.*, COUNT(A.DepartmentID)
	FROM		Department D
	INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
	GROUP BY	D.DepartmentID
	HAVING		COUNT(A.DepartmentID) = (
										SELECT 		COUNT(A.DepartmentID)
										FROM		Department D
										INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
										GROUP BY	D.DepartmentID
										HAVING		COUNT(A.DepartmentID)
										ORDER BY	COUNT(A.DepartmentID) DESC
										LIMIT		1
										);

SELECT 	*
FROM 	vw_DepartmentMaxAccount;

-- CTE
WITH MAX_COUNT_DEPARTMENTID AS
(
	SELECT 		COUNT(A.DepartmentID)
	FROM		Department D
	INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
	GROUP BY	D.DepartmentID
	HAVING		COUNT(A.DepartmentID)
    ORDER BY	COUNT(A.DepartmentID) DESC
    LIMIT		1
),
COUNT_DEPARTMENTID AS
(
	SELECT 		D.*, COUNT(A.DepartmentID) AS COUNT_DEPARTMENT
	FROM		Department D
	INNER JOIN `Account` A ON D.DepartmentID = A.DepartmentID
	GROUP BY	D.DepartmentID
	HAVING		COUNT(A.DepartmentID)
)
SELECT 	*
FROM	COUNT_DEPARTMENTID
WHERE	COUNT_DEPARTMENT = (
							SELECT 	*
							FROM 	MAX_COUNT_DEPARTMENTID);


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vw_QuesHoNguyen
AS
	SELECT 		Q.*, A.FullName
	FROM 		Question Q
	INNER JOIN 	`Account` A ON Q.CreatorID = A.AccountID
	WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';

SELECT 	*
FROM 	vw_QuesHoNguyen;


-- Comman Table Expression
WITH QuesHoNguyen AS
(
	SELECT 		Q.*, A.FullName
	FROM 		Question Q
	INNER JOIN 	`Account` A ON Q.CreatorID = A.AccountID
	WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen'
)
SELECT 	*
FROM 	QuesHoNguyen;
