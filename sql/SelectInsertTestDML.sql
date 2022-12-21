--Select Tsts 
-- Test adds 
SELECT * FROM ers_user_roles;
SELECT * FROM ers_users;
SELECT * FROM ers_reimbursement_status;
SELECT * FROM ers_reimbursement_type;
SELECT * FROM ers_reimbursement;

-- Insert Tests (repeat for unique key test) 
INSERT INTO ers_users (ers_username,ers_password,ers_first_name,ers_last_name,ers_role_id_fk)
VALUES ('user1','password1','manager1','mang1',1)

--Modify for null/ default test accordingly
INSERT INTO ers_reimbursement(ers_reimb_amount,ers_reimb_description,ers_users_fk,ers_reiimb_type_fk,ers_reimb_status_fk) 
VALUES (100,'travel to la',1,2,1);