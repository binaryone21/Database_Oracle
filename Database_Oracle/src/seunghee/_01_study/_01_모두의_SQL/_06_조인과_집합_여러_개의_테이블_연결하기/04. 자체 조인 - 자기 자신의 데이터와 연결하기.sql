        select
            A.employee_id,
            A.first_name,
            A.last_name,
            A.manager_id,
            B.first_name||' '||B.last_name manager_name
                from hr.employees A, hr.employees B
                    where A.manager_id = B.employee_id
                        order by A.employee_id;