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
        