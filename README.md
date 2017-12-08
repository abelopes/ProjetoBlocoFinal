# Projeto de Bloco Final

> Nós nos tornamos o que fazemos. (HERBERT, Frank)
 
## O que é?

Software para avaliação da instituição por seus alunos usando a escala de ***Likert*** ([o quê é isso?](https://pt.wikipedia.org/wiki/Escala_Likert)).

## O que você vai precisar para rodar?

 - [Netbeans 8.2](https://netbeans.org/downloads/)
 - [MySQL 5.7](https://dev.mysql.com/downloads/mysql/)
	 - Crie uma base chamada **projeto_bloco_final** com 'login/senha' como 'root/root'.

***Obs.:*** clique nos links para baixar as dependências.

## Dependências

 - Você deve colocar o conteúdo do projeto https://github.com/brucelucien/ProjetoBlocoFinalLibs dentro do diretório **lib** na raiz deste projeto.
 - **ATENÇÃO**: se você precisar adicionar novas bibliotecas ao projeto o faça também nesse repositório citado acima e, no Netbeans, faça uma referência com **caminho relativo**, que é uma opção do Netbeans quando incluímos novas libs ao projeto.

## Carga inicial de usuários

  - Você deve executar o script abaixo para adicionar alguns usuários (com 'login/senha' como 'EDUARDO/123', 'JOAO/123' e 'MARCOS/123') à aplicação.

<pre>
INSERT INTO user 
            (id, 
             email, 
             password, 
             salt, 
             status, 
             username, 
             aluno_id) 
VALUES      (1, 
             NULL, 
             'f3887592f08cffaf18e078b3c708dbe896e1e331', 
             '6b3d32e0-2f70-490d-aaa2-4daccb66fccd', 
             0, 
             'EDUARDO', 
             NULL); 

INSERT INTO user 
            (id, 
             email, 
             password, 
             salt, 
             status, 
             username, 
             aluno_id) 
VALUES      (2, 
             '', 
             'd39778d594d4e580ca34afa822ac4ce89000952b', 
             '6a5dde38-7012-4ef7-a5f2-067a7488d8c2', 
             0, 
             'JOAO', 
             NULL); 

INSERT INTO user 
            (id, 
             email, 
             password, 
             salt, 
             status, 
             username, 
             aluno_id) 
VALUES      (3, 
             NULL, 
             'b3eeee2f57df2c6f5243e684af38bb0c2bad88e3', 
             '6c4557c5-cdf8-4ea7-bb1a-ca2b31ce9f0f', 
             NULL, 
             'MARCOS', 
             NULL); 
</pre>

## Manhas do Netbeans

  - [Alt + Enter]: sobre um trecho de código qualquer oferece opções úteis;
  - [Alt + Shift + O]: procurar qualquer arquivo do projeto;
  - [Shift + Ctrl + F]: procurar por uma string qualquer nos arquivos do projeto;
  - [Ctrl + O]: procurar por tipos.