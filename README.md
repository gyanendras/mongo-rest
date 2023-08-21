# mongo-rest
Spring security - Authentication - As in Who you are , confirming your identity ?
Authorization - Confirming your role, Are you Admin or Analyst.
Depending on Authentiction , Access will be allowed  to a resource in  your application - username and password, biometrics
Depending on Authorizaton , how many and which one of resources ? - Role names , Are you ROLE_ADMIN, or ROLE_Analysts
Use  @Bean
    public SecurityFilterChain 
    it has a http object , to which we can configure , filter class, login form to use and authentication manager(Decide from where to get username and passwd) and also configure which url mapping should be authenticated or free for all like login. And in Filter we check for token and roles.
    Token is encrypted form of your username and roles.
