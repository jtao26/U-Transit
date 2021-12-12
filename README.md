# UMN-VisualTransitSimulator-CSCI3081W

## Visual Transit Simulator Software
### Description
The current visual transit simulator (VTS) software models vehicle transit around the University of Minnesota campus. Specifically, the software simulates the behavior of vehicles and passengers on campus. The VTS software currently supports four main types of vehicles: small buses, large buses, electric trains, and diesel trains. Vehicles provide service for a line. A line is made by two routes: an outbound and an inbound route. Vehicles go along a route, make stops, and pick up/drop off passengers. The simulation operates over a certain number of time units. In each time unit, the VTS software updates the state of the simulation by creating passengers at stops, moving vehicles along the routes, allowing a vehicle to pick up passengers at a stop, etc. The simulation is configured using a configuration file that specifies the simulation lines, the stops of the routes, and how likely it is that a passenger will show up at a certain stop at each time unit. Routes must be defined in pairs, that is, there should be both an outbound and inbound route and the routes should be specified one after the other. The ending stop of the outbound route should be at the same location as the starting stop of the inbound route and the ending stop of the inbound route should be at the same location as the starting stop of the outbound route. However, stops between the starting and ending stops of outbound and inbound routes can be at different locations. After a vehicle has passed a stop, it is possible for passengers to show up at stops that the vehicle has already passed. For this reason, the simulator supports the creation of multiple vehicles and these vehicles will go and pick up the new passengers. Each vehicle has its own understanding of its own route, but the stops have relationships with multiple vehicles serving the same line. Vehicles do not make more than one trip in the line they serve. When a vehicle finishes both of its routes (outbound and inbound), the vehicle exits the simulation.


### Code Structure
The VTS software is divided into two main modules: the visualization module and the simulator module. The visualization module displays the state of the simulation in a browser, while the simulator module performs the simulation. The visualization module is a web client application that runs in a browser and it is written in Javascript and HTML. The visualization module code is inside the &lt;dir&gt;/src/main/webapp/web_graphics directory of this repo (where &lt;dir&gt; is the root directory of the repo). The simulator module is a web server application written in Java. The simulator module code is inside the &lt;dir&gt;/src/main/java/edu/umn/cs/csci3081w/project directory. The simulator module is divided into two parts: model classes and the webserver classes. The model classes model real-world entities (e.g., the concept of a vehicle) and the code is inside the &lt;dir&gt;/src/main/java/edu/umn/cs/csci3081w/project/model directory. The webserver classes include the code that orchestrates the simulation and is inside the &lt;dir&gt;/src/main/java/edu/umn/cs/csci3081w/project/webserver directory. The visualization module and the simulator module communicate with each other using websockets.

### Configuration File
The simulation is based on the &lt;dir&gt;/src/main/resources/config.txt configuration file.

### Usage
To run the VTS software, you have to first start the simulator module and then start the visualization module. To start the simulator module, go to &lt;dir&gt; and run./gradlew appRun. To start the visualization module, open a browser and paste this link http://localhost:7777/project/web_graphics/project.html in its search bar. To stop the simulator module, press the enter/return key in the terminal where you started the module. To stop the visualization module, close the tab of browser where you started the module.

The user of the VTS software interacts with the visualization module using the browser and can specific how long the simulation will run (i.e., how many time units) and how often new vehicles will be added to a route in the simulation. The users also specifies when to start the simulation. The user can click on a vehicle to display detailed information about the vehicle. The user can also select a line from the drop down menu provided by the visualization module to simulate an issue on that line.
