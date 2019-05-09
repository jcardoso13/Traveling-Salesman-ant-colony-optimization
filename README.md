

Object Oriented Programming Project 2019

Discrete Stochastic Simulation

Travelling Salesmen problem by ant colony optimization

Coeficient of an edge =(alpha+pheromones)/(beta+weight of edge)


probability from each ant to move to a new node= (Coef/ sum of adjacent edges Coef)


if no new movement is possible, it will chose randomly and delete the path up until that vertex (Example 1->2->3->2 becomes 1->2)


each movement takes X instance time depending on weight of the node and input parameter (delta)



Etha is the time between evaporation events


Rho is the ammount of decay of the pheromones

the XML has all the inputs of the project, including the graph and it's weights.


how to run?

make

make run TEST=(XML file in folder TEST)
