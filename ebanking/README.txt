Welcome to E banking
        -----------------------------------------
        | Technology | 	JSP, Servlet, Hibernate |
        |----------------------------------------
        | Build Tool |	       Maven            |
        |----------------------------------------
        |  Database  |	       mysql            |
        -----------------------------------------
   

This provides three type of access
  1.User
  2.Employee
  3.Admin

Admin account is already created it is only transferable account, new admin account can't be created.Admin can
     => create new Employee account.
     => Generate report in xls format of a particular account no(Admin generated report will have
        last 25 transation details of that account)

Employee account is created by admin. The employee can
     => Create bank account for user.
     => Deposit money to a particular account.
     => Withdraw money from a particular account.
     => Check balance of a bank account.
     => Generate report in xls format of a particular account no(Employee generated report will have
        last 20 transation details of that account)

User bank account is created by employee, then user needs to create online banking account. The user online banking 
account can be used for
     => See th account details.
     => Check balance of a bank account.
     => Transfer money to another account.
     => Generate report in xls format of a particular account no(user generated report will have
        last 10 transation details of that account)
   