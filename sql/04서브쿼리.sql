-- 1번
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(s.salary)
from salaries s
where s.to_date = '9999-01-01'
	and s.salary > (select avg(s.salary)
					from salaries s
					where s.to_date = '9999-01-01')
order by s.salary asc;

-- 2번
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 
-- 사번, 이름, 부서 연봉을 조회하세요. 
-- 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.

select 
	d.dept_no,
	e.emp_no 사번, 
    concat(e.first_name, ' ', e.last_name) 이름, 
    d.dept_name 부서,
    s.salary 연봉
from 
	employees e, 
    departments d, 
    dept_emp de, 
    salaries s,
    (select d.dept_no, max(s.salary) as sal
						from employees e, dept_emp de, departments d, salaries s
						where e.emp_no = de.emp_no
							and e.emp_no = s.emp_no
							and de.dept_no = d.dept_no
							and e.emp_no = s.emp_no
							and s.to_date = '9999-01-01'
							and de.to_date = '9999-01-01'
						group by d.dept_no) max_dept
where e.emp_no = de.emp_no
	and s.emp_no = de.emp_no
    and de.dept_no = d.dept_no
    and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and max_dept.sal = s.salary
    and max_dept.dept_no = de.dept_no;


-- 3번
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 
-- 사원의 사번, 이름과 연봉을 조회하세요 
select 
	e.emp_no 사번,
    concat(e.first_name, ' ', e.last_name) 이름,
    s.salary 연봉
from employees e, 
	salaries s, 
    dept_emp de,
	(select d.dept_no, avg(s.salary) as dept_salary_avg
		from employees e, dept_emp de, departments d, salaries s
		where e.emp_no = de.emp_no
			and e.emp_no = s.emp_no
			and de.dept_no = d.dept_no
			and e.emp_no = s.emp_no
			and s.to_date = '9999-01-01'
			and de.to_date = '9999-01-01'
		group by d.dept_no) dept_salary
where e.emp_no = s.emp_no
	and s.emp_no = de.emp_no
	and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and s.salary > dept_salary.dept_salary_avg
    and de.dept_no = dept_salary.dept_no;


-- 4번
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select 
	e.emp_no 사번,
    concat(e.first_name, ' ', e.last_name) 이름,
	manager.m_name '매니저 이름',
    d.dept_name '부서 이름'
from 
	employees e, 
    dept_emp de, 
    departments d,
    (select 
		e.emp_no,
        dm.dept_no,
		concat(e.first_name, ' ', e.last_name) m_name
	from employees e, dept_manager dm
	where e.emp_no = dm.emp_no
		and dm.to_date = '9999-01-01') manager
where e.emp_no = de.emp_no
	and de.dept_no = d.dept_no
    and manager.dept_no = de.dept_no
    and de.to_date = '9999-01-01'
order by e.emp_no;
    
select 
	e.emp_no,
	concat(e.first_name, ' ', e.last_name) m_name
from employees e, dept_manager dm
where e.emp_no = dm.emp_no
	and dm.to_date = '9999-01-01';
    
-- 5번
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 
-- 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select 
	de.dept_no,
	e.emp_no 사번,
    concat(e.first_name, ' ', e.last_name) 이름,
    t.title 직책,
    s.salary 연봉
from 
	employees e, 
    dept_emp de, 
    salaries s,
    titles t
where e.emp_no = de.emp_no
	and e.emp_no = s.emp_no
    and t.emp_no = e.emp_no
    and de.to_date = '9999-01-01'
    and s.to_date = '9999-01-01'
    and t.to_date = '9999-01-01'
    and de.dept_no = (select de.dept_no
						from employees e, salaries s, dept_emp de
						where e.emp_no = s.emp_no
							and e.emp_no = de.emp_no
							and de.to_date = '9999-01-01'
							and s.to_date = '9999-01-01'
						group by de.dept_no
						having round(avg(s.salary), 2) = (select round(max(dept_sal.avg_dept_sal), 2)
															from 
																(select de.dept_no, avg(s.salary) as avg_dept_sal
																from employees e, salaries s, dept_emp de
																where e.emp_no = s.emp_no
																and e.emp_no = de.emp_no
																and de.to_date = '9999-01-01'
																and s.to_date = '9999-01-01'
																group by de.dept_no) dept_sal))
order by s.salary desc;


-- 6번
-- 평균 연봉이 가장 높은 부서는?
select d.dept_name
from employees e, salaries s, dept_emp de, departments d
where e.emp_no = s.emp_no
	and e.emp_no = de.emp_no
    and de.dept_no = d.dept_no
	and de.to_date = '9999-01-01'
	and s.to_date = '9999-01-01'
group by de.dept_no
having round(avg(s.salary), 2) = (
		select round(max(dept_sal.avg_dept_sal), 2)
		from
			(select 
				de.dept_no, 
				avg(s.salary) as avg_dept_sal
			from employees e, salaries s, dept_emp de
			where e.emp_no = s.emp_no
				and e.emp_no = de.emp_no
				and de.to_date = '9999-01-01'
				and s.to_date = '9999-01-01'
			group by de.dept_no) 
		dept_sal);


-- 7번
-- 평균 연봉이 가장 높은 직책?
select t.title
from titles t, salaries s
where t.emp_no = s.emp_no
	and s.to_date = '9999-01-01'
group by t.title
having round(avg(s.salary), 2) = (select round(max(avg_sal_title.avg_sal), 2)
					from (select t.title, avg(s.salary) avg_sal
							from titles t, salaries s
							where t.emp_no = s.emp_no
								and s.to_date = '9999-01-01'
							group by t.title) 
						avg_sal_title);
                        

-- 8번
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select 
	de.dept_no,
	d.dept_name 부서이름,
	concat(e.first_name, ' ', e.last_name) 이름,
    s.salary 연봉,
	manager.name '매니저 이름',
    manager.salary '매니저 연봉' 
from 
	employees e,
	dept_emp de, 
    departments d, 
    salaries s,
    (select 
		dm.dept_no,
		e.emp_no,
		s.salary,
		concat(e.first_name, ' ', e.last_name) name
	from dept_manager dm, salaries s, employees e
	where dm.emp_no = s.emp_no
		and dm.emp_no = e.emp_no
		and e.emp_no = s.emp_no
		and dm.to_date = '9999-01-01'
		and s.to_date = '9999-01-01') manager
where e.emp_no = de.emp_no
	and de.emp_no = s.emp_no
	and d.dept_no = de.dept_no
    and de.to_date = '9999-01-01'
    and s.to_date = '9999-01-01'
    and de.dept_no = manager.dept_no
    and s.salary > manager.salary
order by de.dept_no desc, s.salary asc;
