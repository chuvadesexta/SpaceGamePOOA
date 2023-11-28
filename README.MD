# SpaceGamePOOA
 
# Proposta: Usar o padrão Component para refatorar as mecânicas do jogo

# Mudanças Principais:


## 1. 🟣Estrutura e Organização:

-Mantivemos a lógica do jogo, porém fomos para uma abordagem mais específica para cada objeto
com classes como `Game`, `Character`, `GameObject`, `Manager`, `Scene`, etc.


## 2. 🟣Controle de Atualização:

-Criamos métodos como `onUpdate`, `onLateUpdate`, `onCollision` nas classes para controlar a lógica do jogo
baseado no conjunto `actionPerformed` original. 


## 3. 🟣Entrada do Usuário:

-Transportamos e otimizamos o `KeyAdapter` para um conjunto da classe `Input`.


## 4. 🟣Tempo e FPS:

-Criamos a classe `Time` para gerenciar o tempo e o FPS, baseado no `Timer` do código original.


## 5. 🟣Tratamento de Colisões:

-Fizemos um sistema de colisão mais modular, com métodos `onCollision` nas classes.
-Baseando-se no método `checkCollisions` dentro da classe `Jogo`.


## 6. 🟣Criação de Objetos:

-Criamos o método `Generate` para carregar imagens e adicionar objetos ao gerenciador.
refatorando diretamente no método `initJogo`.


## 7. 🟣Thread de Renderização:

-Criamos uma thread separada apenas para renderizar o jogo e calcular o mapa.


## 8. 🟣Sistema de Cena:

-Fizemos um sistema de cenas mais elaborado, com classes `Scene`, `Gameplay`, e `GameOver` 
deixando um contexto explícito de cena.


#PRÁTICA DA PROPOSTA

# Relação com o Padrão de Design Component

## 1. GameObject como Componente

-Na hierarquia do código, `GameObject` serve como a classe base para todos os objetos do jogo, o que pode ser comparado a um componente no padrão Component. 
-As classes derivadas, como `Character`, `NPC`, `Player`, e `Projectile`, podem ser vistas como diferentes tipos de componentes que herdam de `GameObject`.

## 2. Composição de Objetos

-A classe `Scene` é responsável por gerenciar uma lista de `GameObject`, Essa composição é semelhante ao padrão Component, 
onde tanto objetos individuais quanto composições de objetos são tratados uniformemente. 
-O método `draw` na classe `Scene` itera sobre a lista de objetos e os desenha, mostrando a capacidade de lidar com componentes individuais e composições de maneira consistente.

## 3. Tratamento Uniforme

-A interface `GameObject` define métodos padrão como `onUpdate`, `onCollision`, e `onLateUpdate`, e esses métodos são chamados uniformemente para todos os componentes, independentemente do tipo específico do componente. Isso reflete a ideia do padrão Component de tratar todos os elementos da hierarquia de maneira uniforme.

## 4. Manager como Cliente

-A classe `Manager` desempenha o papel de um cliente que interage com os componentes (objetos do jogo), ele gerencia a troca de cenas, a adição e remoção de objetos
assim como um cliente no padrão Component interage com os componentes sem se preocupar com suas classes concretas.

## 5. Scene como Composite

-A classe `Scene` age como um "composite" no sentido do padrão Component, ela pode conter objetos individuais (`GameObject`) e outros compositores (subclasses de `GameObject`), refletindo a capacidade do padrão Component de compor objetos em estruturas mais complexas.

## 6. Uso de Polimorfismo

-O polimorfismo está presente no código onde métodos como `onUpdate` e `onCollision` são sobrescritos nas classes derivadas. Esse é um princípio fundamental do padrão Component, permitindo que objetos individuais e composições se comportem de maneira única.
