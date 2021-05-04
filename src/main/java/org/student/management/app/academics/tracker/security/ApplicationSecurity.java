package org.student.management.app.academics.tracker.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.student.management.app.academics.tracker.service.impl.StudentServiceImpl;

@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter{
	private final StudentServiceImpl studentService;

	public ApplicationSecurity(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
	http.csrf().disable().authorizeRequests()
	}
	

}
