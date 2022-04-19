package gameStates;

public class FileException extends Exception {
    public FileException(String errorMessage) {
        super("File with the path " + errorMessage + " error occurred");
    }
}
