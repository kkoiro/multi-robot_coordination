# multi-robot coordination
---

## About
This program simulates the multi-robot coordination problem under the assumptions below.

- The number of robots: 1 < N < 10
- Field size: 512 * 512
- Information robots have: Field size, The number of robots, Destination coordinates
- Algorithms to avoid robot conflicts: Round-Robin, Random

## How to run
```
$ cd src
$ javac mypackage/*.java
$ java mypackage.MultiRobotCoordination [The_number_of_robots] [Algorithm_index(roundrobini=1, random=2)]
```
