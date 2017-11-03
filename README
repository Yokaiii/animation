The model consists of Drawable objects, Commands, and an Animation.
An animation has a set starting time and ending time along with a list of
Commands and Drawables, putting the commands to execute on the objects right
there together. Drawable objects as of now only consist of Ovals and Rectangles but more can
be added by creating new classes. A rectangle has a width and height, while an oval has a
x radius and y radius, although an oval technically has a width of 2*xradius and a height
of 2*yradius. Drawables can be moved, scaled to a new size, have their color changed,
and be changed into a new shape. Drawables have a drawabletype in order to change from shape
to shape. (Currently the only types are RECTANGLE and OVAL).

A command has several fields; a drawable object to apply the
command to and a start/end time (a command is applied over a time period). A move command has these
and also a target position to move to, and a scale command has a target size to scale to. Commands
can check if they will conflict with another command (ie a rectangle being moved to two different
coordinates at the same time). Commands also override compareTo in order to allow sorting of a list
of Commands. A command has a toString to work with the toString of an Animation.

An Animation consists of a list of commands and drawables. The
commands are ordered by their start time so that when a string representation is returned it is
in chronological order.