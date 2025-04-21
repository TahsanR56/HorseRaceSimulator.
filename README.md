# HorseRaceSimulator.
OOP Horse simulation project Tahsan Rahman 230239436

Project Overview
This is a java based program that simulates a horse racw. This is a university project for the EC414U OOP module.
It includes fully encapsulated horse objects, a confidence based race mechanism, and a dynamic CLI experience with animated output. It is completely IDE agnostic.

Project Structure
This project is split into part 1 and part 2. Both parts are horse simulations however part 1 is a text based simulation run in the terminal wheras part 2 is a simulation with a full GUI and new features.

Dependencies
- Java 8 or higher
- No external libraries needed
- Runs via CLI

How to compile and Run
- open bash
- cd Part1, this opens the directory
- javac *.java, this compiles the java code
- java Main, this runs the simulation
- to change the horses / race settings open the main class and modify the List<Horses>
  horses.add(new Horse('♞', "Test Horse 1", 0.7));
  horses.add(new Horse('♘', "Test Horse 2", 0.9));
  you can change these variables as well as the number of horses in the race by adding more horses

Test Cases
1.	       Empty horse list	Ends with no winner                     ✅
2.	       One horse, 0.7 confidence	Moves & may fall              ✅
3.	       3 horses at 0.9 confidence	Fast, risky race              ✅
4.	       1 at 0.1, 2 at 0.9	Low confidence lags                   ✅
5.	       All horses at 0.6	Balanced race                         ✅
6.	       10 horses at 0.6	Stress test passed                      ✅ 
7.	       100 horses at 0.6	Heavy load passed                     ✅
8.	       One horse at 1.0 confidence	Fixed bug, now falls more   ✅
9.	       One horse at 0.0 confidence	Fixed bug, moves slowly     ✅

All results verified and screenshots included in the coursework document.

Key features
- Confidence based race system
- Visual race lanes using unicode characters
- Dynamic number of of races
- Real time cross platform screen clearing
- Fully encapsulated class design

