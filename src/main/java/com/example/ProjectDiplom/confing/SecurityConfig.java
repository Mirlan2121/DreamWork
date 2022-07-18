package com.example.ProjectDiplom.confing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/**").permitAll()
                .antMatchers(HttpMethod.GET,"/user/userCreate/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET, "/user/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/user/get-current/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/user/getAll/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/user/getByUserId/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/user/sing-in/**").fullyAuthenticated()

                .antMatchers(HttpMethod.DELETE,"/user/deleteUser/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/user/updateUser/**").fullyAuthenticated()

                //--------CLIENT INFO--------------//
                .antMatchers(HttpMethod.GET, "/clientInfo/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/clientInfo/create/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/clientInfo/getAll/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/clientInfo/clientName/{customerName}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/clientInfo/getById/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/clientInfo/deleteClient/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/clientInfo/updateClient/**").fullyAuthenticated()
                //--------COMPANY-----------------//
                .antMatchers(HttpMethod.GET, "/company/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/company/createCompany/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/company/getAll/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/company/getByCompanyId/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/company/deleteCompany/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/company/updateCompany/**").fullyAuthenticated()
                //--------TASK-----------------//
                .antMatchers(HttpMethod.GET, "/task/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/task/createTask/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/task/getAllTasks/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/task/getByIdTask/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/task/updateWorkers/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/task/deleteTask/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/task/updateStatus/**").fullyAuthenticated()
                //--------WORKERS-----------------//
                .antMatchers(HttpMethod.GET, "/workers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/workers/createWorkers/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workers/getAll/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workers/clientName/{customerName}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workers/getByWorkersId/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/workers/deleteWorkers/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/workers/updateWorkers/**").fullyAuthenticated()
                //--------TYPE CATALOG-----------------//
                .antMatchers(HttpMethod.GET, "/type/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/type/create/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/type/getAllType/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/type/getByTypeName/{name}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/type/getByTypeId/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE,"/type/deleteTypeCatalog/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.POST,"/type/updateTypeCatalog/**").fullyAuthenticated()
                //--------WORKER COMPANY-----------------//
                .antMatchers(HttpMethod.GET, "/workerCompany/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/workerCompany/save/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workerCompany/getAllUserCompany/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workerCompany/getByCompanyId/{id}/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/workerCompany/getById/{id}**").fullyAuthenticated()

                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active from users where username=?")
                .authoritiesByUsernameQuery
                        ("select u.username, ur.role_name as role from user_role ur inner join users u on ur.user_id = " +
                                "u.id where u.username=? and u.active=1");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
