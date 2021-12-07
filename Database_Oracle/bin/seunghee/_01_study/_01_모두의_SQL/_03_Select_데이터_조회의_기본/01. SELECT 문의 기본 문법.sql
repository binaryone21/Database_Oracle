전체 데이터 조회하기

    SELECT ~ FROM
    	
        select * from hr.employees;

원하는 열만 조회하고 정렬하기
    
        select employee_id, first_name, last_name
            from hr.employees;

    ORDER BY
	
        select employee_id, first_name, last_name
            from hr.employees
                order by employee_id desc;
	
중복된 출력 값 제거하기

    DISTINCT
	
        select distinct job_id
            from hr.employees

SQL문을 효율적으로 작성하기 위해 별칭 사용하기

    AS
	
        select
            employee_id as 사원번호,
            first_name as 이름,
            last_name as 성
                from hr.employees;

데이터 값 연결하기

    ||
	
        select
            employee_id,
            first_name || last_name
                from hr.employees;

        select
            employee_id,
            first_name ||' '|| last_name,
            email||'@'||'company.com'
                from hr.employees;
		        
산술 처리하기 : 데이터 값끼리 계산

    산술 연산자
    
        select
            employee_id,
            salary,
            salary+500,
            salary-100,
            (salary * 1.1)/2
                from hr.employees;
                
        select
            employee_id as 사원번호,
            salary as 급여,
            salary+500 as 추가급여,
            salary-100 as 인하급여,
            (salary * 1.1)/2 as 조정급여
                from hr.employees;