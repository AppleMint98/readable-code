package cleancode.studycafe.mission.mission7;

import cleancode.studycafe.mission.mission7.config.AppConfig;
import cleancode.studycafe.mission.mission7.io.ConsoleInputHandler;
import cleancode.studycafe.mission.mission7.io.ConsoleOutputHandler;
import cleancode.studycafe.mission.mission7.io.StudyCafeFileHandler;

public class StudyCafeApplication {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig(new ConsoleInputHandler(), new ConsoleOutputHandler(), new StudyCafeFileHandler());
    StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(appConfig);
    studyCafePassMachine.run();
  }

}
