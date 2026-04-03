# POO-PBL-11
Resolução do PBL 11: "Try-Catch-Finally" de Prog. Orientada a Objetos.

ESTUDO DE CASO — SISTEMA DE AUDITORIA DE CONTRATOS PÚBLICOS COM USO INTENSIVO DE TRY-CATCH-FINALLY E INTERFACES

Um órgão de controle governamental está desenvolvendo um sistema para auditoria automatizada de contratos públicos. O objetivo é identificar irregularidades como sobrepreço, pagamentos indevidos, inconsistências cadastrais e falhas na execução de contratos.

Esse sistema será implementado em Java utilizando orientação a objetos e deverá ser altamente robusto, pois trabalhará com dados reais que frequentemente apresentam problemas, como:

valores ausentes (nulos)
dados inconsistentes
erros de digitação
divisões matemáticas inválidas
objetos não inicializados
listas incompletas ou vazias

O sistema não pode interromper sua execução em caso de erro. Cada falha deve ser tratada, registrada e o processamento deve continuar. Por isso, será necessário utilizar intensivamente estruturas de tratamento de exceções: try, catch e finally, distribuídas em vários pontos do sistema.

CONTEXTUALIZAÇÃO DOS CONCEITOS DO DOMÍNIO
Antes de implementar, é necessário compreender alguns conceitos básicos da gestão pública:

Contrato Público
É um acordo entre o governo e uma empresa (fornecedor) para prestação de um serviço ou execução de uma obra. Exemplo: construção de escola, fornecimento de medicamentos, pavimentação de ruas.

Fornecedor
É a empresa contratada pelo governo para executar o serviço.

Nota Fiscal
Documento que comprova que um serviço foi realizado ou um produto foi entregue, sendo utilizado para justificar pagamentos.

Percentual de Execução
Indica quanto do contrato já foi realizado. É calculado comparando o valor já pago com o valor total do contrato. Esse indicador é importante porque permite verificar se o andamento financeiro está coerente com a execução real do serviço.

Exemplo conceitual:

contrato total: 100 unidades monetárias
valor pago: 40
→ execução: 40%

Esse tipo de cálculo pode gerar erro se o valor total for zero, sendo necessário tratamento com try-catch.

ARQUITETURA BASEADA EM INTERFACES
Para garantir organização e padronização do sistema, serão utilizadas interfaces. Interfaces definem comportamentos obrigatórios que as classes devem implementar.

Interface Validador
Responsável por validar dados.
public interface Validador {     boolean validar(); }
Aplicação:
verificar se valores são válidos
checar se campos obrigatórios estão preenchidos
validar formatos como CNPJ
Cada validação pode gerar erros, portanto deve conter vários blocos try-catch.

Interface Calculavel
Responsável por cálculos financeiros e indicadores.
public interface Calculavel {     double calcular(); }
Aplicação:
cálculo de percentual de execução
cálculo de custo médio
cálculo de indicadores de risco
Esses cálculos podem gerar erros matemáticos, como divisão por zero, exigindo tratamento intensivo de exceções.

Interface Auditavel
Responsável por realizar auditorias.
public interface Auditavel {     void auditar(); }
Aplicação:
cruzar dados entre contratos, fornecedores e notas fiscais
identificar inconsistências
detectar possíveis irregularidades
Esse processo envolve múltiplas operações e deve conter vários try-catch, inclusive dentro de estruturas de repetição.

Interface Relatavel
Responsável pela geração de relatórios.
public interface Relatavel {     void gerarRelatorio(); }
Aplicação:
registrar irregularidades encontradas
exibir resultados da auditoria
consolidar informações
Mesmo que ocorram erros, o relatório deve ser gerado parcialmente, exigindo tratamento de exceções.

MODELAGEM DAS CLASSES
As classes do sistema devem implementar as interfaces conforme suas responsabilidades:

ContratoPublico
implementa Validador e Calculavel
responsável por armazenar dados do contrato e calcular indicadores como percentual de execução

Fornecedor
implementa Validador e Calculavel
responsável por validar dados da empresa e calcular indicadores de risco

NotaFiscal
implementa Validador
responsável por validar valores e consistência dos documentos

Auditoria
implementa Auditavel
responsável por percorrer os dados e identificar irregularidades

RelatorioIrregularidade
implementa Relatavel
responsável por apresentar os resultados da auditoria

REQUISITOS DE TRATAMENTO DE EXCEÇÕES
Uso intensivo de try-catch-finally
Todos os métodos relevantes devem conter múltiplos blocos de tratamento de exceção.
Try-catch em validações

Exemplo de situações:
valor nulo
formato inválido
conversão incorreta
Cada validação deve tratar erros individualmente.
Try-catch em cálculos

Exemplo:
divisão por zero
dados inconsistentes
Os cálculos devem ser protegidos para evitar interrupção do sistema.

Try-catch em loops

Durante auditoria:
cada contrato deve ser processado individualmente
erro em um item não pode parar o processamento dos demais
Try-catch em chamadas entre objetos

Exemplo:
contrato acessa fornecedor
auditoria acessa contrato
Cada chamada deve ser protegida contra falhas.

Uso obrigatório de finally
O bloco finally deve ser utilizado para:
indicar fim de processamento
garantir execução de logs
assegurar continuidade do sistema

Uso de exceções específicas e genéricas
Devem ser tratados explicitamente:
divisão por zero
acesso a objeto nulo
erro de índice
erro de conversão
e também exceções genéricas

CENÁRIOS DE TESTE
Simular situações reais:
contrato com valor total igual a zero
fornecedor com dados incompletos
nota fiscal com valor negativo
contrato sem fornecedor associado
listas vazias
dados inconsistentes entre objetos

COMPORTAMENTO ESPERADO
O sistema deve:
continuar executando mesmo com erros
registrar todas as falhas
não interromper a auditoria
gerar relatório final com inconsistências identificadas

OBJETIVO PEDAGÓGICO
compreender conceitos básicos de contratos públicos
aplicar interfaces para organizar o sistema
utilizar try-catch-finally de forma intensiva
desenvolver sistemas robustos e tolerantes a falhas
lidar com dados imperfeitos em um contexto real
