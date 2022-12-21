--table creation schema 

--Create User Roles Table
CREATE TABLE ers_user_roles(
ers_role_id SERIAL PRIMARY KEY,
ers_role TEXT
);

--Create Users Table
CREATE TABLE ers_users(
ers_user_id SERIAL PRIMARY KEY,
ers_username TEXT UNIQUE NOT NULL,
ers_password TEXT NOT NULL,
ers_first_name TEXT,
ers_last_name TEXT,
ers_role_id_fk INT REFERENCES ers_user_roles(ers_role_id) DEFAULT 2

);

-- Create REimbursement type table
CREATE TABLE ers_reimbursement_type(
ers_reimb_type_id SERIAL PRIMARY KEY,
ers_reimb_type TEXT
);

-- Create reimbursement status table
CREATE TABLE ers_reimbursement_status(
ers_reimb_status_id SERIAL PRIMARY KEY,
ers_reimb_status TEXT

);

--Create Reimbursement Table
CREATE TABLE ers_reimbursement(
ers_reimb_id SERIAL PRIMARY KEY,
ers_reimb_amount TEXT NOT NULL,
ers_reimb_description TEXT NOT NULL, 
ers_users_fk INT REFERENCES ers_users(ers_user_id),
ers_reiimb_type_fk INT REFERENCES ers_reimbursement_type(ers_reimb_type_id) DEFAULT 3,
ers_reimb_status_fk  INT REFERENCES ers_reimbursement_status(ers_reimb_status_id) DEFAULT 1

);
--insert initial  roles 
INSERT INTO ers_user_roles(ers_role) VALUES ('Manager'),('Employee'),('Intern');

--iNsert FOR Initial Tticket Status 
INSERT INTO ers_reimbursement_status (ers_reimb_status) VALUES ('Pending'),('Approved'),('Denied')

--Insert   initial reimb type 
INSERT INTO ers_reimbursement_type(ers_reimb_type)VALUES ('Travel'),('Lodging'),('Other')
