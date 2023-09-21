# RSS Reader to HTML Converter

This is a Java program that takes an XML RSS (version 2.0) feed from a given URL and converts it into an HTML webpage. The program parses the RSS feed and extracts information such as the channel title, description, and individual news items, including their publication date, source, and title or description.

## Dependencies

- Java Development Kit (JDK) 8 or higher.

- Ohio State University's specific components:
  - `components.simplereader.SimpleReader` and `components.simplewriter.SimpleWriter`
  - `components.xmltree.XMLTree`

  You can find these components at the following link: [Ohio State Software Components](http://web.cse.ohio-state.edu/software/common/doc/).

## How to Use

1. Clone or download this repository to your local machine.

2. Open the project in your Java development environment (e.g., Eclipse, IntelliJ IDEA).

3. Make sure to include the Ohio State University's specific components in your project's classpath. You can add these components to your project as external JAR files.

4. Build and run the `RSSReader` class.

5. When prompted, enter the URL of an RSS 2.0 news feed. Ensure that the URL is accessible and points to a valid RSS feed.

6. The program will process the RSS feed and generate an HTML file named `RSSOutput.html` in the project directory.

## Program Structure

The program consists of the following main components:

- `RSSReader.java`: The main class that contains the program logic.

- `components.simplereader.SimpleReader` and `components.simplewriter.SimpleWriter`: These components are used for input and output operations.

- `components.xmltree.XMLTree`: An XML parsing library used to work with XML data.

## HTML Output Structure

The generated HTML output follows this structure:

```html
<html>
<head>
    <title>Channel Title</title>
</head>
<body>
    <h1><a href="Channel Link">Channel Title</a></h1>
    <p>Channel Description</p>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Source</th>
            <th>News</th>
        </tr>
        <!-- Individual news items go here -->
    </table>
</body>
</html>
```

## Note

- Make sure you have the necessary permissions to access the RSS feed URL you provide.

- The program is designed to handle RSS 2.0 feeds. It may not work correctly with other versions of RSS or non-standard XML formats.

- The generated HTML file (`RSSOutput.html`) will be located in the project directory.

Enjoy using this RSS to HTML converter! If you encounter any issues or have suggestions for improvements, please feel free to open an issue or contribute to the project.
