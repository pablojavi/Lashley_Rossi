# Lashley_Rossi    Robocode

In our original design for our robot, our goal was to aim and shoot for the robot that had
the most energy on the field. If that were prove to be too hard we would try and aim for the
closest robot on the field. What we found while researching an approach and trying to
implement our code is that it is quite difficult to compare two robots on the field in a quick and
efficient manner. When we considered that the robot with the most energy or the closest one
would be changing rapidly we decided that it would be inefficient to try and constantly change
which robot we would aim for. Likewise, for our robots movement, we initially wanted to keep a
minimum distance from all other robots. This proved to be difficult because we would have to
continually check all surrounding robots and we found this to be an inefficient use of movement.
What we ended up doing instead was we scanned clockwise around the arena until we
found an enemy. What we did then was stay on the enemy and shoot at that enemy until they
either died or if for some reason they got out of range and then we continued to search
clockwise around the arena until finding another robot. For our movement our backup plan was
to move around the arena while keeping a buffer from the walls. We did do this but we feel that
this is definitely an area we could have improved on.
We were expecting to do better in the competition. While we watched our robots we did
notice some things that could have definitely been improved. The first thing that we noticed was
our bullets were not very accurate. This could have been improved by using linear targeting.
Linear targeting is where you get the velocity of the scanned robot and you predict where the
robot will be and shoot so the bullet will hit the target assuming that the target will continue
moving in the same direction at the same velocity. We realized that this, to be accurate, would
need to be a function of the enemy’s position and velocity with respect to our own robot along
with time. Another thing that we felt did not meet our expectations was the movement of our
robot. In our onScannedRobot method we were planning on including movement but we soon
realized that once we started moving in that method we would easily lose track of the robot we
were scanned on. To improve this we would have to create a function of the enemy’s position
and velocity relative to our position and velocity. When we realized this we did not have enough
time to implement this into our code. This resulted in us being almost a sitting duck while
scanned on an enemy. While we were not scanned on a robot we were able to move how we
intended however. In conclusion, we did have to make some adjustments to our robot due to both ability to
complete the desired task and practicality of the action when considering efficiency. We
definitely saw areas of improvement that we believe could be completed with more time to
complete said tasks. In the end it was a fun learning experience and we are excited to improve
our robot for next time.
