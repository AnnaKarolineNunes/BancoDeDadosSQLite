# Lidando com banco de dados no android

## Descrição

Neste projeto o bjetivo consistiu na criação de um banco de dados integrado a um aplicativo Android, proporcionando a capacidade de realizar operações básicas por meio deste sistema.
Temos aqui alguns exemplos: 
```
    //criar a tabela
    bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

```

    // inserir dados
    bancoDados.execSQL("INSERT INTO pessoas(nome,idade)VALUES ('Leticia','45')"); // a ordem importa

```
      // atualizar registros
      bancoDados.execSQL("UPDATE pessoas SET nome  = 'Mariana Silva' WHERE id  = 2" );
