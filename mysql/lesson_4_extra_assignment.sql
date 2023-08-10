USE	TestingSystem1;

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
