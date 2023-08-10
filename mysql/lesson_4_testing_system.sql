USE `TestingSystem`;
/*================================ Query Data =================================*/
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    A.Email,
    A.Username,
    A.FullName,
    A.PositionID,
    A.CreateDate,
    A.DepartmentID,
    D.DepartmentName
FROM
    Account A
        INNER JOIN
    Department D ON A.DepartmentID = D.DepartmentID
    
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/03/2020
SELECT		*
FROM		`Account`
WHERE		CreateDate < '2020-03-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT		*
FROM		`Account` A
INNER JOIN 	Position P ON A.PositionID = P.PositionID
WHERE		P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		D.DepartmentID, D.DepartmentName, COUNT(A.DepartmentID) AS 'SO LUONG'
FROM 		`Account` A
INNER JOIN 	Department  D ON D.DepartmentID = A.DepartmentID
GROUP BY 	A.DepartmentID
HAVING 		COUNT(A.DepartmentID) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM		Question Q
INNER JOIN 	ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(Q.Content) = (SELECT	MAX(CountQ)
								FROM
										(SELECT 		COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ
										INNER JOIN 		Question Q ON EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.QuestionID) AS MaxContent);

-- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID) AS 'SO LUONG'
FROM		CategoryQuestion CQ
LEFT JOIN 	Question Q ON CQ.CategoryID = Q.CategoryID
GROUP BY	CQ.CategoryID
ORDER BY	CQ.CategoryID ASC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		Q.Content, COUNT(EQ.QuestionID) AS 'SO LUONG'
FROM		Question Q
LEFT JOIN 	ExamQuestion EQ ON EQ.QuestionID = Q.QuestionID
GROUP BY	Q.QuestionID
ORDER BY 	EQ.ExamID ASC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO LUONG'
FROM		Question Q
INNER JOIN 	Answer A ON	Q.QuestionID = A.QuestionID
GROUP BY	A.QuestionID
HAVING		COUNT(A.QuestionID) =	(SELECT 	MAX(CountQ)
									 FROM		(SELECT 		COUNT(A.QuestionID) AS CountQ
												FROM			Answer A
												RIGHT JOIN      Question Q ON A.QuestionID = Q.QuestionID
												GROUP BY		A.QuestionID) AS MaxCountQ);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT		G.GroupID, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		GroupAccount GA
RIGHT JOIN 	`Group` G ON	GA.GroupID = G.GroupID
GROUP BY	G.GroupID
ORDER BY	G.GroupID ASC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		P.PositionID, P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM		Position P
INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
GROUP BY 	P.PositionID
HAVING		COUNT(A.PositionID)	=	(SELECT 	MIN(CountP)
									 FROM		(SELECT 	COUNT(P.PositionID) AS CountP
												FROM		Position P
												INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
												GROUP BY	P.PositionID) AS MinCountP);

-- Question 11: thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT
    t1.DepartmentID,
    t1.PositionID,
    IF((t2.number_of_account IS NULL),
        0,
        t2.number_of_account) AS number_of_account
FROM
    (SELECT
        d.DepartmentID, p.PositionID
    FROM
        department d
    CROSS JOIN `position` p
    WHERE
        p.PositionName IN ('Developer' , 'Tester', 'Scrum Master', 'Project Manager')
    ORDER BY d.DepartmentID , p.PositionID) AS t1
        LEFT JOIN
    (SELECT
        d.DepartmentID,
            p.PositionID,
            COUNT(a.AccountID) AS number_of_account
    FROM
        position p
    LEFT JOIN `account` a ON p.PositionID = a.PositionID
    RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID
    WHERE
        p.PositionName IN ('Developer' , 'Tester', 'Scrum Master', 'Project Manager')
    GROUP BY d.DepartmentID , p.PositionID) AS t2 ON t1.DepartmentID = t2.DepartmentID
        AND t1.PositionID = t2.PositionID
GROUP BY t1.DepartmentID , t1.PositionID
ORDER BY t1.DepartmentID , t1.PositionID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 		T.TypeName AS 'LOAI CAU HOI', Q.CreatorID AS 'ID NGUOI TAO', Q.Content AS 'CAU HOI', A.Content AS 'CAU TRA LOI', Q.CreateDate AS 'NGAY TAO'
FROM		Question Q
INNER JOIN 	Answer A ON	Q.QuestionID = A.QuestionID
INNER JOIN	TypeQuestion T ON Q.TypeID = T.TypeID;

-- Question 13: lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT		T.TypeName AS 'LOAI CAU HOI', COUNT(Q.TypeID) AS 'SO LUONG'
FROM		Question Q
INNER JOIN 	TypeQuestion T ON Q.TypeID = T.TypeID
GROUP BY	Q.TypeID;

-- Question 14: lấy ra group không có account nào
SELECT 		DISTINCT G.GroupName
FROM 		`Group` G
LEFT JOIN 	GroupAccount GA ON G.GroupID = GA.GroupID
WHERE 		GA.AccountID IS NULL;

-- Question 15: lấy ra group không có account nào
SELECT		*
FROM		`Group`
WHERE		GroupID  NOT IN	(SELECT		GroupID
							 FROM		GroupAccount);

-- Question 16: lấy ra question không có answer nào
SELECT		*
FROM		Question
WHERE		QuestionID NOT IN (SELECT	QuestionID
							   From		Answer);

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 3
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 3;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1
UNION
SELECT 		A.FullName
FROM 		`Account` A
JOIN 		GroupAccount GA ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 3;

-- Question 18:
-- a) Lấy các group có lớn hơn bằng 3 thành viên
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong >= 3;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong <= 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong >= 3
UNION
SELECT 		G.GroupName, COUNT(1) AS so_luong
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY	GA.GroupID
HAVING 		so_luong <= 7;