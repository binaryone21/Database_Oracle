        select
            A.employee_id,
            A.department_id,
            B.department_name,
            C.location_id,
            C.city
                from hr.employees A, hr.departments B, hr.locations C
                    where A.department_id = B.department_id
                        and B.location_id = C.location_id;