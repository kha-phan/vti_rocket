-- CREATE TABLE
DROP DATABASE DB_4_1;
CREATE DATABASE DB_4_1;
USE	DB_4_1;

/* ======TẠO BẢNG DỮ LIỆU (Q1)========*/
-- Department (Department_Number, Department_Name)
-- Employee_Table (Employee_Number, Employee_Name, Department_Number)
-- Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered)

-- Tạo bảng Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	Department_Number 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Department_Name		NVARCHAR(50) UNIQUE KEY NOT NULL
);

-- Tạo bảng Employee_Table
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table(
	Employee_Number 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Employee_Name		NVARCHAR(50) NOT NULL,
    Department_Number	TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(Department_Number) REFERENCES Department(Department_Number)
);

-- Tạo bảng Employee_Skill_Table
DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table(
	Employee_Number 	TINYINT UNSIGNED AUTO_INCREMENT,
    Skill_Code			NVARCHAR(20) NOT NULL,
    Date_Registered		DATETIME DEFAULT NOW(),
    FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

/* ======INSERT DỮ LIỆU (Q2)========*/
INSERT INTO Department	(Department_Name)
VALUE
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


INSERT INTO Employee_Table 	(Employee_Name		, Department_Number	)
VALUE
(N'Nguyễn Hải Đăng'	,		1			),
(N'Dương Văn Quá'	,		1			),
(N'Tiểu Long Nữ'	,		2			),
(N'Chu Chỉ Nhược'	,		5			),
(N'Trương Vô Kị'	,		6			),
(N'Hoàng Dược Sư'	,		5			),
(N'Lý Mạc Sầu'		,		5			),
(N'Quách Tĩnh'		,		1			),
(N'Hoàng Dung'		,		9			),
(N'Chu Bá Thông'	,		10			);


INSERT INTO Employee_Skill_Table 	(Employee_Number, Skill_Code	, Date_Registered	)
VALUE
( 	1,				'Java'		, '2020-03-15'		),
( 	2,				'Android'	, '2020-03-16'		),
( 	3,				'C#'		, '2020-03-17'		),
( 	1,				'SQL'		, '2020-03-20'		),
( 	1,				'Postman'	, '2020-03-21'		),
( 	4,				'Ruby'		, '2020-04-22'		),
( 	5,				'Java'		, '2020-04-24'		),
( 	6,				'C++'		, '2020-04-27'		),
( 	7,				'C Sharp'	, '2020-04-04'		),
( 	10,				'PHP'		, '2020-04-10'		);

/* ======TRUY VẤN DỮ LIỆU (Q3)========*/

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT 	ET.Employee_Number, ET.Employee_Name, ET.Department_Number, EST.Skill_Code
FROM	Employee_Table ET RIGHT JOIN Employee_Skill_Table EST
ON		ET.Employee_Number = EST.Employee_Number
WHERE	EST.Skill_Code = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên
SELECT		D.Department_Number AS NUMBER, D.Department_Name AS NAME, COUNT(ET.Department_Number) AS TOTAL
FROM		Department D INNER JOIN Employee_Table ET
ON			D.Department_Number = ET.Department_Number
GROUP BY 	ET.Department_Number
HAVING		COUNT(ET.Department_Number)>=3
ORDER BY	D.Department_Number ASC;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
SELECT		ET.*
FROM		Department D INNER JOIN Employee_Table ET
ON			D.Department_Number = ET.Department_Number
ORDER BY	D.Department_Number ASC;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
SELECT 		ET.*, COUNT(EST.Employee_Number) AS TOTAL
FROM		Employee_Table ET RIGHT JOIN Employee_Skill_Table EST
ON			ET.Employee_Number = EST.Employee_Number
GROUP BY	ET.Employee_Number
HAVING 		COUNT(EST.Employee_Number)>1;
