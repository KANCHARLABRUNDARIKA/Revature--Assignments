-- views 
use bankingDB;

create view vw_CustomerAccountDetails as
select 
Customers.CustomerId,
CustomerName,
AccountNumber,
AccountType,
Balance,
AccountStatus
from Customers
join Accounts
on Customers.CustomerId = Accounts.CustomerId;

create view vw_BranchAccountSummary as
select 
BranchName,
count(AccountId) as TotalAccounts,
sum(Balance) as TotalBalance
from Branches
join Accounts
on Branches.BranchId = Accounts.BranchId
group by BranchName;

create view vw_LoanCustomerDetails as
select 
CustomerName,
LoanType,
LoanAmount,
InterestRate,
LoanStatus,
BranchName
from Loans
join Customers
on Loans.CustomerId = Customers.CustomerId
join Branches
on Loans.BranchId = Branches.BranchId;

create view vw_HighValueAccounts as
select *
from Accounts
where Balance > 100000;

create view vw_DailyTransactions as
select 
AccountNumber,
TransactionDate,
TransactionType,
Amount,
Description
from Transactions
join Accounts
on Transactions.AccountId = Accounts.AccountId;

create view vw_ActiveCustomers as
select *
from Customers
where CustomerStatus = 'Active';

create view vw_ApprovedLoans as
select *
from Loans
where LoanStatus = 'Approved';

create view vw_CustomerAccountBranch as
select 
CustomerName,
AccountNumber,
BranchName,
Balance
from Customers
join Accounts
on Customers.CustomerId = Accounts.CustomerId
join Branches
on Accounts.BranchId = Branches.BranchId;

select * from vw_ActiveCustomers;

update vw_ActiveCustomers
set City = 'Chennai'
where CustomerId = 1;

insert into vw_ActiveCustomers
values (6,'Arun','M','1995-06-01','9876543215','arun@gmail.com','Chennai','Tamil Nadu','Active');

create view vw_BranchBalanceSummary as
select 
BranchId,
sum(Balance) as TotalBalance
from Accounts
group by BranchId;

update vw_BranchBalanceSummary
set TotalBalance = 50000
where BranchId = 1;


