-- Address Table
insert into address_tbl(state,township,address)values('yangon','insein','no-22 b-2,thayayyon street');
insert into address_tbl(state,township,address)values('mandalay','patheingyi','19st nanoolwin');
insert into address_tbl(state,township,address)values('mandalay','pwinoolwin','block-9');

-- Patient Table
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Aung Aung','1988-02-11','MALE','094534534','aung@gmail.com',1);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Sandar','1990-10-12','FEMALE','094534343','sandar@gmail.com',2);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Htun Htun','1980-03-01','MALE','0999923','htun@gmail.com',3);

-- Department Table
insert into department_tbl(name,location)values('lab','A1');
insert into department_tbl(name,location)values('operation','B2');

-- Doctor Table
insert into doctor_tbl(name,phone,email,specialization,department_id)values('U Sai Kyaw Htun','0999897722','saikyaw11@gmail.com','genaral',1);
insert into doctor_tbl(name,phone,email,specialization,department_id)values('Daw Sein Sein','0998234234','seinse11@gmail.com','Femal specialist',1);
insert into doctor_tbl(name,phone,email,specialization,department_id)values('U Wanna','099923342','wanna@gmail.com','Surgen',2);

-- Appointment Table
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(1,1,'2024-02-12','11:30','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(2,2,'2024-02-12','11:40','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(1,3,'2024-03-10','09:00','SCHEDULED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(2,3,'2024-03-10','12:00','SCHEDULED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(3,3,'2024-03-11','12:00','SCHEDULED');

-- Prescription Table
insert into prescription_tbl(medicationDetails,precriptionDate)values('testing for high blood pressure','2024-02-12');
insert into prescription_tbl(medicationDetails,precriptionDate)values('testing for blood','2024-02-12');
insert into prescription_tbl(medicationDetails,precriptionDate)values('testing for broken leg','2024-02-12');
insert into prescription_tbl(medicationDetails,precriptionDate)values('for broken leg','2024-02-12');
insert into prescription_tbl(medicationDetails,precriptionDate)values('for broken leg','2024-02-15');

-- MedicalRecord Table
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(1,1,'2024-02-12',1,'high blood pressure','stamplo 5','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(2,2,'2024-02-12',2,'high blood pressure','other','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(3,1,'2024-02-12',1,'high blood pressure','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(1,3,'2024-02-15',3,'upper left leg was broken 3 pieces ','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(2,3,'2024-02-15',4,'lower left leg was broken ','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(3,3,'2024-02-16',5,'high blood pressure','test','test');

--Billing Table
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(1,1,'2024-02-12','KPAY',120000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(2,2,'2024-02-12','CASH',110000);


