insert into cashier_tbl(username,loginId,password)values('thida aye','thida','123');
insert into cashier_tbl(username,loginId,password)values('sandar aung','sandar','222');

insert into category_tbl(name) values('T-Shirt');
insert into category_tbl(name) values('Trouser');
insert into category_tbl(name) values('Wallet');

insert into address_tbl(city,township,street)values('Yangon','latha','41st')
insert into address_tbl(city,township,street)values('Yangon','latha','41st')
insert into address_tbl(city,township,street)values('Yangon','latha','41st')
insert into address_tbl(city,township,street)values('Mandalay','aungmyaytharzan','22st bet, 66st and 67st')
insert into address_tbl(city,township,street)values('Mandalay','patheingyi','19st')

insert into contact_tbl(id,email,primaryContact,secondaryContact)values(1,'aung@gmail.com','098234234','093423234');
insert into contact_tbl(id,email,primaryContact,secondaryContact)values(2,'susu@gmail.com','099921234','0923423');
insert into contact_tbl(id,email,primaryContact,secondaryContact)values(3,'thida@gmail.com','09984234','092232423');
insert into contact_tbl(id,email,primaryContact,secondaryContact)values(4,'wanna@gmail.com','09923422','09534534');
insert into contact_tbl(id,email,primaryContact,secondaryContact)values(5,'susan@gmail.com','0934234234','096776343');

insert into customer_tbl(username,loginId,password,address_id,member)values('aung aung','aung123','111',1,0);
insert into customer_tbl(username,loginId,password,address_id,member)values('Su Su','sssss','1234',2,0);
insert into customer_tbl(username,loginId,password,address_id,member)values('thida aye','thida','333',3,2);
insert into customer_tbl(username,loginId,password,address_id,member)values('myo wanna','wwwww','9999',4,1);
insert into customer_tbl(username,loginId,password,address_id,member)values('susan','sus','1212',5,3);

insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Adidas',30000,28000,1);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('BlackBarrys',50000,45000,1);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Nike',35000,33000,1);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Puma',40000,35000,1);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Levis',55000,50000,1);

insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('HUGO',65000,55000,2);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('POLO',55000,50000,2);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('EMPORIO ARMAMNI',55000,50000,2);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('GUESS',35000,32000,2);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Levis',75000,70000,2);

insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Levis',20000,15000,3);
insert into product_tbl(name,detailPrice,wholeSalePrice,category_id) values('Levis',65000,50000,3);


insert into sizes_tbl(product_id,size)values(1,1);
insert into sizes_tbl(product_id,size)values(1,2);
insert into sizes_tbl(product_id,size)values(1,3);
insert into sizes_tbl(product_id,size)values(1,4);
insert into sizes_tbl(product_id,size)values(1,0);
insert into sizes_tbl(product_id,size)values(2,1);
insert into sizes_tbl(product_id,size)values(2,2);
insert into sizes_tbl(product_id,size)values(2,3);
insert into sizes_tbl(product_id,size)values(3,1);
insert into sizes_tbl(product_id,size)values(3,2);
insert into sizes_tbl(product_id,size)values(3,3);
insert into sizes_tbl(product_id,size)values(3,4);
insert into sizes_tbl(product_id,size)values(3,0);
insert into sizes_tbl(product_id,size)values(4,1);
insert into sizes_tbl(product_id,size)values(4,2);
insert into sizes_tbl(product_id,size)values(4,3);
insert into sizes_tbl(product_id,size)values(5,2);
insert into sizes_tbl(product_id,size)values(5,3);
insert into sizes_tbl(product_id,size)values(5,4);
insert into sizes_tbl(product_id,size)values(5,0);
insert into sizes_tbl(product_id,size)values(6,1);
insert into sizes_tbl(product_id,size)values(6,2);
insert into sizes_tbl(product_id,size)values(6,3);
insert into sizes_tbl(product_id,size)values(6,4);
insert into sizes_tbl(product_id,size)values(6,0);
insert into sizes_tbl(product_id,size)values(7,2);
insert into sizes_tbl(product_id,size)values(7,3);
insert into sizes_tbl(product_id,size)values(7,4);
insert into sizes_tbl(product_id,size)values(7,0);
insert into sizes_tbl(product_id,size)values(8,3);
insert into sizes_tbl(product_id,size)values(8,4);
insert into sizes_tbl(product_id,size)values(8,0);
insert into sizes_tbl(product_id,size)values(9,1);
insert into sizes_tbl(product_id,size)values(9,2);
insert into sizes_tbl(product_id,size)values(9,3);
insert into sizes_tbl(product_id,size)values(9,4);
insert into sizes_tbl(product_id,size)values(9,0);
insert into sizes_tbl(product_id,size)values(10,2);
insert into sizes_tbl(product_id,size)values(10,3);
insert into sizes_tbl(product_id,size)values(10,4);
insert into sizes_tbl(product_id,size)values(10,0);

insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,1,60000,500,59500,'2022-10-20','10:30:22');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,2,95000,500,594500,'2022-10-20','11:00:00');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,3,105000,500,104500,'2022-10-21','09:20:12');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (2,4,30000,500,29500,'2022-10-22','15:10:13');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (2,5,170000,500,169500,'2022-10-24','10:00:22');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,5,95000,500,84500,'2022-10-25','10:30:20');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,3,65000,500,64500,'2022-10-25','10:40:12');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,3,30000,500,24500,'2022-10-25','10:50:02');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (1,5,50000,500,44500,'2022-10-25','10:00:22');
insert into sales_tbl(cashier_id,customer_id,subTotal,tax,total,saleDate,saleTime) values (2,4,75000,500,66500,'2022-10-24','10:00:22');



insert into sale_history_tbl(product_id,sales_id,size,qtys) values (1,1,3,2);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (2,2,4,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (5,2,1,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (3,2,1,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (2,3,2,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (7,3,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (1,4,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (8,5,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (9,5,2,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (1,5,2,1);

insert into sale_history_tbl(product_id,sales_id,size,qtys) values (2,5,2,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (10,6,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (11,6,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (12,7,3,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (1,8,4,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (2,9,1,1);
insert into sale_history_tbl(product_id,sales_id,size,qtys) values (10,10,2,1);


