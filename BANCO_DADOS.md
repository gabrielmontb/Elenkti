# Documentação do Banco de Dados - Elenktí

**Autor:** Gabriel Montserrat  
**Versão:** 1.0  
**SGBD:** MySQL 5.7+

---

## 📋 Índice

1. [Configuração Inicial](#configuração-inicial)
2. [Schema do Banco](#schema-do-banco)
3. [Tabelas Detalhadas](#tabelas-detalhadas)
4. [Relacionamentos](#relacionamentos)
5. [Índices e Performance](#índices-e-performance)
6. [Scripts SQL](#scripts-sql)
7. [Backup e Recuperação](#backup-e-recuperação)
8. [Troubleshooting](#troubleshooting)

---

## ⚙️ Configuração Inicial

### Criar Banco de Dados

```sql
CREATE DATABASE Elenkti 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE Elenkti;
```

### Configuração Hibernate (hibernate.cfg.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC 
  "-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
  "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <!-- Dialect para MySQL -->
    <property name="hibernate.dialect">
      org.hibernate.dialect.MySQLDialect
    </property>
    
    <!-- Driver JDBC -->
    <property name="hibernate.connection.driver_class">
      com.mysql.jdbc.Driver
    </property>
    
    <!-- URL de conexão -->
    <property name="hibernate.connection.url">
      jdbc:mysql://localhost:3306/Elenkti?zeroDateTimeBehavior=convertToNull
    </property>
    
    <!-- Credenciais -->
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">sua_senha_aqui</property>
    
    <!-- Auto-criação/atualização de tabelas -->
    <property name="hibernate.hbm2ddl.auto">update</property>
    
    <!-- Propriedades opcionais -->
    <property name="hibernate.format_sql">true</property>
    <property name="hibernate.use_sql_comments">true</property>
    <property name="hibernate.jdbc.batch_size">20</property>
    <property name="hibernate.connection.pool_size">5</property>
    
    <!-- Mapeamento de classes -->
    <mapping class="model.bean.Usuario"/>
    <mapping class="model.bean.Funcionario"/>
    <mapping class="model.bean.Equipamento"/>
  </session-factory>
</hibernate-configuration>
```

---

## 📊 Schema do Banco

### Diagrama Visual

```
┌─────────────┐
│   USUARIO   │
├─────────────┤
│ id (PK)     │◄────────────────┐
│ nome        │                 │
│ email       │         (Futuro)│
│ senha       │                 │
│ tipo        │                 │
│ ativo       │                 │
│ created_at  │                 │
│ updated_at  │                 │
└─────────────┘                 │
                                │
┌──────────────────┐            │
│   FUNCIONARIO    │    Gerencia│
├──────────────────┤            │
│ id (PK)          │            │
│ nome             │            │
│ matricula (UK)   │            │
│ departamento     │            │
│ telefone         │            │
│ ativo            │            │
│ created_at       │            │
│ updated_at       │            │
└──────────────────┘            │
                                │
                    ┌───────────┘
                    │
┌──────────────────▼──┐
│    EQUIPAMENTO      │
├─────────────────────┤
│ id (PK)             │
│ nome                │
│ descricao           │
│ tag (UK)            │
│ status              │
│ localizacao         │
│ data_aquisicao      │
│ usuario_id (FK)     │◄─────┘ (Futuro)
│ created_at          │
│ updated_at          │
└─────────────────────┘
```

---

## 📋 Tabelas Detalhadas

### 1. Tabela: usuario

**Descrição:** Armazena dados dos usuários do sistema

```sql
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('usuario', 'admin') DEFAULT 'usuario',
    ativo BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

**Campos:**

| Campo | Tipo | Restrições | Descrição |
|-------|------|-----------|-----------|
| `id` | INT | PK, AUTO_INCREMENT | Identificador único |
| `nome` | VARCHAR(100) | NOT NULL | Nome do usuário |
| `email` | VARCHAR(100) | UNIQUE, NOT NULL | Email único para login |
| `senha` | VARCHAR(255) | NOT NULL | Senha (idealmente com hash) |
| `tipo` | ENUM | DEFAULT 'usuario' | Tipo de acesso (usuario/admin) |
| `ativo` | BOOLEAN | DEFAULT TRUE | Indica se usuário está ativo |
| `created_at` | TIMESTAMP | DEFAULT NOW | Data de criação |
| `updated_at` | TIMESTAMP | DEFAULT NOW | Data de última atualização |

**Índices:**
```sql
CREATE INDEX idx_usuario_email ON usuario(email);
CREATE INDEX idx_usuario_ativo ON usuario(ativo);
```

**Exemplo de Insert:**
```sql
INSERT INTO usuario (nome, email, senha, tipo, ativo) 
VALUES ('Gabriel', 'gabriel@ufv.edu.br', 'senha123', 'admin', TRUE);
```

---

### 2. Tabela: funcionario

**Descrição:** Armazena dados dos funcionários da instituição

```sql
CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    departamento VARCHAR(100),
    telefone VARCHAR(20),
    ativo BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

**Campos:**

| Campo | Tipo | Restrições | Descrição |
|-------|------|-----------|-----------|
| `id` | INT | PK, AUTO_INCREMENT | Identificador único |
| `nome` | VARCHAR(100) | NOT NULL | Nome completo |
| `matricula` | VARCHAR(20) | UNIQUE, NOT NULL | Matrícula institucional |
| `departamento` | VARCHAR(100) | - | Departamento/Setor |
| `telefone` | VARCHAR(20) | - | Telefone de contato |
| `ativo` | BOOLEAN | DEFAULT TRUE | Status do funcionário |
| `created_at` | TIMESTAMP | DEFAULT NOW | Data de criação |
| `updated_at` | TIMESTAMP | DEFAULT NOW | Data de última atualização |

**Índices:**
```sql
CREATE INDEX idx_funcionario_matricula ON funcionario(matricula);
CREATE INDEX idx_funcionario_ativo ON funcionario(ativo);
CREATE INDEX idx_funcionario_departamento ON funcionario(departamento);
```

**Exemplo de Insert:**
```sql
INSERT INTO funcionario (nome, matricula, departamento, telefone, ativo) 
VALUES ('João Silva', '001234', 'TI', '(34)3899-1234', TRUE);
```

---

### 3. Tabela: equipamento

**Descrição:** Armazena dados dos equipamentos gerenciados

```sql
CREATE TABLE equipamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT,
    tag VARCHAR(50) UNIQUE NOT NULL,
    status ENUM('disponível', 'indisponível', 'manutenção', 'descartado') 
           DEFAULT 'disponível',
    localizacao VARCHAR(100),
    data_aquisicao DATE,
    usuario_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

**Campos:**

| Campo | Tipo | Restrições | Descrição |
|-------|------|-----------|-----------|
| `id` | INT | PK, AUTO_INCREMENT | Identificador único |
| `nome` | VARCHAR(150) | NOT NULL | Nome do equipamento |
| `descricao` | TEXT | - | Descrição detalhada |
| `tag` | VARCHAR(50) | UNIQUE, NOT NULL | Código/TAG de rastreamento |
| `status` | ENUM | DEFAULT 'disponível' | Estado atual |
| `localizacao` | VARCHAR(100) | - | Localização física |
| `data_aquisicao` | DATE | - | Data de compra/aquisição |
| `usuario_id` | INT | FK, NULL | Usuário responsável (futuro) |
| `created_at` | TIMESTAMP | DEFAULT NOW | Data de criação |
| `updated_at` | TIMESTAMP | DEFAULT NOW | Data de última atualização |

**Possíveis Status:**
- `disponível` - Pronto para uso
- `indisponível` - Em uso ou reservado
- `manutenção` - Sob manutenção
- `descartado` - Removido do inventário

**Índices:**
```sql
CREATE INDEX idx_equipamento_tag ON equipamento(tag);
CREATE INDEX idx_equipamento_status ON equipamento(status);
CREATE INDEX idx_equipamento_localizacao ON equipamento(localizacao);
```

**Exemplo de Insert:**
```sql
INSERT INTO equipamento (nome, descricao, tag, status, localizacao, data_aquisicao) 
VALUES ('Monitor Dell 24"', 'Monitor LED, Entrada HDMI', 'LAB-001', 
        'disponível', 'Laboratório 01', '2020-05-15');
```

---

## 🔗 Relacionamentos

### Relacionamento Futuro: Usuario → Equipamento

Quando implementado:

```sql
ALTER TABLE equipamento 
ADD CONSTRAINT fk_eq_usuario 
FOREIGN KEY (usuario_id) REFERENCES usuario(id) 
ON DELETE SET NULL 
ON UPDATE CASCADE;
```

**Significado:**
- Um usuário pode ter vários equipamentos
- Se usuário for deletado, equipamentos ficam órfãos (NULL)
- Se ID do usuário mudar, é atualizado em cascata

### Relacionamento Futuro: Funcionario → Equipamento

Possível extensão:

```sql
ALTER TABLE equipamento 
ADD COLUMN funcionario_id INT,
ADD FOREIGN KEY (funcionario_id) REFERENCES funcionario(id) 
ON DELETE SET NULL;
```

---

## ⚡ Índices e Performance

### Índices Criados Automaticamente

```sql
-- Chaves primárias (automáticas)
CREATE INDEX pk_usuario ON usuario(id);
CREATE INDEX pk_funcionario ON funcionario(id);
CREATE INDEX pk_equipamento ON equipamento(id);

-- Índices de unicidade (automáticos)
CREATE UNIQUE INDEX uk_usuario_email ON usuario(email);
CREATE UNIQUE INDEX uk_funcionario_matricula ON funcionario(matricula);
CREATE UNIQUE INDEX uk_equipamento_tag ON equipamento(tag);
```

### Índices Recomendados para Performance

```sql
-- Para buscas por status
CREATE INDEX idx_equipamento_status ON equipamento(status);

-- Para buscas por localização
CREATE INDEX idx_equipamento_localizacao ON equipamento(localizacao);

-- Para buscas por ativo
CREATE INDEX idx_usuario_ativo ON usuario(ativo);
CREATE INDEX idx_funcionario_ativo ON funcionario(ativo);

-- Para buscas por departamento
CREATE INDEX idx_funcionario_departamento ON funcionario(departamento);

-- Índice composto para consultas frequentes
CREATE INDEX idx_eq_status_loc ON equipamento(status, localizacao);
```

### Análise de Queries Lentas

```sql
-- Ativar log de queries lentas
SET GLOBAL slow_query_log = 'ON';
SET GLOBAL long_query_time = 2;

-- Analisar query
EXPLAIN SELECT * FROM equipamento WHERE status = 'disponível';
```

---

## 🔤 Scripts SQL

### Script de Inicialização Completa

```sql
-- 1. Criar banco de dados
CREATE DATABASE IF NOT EXISTS Elenkti 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE Elenkti;

-- 2. Criar tabelas
DROP TABLE IF EXISTS equipamento;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS usuario;

-- Tabela usuario
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('usuario', 'admin') DEFAULT 'usuario',
    ativo BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela funcionario
CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL,
    departamento VARCHAR(100),
    telefone VARCHAR(20),
    ativo BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela equipamento
CREATE TABLE equipamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT,
    tag VARCHAR(50) UNIQUE NOT NULL,
    status ENUM('disponível', 'indisponível', 'manutenção', 'descartado') 
           DEFAULT 'disponível',
    localizacao VARCHAR(100),
    data_aquisicao DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. Criar índices
CREATE INDEX idx_usuario_ativo ON usuario(ativo);
CREATE INDEX idx_funcionario_ativo ON funcionario(ativo);
CREATE INDEX idx_funcionario_departamento ON funcionario(departamento);
CREATE INDEX idx_equipamento_status ON equipamento(status);
CREATE INDEX idx_equipamento_localizacao ON equipamento(localizacao);

-- 4. Inserir dados iniciais
INSERT INTO usuario (nome, email, senha, tipo, ativo) 
VALUES ('Administrador', 'admin@ufv.edu.br', 'admin123', 'admin', TRUE);

INSERT INTO funcionario (nome, matricula, departamento, telefone, ativo)
VALUES ('Gerente TI', '000001', 'Tecnologia da Informação', '(34)3899-1000', TRUE);

COMMIT;
```

### Consultas Úteis

**Listar todos os equipamentos disponíveis:**
```sql
SELECT id, nome, tag, localizacao, data_aquisicao 
FROM equipamento 
WHERE status = 'disponível' 
ORDER BY nome;
```

**Contar equipamentos por departamento:**
```sql
SELECT departamento, COUNT(*) as total 
FROM funcionario 
WHERE ativo = TRUE 
GROUP BY departamento;
```

**Buscar usuários inativos:**
```sql
SELECT id, nome, email, tipo 
FROM usuario 
WHERE ativo = FALSE;
```

**Equipamentos adquiridos em 2020:**
```sql
SELECT nome, tag, localizacao 
FROM equipamento 
WHERE YEAR(data_aquisicao) = 2020;
```

**Equipamentos em manutenção há mais de 30 dias:**
```sql
SELECT nome, tag, updated_at 
FROM equipamento 
WHERE status = 'manutenção' 
AND DATE_SUB(NOW(), INTERVAL 30 DAY) > updated_at;
```

---

## 💾 Backup e Recuperação

### Criar Backup

```bash
# Backup completo do banco
mysqldump -u root -p Elenkti > backup_elenkti_$(date +%Y%m%d_%H%M%S).sql

# Backup com compressão
mysqldump -u root -p Elenkti | gzip > backup_elenkti_$(date +%Y%m%d_%H%M%S).sql.gz

# Apenas estrutura (sem dados)
mysqldump -u root -p --no-data Elenkti > estrutura_elenkti.sql

# Apenas dados (sem estrutura)
mysqldump -u root -p --no-create-info Elenkti > dados_elenkti.sql
```

### Restaurar Backup

```bash
# Restaurar backup completo
mysql -u root -p Elenkti < backup_elenkti_20210228_100000.sql

# Restaurar com compressão
gunzip < backup_elenkti_20210228_100000.sql.gz | mysql -u root -p Elenkti
```

### Agendamento de Backups (Linux Cron)

```bash
# Adicionar ao crontab
crontab -e

# Executar backup diariamente às 2 da manhã
0 2 * * * mysqldump -u root -psenha Elenkti | gzip > /backup/elenkti_$(date +\%Y\%m\%d).sql.gz
```

---

## 🔍 Troubleshooting

### Problema 1: "Access Denied"

**Erro:**
```
java.sql.SQLException: Access denied for user 'root'@'localhost'
```

**Solução:**
1. Verificar credenciais em `hibernate.cfg.xml`
2. Verificar se MySQL está rodando: `mysql -u root -p`
3. Recriar usuário se necessário:
```sql
CREATE USER 'novouser'@'localhost' IDENTIFIED BY 'senha';
GRANT ALL PRIVILEGES ON Elenkti.* TO 'novouser'@'localhost';
FLUSH PRIVILEGES;
```

### Problema 2: "Database Not Found"

**Erro:**
```
java.sql.SQLException: Unknown database 'Elenkti'
```

**Solução:**
Executar script de criação do banco:
```sql
CREATE DATABASE Elenkti CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### Problema 3: "JDBC Driver Not Found"

**Erro:**
```
java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
```

**Solução:**
1. Verificar se `mysql-connector-java` está no classpath
2. Em NetBeans: Project Properties → Libraries → Add JAR

### Problema 4: Tabelas Não Criadas

**Erro:** Banco existe mas tabelas vazias

**Solução:**
1. Verificar que `hibernate.hbm2ddl.auto` está como "update"
2. Executar aplicação uma vez (criará tabelas)
3. Ou executar script SQL manualmente

### Problema 5: Performance Lenta

**Diagnóstico:**
```sql
-- Verificar índices
SHOW INDEX FROM equipamento;

-- Analisar tamanho
SELECT 
    table_name,
    ROUND(((data_length + index_length) / 1024 / 1024), 2) AS tamanho_mb
FROM information_schema.TABLES
WHERE table_schema = 'Elenkti';
```

**Solução:**
- Adicionar índices (veja seção de Índices)
- Otimizar tabelas: `OPTIMIZE TABLE equipamento;`
- Analisar queries com `EXPLAIN`

### Problema 6: Encoding de Caracteres

**Erro:** Caracteres especiais aparecem como "????"

**Solução:**
1. Verificar que banco usa `utf8mb4`
2. Verificar que tabelas usam `utf8mb4`
3. Verificar URL Hibernate: adicionar `characterEncoding=UTF-8`

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/Elenkti?characterEncoding=UTF-8&useUnicode=yes
</property>
```

---

## 📊 Consultas de Análise

### Estatísticas do Banco

```sql
-- Total de registros por tabela
SELECT 
    'usuario' as tabela, COUNT(*) as total FROM usuario
UNION ALL
SELECT 
    'funcionario', COUNT(*) FROM funcionario
UNION ALL
SELECT 
    'equipamento', COUNT(*) FROM equipamento;

-- Equipamentos por status
SELECT status, COUNT(*) as total 
FROM equipamento 
GROUP BY status;

-- Funcionários por departamento
SELECT departamento, COUNT(*) as total 
FROM funcionario 
WHERE ativo = TRUE
GROUP BY departamento 
ORDER BY total DESC;

-- Usuários ativos vs inativos
SELECT 
    CASE WHEN ativo THEN 'Ativo' ELSE 'Inativo' END as status,
    COUNT(*) as total
FROM usuario
GROUP BY ativo;
```

---

## 📝 Política de Retenção de Dados

**Dados Permanentes:**
- Registros de usuários, funcionários e equipamentos

**Dados com Versionamento:**
- Campos `created_at` e `updated_at` rastreiam mudanças

**Possíveis Melhorias:**
- Implementar soft deletes (flag `deleted_at`)
- Criar tabelas de auditoria para histórico completo
- Manter backups por 12 meses

---

## 🔐 Segurança do Banco

### Princípios Implementados

✅ Senhas armazenadas (sem hash em produção - MELHORAR)  
✅ Restrições de UNIQUE em campos sensíveis  
✅ Timestamps automáticos para auditoria  
✅ Prepared statements via Hibernate  

### Melhorias Recomendadas

```sql
-- Criar usuário com permissões limitadas
CREATE USER 'elenkti_app'@'localhost' IDENTIFIED BY 'senha_forte';
GRANT SELECT, INSERT, UPDATE, DELETE ON Elenkti.* TO 'elenkti_app'@'localhost';
FLUSH PRIVILEGES;

-- Usar este usuário em produção em vez de 'root'
```

---

## 📚 Referências

- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Hibernate Docs](https://hibernate.org/orm/)
- [JDBC Best Practices](https://docs.oracle.com/javase/tutorial/jdbc/)

---

**Última atualização:** 2026-07-22  
**Versão da Documentação:** 1.0
