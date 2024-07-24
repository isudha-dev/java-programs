package interview.interview_athena;

/*
how to print number 1-10 by 2 threads.
 */

/*
EMPLOYEE
Id    Name    Manager_Id
1     Ravi        3
2     Kumar   	  3
3     Rizwan     NULL

Query?
select ...

Result
Employee_Name    Manager_Name
Ravi                 Rizwan
Kumar                Rizwan
Rizwan               NULL
 */

/*

    select e.Employee_Name, m.Employee_Name
    from EMPLOYEE e
    left join EMPLOYEE m
    where e.Manager_Id == m.id;

 */
public class Test3 {

}
