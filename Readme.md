# Island Simulation v1.0

## Brief overview
 Simulates life of different kind of animals. Simulation cycle includes moving, eating, reproducing and depletion of every animal. 
 Animals splited into Predators and Herbivores. 
 All simulation processed at field with size 10*10 cells. 
 In each cell on initiation creates a random amount of each animal, in amount between 0 and 40% of max amount for this animal per cell.
 In every cell also every 2 seconds spawns a random amount of Grass (food for herbivores).
 
## Setup and Configuration
### Installation
1. **Clone the project repository:** Clone repository to your local machine.
2. **Open the project:** Open the project using your preferred IDE(e.g. IntelliJ IDEA)
3. **Compile the source code:** Use a java compiler to compile the source code.
4. **Run the program:** Execute the 'Main' class to start the application.

### Detailed overview
 Simulation continues per 100 iterations or while there is animals alive. New iteration starts every 0.5 seconds(+time to perform simulation in every cell on the sim. field). Also, every 2 seconds starts scheduled event of growing the grass. 
 On start of simulation every animal spawns in random amount in diapason between 0 and (maximal count for this species)*0.4.
 Then every iteration, every animal tries to move(random amount of moves), tries to eat(randomly choose a prey for eating from list of all residents from cell, and randomly getting a chance for eating), tries to reproduce(randomly choose a partner with another gender, and randomly "born" 1 or 2 offsprings), and depletes(every iteration, every animal loses his weight in amount of his hunger(foodNeed), if it's weight goes to 0, animal dies).

#### Planed to realize in future relieses:
- Changing size of simulation field
- Changing number of iterations to perform
- Changing amount of Animals(Max amount per Cell, spawning diapason, eating chances).

 