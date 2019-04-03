   -- Migration to MySQL
1. Install MySQL 5.x
2. Create a database called CCCOWNER. Create a username: myadmin and password: myadmin
3. Create DMCS Schema by executing: dmcs_persistence\src\main\resources\mysql\01_dmcs_schema.sql
4. Load DMCS Data by executing: dmcs_persistence\src\main\resources\sql\mysql\02_dmcs_data.sql
5. Apply DMCS Relational Constraints by executing: dmcs_persistence\src\main\resources\sql\mysql\03_dmcs_constraint.sql
6. Apply fix: dmcs_persistence\src\main\resources\sql\mysql\04_dmcs_alter_cso_input_file_controls.sql
7. Apply fix: dmcs_persistence\src\main\resources\sql\mysql\05_dmcs_update_csf_directories.sql
8. Apply fix: dmcs_persistence\src\main\resources\sql\mysql\06_dmcs_fix_primary_keys.sql
6. Copy dmcs_persistence\src\main\resources\wildfly\standalone\configuration\standalone.xml to $JBOSS_HOME\standalone\configuration\standalone.xml
7. Restart JBOSS

-- To switch back to Oracle
1. Open $JBOSS_HOME\standalone\configuration\standalone.xml
2. Change line 215 from jndi-name="java:jboss/datasources/DMCSDb" to jndi-name="java:jboss/datasources/DMCSDbMySQL"
3. Change line 177 from jndi-name="java:jboss/datasources/DMCSDbOracle" to jndi-name="java:jboss/datasources/DMCSDb"
5. Restart JBOSS