# DeviceAPI
Test device api best practices

show dependency tree(.jar)

mvn dependency:tree
copy the jar(dependencies) to the target/dependency folder [ avoid any environmental problems ]

mvn dependency:copy-dependencies
compile the project

mvn compile
run the tests

mvn test
generate the .jars, often used in ear projects

mvn package
clears all dependencies(.jars)

mvn clean
look for all the commands you gave to maven

history | grep mvn
good practice adopted to generate the project's deploy package

mvn clean install 
