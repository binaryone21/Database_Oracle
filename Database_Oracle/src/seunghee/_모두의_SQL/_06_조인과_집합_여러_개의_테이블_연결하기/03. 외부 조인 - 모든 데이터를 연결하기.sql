        select
            A.employee_id,
            A.first_name,
            A.last_name,
            B.department_id,
            B.department_name
                from hr.employees A, hr.departments B
                    where A.department_id = B.department_id(+)
                        order by A.employee_id;