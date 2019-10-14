# Produto API
### Uma simples aplicação de cadastro de usuários, produtos e suas respectivas categorias.

## Swagger
A aplicação conta com swagger configurado podendo ser acessado através da url: 
> http://localhost:8081/v1/dev/swagger-ui.htm

## JWT
A aplicação também conta com com configuração de segurança Json Web Token (JWT).

## Testes
Os testes podem ser iniciados e visualizados através da lib Jacoco usando-se os seguintes comandos:
> mvn clean install

> mvn jacoco:report

Com esse segundo comando um diretório com nome de "site" será criado na pasta target, após acessá-la clique em index.html. Na página que se abrirá será possível visualizar os testes e quais classes e métodos estão sendo cobridos por eles, bem como a percentagem de cobertura.

