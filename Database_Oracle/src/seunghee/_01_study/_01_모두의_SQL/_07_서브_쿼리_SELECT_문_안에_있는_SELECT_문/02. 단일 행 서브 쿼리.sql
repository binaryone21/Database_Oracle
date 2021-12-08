        
        select *
            from hr.employees A
                where A.salary = (select salary
                                    from hr.employees
                                        where last_name = 'De Haan');