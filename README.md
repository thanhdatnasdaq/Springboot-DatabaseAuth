# Springboot-DatabaseAuth

1) Create User, Role in entity package

2) Create the UserRepository, RoleRepository in repository package

3) Add the  authenticationManager(...) method and UserDetailsService in SpringSecurityConfig.java

4) Eitheir modify the security layer with authorize.requestMatchers in SpringSecurityConfig.java or @PreAuthorize("hasAnyRole('ADMIN', 'USER')") in PostController.java

5) Create the CustomUserDetailsService class in security package

6) open database and insert value for roles, users (password entered in user should be encode, can be seen in the utils package), set the user_roles table
