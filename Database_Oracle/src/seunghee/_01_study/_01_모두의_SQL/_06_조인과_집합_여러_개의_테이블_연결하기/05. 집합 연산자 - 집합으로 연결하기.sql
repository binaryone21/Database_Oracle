    UNION 
        
        select department_id
            from hr.employees
            
        union
        
        select department_id
            from hr.departments;
            
    UNION ALL
        
        select department_id
            from hr.employees
            
        union all
        
        select department_id
            from hr.departments;
            
    INTERSECT
        
        select department_id
            from hr.employees
            
        intersect
        
        select department_id
            from hr.departments;
            
    MINUS
    
        select department_id
            from hr.departments
            
        minus
        
        select department_id
            from hr.employees;