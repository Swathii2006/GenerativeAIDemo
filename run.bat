javac -cp ".;lib/json-20231013.jar" src/GenerativeAIDemo.java
java -cp ".;lib/json-20231013.jar;src" GenerativeAIDemo
@echo off
echo Compiling Java code...
javac -cp ".;lib/json-20231013.jar" src/GenerativeAIDemo.java

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b
)

echo Running Java program...
java -cp ".;lib/json-20231013.jar;src" GenerativeAIDemo
pause
