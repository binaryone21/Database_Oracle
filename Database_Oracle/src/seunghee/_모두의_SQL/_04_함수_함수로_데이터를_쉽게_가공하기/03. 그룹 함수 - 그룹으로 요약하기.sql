그룹 함수의 종류와 사용법

    COUNT 함수
    
        select count(salary) salary행수
            from hr.employees;
            
    SUM, AVG 함수
    
        select
            sum(salary) 합계,
            avg(salary) 평균,
            sum(salary)/count(salary) 계산된평균
                from hr.employees;
                
    MAX, MIN 함수
    
        select
            max(salary) 최댓값,
            min(salary) 최솟값,
            max(first_name) 최대문자값,
            min(first_name) 최소문자값
                from hr.employees;
                
GROUP BY : 그룹으로 묶기

        select
            job_id 직무,
            sum(salary) 직무별_총급여,
            avg(salary) 직무별_평균급여
                from hr.employees
                    where employee_id >= 10
                        group by job_id
                            order by 직무별_총급여 desc, 직무별_평균급여;
                            
        select
            job_id 대그룹,
            manager_id 중그룹,
            sum(salary) 그룹핑_총급여,
            avg(salary) 그룹핑_평균급여
                from hr.employees
                    where employee_id >= 10
                        group by job_id, manager_id
                            order by 그룹핑_총급여 desc, 그룹핑_평균급여;
                            
HAVING : 연산된 그룹 함수 결과에 조건 적용하기

        select
            job_id 직무,
            sum(salary) 직무별_총급여,
            avg(salary) 직무별_평균급여
                from hr.employees
                    where employee_id >= 10
                        group by job_id
                            having sum(salary) > 30000
                                order by 직무별_총급여 desc, 직무별_평균급여;