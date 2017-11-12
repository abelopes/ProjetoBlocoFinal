# Projeto de Bloco Final

> Nós nos tornamos o que fazemos. (HERBERT, Frank)
 
## O que é?

Software para avaliação da instituição por seus alunos usando a escala de ***Likert*** ([o quê é isso?](https://pt.wikipedia.org/wiki/Escala_Likert)).

## O que você vai precisar para rodar?

 - [Netbeans 8.2](https://netbeans.org/downloads/)
 - [MySQL 5.7](https://dev.mysql.com/downloads/mysql/)
	 - Crie uma base chamada **projeto_bloco_final**
 - [Hibernate: 5.2.10.Final](http://hibernate.org/orm/releases/5.2/)
	 - **IMPORTANTE**: você precisa ter um diretório chamado "libs" no mesmo nível do diretório do projeto, no caso "ProjetoBlocoFinal" (ver item abaixo sobre os diretórios do projeto).

***Obs.:*** clique nos links para baixar as dependências.

## Diretórios do projeto

Por default o Netbeans cria o projeto em, por exemplo, **C:\Users\USUARIO\Documents\NetBeansProjects**. 

Você terá uma estrutura de diretórios como:

- **NetBeansProjects** *=>> ESSE É O DIRETÓRIO NO QUAL O NETBEANS CRIA OS ARQUIVOS*
	- **libs** *=>> VOCÊ VAI CRIAR ESSE DIRETÓRIO*
		- **hibernate-release-5.2.10.Final** *=>> VOCÊ VAI BAIXAR ISSO DE [http://hibernate.org/orm/releases/5.2/](http://hibernate.org/orm/releases/5.2/)*
			- **lib**
				- **optional** *=>> AQUI FICAM OS ARQUIVOS OPCIONAIS DO HIBERNATE*
				- **required** *=>> AQUI FICAM OS ARQUIVOS REQUERIDOS PELO HIBERNATE*
	- **ProjetoBlocoFinal** *=> ESSE É O CONTEÚDO DO PROJETO QUE VEM DO GIT*