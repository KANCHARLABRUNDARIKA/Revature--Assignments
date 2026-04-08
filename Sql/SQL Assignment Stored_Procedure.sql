use bankingdb;

-- Stored Procedure

delimiter //
create procedure GetAllCustomers()
begin
select * from Customers;
end //
delimiter ;

delimiter //
create procedure GetAccountsByCustomer(IN p_CustomerId int)
begin
select *
from Accounts
where CustomerId = p_CustomerId;
end //
delimiter ;

delimiter //
create procedure GetBranchTotalBalance(IN p_BranchId int)
begin
select sum(Balance) as TotalBalance
from Accounts
where BranchId = p_BranchId;
end //
delimiter ;

delimiter //
create procedure GetApprovedLoanCount(OUT p_TotalCount int)
begin
select count(*) into p_TotalCount
from Loans
where LoanStatus = 'Approved';
end //
delimiter ;

delimiter //
create procedure AddTransaction(
IN p_AccountId int,
IN p_TransactionType varchar(20),
IN p_Amount decimal(10,2),
IN p_Description varchar(200)
)
begin
insert into Transactions
(AccountId, TransactionDate, TransactionType, Amount, Description)
values
(p_AccountId, curdate(), p_TransactionType, p_Amount, p_Description);
end //
delimiter ;

delimiter //
create procedure DepositAmount(
IN p_AccountId int,
IN p_Amount decimal(10,2)
)
begin
update Accounts
set Balance = Balance + p_Amount
where AccountId = p_AccountId;
insert into Transactions
(AccountId, TransactionDate, TransactionType, Amount, Description)
values
(p_AccountId, curdate(), 'Deposit', p_Amount, 'Deposit');
end //
delimiter ;


delimiter //
create procedure WithdrawAmount(
IN p_AccountId int,
IN p_Amount decimal(10,2)
)
begin
declare currentBalance decimal(10,2);
select Balance into currentBalance
from Accounts
where AccountId = p_AccountId;
if currentBalance >= p_Amount then
update Accounts
set Balance = Balance - p_Amount
where AccountId = p_AccountId;
insert into Transactions
(AccountId, TransactionDate, TransactionType, Amount, Description)
values
(p_AccountId, curdate(), 'Withdrawal', p_Amount, 'Withdrawal');
end if;
end //
delimiter ;

delimiter //
create procedure GetCustomerLoans(IN p_CustomerId int)
begin
select *
from Loans
where CustomerId = p_CustomerId;
end //
delimiter ;

delimiter //
create procedure ChangeAccountStatus(
IN p_AccountId int,
IN p_NewStatus varchar(20)
)
begin
update Accounts
set AccountStatus = p_NewStatus
where AccountId = p_AccountId;
end //
delimiter ;

delimiter //
create procedure AddServiceCharge(INOUT p_Balance decimal(10,2))
begin
set p_Balance = p_Balance - 100;
end //
delimiter ;

