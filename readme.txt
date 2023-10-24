README

Program: Assignment 5 (Spaceship Simulator)

Overview:
This program creates an interactive spaceship simulator, wherein users may add
rockets of different types to a simulation, with unique speeds and appearances,
and custom spawn coordinates and names.

Design:
The program will be a spaceship control system, essentially observing and 
interacting with moving spaceships. I plan to have a panel on top of the screen 
which allows users to interact with the spaceships via widgets.

Each of the widget-classes (Button, Textfield, etc.) are subclasses of their 
given Java classes, also including the implementation of action/adjustment 
event listeners in order to allow the user to use the widgets to interact with
the program.

The Main class instantiates instances of each class in its constructor, 
initializes required objects, sets the window to visible, and then lets the 
window system take over and wait for callbacks.

The Model class handles communications between the widgets and the canvas,
making it essentially responsible for all drawing in the canvas triggered by 
user interaction with the program. This is also where each Vehicle is 
instantiated and drawn.

The Canvas class handles all drawing via the paintComponent function.

The Vehicle class acts as the parent class for each rocket, defining universal 
member variables such as speed, direction, name, etc. and defining movement, 
but allowing drawing to be defined by its subclasses, BigRocket and SmallRocket.

Collaboration Relationships:
Taking Widget Inputs:
The model class stores references to each widget in the control panel and uses
their inbuilt access functions (getText(), isEnabled(), etc.) in order to update
information about the vehicles in the simulation in realtime (currTX, currName, etc.)

Drawing Vehicles:
The model class responds to user requests to add a vehicle by adding a vehicle 
of the specified type to its vehicle_list member vector. Model's drawer function
repeatedly loops through this vector and calls each individual vehicle'ss draw 
method before triggering a repaint of the main canvas, which model also has 
access to.

Encapsulation:
The values/states of each widget are never communicated directly to a vehicle,
but only via the Model class as described above. More specifically, the Model
stores realtime reflections of the requested state of the program based on user
input via widgets (paused/unpaused, number of vehicles, etc.), and communicates
this to the canvas which adjusts its drawing behaviors accordingly. The canvas
never receives direct access to the values/states of the widgets, however.

Compile with: javac Main.java
Run with: java Main.java

Written By: Vir Bhatia

Email: vbhati02@tufts.edu

Date: Thursday, 22 October 2023