# Ships-and-Cranes
Problem – Ships & Cranes
Given specifications of a ship and different types of containers, find whether the containers can be successfully stacked in the ship or not. If they can be, output a possible stacking.

• 7 different parameters are used as constraints. They are: -

o Number of stacks, Size of each stack, Maximum height of each stack, Risk Tolerance, Maximum Power output, and Maximum Sway Tolerance.

• Each container has a certain id, type (described below) and a propterty assiocated with it(explanied below). Depending on the type of the container, it can also have another parameter like power requirement, sway, toxicity, fragile.

• A successful stacking is possible only when all the containers’ cumulative parameters do not exceed that of the ship.

• Description of the different types of Containers: -

o Liquid (Type 1) – Carries liquid substance. Has some sway.
o Refrigerate (Type 2) – Needs some power to continue refrigeration. 
o Heavy (Type 3) – Is heavier then rest containers.
o Toxic (Type 4) – Contains radioactive substance, hence has some associated toxicity with it. 
o Weak (Type 5) – Contains fragile equipment, hence no other container can be put on top of it

Code Explanation

•	Driver class uses an object of ContainerFactory which returns an object of specific type of Container depending on the typeID.

•	Container is an abstract class which has different types of concrete class extending it which represent different type of containers.

• Class Refrigerate, Toxic, Liquid, Regular and Weak inherit the Container class and denote the respective type of containers.

o They contain a variable which stores the value of the parameter. The constructor of the class is used to fulfil this.

• Class Container is the class of all the containers. o It contains id, type parameters which are used by all types of containers.

• Class Ship denotes the Ship. It contains the information about all the capacity of the ship.

• Class Crane denotes the crane. It performs all the work of stacking via the stack() function. The Crane class keeps a track of current status of these properties.

• Class Driver contains the main() function. It initializes all the classes, takes the inputs from the user and store them accordingly. It also receives the verdict from the Crane class whether the containers can be stacked or not, and accordingly gives the output.

Class Crane
• 2-D List Array ‘stacks’ stores the final stacking of containers. Each list denotes a stack. The 1st element of each list of the 2-D list (arrange[0]) denotes the bottom-most container of the stack, the 2nd element denotes the container above it, and so on. Hence the last element of each list in ‘stacks’ denotes the topmost container of the stack.

• For each Container, we get the stack of containing minimum number of containers.

• As weak container has to be on top, they are stacked at the end.Therefore we use 'ContainerComparator' so that it is dealth with at the end.

• Each parameter of a container is checked. As soon as a container fails in any of the parameter, a ‘false’ is returned, which in turn results in a “Not possible” output to the user. Only if all the containers fulfil the constraints of the Ship, a ‘true’ is returned.

• For stacking a weak container (which is done in the end, all stacking all other containers), a HashSet mp is maintained. A stack is added to mp if a weak container is stacked in it. Hence, that stack is sealed now and no more container can be stacked in it. The weak container will be on the top.

•	The Container class is implemented using Factory Design Pattern. 

Walkthrough of Inputs and Outputs 

Input Format
The first line of the file is the number of test cases that are being tested in the project. The layout of each test case is as explained below.
The next six lines of the input correspond to various ship properties like risk tolerance, power input, maximum weight, sway tolerance, maximum stack height, stack limit, respectively. The next line of the input consists of an integer N, number of containers to be stacked by the crane. N lines follow after this, each containing three integers (say a, b, c) which describe individual containers. ‘a’ denotes the serial number (or the ID) of the container, ‘b’ denotes the type (or the type ID), and ‘c’ denotes the exclusive property of the incoming container.

Output Format
•	Case 1: When a valid stacking is not possible 
The code will simply display the statement ‘No Viable Stacking Possible’.
•	Case 2: When a valid stacking is possible
There will be N stacks and N lines will be displayed corresponding to each stack with each line having the serial ID of the containers in that particular stack. Consider that the stack limit is 3, the code will display one possible stacking as follows:
The viable stacking is:
Stack 0:  id1 id2 id3
Stack 1: id4 id5 
Stack 2: id6  
