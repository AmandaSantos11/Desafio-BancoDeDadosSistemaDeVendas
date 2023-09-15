# Desafio - Sistema de vendas com Banco de dados  :computer: 🏦

*Nesse desafio o objetivo era desenvolver sistema de vendas que contivesse um banco de dados.*

<hr>

**💡 A regra de negócio era:**

+ **O banco de dados deveria conter as seguintes queries:**
    + Pesquisar os itens que foram vendidos acima de R$10,00;
    + Alterar o valor do "valor_total" para zero de todos os registros onde este campo é nulo;
    + Pesquisar o salário dos vendedores e ordenar o resultado do maior salário para o menor;
    + Excluir um cliente;
    + Pesquisar quantos usuários tem o email 'zup.com.br'.

<hr>

+ Para desenvolver esse sistema utilizei o banco de dados Postgres, arquitetura MVC e a linguagem de programação Java. Iniciei o desafio organizando a estrutura das tabelas e fazendo a criação do mesmo no banco, em seguida desenvolvi a classe ‘ConnectionDB’ que é responsável pela conexão com o banco de dados e desenvolvi as seguintes classes e suas respectivas queries:

  + ClientRepository - 'deleteClient()', 'registerClient()', 'clientShopping()';

  + ProdutcRepository - 'registerProduct()';

  + SaleRepository - 'displayAllSalesOverTenReais()', 'changeTheTotalValueOfSalesThatAreNullToZero()', 'registerSale()';

  + SellerRepository - 'showSellerInformation()', 'showEmailsThatContainZup()';

  + ValidateLoginRepository - 'validateLogin()'.


+ Após isso, desenvolvi a model de cada tabela do meu banco que são:

  + ClientModel;

  + ProductModel;

  + SaleModel;

  + SellerModel.

    **Exemplo de model:**

        public class ClientModel {
        private String name;
        private String email;
        private String cpf;
        private String address;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        }

+ O projeto também conta com o pacote de controller que é responsável por se comunicar com o repositório e o pacote de service que é responsável pelas validações do sistema como garantir que o ‘cpf’ e ‘email’ estejam de acordo com o que o sistema espera.


+ Por fim temos o pacote de view que é responsável por exibir os menus e receber os input do usuário e permitir que ele interaja com o sistema.

<hr>

# Conclusão 🎉✔

Com este desafio pude exercitar e fixar os meus conhecimentos em persistência de dados e criação de banco de dados, além de praticar tudo o que havia aprendido até o momento.

<hr>

# Script SQL 🐘

*As queries utilizadas no programa foram escritas no PostgreSQL da seguinte forma seguindo a regra de négocio:*

**1º Query:**

      SELECT produto.nome,venda.valor_total
      FROM produto,venda
      WHERE produto.id_produto = venda.id_produto
      AND venda.valor_total >= 10.00

**2º Query:**

    UPDATE venda
    SET valor_total = 0
    WHERE valor_total IS NULL

**3º Query:**

    SELECT vendedor.nome,vendedor.salario
    FROM vendedor
    ORDER BY vendedor.salario DESC

**4º Query:**

    DELETE FROM cliente WHERE id_cliente = 1

**5º Query:**

    SELECT nome, email
    FROM vendedor
    WHERE email LIKE '%@zup.com.br%'
    UNION
    SELECT nome, email
    FROM cliente
    WHERE email LIKE '%@zup.com.br%'


**Query extra:**

*Nessa query, eu exibo as compras do cliente com base no seu CPF.*

    SELECT produto.nome,venda.qtd_produto,venda.valor_total
    FROM cliente
    INNER JOIN venda ON cliente.id_cliente = venda.id_cliente
    INNER JOIN produto ON produto.id_produto = venda.id_produto
    WHERE cliente.cpf = ? 

<hr>

# Modelo das tabelas no PostgreSQL 📄


***Tabela 'produto'***

| Coluna      | Tipo    | Chave  | Descrição                 |
|-------------|---------|-------------------|---------------------------|
| id_produto  | AUTOINCREMENT     | chave primária               | Identificador do produto  |
| nome        | TEXT    | -                 | Nome do produto           |
| preco       | NUMERIC | -                 | Preço do produto          |



***Tabela 'cliente'***

| Coluna      | Tipo    | Chave  | Descrição               |
|-------------|---------|------------------|-------------------------|
| id_cliente  | AUTOINCREMENT     | chave primária   | Identificador do cliente|
| nome        | TEXT | -                | Nome do cliente         |
| email       | TEXT | -                | Email do cliente        |
| cpf         | TEXT | -                | CPF do cliente          |
| endereco    | TEXT | -                | Endereço do cliente     |



***Tabela 'vendedor'***

| Coluna      | Tipo    | Chave  | Descrição               |
|-------------|---------|-------------------|-------------------------|
| id_vendedor | AUTOINCREMENT     | chave primária    | Identificador do vendedor|
| nome        | TEXT    | -                 | Nome do vendedor        |
| email       | TEXT | -                 | Email do vendedor       |
| cpf         | TEXT | -                 | CPF do vendedor         |
| salario     | NUMERIC | -                 | Salário do vendedor     |



***Tabela 'venda'***

| Coluna      | Tipo    | Chave              | Descrição                       |
|-------------|---------|--------------------|---------------------------------|
| id_venda    | AUTOINCREMENT     | chave primária     | Identificador da venda          |
| qtd_produto  | INT     | -                  | Quantidade de produtos          |
| valor_total  | NUMERIC | -                  | Valor total da venda            |
| id_vendedor  | INT     | chave estrangeira  | referenciando a tabela Vendedor |
| id_cliente   | INT     | chave estrangeira                | referenciando a tabela Cliente  |
| id_produto   | INT     | chave estrangeira               | referenciando a tabela Produto  |

