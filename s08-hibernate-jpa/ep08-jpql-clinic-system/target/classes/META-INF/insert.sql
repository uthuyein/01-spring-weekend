-- Address Table
insert into address_tbl(state,township,address)values('Yangon','insein','no-22 b-2,thayayyon street');
insert into address_tbl(state,township,address)values('Mandalay','Aung Myany Tharzan','1/17, 35th St, Bet 84th & 85th St');
insert into address_tbl(state,township,address)values('Yangon','Mingalar Taungnyunt','Rm 002, Bldg 16, Aung Tha Pyay S');
insert into address_tbl(state,township,address)values('Yangon','Mayangone','No.165, 10th St, Thiri Mon Avenue');
insert into address_tbl(state,township,address)values('Bago','Bago','Street:  No.430, Ohn Pin Tan St-9');
insert into address_tbl(state,township,address)values('Yangon','Hlaingtharyar','No.173(A/B), Seik Kan Tha Rd, Cor of Myawaddy Mingyi St');
insert into address_tbl(state,township,address)values('Mandalay','aungmyay tharzan','30th St, Bet 70th & 71st St, construction Tike-9');

-- Patient Table
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Aung Aung','1988-02-11','MALE','094534534','aung@gmail.com',1);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Sandar','1990-10-12','FEMALE','094534343','sandar@gmail.com',2);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Su Su','1988-11-01','FEMALE','098353453','susu@gmail.com',3);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Thida','1999-05-07','FEMALE','097653534','thida@gmail.com',4);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Myo Thu','1989-09-20','MALE','099923234','myothu@gmail.com',5);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Aya Thida','2005-10-11','FEMALE','09923234232','ayethida@gmail.com',6);
insert into patient_tbl(name,dob,gender,phone,email,address_id)values('Zaw Htun','1989-06-12','MALE','0943131455','zwhtun@gmail.com',7);



-- Department Table
insert into department_tbl(name,location)values('General medical department','A1');
insert into department_tbl(name,location)values('Outpatient treatment(OPT)','B1');

-- Doctor Table
insert into doctor_tbl(name,phone,email,specialization,department_id)values('U Sai Kyaw Htun','0999897722','saikyaw11@gmail.com','generalist',1);
insert into doctor_tbl(name,phone,email,specialization,department_id)values('Daw Sein Sein','0998234234','seinse11@gmail.com','Female specialist',1);
insert into doctor_tbl(name,phone,email,specialization,department_id)values('U Wanna','099923342','wanna@gmail.com','Surgeon',2);

-- Appointment Table
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(1,1,'2024-02-12','11:30','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(2,2,'2024-02-12','11:40','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(1,3,'2024-03-10','09:00','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(2,3,'2024-03-10','12:00','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(3,3,'2024-03-11','12:00','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(4,1,'2024-03-11','13:20','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(5,1,'2024-03-11','13:30','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(6,1,'2024-03-11','14:50','COMPLETED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(4,3,'2024-03-15','09:00','SCHEDULED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(5,3,'2024-03-15','11:00','SCHEDULED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(6,3,'2024-03-15','11:00','SCHEDULED');
insert into appointment_tbl(patient_id,doctor_id,appointmentDate,appointmentTime,status)values(7,1,'2024-03-16','09:00','SCHEDULED');


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
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(4,1,'2024-02-15',4,'lower left leg was broken ','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(5,2,'2024-02-16',5,'high blood pressure','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(6,3,'2024-02-15',4,'lower left leg was broken ','test','test');
insert into medical_record_tbl(patient_id,doctor_id,visitDate,prescription_id,diagonosis,treatment,note)values(4,3,'2024-02-16',5,'high blood pressure','test','test');

--Billing Table
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(1,1,'2024-02-12','KPAY',120000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(2,2,'2024-02-12','CASH',110000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(3,3,'2024-03-11','CASH',130000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(4,4,'2024-03-11','CASH',280000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(5,5,'2024-03-11','CASH',500000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(6,6,'2024-03-11','CASH',770000);
insert into billing_tbl(patient_id,appointment_id,billDate,paymentType,amount)values(4,7,'2024-03-11','CASH',850000);





