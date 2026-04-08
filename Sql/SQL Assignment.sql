create database EcommerceDB;
use EcommerceDB;

-- creating tables 
create table Customers(
CustomerId int ,
CustomerName varchar(50),
City varchar(50),
Email varchar(50)
);

create table Products(
ProductId int ,
ProductName varchar(50),
Category varchar(50),
Price bigint
);

create table Orders(
OrderId int ,
CustomerId int,
OrderDate date,
TotalAmount decimal(10,2)
);

create table OrderItems(
OrderItemId int,
OrderId int,
ProductId int,
Quantity bigint
);

 -- adding Constraints
 alter table Customers
 modify CustomerId int primary key;
 show create table Customers;
 
  alter table Products
 modify ProductId int primary key;
 show create table Products;
 
  alter table Orders
 modify CustomerId int primary key;
 show create table Orders;
 
  alter table OrderItems
 modify OrderItemId int primary key;
 show create table OrderItems;
 
alter table Orders
add constraint fk_Orders_Customers
foreign key (CustomerId) references Customers(CustomerId);

alter table OrderItems
add constraint fk_OrderItems_Orders
foreign key (OrderId) references Orders(CustomerId);

alter table OrderItems
add constraint fk_OrderItems_Products
foreign key (ProductId) references Products(ProductId);
 
 -- inserting values
insert into Customers (CustomerId, CustomerName, City, Email)
values
(1, 'Aadhi', 'Bangalore', 'aadhi@gmail.com'),
(2, 'Diya', 'Chennai', 'diya@gmail.com'),
(3, 'Karthik', 'Hyderabad', 'karthik@gmail.com'),
(4, 'Sneha', 'Mumbai', 'sneha@gmail.com'),
(5, 'Rahul', 'Delhi', 'rahul@gmail.com');
select * from Customers;

insert into Customers (CustomerId, CustomerName, City, Email)
values
(6, 'Ramu', 'Delhi', Null);

insert into Products (ProductId, ProductName, Category, Price)
values
(101, 'Laptop', 'Electronics', 65000),
(102, 'Mobile', 'Electronics', 25000),
(103, 'Chair', 'Furniture', 5000),
(104, 'Notebook', 'Stationery', 200),
(105, 'Headphones', 'Electronics', 3000);
 
insert into Orders (CustomerId, OrderDate, TotalAmount)
values
(1, '2024-01-10', 65000),
(2, '2024-02-12', 25000),
(3, '2024-03-15', 5000),
(4, '2024-04-18', 200),
(5, '2024-05-20', 3000);

insert into OrderItems (OrderItemId, OrderId, ProductId, Quantity)
values
(11,1, 101, 1),
(12,2, 102, 2),
(13,3, 103, 4),
(14,4, 104, 5),
(15,5, 105, 2);

--  Section D: Arithmetic Operators
select Quantity, (Quantity * 1000) as estimatedTotal from OrderItems;
select Price,(Price+500) as TotalPrice from Products;
select Price,(Price-200) as TotalPrice from Products;
select  Quantity ,(Quantity*2)as doublequantity from OrderItems;
select TotalAmount ,(TotalAmount /2) as dividedAmount from Orders;

-- Section E: Comparison Operators
select * from Orders where TotalAmount > 10000;
select * from Products where Price < 5000;
select * from Orders where TotalAmount >= 25000;
select * from Products where Price <= 8000;
select * from Customers where City= 'Chennai' ;

-- Section F: Logical Operators
select CustomerName from Customers
where City = 'Bangalore'
and CustomerName like 'a%';

select * from Products
where Category = "Electronics" or Category="Furniture" ;

select * from Orders
where TotalAmount>=5000 or TotalAmount <=70000;

select CustomerName from Customers
where City != 'Mumbai';

select * from Products
where Category != "Accessories" ;

-- Section G: Special Operators
select * from Products
where Category in ("Electronics" ,"Furniture" );

select CustomerName from Customers
where City not in ('Bangalore','Chennai');

select * from Orders
where TotalAmount between 5000 and 60000;

select * from Orders
where TotalAmount not between 5000 and 60000;

select * from Customers
where CustomerName like '%a';

select * from Products
where ProductName like 'm%';

select * from Customers
where Email is Null;

select * from Customers
where Email is not Null;

-- Section H: WHERE Clause
select * from Customers
where City="Chennai";

select * from Orders
where OrderDate > 2024-02-01;

select * from Products
where Price>10000;

select * from OrderItems
where Quantity=1;

select * from Customers
where Email is Null;

-- Section I: ORDER BY
select * from  Orders order by TotalAmount desc;
select * from  Customers order by CustomerName asc;
select * from  Products order by Price desc;
select * from  Orders order by OrderDate asc;

-- Section J: GROUP BY
select customerId , count(*) as TotalOrders from Orders
group by customerId;

select sum(TotalAmount) as totalRevenue , CustomerID from  Orders
group by CustomerID;

select avg(TotalAmount) as avgAmount , CustomerID from  Orders
group by CustomerID;

select sum(Quantity) AS TotalQuantity, ProductId from  OrderItems 
group by ProductId;

select count(*) as totalCount , Category from  Products 
group by Category ;

-- Section K: HAVING
select CustomerId, sum(TotalAmount) as TotalAmount
from Orders
group by CustomerId
having sum(TotalAmount) > 50000;

select CustomerId, count(OrderId) as OrderCount
from Orders
group by CustomerId
having count(OrderId) > 1;

select ProductId, sum(Quantity) as TotalQuantity
from OrderItems
group by ProductId
having sum(Quantity) > 1;

select Category, count(ProductId) as ProductCount
from Products
group by Category
having count(ProductId) > 1;

select CustomerId, avg(TotalAmount) as AvgOrderAmount
from Orders
group by CustomerId
having avg(TotalAmount) > 20000;

-- Section L: Join-Based Queries
select CustomerName, TotalAmount
from Customers
join Orders
on Customers.CustomerId = Orders.CustomerId;

select ProductName, Quantity
from Products
join OrderItems
on Products.ProductId = OrderItems.ProductId;

select CustomerName, OrderDate, TotalAmount
from Customers
join Orders
on Customers.CustomerId = Orders.CustomerId;

select OrderId, ProductName, Quantity
from OrderItems
join Products
on OrderItems.ProductId = Products.ProductId;

select CustomerName, Orders.OrderId, OrderDate, ProductName, Quantity, TotalAmount
from Customers
join Orders
on Customers.CustomerId = Orders.CustomerId
join OrderItems
on Orders.OrderId = OrderItems.OrderId
join Products
on OrderItems.ProductId = Products.ProductId;

-- Section M: Reporting Questions

select CustomerId, sum(TotalAmount) as TotalRevenue
from Orders
group by CustomerId
order by TotalRevenue desc;

select ProductId, sum(Quantity) as TotalQuantity
from OrderItems
group by ProductId
order by TotalQuantity desc;

select *
from Customers
where Email is null;

select month(OrderDate) as Month, sum(TotalAmount) as TotalRevenue
from Orders
group by month(OrderDate);

select *
from Orders
where TotalAmount > 20000;

select *
from Products
where ProductId not in
(
select ProductId from OrderItems
);

select *
from Customers
where CustomerId not in
(
select CustomerId from Orders
);

select CustomerId, sum(TotalAmount) as TotalRevenue
from Orders
group by CustomerId
order by TotalRevenue desc
limit 3;

select Category, sum(Quantity) as TotalSales
from Products
join OrderItems
on Products.ProductId = OrderItems.ProductId
group by Category;

select CustomerId, avg(TotalAmount) as AvgOrderValue
from Orders
group by CustomerId;





