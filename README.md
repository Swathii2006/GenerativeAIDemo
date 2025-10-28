# Generative AI Java Project

A Java project that connects to OpenAI API to generate creative text.

## Requirements
- Java 8+
- JSON library (json-20231013.jar)
- OpenAI API Key

## How to Run
1. Add your API key in `apikey.txt`.
2. Compile and run:
   ```bash
   javac -cp ".;lib/json-20231013.jar" src/GenerativeAIDemo.java
   java -cp ".;lib/json-20231013.jar;src" GenerativeAIDemo
