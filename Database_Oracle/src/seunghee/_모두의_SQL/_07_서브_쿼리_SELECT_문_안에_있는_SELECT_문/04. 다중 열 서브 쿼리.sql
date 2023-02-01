
        select *
            from hr.employees A
                where (A.job_id, A.salary) in (select
                                                job_id,
                                                min(salary)
                                                    from hr.employees
                                                        group by job_id)
                    order by A.salary desc;