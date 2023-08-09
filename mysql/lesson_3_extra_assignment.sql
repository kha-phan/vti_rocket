USE `Fresher_management`;

-- Add data into Trainee
INSERT INTO `Trainee` (   Full_Name		,   Birth_Date	, Gender	, ET_IQ	, ET_Gmath	, ET_English	, Trainning_Class	, Evaluation_Notes	, VTI_Account		)
VALUE
('Nguyễn Hải Đăng'	,  '2000-04-29'	, 'male'	,	20	,	20		,	20			,		'VTI001'	,		'Very good'	,	'dangblack'		),
('Nguyễn Văn Bảo'	,  '2000-05-09'	, 'male'	,	18	,	16		,	16			,		'VTI002'	,		'Normal'	,	'bao123'		),
('Hoàng Thị Thường'	,  '2000-06-22'	, 'female'	,	11	,	17		,	10			,		'VTI003'	,		'Good'		,	'thuong69'		),
('Huấn Râu Sì'		,  '2000-07-24'	, 'male'	,	20	,	12		,	20			,		'VTI004'	,		'Good'		,	'huanrose'		),
('Ngô Bá Khá'		,  '2000-08-05'	, 'male'	,	16	,	20		,	16			,		'VTI005'	,		'Normal'	,	'khabanh'		),
('Nguyễn Văn Dũng'	,  '2000-09-08'	, 'female'	,	19	,	10		,	19			,		'VTI006'	,		'Good'		,	'dungtroc'		),
('Nguyễn Hải Hậu'	,  '2000-10-11'	, 'male'	,	20	,	19		,	18			,		'VTI007'	,		'Normal'	,	'haumon'		),
('Tống Quang Anh'	,  '2000-11-12'	, 'female'	,	15	,	20		,	17			,		'VTI008'	,		'Good'		,	'antondev'		),
('Nguyễn Thị Chiến'	,  '2000-11-13'	, 'unknown'	,	20	,	19		,	20			,		'VTI009'	,		'Normal'	,	'chienpanda'	),
('Nguyễn Thị Hảo'	,  '2000-11-13'	, 'female'	,	20	,	19		,	15			,		'VTI010'	,		'Good'		,	'haohaochucay'	);

-- Add data into Ques2
INSERT INTO `Ques2`	 (   `Name`,  	   `Code`, 		`ModifiedDate`	)
VALUE
('NOW OR NEVER'     , 'VT001'	,	'2020-03-05'	),
('DEAD OR LIVE'     , 'VT002'	,	'2020-03-05'	),
('BE CAREFULL'      , 'VT003'	,	'2020-03-07'	),
('PAY LAK'          , 'VT004'	,	'2020-03-08'	),
('LET DO IT'        , 'VT005'	,	'2020-03-10'	),
('DOING STH'        , 'VT006'	,	'2020-04-05'	),
('GET OUT'          , 'VT007'	,	'2020-04-05'	),
('OUTLAST'          , 'VT008'	,	'2020-04-07'	),
('GET IT'           , 'VT009'	,	'2020-04-07'	),
('TAKE OUT'         , 'VT010'	,	'2020-04-09'	);

-- Add data into Ques3
INSERT INTO `Ques3` 	(   `Name`			,   `BirthDate`		, `Gender`	, `IsDeletedFlag`	)
VALUE
('Nguyễn Hải Đăng'	,  '2000-04-29'		, 	'0'		,		'0'			),
('Nguyễn Văn Bảo'	,  '2000-05-09'		, 	'0'		,		'1'			),
('Hoàng Thị Thường'	,  '2000-06-22'		, 	'1'		,		'0'			),
('Huấn Râu Sì'		,  '2000-07-24'		, 	'1'		,		'1'			),
('Ngô Bá Khá'		,  '2000-08-05'		, 	'2'		,		'0'			),
('Nguyễn Văn Dũng'	,  '2000-09-08'		, 	'1'		,		'1'			),
('Nguyễn Hải Hậu'	,  '2000-10-11'		, 	'0'		,		'1'			),
('Tống Quang Anh'	,  '2000-11-12'		, 	'0'		,		'0'			),
('Nguyễn Thị Chiến'	,  '2000-11-13'		, 	'0'		,		'0'			),
('Nguyễn Thị Hảo'	,  '2000-11-13'		, 	'1'		,		'1'			);



/*================ QUERY DATA ===========================*/
/*===========================================================*/
-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT GROUP_CONCAT(Full_Name), MONTH(Birth_Date) FROM `Trainee` GROUP BY MONTH(Birth_Date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT *
FROM `Trainee`
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20
-- ET_IQ>=8
-- ET_Gmath>=8
-- ET_English>=18
SELECT *
FROM `Trainee`
WHERE ET_IQ + ET_Gmath>=20 AND ET_Gmath>=8 AND ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE FROM `Trainee` WHERE TraineeID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE `Trainee`
SET Trainning_Class = 'VTI002'
WHERE TraineeID = 5;