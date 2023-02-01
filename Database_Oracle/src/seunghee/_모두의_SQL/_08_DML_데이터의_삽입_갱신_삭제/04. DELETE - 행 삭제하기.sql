        delete from hr.departments
            where department_name in 'Sample_Dept';
            
        delete from hr.departments
            where department_id in (select department_id
                                        from hr.departments
                                            where department_name = 'Sample_Dept');