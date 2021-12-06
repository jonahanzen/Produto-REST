
## Java REST - Produto - 

Este projeto começa simples, mas tenho grandes planos para ele. O objetivo é inicialmente ter uma aplicação rest com as operações padrão de GET, POST, PUT, DELETE.  Em especial o projeto e esta branch começam mostrando a facilidade de criar uma "API Rest" usando o framework Spring, e que mesmo abstraindo um bocado de coisas, há a possibilidade de "N" configurações.

Junto com o objetivo de ter uma API REST, eu **pretendo***  ter uma API Rest com as mesma especificação desta com diferentes configurações. Essa sendo o "marco zero", eu tenho ideias de criar branches utilizando apenas o Jakarta EE, e bancos como o MongoDB com as novas atualizações.  Eu tenho notado que os projetos no github utilizando o Java Enterprise ainda abusam do web.xml que é praticamente desnecessário nas novas versões,  vida longa a abstração e anotações! Sendo então a ideia principal, ter um projeto atualizado com diferentes configurações enquanto vou aprendendo as mesmas, para mostrar a mais pessoas formas mais fáceis de seguir o "modelo REST" usando o Java.

###  Especificações particulares desta Branch inicial

Ferramentas utilizadas : Java SE 17, Spring, Spring Data, Spring Boot, PostgreSQL, Maven

Favor checar [application.properties](https://github.com/jonahanzen/Produto-REST/blob/master/src/main/resources/application.properties) para detalhes do banco, para rodar o projeto.

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

### Configuração por Branch

- master
    - Java SE 17, Spring, Spring Data, Spring Boot, PostgreSQL, Maven, Apache Tomcat
- jakartaee
    - Java SE 11, Java EE 8, JUnit 5 , PostgreSQL, Maven, WildFly
