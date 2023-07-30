# WordAnalysisTool

 The `WordAnalysisTool` is a Java application that performs a concurrent analysis on a list of words read from a text file. 
 It calculates the average word length, finds the longest word, and identifies the most frequently occurring letter.

## Getting Started

 These instructions will help you run the project on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK)

### Installation

- Clone this repository to your local machine.
- Navigate to the directory containing the Java files.
- Compile the Java files using the `javac` command:

```bash
javac AnalyzeWords.java
```

This will create `AnalyzeWords.class`.

### Usage

Run the `AnalyzeWords` program with a text file as an argument:

```bash
java AnalyzeWords /path/to/your/textfile.txt
```

This command will execute `AnalyzeWords` with `textfile.txt` as the file to be opened. 
The program will read the file, split it into words, and perform the analysis on these words. The results will be printed to the console.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License.
