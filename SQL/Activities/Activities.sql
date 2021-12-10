REM   Script: Session 01
REM   Activity 1 to 6

select * from scott.emp;

 Create salesman table 
CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

desc salesman


INSERT into Salesman (5001, James Hong, Newyork, 15) ;

INSERT into Salesman values (5001, James Hong, Newyork, 15) ;

INSERT into Salesman values (5001, James Hong, Newyork, 15);

INSERT into Salesman values (5001, James Hong, Newyork, 15);

INSERT into salesman values(5001, James Hong, Newyork, 15);

select * from scott.emp;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

desc salesman 


INSERT into salesman values(5001, 'James Hong', 'Newyork', 15);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

Select salesman_id, salesman_city from salesman where salesman_city = 'Paris';

select salesman_id, commission from salesman where salesman_name = 'Paul Adam';

Select * from salesmanwhere salesman_city = 'Paris';

Select * from salesman where salesman_city = 'Paris';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET Grade = 100;

Select * from salesman;

Update salesman SET Grade = 200 where salesman_city = 'Rome';

Update salesman SET Grade = 300 where salesman_name = 'James Hoog';

Update salesman SET Grade = 300 where salesman_name = 'James Hong';

Update salesman SET salesman_name = 'Pierre' where salesman_name = 'McLyon';

Select * from Salesman;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

Select DISTINCT salesman_id from orders;

Select * from orders order by order_no, order_date;

Select * from orders order by order_no, order_date ASC;

Select * from orders order by order_no, purchase_amount DESC;

Select order_no, purchase_amount from orders order by purchase_amount DESC;

Select order_no, order_date from orders order by order_date ASC;

Select * from orders where purchase_amount < 500;

Select * from orders where purchase_amount BETWEEN 1000 and 2000;


select SUM(purchase_amount) AS "Total sum" from orders;


select AVG(purchase_amount) AS "Average" from orders;


select MAX(purchase_amount) AS "Maximum" from orders;


select MIN(purchase_amount) AS "Minumum" from orders;


select COUNT(distinct salesman_id) AS "Total count" from orders;
