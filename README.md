# springboot_padrao
Spring Boot Padrão

# RUN postgres(docker)
docker start dev-postgres

## TESTS:

### Run all the unit test classes.
$ mvn test  or  mvn clean package spring-boot:repackage

# Run a single test class.
$ mvn -Dtest=EstacaoRepositoryTest test

# Run a single test method from a test class.
$ mvn -Dtest=EstacaoRepositoryTest#whenFindByNomeCustomQuery_thenReturnEstacao test
