문자 타입 함수

    LOWER, UPPER, INITCAP : 데이터 값을 대소문자로 변환하기
    
        select
            last_name,
            lower(last_name) LOWER적용,
            upper(last_name) upper적용,
            email,
            initcap(email) initcap적용
                from hr.employees;
                
    SUBSTR : 지정한 길이만큼 문자열 추출하기
    
        select
            job_id,
            substr(job_id, 1, 2) 적용결과
                from hr.employees;
                
    LPAD, RPAD : 특정 문자로 자릿수 채우기
    
        select
            first_name,
            lpad(first_name, 12, '*') LPAD적용결과
                from hr.employees;
    
        select
            first_name,
            rpad(first_name, 12, '*') RPAD적용결과
                from hr.employees;
        
    LTRIM, RTRIM : 특정 문자 삭제하기
    
        select
            job_id,
            ltrim(job_id, 'F') LTRIM적용결과,
            rtrim(job_id, 'T') RTRIM적용결과
                from hr.employees;
                
    TRIM : 공백 제거하기
    
        select 'start' || trim('  - space -   ') || 'end'
            from dual;
            
숫자 타입 함수

    ROUND : 숫자 반올림하기
    
        select
            salary,
            salary/30 일급,
            round(salary/30, 0) 적용결과0,
            round(salary/30, 1) 적용결과1,
            round(salary/30, -1) 적용결과minus1
                from hr.employees;
                
    TRUNC : 숫자 절삭하기
    
        select
            salary,
            salary/30 일급,
            trunc(salary/30, 0) 적용결과0,
            trunc(salary/30, 1) 적용결과1,
            trunc(salary/30, -1) 적용결과minus1
                from hr.employees;
                
날짜 타입 함수

        select
            to_char(sysdate, 'YY/MM/DD/HH24:MI') 오늘날짜,
            sysdate+1 더하기1,
            sysdate-1 빼기1,
            to_date('20171202', 'YYYYMMDD')-to_date('20171201', 'YYYYMMDD') "날짜빼기",
            sysdate+13/24 시간더하기,
            sysdate
                from dual;

    MONTHS_BETWEEN : 두 날짜 사이의 개월 수 계산하기
    
        select
            sysdate,
            hire_date,
            months_between(sysdate, hire_date) 적용결과
                from hr.employees
                    where department_id = 100;
                    
    ADD_MONTHS : 월에 날짜 더하기
        
        select
            hire_date,
            add_months(hire_date, 3) 더하기_적용결과,
            add_months(hire_date, -3) 빼기_적용결과
                from hr.employees
                    where employee_id between 100 and 106;
        
    NEXT_DAY : 돌아오는 요일의 날짜 계산하기
    
        select
            hire_date,
            next_day(hire_date, 'sat') 적용결과_문자지정,
            next_day(hire_date, 6) 적용결과_숫자지정
                from hr.employees
                    where employee_id between 100 and 106;
                    
    LAST_DAY : 돌아오는 월의 마지막 날짜 계산하기
    
        select
            hire_date,
            last_day(hire_date) 적용결과
                from hr.employees
                    where employee_id between 100 and 106;
                    
    ROUND, TRUNC : 날짜를 반올림하거나 절삭하기
    
        select
            hire_date,
            round(hire_date, 'month') 적용결과_ROUND_M,
            round(hire_date, 'year') 적용결과_ROUND_Y,
            trunc(hire_date, 'month') 적용결과_TRUNC_M,
            trunc(hire_date, 'year') 적용결과_TRUNC_Y
                from hr.employees
                    where employee_id between 100 and 106;
            
변환 함수
    
    자동 데이터 타입 변환
    
        select 1 + '2' from dual;
        
    날짜 및 시간 형식 변환하기
    
        select
            to_char(sysdate, 'yy'),
            to_char(sysdate, 'yyyy'),
            to_char(sysdate, 'mm'),
            to_char(sysdate, 'mon'),
            to_char(sysdate, 'yyyymmdd') 응용적용1,
            to_char(to_date('20171008', 'yyyymmdd')) 응용적용2
                from dual;
                
        select
            to_char(sysdate, 'hh-mi-ss pm') 시간형식,
            to_char(sysdate, '"날짜 : " yyyy/mm/dd "시각 : " hh:mi:ss pm') 날짜와시각표현
                from dual;
                
    숫자 형식 변환하기        
        
        select to_number('123') from dual;
        
일반 함수

    NVL : NULL 값 처리하기
    
        select salary * NVL(commission_pct, 1)
            from hr.employees
                order by commission_pct desc;
                
    DECODE : 조건 논리 처리하기
    
        select
            first_name,
            last_name,
            department_id,
            salary 원래급여,
            decode(department_id, 60, salary*1.1, salary) 조정된급여,
            decode(department_id, 60, '10%인상', '미인상') 인상여부
                from hr.employees;

    CASE 표현식 : 복잡한 조건 논리 처리하기
    
        select
            employee_id,
            first_name,
            last_name,
            salary,
            case
                when salary >= 9000 then '상위급여'
                when salary between 6000 and 8999 then '중위급여'
                else '하위급여'
            end as 급여등급
                from hr.employees
                    where job_id = 'IT_PROG';
                    
    RANK, DENSE_RANK, ROW_NUMBER : 데이터 값에 순위 매기기
    
        select
            employee_id,
            salary,
            rank() over(order by salary desc) RANK_급여,
            dense_rank() over(order by salary desc) DENSE_RANK_급여,
            row_number() over(order by salary) ROW_NUMBER_급여
                from hr.employees;
                
        select
            employee_id,
            department_id,
            salary,
            rank() over(partition by department_id order by salary desc) RANK_급여,
            dense_rank() over(partition by department_id order by salary desc) DENSE_RANK_급여,
            row_number() over(partition by department_id order by salary) ROW_NUMBER_급여
                from hr.employees;
