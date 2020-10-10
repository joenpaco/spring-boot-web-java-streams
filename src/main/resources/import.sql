CREATE TABLE PRODUCTOS (

   id INT NOT NULL, 
   name VARCHAR(100),
   supplier INT,
   category INT,
   unitPrice DOUBLE,
   unitsInStock INT

) as select * from CSVREAD('classpath:products.csv'); 