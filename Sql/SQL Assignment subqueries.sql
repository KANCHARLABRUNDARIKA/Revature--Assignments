create database BankingDB;
use BankingDB;

-- TABLE 
create table  Customers(
CustomerId int auto_increment primary key,
CustomerName varchar(50),
Gender char,
DateOfBirth date,
PhoneNumber bigint,
Email varchar(50),
City varchar(50),
State varchar(50),
CustomerStatus varchar(50)
);

create table Branches(
BranchId int auto_increment primary key,
BranchName varchar(50), 
BranchCode varchar(50), 
City varchar(50), 
State varchar(50), 
IFSCCode varchar(50)
);

create table Accounts (
AccountId int,
CustomerId int,
BranchId int,
AccountNumber varchar(50),
AccountType varchar(50),
OpenDate date,
Balance decimal(10,2),
AccountStatus varchar(50)
);

create table Transactions (
TransactionId int,
AccountId int,
TransactionDate date,
TransactionType varchar(50),
Amount decimal(10,2),
Description varchar(200)
);

create table Loans (
LoanId int,
CustomerId int,
BranchId int,
LoanType varchar(50),
LoanAmount decimal(10,2),
InterestRate decimal(5,2),
LoanStartDate date,
LoanStatus varchar(50)
);

create table AccountAudit (
AuditId int,
AccountId int,
ActionType varchar(50),
OldBalance decimal(10,2),
NewBalance decimal(10,2),
ActionDate date,
Remarks varchar(200)
);

-- Primary key
alter table Accounts
add constraint pk_Accounts
primary key (AccountId);

alter table Transactions
add constraint pk_Transactions
primary key (TransactionId);

alter table Loans
add constraint pk_Loans
primary key (LoanId);

alter table AccountAudit
add constraint pk_AccountAudit
primary key (AuditId);

-- Foreign key
alter table Accounts
add constraint fk_Accounts_Customers
foreign key (CustomerId)
references Customers(CustomerId);

alter table Accounts
add constraint fk_Accounts_Branches
foreign key (BranchId)
references Branches(BranchId);

alter table Transactions
add constraint fk_Transactions_Accounts
foreign key (AccountId)
references Accounts(AccountId);

alter table Loans
add constraint fk_Loans_Customers
foreign key (CustomerId)
references Customers(CustomerId);

alter table Loans
add constraint fk_Loans_Branches
foreign key (BranchId)
references Branches(BranchId);

-- Not Null
alter table Customers
modify CustomerName varchar(50) not null;

alter table Customers
modify PhoneNumber varchar(15) not null;

alter table Branches
modify BranchName varchar(100) not null;

alter table Accounts
modify AccountNumber varchar(20) not null;

-- Unique
alter table Accounts
add constraint uq_AccountNumber
unique (AccountNumber);

alter table Branches
add constraint uq_BranchCode
unique (BranchCode);

alter table Branches
add constraint uq_IFSC
unique (IFSCCode);

alter table Customers
add constraint uq_Phone
unique (PhoneNumber);

alter table Customers
add constraint uq_Email
unique (Email);

insert into Customers values
(1,'Ravi Kumar','M','1995-05-10','9876543210','ravi@gmail.com','Chennai','Tamil Nadu','Active'),
(2,'Priya Sharma','F','1998-08-15','9876543211','priya@gmail.com','Bangalore','Karnataka','Active'),
(3,'Amit Verma','M','1992-03-20','9876543212','amit@gmail.com','Hyderabad','Telangana','Inactive'),
(4,'Neha Singh','F','1997-07-25','9876543213','neha@gmail.com','Chennai','Tamil Nadu','Active'),
(5,'Rahul Das','M','1990-12-05','9876543214','rahul@gmail.com','Mumbai','Maharashtra','Active');

insert into Branches values
(1,'Chennai Main','CH001','Chennai','Tamil Nadu','SBIN0001'),
(2,'Bangalore Central','BL001','Bangalore','Karnataka','SBIN0002'),
(3,'Hyderabad Branch','HY001','Hyderabad','Telangana','SBIN0003'),
(4,'Mumbai Main','MB001','Mumbai','Maharashtra','SBIN0004'),
(5,'Chennai West','CH002','Chennai','Tamil Nadu','SBIN0005');

insert into Accounts values
(1,1,1,'100001','Savings','2024-01-10',50000,'Active'),
(2,2,2,'100002','Current','2024-02-15',75000,'Active'),
(3,3,3,'100003','Savings','2024-03-20',20000,'Active'),
(4,4,1,'100004','Savings','2024-04-05',120000,'Active'),
(5,5,4,'100005','Fixed Deposit','2024-05-12',150000,'Active');

insert into Transactions values
(1,1,'2024-06-01','Deposit',10000,'Initial Deposit'),
(2,2,'2024-06-02','Withdrawal',5000,'ATM Withdrawal'),
(3,3,'2024-06-03','Deposit',7000,'Online Transfer'),
(4,4,'2024-06-04','Deposit',20000,'Salary'),
(5,5,'2024-06-05','Withdrawal',10000,'Cash Withdrawal');

insert into Loans values
(1,1,1,'Home Loan',500000,7.5,'2024-01-01','Approved'),
(2,2,2,'Car Loan',300000,8.0,'2024-02-01','Approved'),
(3,3,3,'Personal Loan',100000,9.5,'2024-03-01','Pending'),
(4,4,1,'Education Loan',200000,6.5,'2024-04-01','Approved'),
(5,5,4,'Personal Loan',150000,9.0,'2024-05-01','Closed');

insert into AccountAudit values
(1,1,'Account Created',0,50000,'2024-01-10','New Account'),
(2,2,'Account Created',0,75000,'2024-02-15','New Account'),
(3,3,'Account Created',0,20000,'2024-03-20','New Account'),
(4,4,'Account Created',0,120000,'2024-04-05','New Account'),
(5,5,'Account Created',0,150000,'2024-05-12','New Account');


select *
from Customers
where CustomerId in
(
select CustomerId
from Accounts
where Balance > 
(
select avg(Balance) from Accounts
)
);

select *
from Customers
where CustomerId in
(
select CustomerId
from Loans
where LoanAmount >
(
select max(LoanAmount)
from Loans
where LoanType = 'Personal Loan'
)
);

select *
from Accounts
where BranchId in
(
select BranchId
from Branches
where City = 'Chennai'
);

select *
from Customers
where CustomerId not in
(
select CustomerId
from Loans
);

select CustomerId
from Accounts
where AccountId in
(
select AccountId
from Transactions
group by AccountId
having sum(Amount) >
(
select sum(Amount)
from Transactions
where AccountId in
(
select AccountId
from Accounts
where CustomerId = 1
)
)
);

select *
from Branches
where BranchId in
(
select BranchId
from Accounts
group by BranchId
having count(AccountId) >
(
select avg(AccountCount)
from
(
select count(AccountId) as AccountCount
from Accounts
group by BranchId
) as temp
)
);

select *
from Accounts
where Balance =
(
select max(Balance)
from Accounts
where Balance <
(
select max(Balance) from Accounts
)
);

select *
from Customers
where CustomerId in
(
select CustomerId
from Accounts
where OpenDate =
(
select min(OpenDate)
from Accounts
)
);

select *
from Loans
where CustomerId in
(
select CustomerId
from Accounts
where AccountType = 'Savings'
);

select *
from Customers
where CustomerId in
(
select CustomerId
from Accounts
group by CustomerId
having count(AccountId) > 1
);
