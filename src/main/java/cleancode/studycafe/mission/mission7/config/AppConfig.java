package cleancode.studycafe.mission.mission7.config;


import cleancode.studycafe.mission.mission7.io.FileHandler;
import cleancode.studycafe.mission.mission7.io.InputHandler;
import cleancode.studycafe.mission.mission7.io.OutputHandler;

public class AppConfig {
  private final InputHandler inputHandler;
  private final OutputHandler outputHandler;
  private final FileHandler fileHandler;

  public AppConfig(InputHandler inputHandler, OutputHandler outputHandler, FileHandler fileHandler) {
    this.inputHandler = inputHandler;
    this.outputHandler = outputHandler;
    this.fileHandler = fileHandler;
  }

  public InputHandler getInputHandler() {
    return inputHandler;
  }

  public OutputHandler getOutputHandler() {
    return outputHandler;
  }

  public FileHandler getFileHandler() {
    return fileHandler;
  }
}
