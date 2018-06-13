import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

class GrepTool {

    private static final String[] FLAGS = {"-n", "-l", "-i", "-v", "-x"};

    private boolean shouldTrackLineNumbers,
            shouldPrintOnlyFileNames,
            shouldIgnoreCase,
            shouldCatchFailedMatches,
            shouldMatchWholeLines,
            shouldPrintFilesNamesWithMatches;
    private int lineNumber;

    /**
     * A Java implementation of the grep CLI utility.
     *
     * @param searchTerm - The term to search for
     * @param flags      - Optional flags to modify search parameters
     *                   -n Print the line numbers of each matching file
     *                   -l Print only the names of files that contain at least one matching line
     *                   -i Match line using a case-insensitive comparison
     *                   -v Invert the program -- collect all lines that fail to match the pattern.
     *                   -x Only match entire lines, instead of lines that contain a match
     * @param files      - A list of files to search
     * @return Returns a String containing all lines which match both the search term and the optional parameters given
     */
    String grep(String searchTerm, List<Object> flags, List<String> files) {

        shouldTrackLineNumbers = flags.contains(FLAGS[0]);
        shouldPrintOnlyFileNames = flags.contains(FLAGS[1]);
        shouldIgnoreCase = flags.contains(FLAGS[2]);
        shouldCatchFailedMatches = flags.contains(FLAGS[3]);
        shouldMatchWholeLines = flags.contains(FLAGS[4]);
        StringBuilder result = new StringBuilder();

        if (shouldIgnoreCase) {
            searchTerm = searchTerm.toLowerCase();
        }
        if (files.size() > 1) {
            shouldPrintFilesNamesWithMatches = true;
        }

        try {
            for (String fileName : files) {
                Scanner scanner = new Scanner(new File(fileName));

                lineNumber = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNumber++;

                    if (!shouldCatchFailedMatches && isMatch(line, searchTerm)) {
                        generateOutputLine(result, fileName, line);
                    }
                    else if (shouldCatchFailedMatches && !isMatch(line, searchTerm)) {
                        generateOutputLine(result, fileName, line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    /**
     * A utility method which determines if the given term matches the given line using the optional parameters declared above.
     *
     * @param line - The line to search within
     * @param term - The term to search for
     * @return Returns true if the search term is matched with text from the current line.
     */
    private boolean isMatch(String line, String term) {

        if (shouldMatchWholeLines) {
            return shouldIgnoreCase
                   ? line.equalsIgnoreCase(term)
                   : line.contentEquals(term);
        }
        return shouldIgnoreCase
               ? line.toLowerCase().contains(term.toLowerCase())
               : line.contains(term);
    }

    /**
     * A utility method which updates the output once a match has been found.
     *
     * @param result - The StringBuilder to update with additional output
     * @param file   - The file currently being searched
     * @param line   - The line of search that was used in the match
     */
    private void generateOutputLine(StringBuilder result, String file, String line) {

        if (shouldPrintOnlyFileNames) {
            if (!result.toString().contains(file)) {
                if (!result.toString().isEmpty()) {
                    result.append("\n");
                }
                result.append(file);
            }
        }
        else {
            if (!result.toString().isEmpty()) {
                result.append("\n");
            }
            if (shouldPrintFilesNamesWithMatches) {
                String outputLine = file + ":";
                result.append(outputLine);
            }
            if (shouldTrackLineNumbers) {
                String outputLine = lineNumber + ":";
                result.append(outputLine);
            }
            result.append(line);
        }
    }
}
