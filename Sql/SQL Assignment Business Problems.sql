use bankingdb;

delimiter //
create procedure GetCustomersAboveBranchAvg()
begin
select *
from Customers
where CustomerId in
(
select CustomerId
from Accounts a
where Balance >
(
select avg(Balance)
from Accounts
where BranchId = a.BranchId
)
);
end //
delimiter ;

create view vw_ActiveCustomers1 as
select *
from Customers
where CustomerStatus = 'Active';
delimiter //
create procedure GetActiveCustomers()
begin
select *
from vw_ActiveCustomers;
end //
delimiter ;

delimiter //
create trigger trg_deposit_audit
after update on Accounts
for each row
begin
if new.Balance > old.Balance then
insert into AccountAudit
(AccountId, ActionType, OldBalance, NewBalance, ActionDate, Remarks)
values
(new.AccountId, 'Deposit', old.Balance, new.Balance, curdate(), 'Deposit Made');
end if;
end //
delimiter ;

create view vw_CustomerTransactionReport as
select 
CustomerName,
BranchName,
AccountNumber,
max(TransactionDate) as LatestTransaction
from Customers
join Accounts on Customers.CustomerId = Accounts.CustomerId
join Branches on Accounts.BranchId = Branches.BranchId
join Transactions on Accounts.AccountId = Transactions.AccountId
group by CustomerName, BranchName, AccountNumber;


delimiter //
create procedure GetCustomerTransactionCount(IN p_CustomerId int)
begin
select count(*) as TotalTransactions
from Transactions
where AccountId in
(
select AccountId
from Accounts
where CustomerId = p_CustomerId
);
end //
delimiter ;