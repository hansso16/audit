package com.soses.audit.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import com.soses.audit.common.GeneralUtil;
import com.soses.audit.entity.AntMatcher;
import com.soses.audit.repository.AntMatcherRepository;
import com.soses.audit.repository.RoleHierarchyRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	private AntMatcherRepository antMatcherRepo;
	
	private RoleHierarchyRepository roleHierarchyRepo;
	
	private final AuthenticationProvider authenticationProvider;
	
	public SecurityConfig(AntMatcherRepository antMatcherRepo, RoleHierarchyRepository roleHierarchyRepo
			, AuthenticationProvider authenticationProvider) {
		super();
		this.antMatcherRepo = antMatcherRepo;
		this.roleHierarchyRepo = roleHierarchyRepo;
		this.authenticationProvider = authenticationProvider;
	}
	
	 @Bean
	 MethodSecurityExpressionHandler MmthodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
		 DefaultMethodSecurityExpressionHandler meh = new DefaultMethodSecurityExpressionHandler();
		 meh.setRoleHierarchy(roleHierarchy);
		 return meh;
	  }

    @Bean
    RoleHierarchy roleHierarchy() {

        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        List<com.soses.audit.entity.RoleHierarchy> rhList = roleHierarchyRepo.findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate.now(), LocalDate.now());
        if (!GeneralUtil.isListEmpty(rhList)) {
            StringBuilder hierarchy = new StringBuilder();
            for (com.soses.audit.entity.RoleHierarchy role : rhList) {
                if (role.getChildRole() != null && role.getParentRole() != null) {
                    hierarchy.append(role.getParentRole().getFullRoleCode()).append(" > ").append(role.getChildRole().getFullRoleCode()).append(" \n");
                }
            }
            roleHierarchy.setHierarchy(hierarchy.toString());
        }
        return roleHierarchy;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests()
            .requestMatchers("/favicon.ico").permitAll()
            .requestMatchers("/css/public/*").permitAll()
            .requestMatchers("/js/public/*").permitAll()
            ;

        
        List<AntMatcher> matchers = antMatcherRepo.findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate.now(), LocalDate.now());
        for (AntMatcher matcher : matchers) {
        	AuthorityAuthorizationManager<RequestAuthorizationContext> auth = AuthorityAuthorizationManager.<RequestAuthorizationContext>hasRole(matcher.getRoleInfo());
        	auth.setRoleHierarchy(roleHierarchy());
            http.authorizeHttpRequests().requestMatchers(matcher.getPath()).access(auth);
        }

        http
            .authorizeHttpRequests()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .and().logout().permitAll()
            .and().authenticationProvider(authenticationProvider)
            ;

        return http.build();
    }
}
