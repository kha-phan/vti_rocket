USE TestingSystem2;

/* b) Viết stored procedure (không có parameter) để Remove tất cả thông tin project
đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã remove
từ các table liên quan trong khi removing (dùng lệnh print) */
DROP PROCEDURE IF EXISTS remove_project_done;
DELIMITER $$
CREATE PROCEDURE remove_project_done()
BEGIN
    DECLARE deleted_count INT;
	DELETE FROM Projects WHERE ProjectCompletedOn IS NOT NULL AND DATE_ADD(ProjectStartDate, INTERVAL 3 MONTH) > CURDATE();
    SET deleted_count = ROW_COUNT();
    -- Print the count of deleted records
    -- PRINT CONCAT('Deleted ', deleted_count, ' records.');
    SELECT deleted_count;
    
END$$
DELIMITER ;

call remove_project_done();

/* c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện) */
DROP PROCEDURE IF EXISTS module_inprogress;
DELIMITER $$
CREATE PROCEDURE module_inprogress(IN in_ProjectID TINYINT UNSIGNED)
BEGIN

	SELECT 		ProjectID, ModuleID
    FROM		Project_Modules
    WHERE		ProjectID = in_ProjectID AND ProjectModulesCompletedOn is NULL;

END$$
DELIMITER ;

call module_inprogress(1);


/* d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm
mặc dù không ai giao việc cho nhân viên đó (trong bảng Works) */
DROP PROCEDURE IF EXISTS employee_joined;
DELIMITER $$
CREATE PROCEDURE employee_joined(IN in_EmployeeID TINYINT UNSIGNED)
BEGIN

	SELECT 		EmployeeID, CONCAT(EmployeeLastName, ' ', EmployeeFirstName)
    FROM		Employee
    WHERE		EmployeeID NOT IN (SELECT EmployeeID FROM Work_Done);

END$$
DELIMITER ;

call employee_joined(1);
