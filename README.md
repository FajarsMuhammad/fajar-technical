## Command Line Application Using Spring boot and spring shell

To run this app you need following:

- JDK 8.+
- Maven 3.6.3
- MySQL 5.7.+

How to:

- Create `spring_cli` database

```mysql
create database spring_cli;
```

- Install
```shell
mvc clean install
```

- Run
```shell
java -jar ~/target/fajar-cli-1.0-SNAPSHOT.jar
```

- wait until show 
```shell
fajars:>
```

- The following command :
```shell
* `login [name]` - Logs in as this customer and creates the customer if not exist

* `deposit [amount]` - Deposits this amount to the logged in customer

* `transfer [target] [amount]` - Transfers this amount from the logged in customer to the target customer

* `logout` - Logs out of the current customer

```

Login
```shell
fajars:> login <username>
```

deposit
```shell
fajars:> deposit <amount>
```

transfer
```shell
fajars:> transfer <target> <amount>
```

logout
```shell
fajars:> logout
```
