CREATE TABLE employee (
   empleadoID INT NOT NULL,
   nombreEmpleado VARCHAR(255),
   correoEmpleado VARCHAR(255),
   passwdEmpleado VARCHAR(255),
   codSuperior INT NOT NULL,
   CONSTRAINT pk_employee PRIMARY KEY (empleadoID)
);

ALTER TABLE Employee ADD CONSTRAINT FK_EMPLOYEE_ON_EMPLEADOID FOREIGN KEY (codSuperior) REFERENCES Employee (empleadoID);