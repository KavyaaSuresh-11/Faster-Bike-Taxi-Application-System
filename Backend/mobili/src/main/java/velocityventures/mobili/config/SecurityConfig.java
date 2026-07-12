// package velocityventures.mobili.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// //To configure how the application secures incoming HTTP requests.
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// //annotation that enables web security support and activates the application's custom security configuration.
// import org.springframework.security.web.SecurityFilterChain;
// //class/interface representing the chain of security filters that process every incoming HTTP request.
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http){
//         http
//           .csrf(csrf -> csrf.disable())//cross site request forgery.
//         .authorizeHttpRequests(auth-> 
//             auth.requestMatchers("/users/login","/users/register","/create-application").permitAll()
//             .anyRequest().authenticated()
//         );
//         return http.build();
//     }
    
//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return new  BCryptPasswordEncoder();
//     }
// }
// //requestMatchers() is a method used to select the HTTP endpoints
// //authorizeHttpRequests() is a method of HttpSecurity used to configure authorization rules for HTTP endpoints.
