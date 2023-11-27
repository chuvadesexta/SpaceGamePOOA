# SpaceGamePOOA
 
# Proposta: Usar o padrão Component para refatorar as mecânicas do jogo

# Mudanças Principais:


🟣Estrutura e Organização:

-Mantivemos a lógica do jogo, porém fomos para uma abordagem mais específica para cada objeto
com classes como "Game, Character, GameObject, Manager, Scene", etc.


🟣Controle de Atualização:

-Criamos métodos como "onUpdate, onLateUpdate, onCollision" nas classes para controlar a lógica do jogo
baseado no conjunto "actionPerformed" original. 


🟣Entrada do Usuário:

-Transportamos e otimizamos o "KeyAdapter" para um conjunto da classe "Input".


🟣Tempo e FPS:

-Criamos a classe "Time" para gerenciar o tempo e o FPS, baseado no "Timer" do código original.


🟣Tratamento de Colisões:

-Fizemos um sistema de colisão mais modular, com métodos "onCollision" nas classes.
-Baseando-se no método "checkCollisions" dentro da classe "Jogo".


🟣Criação de Objetos:

-Criamos o método "Generate" para carregar imagens e adicionar objetos ao gerenciador.
refatorando diretamente no método "initJogo".


🟣Thread de Renderização:

-Criamos uma thread separada apenas para renderizar o jogo e calcular o mapa.


🟣Sistema de Cena:

-Fizemos um sistema de cenas mais elaborado, com classes "Scene, Gameplay, e GameOver" 
deixando um contexto explícito de cena.

