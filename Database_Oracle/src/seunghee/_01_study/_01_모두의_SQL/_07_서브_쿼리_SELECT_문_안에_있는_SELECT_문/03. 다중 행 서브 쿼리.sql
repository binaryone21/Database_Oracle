
        select *
            from hr.employees A
                where A.salary in (select min(salary)
                                        from hr.employees
                                            group by department_id)
                    order by A.salary desc;