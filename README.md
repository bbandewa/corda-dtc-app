# corda-dtc-app
Corda Digital Trade Chain Project Repository

# software prerequisites
1. JDK 8.0 and above
2. Eclipse Luna v4.4.2
3. Git v2.11.0
4. Maven v3.3.9
5. Gradle Eclipse Plugin (Help->Install New Software) url - http://dist.springsource.com/release/TOOLS/gradle
6. Postman (REST client)

# application setup
$ git clone https://github.com/biksen/corda-dtc-app.git

Open Eclipse:
File->Import->Gradle

# corda dependent jars
Core Corda platform dependent JARs: 
1. client 
2. corda 
3. core 
4. finance 
5. node

Corda Maven Central Repository::

https://mvnrepository.com/artifact/net.corda/corda/0.7 

https://mvnrepository.com/artifact/net.corda/client/0.7

Corda Maven Local Repository::

C:/Users/biksen/.m2/repository/net/corda

# Broadcasting
https://discourse.corda.net/t/broadcasting-in-corda-7-missing-signature/755

# REST api call

PUT:http://localhost:10005/api/dtc/NodeB/create-purchase-order

{"orderNumber": "100","deliveryDate": "2018-09-15","deliveryAddress": {"city": "London","country": "UK"},"items" : [{"name": "widget","amount": "3"},{"name": "thing","amount": "4"}]}

# Git commit issue
If you face git commit error saying "non-fast-forward". Use the following command:
C:\git\corda-dtc-app\>git pull origin master
then push through eclipse.
