cd acceptance
javac -cp .;..\build\classes\main TicTacToe.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..
