		select
		    A.first_name,
		    A.last_name,
		    B.*
		        from hr.employees A, hr.job_history B
		            where A.employee_id = B.employee_id
		                and A.employee_id = 101;