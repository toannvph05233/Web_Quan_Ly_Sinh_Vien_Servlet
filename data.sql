use qlnv;
CREATE TABLE Khoa
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL

);
CREATE TABLE Account
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(50),
    avatar   VARCHAR(255),
    idkhoa   VARCHAR(255)
);

CREATE TABLE HocPhi
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT NOT NULL,
    date      DATE
);

CREATE TABLE KetQuaHocTap
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT NOT NULL,
    type      VARCHAR(50),
    date      DATE,
    content   TEXT
);
CREATE TABLE KhenThuongKyLuat
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    studentId INT NOT NULL,
    type      VARCHAR(50),
    date      DATE,
    content   TEXT
);

CREATE TABLE Student
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    birthday     DATE,
    gender       VARCHAR(10),
    avatar       VARCHAR(255),
    major        VARCHAR(255),
    gpa          double,
    idCardNumber VARCHAR(50),
    address      TEXT,
    status       BOOLEAN,
    idkhoa       VARCHAR(255)
);
