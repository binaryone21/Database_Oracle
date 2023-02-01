
        select *
            from hr.employees A, (select department_id
                                    from hr.departments
                                        where department_name = 'IT') B
                where A.department_id = B.department_id;