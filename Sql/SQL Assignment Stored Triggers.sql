use bankingdb;

-- Triggers

delimiter //
create trigger trg_before_insert_accounts
before insert on Accounts
for each row
begin
if new.Balance < 0 then
signal sqlstate '45000'
set message_text = 'Balance cannot be negative';
end if;
end //
delimiter ;

delimiter //
create trigger trg_after_insert_accounts
after insert on Accounts
for each row
begin
insert into AccountAudit
(AccountId, ActionType, OldBalance, NewBalance, ActionDate, Remarks)
values
(new.AccountId, 'Account Created', 0, new.Balance, curdate(), 'New Account');
end //
delimiter ;

delimiter //
create trigger trg_before_update_accounts
before update on Accounts
for each row
begin
if new.Balance < 0 then
signal sqlstate '45000'
set message_text = 'Balance cannot be negative';
end if;
end //
delimiter ;

delimiter //
create trigger trg_after_update_accounts
after update on Accounts
for each row
begin
if old.Balance <> new.Balance then
insert into AccountAudit
(AccountId, ActionType, OldBalance, NewBalance, ActionDate, Remarks)
values
(new.AccountId, 'Balance Updated', old.Balance, new.Balance, curdate(), 'Balance Changed');
end if;
end //
delimiter ;

delimiter //
create trigger trg_before_insert_transactions
before insert on Transactions
for each row
begin
if new.Amount <= 0 then
signal sqlstate '45000'
set message_text = 'Invalid transaction amount';
end if;
end //
delimiter ;

delimiter //
create trigger trg_after_insert_deposit
after insert on Transactions
for each row
begin
if new.TransactionType = 'Deposit' then
update Accounts
set Balance = Balance + new.Amount
where AccountId = new.AccountId;
end if;
end //
delimiter ;

delimiter //
create trigger trg_after_insert_withdrawal
after insert on Transactions
for each row
begin
if new.TransactionType = 'Withdrawal' then
update Accounts
set Balance = Balance - new.Amount
where AccountId = new.AccountId;
end if;
end //
delimiter ;

delimiter //
create trigger trg_before_delete_branches
before delete on Branches
for each row
begin
if exists
(
select 1
from Accounts
where BranchId = old.BranchId
)
then
signal sqlstate '45000'
set message_text = 'Cannot delete branch with accounts';
end if;
end //
delimiter ;

delimiter //
create trigger trg_before_insert_loans
before insert on Loans
for each row
begin
if new.LoanAmount < 10000 then
signal sqlstate '45000'
set message_text = 'Loan amount too low';
end if;
end //
delimiter ;

delimiter //
create trigger trg_after_update_loans
after update on Loans
for each row
begin
if old.LoanStatus = 'Pending' 
and new.LoanStatus in ('Approved','Closed') then
insert into AccountAudit
(AccountId, ActionType, ActionDate, Remarks)
values
(0, 'Loan Status Changed', curdate(), 'Loan Approved or Closed');
end if;
end //
delimiter ;