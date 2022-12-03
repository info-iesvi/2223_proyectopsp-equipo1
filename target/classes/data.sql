CREATE TABLE employee (
   empleadoID INT NOT NULL,
   nombreEmpleado VARCHAR(255),
   correoEmpleado VARCHAR(255),
   passwdEmpleado VARCHAR(255),
   codSuperior INT NOT NULL,
   CONSTRAINT pk_employee PRIMARY KEY (empleadoID)
);

ALTER TABLE Employee ADD CONSTRAINT FK_EMPLOYEE_ON_EMPLEADOID FOREIGN KEY (codSuperior) REFERENCES Employee (empleadoID);

INSERT INTO employee VALUES (1, 'Juan', 'juan@gmail.com', '1234', 1);
INSERT INTO employee VALUES (2, 'Ana', 'ana@gmail.com', '5678', 1);