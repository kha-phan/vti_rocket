USE `adventureworks`;
/*========THỰC HIỆN TRUY VẤN (EXAM 1) =========*/
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name
-- của ProductSubcategory là 'Saddles'
WITH ProductSubcategoryID_Saddles AS(
	SELECT 	ProductSubcategoryID FROM ProductSubcategory
	WHERE	`Name` = 'Saddles'
)
SELECT 	`Name`
FROM 	product
WHERE	ProductSubcategoryID = (SELECT * FROM ProductSubcategoryID_Saddles);

-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.
-- In this exercise you can change the previous query to deliver the following result set
WITH Product_Name_Bo AS(
	SELECT 	`Name`
    FROM 	Product
	WHERE	SUBSTRING_INDEX(SUBSTRING_INDEX(`Name`, ' ', 2), ' ', -1) LIKE 'Bo%'
    AND		LENGTH(`Name`)>15

)
SELECT * FROM Product_Name_Bo;


-- Question 3:
-- Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring
-- Bike (nghĩa là ProductSubcategoryID = 3)
WITH MIN_StandardCost AS(
	SELECT 	MIN(StandardCost)
	FROM 	Product
	WHERE 	ProductSubcategoryID = 3
)
SELECT 	`Name`
FROM 	Product
WHERE	StandardCost = (SELECT * FROM MIN_StandardCost);

/*========THỰC HIỆN TRUY VẤN (EXAM 2) =========*/
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong
-- AdventureWorks2008sample database

SELECT 	CR.`Name`, SP.`Name`
FROM	countryregion CR INNER JOIN stateprovince SP
ON		CR.CountryRegionCode = SP.CountryRegionCode;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country
-- Germany và Canada
SELECT 	CR.`Name`, SP.`Name`
FROM	countryregion CR INNER JOIN stateprovince SP
ON		CR.CountryRegionCode = SP.CountryRegionCode
WHERE	CR.`Name` = 'Germany'
OR 		CR.`Name` = 'Canada';

-- Question 3:
-- SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột
-- BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale
-- được bao nhiêu người trong năm nay)
SELECT 	SDH.SalesOrderID, SDH.OrderDate, SP.SalesPersonID, SP.Bonus, SP.SalesYTD
FROM	salesperson SP INNER JOIN salesorderheader SDH
ON	SP.SalesPersonID = SDH.SalesPersonID;

-- Question 4:
-- Sử dụng câu query, thêm cột JobTitle và xóa cột SalesPersonID và
-- BusinessEntityID.
SELECT 		SDH.SalesOrderID, SDH.OrderDate, E.Title, SP.Bonus, SP.SalesYTD
FROM		salesperson SP INNER JOIN salesorderheader SDH
ON			SP.SalesPersonID = SDH.SalesPersonID
INNER JOIN	employee E
ON			SP.SalesPersonID = E.EmployeeID;


