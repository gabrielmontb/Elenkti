# Elenkti

Sistema Elenktí para automatizar a portaria de retirada de equipamentos da UFV-CRP.

> Este repositório contém a aplicação backend/cliente desenvolvida em Java (projeto Ant/NetBeans). Use o arquivo BANCO_DADOS.md para detalhes sobre o esquema e a configuração do banco de dados.

## Recursos

- Registro e controle de retiradas/devoluções de equipamentos
- Geração de relatórios básicos (histórico de retiradas)
- Autenticação/identificação dos usuários (implementar conforme necessidade)

## Tecnologias

- Java
- Ant (build.xml)
- Projeto compatível com NetBeans

## Pré-requisitos

- JDK 8 ou superior
- Ant (opcional, para build via linha de comando)
- Banco de dados (veja `BANCO_DADOS.md` para instruções de criação/seed/credenciais)

## Instalação e execução

1. Clone o repositório:

   git clone https://github.com/gabrielmontb/Elenkti.git

2. Abra o projeto no NetBeans (recomendado) ou importe para sua IDE preferida.

3. Configure o banco de dados conforme o arquivo `BANCO_DADOS.md`.

4. Build e run:

   - Pelo NetBeans: execute o projeto diretamente.
   - Pela linha de comando com Ant (se disponível):

     ant compile
     ant run

   (Os alvos exatos podem variar; abra o `build.xml` para ver as targets disponíveis.)

## Estrutura do repositório

- `src/` - código-fonte Java
- `nbproject/` - arquivos do NetBeans
- `build.xml` - script de build Ant
- `BANCO_DADOS.md` - descrição e instruções do banco de dados

## Como contribuir

1. Abra uma issue descrevendo a melhoria ou bug.
2. Crie um branch com um nome descritivo: `feature/minha-melhora` ou `fix/bug-xyz`.
3. Abra um pull request explicando as mudanças.

Sinta-se à vontade para abrir issues pedindo orientação antes de começar alterações maiores.

## Licença

Inclua aqui a licença do projeto (por exemplo, MIT, Apache-2.0). Se ainda não definiu uma, adicione um arquivo `LICENSE` com a licença desejada.

## Contato

Gabriel Montserrat — https://github.com/gabrielmontb

---

Para detalhes técnicos sobre o banco de dados e scripts de criação, consulte `BANCO_DADOS.md` no repositório.
