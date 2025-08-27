# CineDRIVE

## Visão Geral
O **CineDRIVE** é um sistema web em JavaEE para gerenciamento básico de um acervo de filmes, permitindo:
- Upload e download de arquivos de vídeo.
- Paginação e navegação pela lista de filmes.
- Avaliação de filmes.
- Comentários em filmes.
- Cadastro, login e gerenciamento de perfil de usuários.

O projeto utiliza JSP/Servlets, seguindo o padrão MVC, e roda em um servidor Apache Tomcat.

## Funcionalidades
- **Autenticação**: cadastro, login e logout de usuários.
- **Perfil de Usuário**: exibição e edição de dados pessoais.
- **CRUD de Filmes**: upload, listagem (com paginação), avaliação, comentários e download.
- **Navegação**: barra de navegação dinâmica conforme status do usuário (logado/deslogado).

## Estrutura do Projeto

 /Banco de Dados
 
 ├─ cine_drive_tabelas.sql # criação de tabelas 
 
 └─ insercoes.sql # dados de exemplo 

/CineDRIVE (Eclipse JavaEE) 

/─ .classpath 

/─ .project 

/─ .settings/ # configurações Eclipse 

/─ build/ # classes compiladas 

/─ lib/ # bibliotecas adicionais (se houver) 

/─ src/ 

└─ main/ 

├─ java/ 

│ ├─ Controller/ # servlets de controle de fluxo 

│ ├─ Dao/ # classes de acesso a dados 

│ ├─ DB/ # utilitários de conexão 

│ └─ Model/ # JavaBeans de domínio 

└─ webapp/ 

├─ WEB-INF/ 

│ ├─ lib/ # (JARs externos, se necessários) 

│ └─ web.xml # configuração de servlets 

├─ META-INF/ 

│ └─ MANIFEST.MF 

├─ assets/ # CSS, JS, imagens 

├─ icons/ # ícones (ex: pipoca.png) 

├─ *.jsp # páginas JSP 

├─ *.css # estilos 

└─ index.jsp # página inicial 

/Servers 

└─ Tomcat v9.0 Server at localhost-config/ # configs locais do Tomcat 

## Tecnologias Utilizadas
- **Linguagem**: Java 8+  
- **Framework**: Java EE (Servlets, JSP, JSTL)  
- **Servidor de Aplicação**: Apache Tomcat 9  
- **Banco de Dados**: MySQL (ou MariaDB)  
- **IDE Recomendada**: Eclipse IDE for Enterprise Java Developers  

## Pré-requisitos
- Java Development Kit (JDK) 8 ou superior  
- Apache Tomcat 9.x  
- MySQL Server 5.7+ (ou MariaDB compatível)  
- Eclipse com suporte a Java EE  

## Instalação e Configuração

1. **Clone este repositório**  
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. **Importe no Eclipse**

	- File → Import... → Existing Maven/Gradle/General → Existing Projects into Workspace
	
	- Selecione a pasta CineDRIVE.

3. **Configure o Tomcat**

	- Em Servers, crie um novo servidor Apache Tomcat v9.0 apontando para sua instalação local.
	
	- Adicione o projeto à instância do servidor.

4. **Prepare o Banco de Dados**

	- No MySQL, crie um schema (por ex. cinedrive).
	
	- Execute os scripts em /Banco de Dados/cine_drive_tabelas.sql para criar as tabelas.
	
	- Popule dados iniciais com /Banco de Dados/insercoes.sql.

5. **Configuração de Conexão JDBC**

	- Ajuste em src/main/java/DB/ConnectionFactory.java as credenciais (URL, usuário, senha) do seu banco.
	
	- Coloque o driver JDBC (MySQL Connector/J) em WEB-INF/lib se não estiver no classpath do Tomcat.

6. **Como Executar**
	- No Eclipse, clique com o botão direito no projeto → Run As → Run on Server.
	
	- Acesse no navegador: http://localhost:8080/CineDRIVE/ .
