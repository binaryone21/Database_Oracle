비교 연산자 : 비교 조회 조건 주기
    
    등호 연산자 =
    
        select *
            from hr.employees
                where employee_id = 100;

        select *
            from hr.employees
                where first_name = 'David';
                
    부등호 연산자 >=
    
        select *
            from hr.employees
                where employee_id > 105;
                
SQL 연산자 : 조회 조건 확장하기

    BETWEEN
    
        select *
            from hr.employees
                where salary between 10000 and 20000;
                
    IN
    
        select *
            from hr.employees
                where salary in (10000, 17000, 24000);
                
    LIKE
        
        select *
            from hr.employees
                where job_id like 'AD%';
            
        select *
            from hr.employees
                where job_id like 'AD___';
                
    IS NULL
    
        select *
            from hr.employees
                where manager_id is null;
                
논리 연산자 : 조건 논리를 계속 연결하기

        select *
            from hr.employees
                where salary > 4000
                    and job_id = 'IT_PROG'
                    or job_id = 'FI_ACCOUNT';
                    
        select *
            from hr.employees
                where employee_id <> 105;
                
        select *
            from hr.employees
                where manager_id is not null;

