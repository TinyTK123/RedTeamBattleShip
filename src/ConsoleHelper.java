import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

    public static String getInput(final String prompt) {
        String inStr = "";
        System.out.print(prompt);
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    public static int getNumberBetween(final String prompt, int min, int max) {
        while (true) {
            String input = getInput(prompt);
            int retVal = 0;
            try {
                retVal = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(String.format("Invalid entry.  Please enter a number between %d and %d", min, max));
                continue;
            }

            // entry was an integer
            if(retVal < min || retVal > max){
                System.out.println(String.format("Invalid entry.  Please enter a number between %d and %d", min, max));
                continue;
            }

            // entry passed all tests
            return retVal;
        }
    }

    // Enhanced ANSI escape sequence that clears screen, clears scrollback buffer, and homes cursor
    private static final String HARD_WIPE = "\u001b[H\u001b[2J\u001b[3J";
    private static boolean isInitialized = false;

    public static void clearScreen() {
        if (!isInitialized) {
            initWindowsAnsi();
            isInitialized = true;
        }

        // 1. Send the ultimate ANSI wipe sequence 
        System.out.print(HARD_WIPE);
        System.out.flush();

        // 2. Cross-platform fallback: If the terminal ignores ANSI, trigger a clean platform call
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Instantly executes the native Windows 'cls' terminal command
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Instantly executes the native Unix/Mac 'clear' terminal command
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception ignored) {
            // Fall back silently if process builder is restricted
        }
    }

    private static void initWindowsAnsi() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "reg add HKCU\\Console /v VirtualTerminalLevel /t REG_DWORD /d 1 /f").start().waitFor();
            } catch (Exception ignored) {}
        }
    }
}
