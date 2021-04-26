Controle de Pautas
__________________________________________
Tecnologias
  Este projeto foi feito usando java 11 com Spring Boot, 
  JUnit para os testes, e o banco de Dados H2 por proporcionar uma fácil utilização independente de onde o projeto for baixado
Persistindo também os dados independente do projeto ser reiniciado ou atualizado.

1- Ferramentas e Configurações
1.1- Eclipse
Instalação

Baixar e descompactar um dos pacotes (Win ou Linux 64-bit) da versão Eclipse IDE for Java Developers (ou outra IDE de sua escolha).

Importação do Projeto (Git)

Após abrir o Eclipse(Ou a IDE de sua escolha), importar projeto do Git:

File -> Import... -> Projects from Git -> Clone URI
URI: https://github.com/lucasugiette23/controle-pautas -> Next
Escolher branch master
Local destination: pasta-do-workspace
Import as general project -> Next -> Finish
Configuração do Projeto

Clicar com botão direito no projeto -> Configure -> Convert to Maven project
Clicar com botão direito no projeto -> Maven -> Update Project...
OK (incluir opção Force Update os Snapshots/Releases)
Incluir Run Configurations:

Maven Build (para gerar a build do sistema)

New launch configuration:
Name: controle-pautas [maven install]
Base directory: selecionar-nome-do-projeto
Goals: install
Java Application (para rodar a aplicação localmente)
