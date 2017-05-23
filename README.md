# VirtualPetsAssignment

## Command Line Version
To run the command line version use the command
``java -jar VirtualPetsCLI.jar``
from the command line of your choice

## GUI Version
To run the GUI version use the command
``java -jar VirtualPets_och26_spe80.jar``
First you must compile the source code in the ``src/virtualpets`` directory. All
off the resulting source code should be places into ``/bin/virtualpets``. The
jarring command can then be run or GUIMain.class can be called from the output
directory. The command below should suffice to compile the code and place it
into the appropriate directory:
``javac -d "../../bin/virtualpets" /*.class``
(bash script only)
Another way is to just import it into eclipse and run it internally and then
jar it. But hey what you do in your own time isn't up to us.
To build the JAR file. Run the following command:
``jar cvfm newBuildName.jar buildmanifest.txt -C bin . img config``
``buildmanifest.mf`` simply seals the jar and sets GUIMain.class as the main entry point.
To build the GUI JAR file. Run the following command
