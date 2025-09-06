# HorseRaceSimulator

**OOP Horse simulation project**  
**Tahsan Rahman - 230239436**

---

## Project Overview

This is a Java-based program that simulates a horse race. It includes fully encapsulated horse objects, a confidence-based race mechanism, and two separate parts:

- **Part 1**: A text-based horse racing simulation, fully animated via the CLI.
- **Part 2**: A fully-featured **Graphical User Interface (GUI)** version with race stats, betting, and dynamic horse configuration.

---

## Project Structure

- `/Part1` – CLI-based simulation with dynamic horses, animated output, and confidence logic.
- `/Part2` – GUI version using Java Swing. Includes betting system, stats display, and user interaction panels.

---

## Dependencies

- **Java 17** (or Java 8+ if configured)
- **No external libraries**
- **IDE-Agnostic** 

---

## How to Run (Part 1 - CLI)

```bash
cd Part1
javac *.java
java Main
```
## How to Run (Part 2 - GUI)

```bash
cd Part2
javac *.java
java Main
```
## Key Features
Part 1
- Confidence-based horse movement
- Visual terminal race lanes
- CLI animation and cross-platform screen clearing
- Robust test coverage with edge cases

Part 2
- Full GUI using Java Swing
- Custom horse and track setup (breed, coat, gear, weather)
- Real-time race animation
- Statistics tracking: speed, fall status, confidence changes
- Simple betting system with dynamic odds and win tracking


## Part 1 test cases
Part 1 – Test Cases

1. Empty horse list
- Description: Ends immediately with no winner.
- Result: ✅ Passed

2. One horse, 0.7 confidence
- Description: Horse moves forward and may fall occasionally.
- Result: ✅ Passed

3. Three horses at 0.9 confidence
- Description: Horses move quickly, high risk of falling.
- Result: ✅ Passed

4. One horse at 0.1 confidence, two at 0.9
- Description: Low-confidence horse lags behind noticeably.
- Result: ✅ Passed

5. All horses at 0.6 confidence
- Description: Balanced race pace and fall rate.
- Result: ✅ Passed

6. Ten horses at 0.6 confidence
- Description: Stress test, simulation runs smoothly.
- Result: ✅ Passed

7. One hundred horses at 0.6 confidence
- Description: Heavy simulation load, still functional.
- Result: ✅ Passed

8. Horse at 1.0 confidence
- Description: Bug fixed; horse now moves fast but can fall.
- Result: ✅ Passed

9. Horse at 0.0 confidence
- Description: Bug fixed; horse now has a small chance to move.
- Result: ✅ Passed

10. Testing UTF-8 Symbols
- Description: Testing unicode characters instead of regular letters
- Result: ✅ Passed
    
12. Race length of 0
- Description: Race ends immidetely 
- Result: ✅ Passed
    
14. Race length below 0
- Description: Race ends immidetely
- Result: ✅ Passed

All Part 2 GUI development was done in a separate gui-development branch and successfully merged into main.
Code is fully modular and easy to test or expand.
















