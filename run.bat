@echo off
javac -d out src/adivinador/*.java
java -cp out adivinador.Main
pause
