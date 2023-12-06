# Floresta

### Nome: Edillan Kauã
### Matricula: 01611518

Este é um programa que simula um ecossistema de animais em uma floresta. Os animais têm comportamentos específicos que afetam seu movimento e interação com outros animais e elementos do ambiente. Abaixo, você encontrará informações detalhadas sobre o funcionamento do ecossistema, o tamanho do terreno e as siglas dos animais que aparecerão no ambiente.

## Tamanho do Terreno🌎🗺

O terreno onde os animais vivem possui um tamanho fixo. O tamanho do terreno é definido durante a criação do ecossistema, e no exemplo fornecido, o tamanho é configurado para 10 unidades. Isso significa que o terreno tem 10 unidades de largura e 10 unidades de altura.
Agora vai ser exibido no console quantos animais deseja adicionar no terreno, para deixar o usuário mais livre.

## Comportamento dos Animais

### Leão (Sigla: L) 🦁
Espécie: Predador
Vida Inicial: 5
Comportamento: O leão procura por presas (coelhos, esquilos, veados) próximas e as ataca quando estão na mesma posição.

### Tigre (Sigla: T)🐯
Espécie: Predador
Vida Inicial: 5
Comportamento: O tigre também procura por presas (coelhos, esquilos, veados) próximas e as ataca quando estão na mesma posição.

### Coelho (Sigla: C)🐰
Espécie: Presa
Vida Inicial: 1
Comportamento Especial: O coelho pode se esconder em arbustos para evitar ser atacado por predadores e recebe vida ao encostar em arvores.

### Esquilo (Sigla: E)🐿
Espécie: Presa
Vida Inicial: 1
Comportamento Especial: O esquilo pode se esconder em arbustos para evitar ser atacada por predadores e recebe vida ao encostar em arvores.

### Veado (Sigla: V)🦌
Espécie: Presa
Vida Inicial: 3
Comportamento Especial: O veado é uma presa mais resistente e pode sobreviver a mais ataques de predadores do que os coelhos e esquilos.

## Interaçöes ↗ ↘ ↙ 🗡
Os animais podem interagir entre si de acordo com suas espécies. Predadores (leões e tigres) caçam presas (coelhos, esquilos e veados) quando estão na mesma posição. Os arbustos fornecem um local de esconderijo para presas, como coelhos e esquilos, evitando ataques de predadores. As plantas também estão presentes no ambiente e podem aumentar a vida dos coelhos e esquilos quando estão na mesma posição.
Este ecossistema é simulado em um loop infinito. O terreno é exibido periodicamente para acompanhar o movimento e as interações dos animais.
