USE ES_grades;

CREATE TABLE Student (
	sID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    pwdhash VARCHAR(255) NOT NULL,
    grade0 VARCHAR(2) NULL,
	grade1 VARCHAR(2) NULL,
    grade2 VARCHAR(2) NULL,
    grade3 VARCHAR(2) NULL,
    grade4 VARCHAR(2) NULL,
    grade5 VARCHAR(2) NULL,
    grade6 VARCHAR(2) NULL,
    grade7 VARCHAR(2) NULL,
    grade8 VARCHAR(2) NULL,
    grade9 VARCHAR(2) NULL
);

-- Test Cases --
-- valid query --
-- INSERT INTO Student
-- VALUES(777, "example_uname", "example_pwd", "A", "B", "C", "D", "F" , NULL, NULL, NULL, NULL, NULL);

-- valid query, but won't occur based on how the backend populated classes. --
-- INSERT INTO Student
-- VALUES(200, "glab", "glab", "A", NULL, "C", "D", "F" , NULL, NULL, NULL, "C", NULL);

-- invalid query --
-- INSERT INTO Student
-- VALUES(500, "test_uname", "test_pwd", "A");

-- SELECT username, pwdhash FROM Student WHERE sID = "2";

-- Debugging
-- SELECT * FROM Student
-- DROP TABLE Student;
