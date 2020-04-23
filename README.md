# IDLA

A light weighted clojure program simulating the 
internal diffusion limited aggregation (IDLA) process in 
the two dimensional lattice. \\
The origin constitutes the start of this growth model.
With each step, a random walk starts in the origin and runs until it hits
an unoccupied lattice point, which will be added to the cluster.

## Usage
One can run this program from the leiningen repl,
'lein repl'
To get 500 steps of the IDLA process run the function 
'(walk-idla-until-time 500)'

## The Program
The program is written to give a basic framework. It can easily extended to more 
complex graphs than the two-dimensional Z-lattice. 
Moreover, based on the result that up to logarthic fluctuations 
the IDLA cluster is the trace of the Euclidean ball (see Logarithmic Fluctuations for internal DLA, Jerison-Levin-Sheffield, 2012),
one can remarkably improve the computational complexity; see for instance "Fast simulation of large-scale growth models" 
by Friedrich-Levin (DOI 10.1007/978-3-642-22935-0_47). 


