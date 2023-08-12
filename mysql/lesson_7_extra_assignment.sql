USE `TestingSystem`;

/* Exercise 1: Tiếp tục với Database ở buổi 6
Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
(Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn) */
DROP TRIGGER IF EXISTS trig_Not_InsertInvalidProjectModule;
DELIMITER $$
	CREATE TRIGGER trig_Not_InsertInvalidProjectModule
    BEFORE INSERT ON `Project_Modules`
    FOR EACH ROW
    BEGIN
		DECLARE ProjectStart_Date DATETIME;
		DECLARE ProjectComplete_Date DATETIME;
		    SELECT ProjectStartDate, ProjectCompletedOn INTO ProjectStart_Date, ProjectComplete_Date
		    FROM Projects
		    WHERE ProjectID = NEW.ProjectID;
        IF (NEW.ProjectModulesDate < ProjectStart_Date AND NEW.ProjectCompletedOn > ProjectComplete_Date)
        THEN
            SIGNAL SQLSTATE '1122'
            SET MESSAGE_TEXT = 'Invalid module project info';
		END IF;

    END$$
DELIMITER ;
INSERT INTO `Project_Modules` (ProjectID	, EmployeeID, ProjectModulesDate, ProjectModulesCompletedOn	, ProjectModulesDescription	)
VALUE						  (	1		    ,	1		,	'2019-06-05'	, '2019-08-07'		        ,	'Không hợp lệ'			            );

SELECT * FROM `Project_Modules`;

/* Exercise 2: View
Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là
ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số
điểm như sau:

 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18 */

USE `Fresher_management`;
CREATE OR REPLACE VIEW ET_trainee
AS
    SELECT *
    FROM `Trainee`
    WHERE ET_IQ + ET_Gmath>=20 AND ET_Gmath>=8 AND ET_English>=18;

SELECT 	*
FROM 	ET_trainee;