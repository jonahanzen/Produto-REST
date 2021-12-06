

## Java REST - Produto - 

Esta branch segue o conceito da primeira feita com o Spring Boot, porém esta foi feita sem frameworks, apenas com o Java "puro" , com exceção da conexão que o Wildfly abstraiu.
O objetivo é seguir aprendendo diferentes frameworks e implementar uma aplicação Rest simples com as mais derivadas configurações.

Para a aplicação rodar, é necessário configurar uma conexão JDBC pelo WildFly, e o hibernate pode criar o banco se necessário, alterando o database.action no persistence.xml para "create".


###  Especificações particulares desta Branch inicial

Ferramentas utilizadas : Java SE 11, Java EE 8, JUnit 5 , PostgreSQL, Maven, WildFly24+


### Endpoints

Observação : Optei por parametrizar os endpoints por variável de caminho, então as urls não estão no corpo ou como parametros, mas como caminhos mesmo, ex : POST : localhost:8080/api/v1/produto/1/televisao/3500,   levei em consideração que fica "mais didático" dessa forma.

- GET :
    - /produto : Consulta todos os produtos
	- /produto/id : Consulta o produto por id 
	- /produto/nome : Consulta o produto que conter o que for no nome, ignorando case / **A ser implementado**

- POST : 
    - /produto/nome/preco : cria um novo produto com o nome e preço 

- PUT :
    - /produto/id/nome/preco : Altera os dados do produto a partir do id fornecido
	
- DELETE :
    - /produto/id : Deleta o produto por id