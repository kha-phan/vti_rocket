USE `TestingSystem`;

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