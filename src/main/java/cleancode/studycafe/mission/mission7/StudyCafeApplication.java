package cleancode.studycafe.mission.mission7;

import cleancode.studycafe.mission.mission7.io.StudyCafeFileHandler;

public class StudyCafeApplication {

  public static void main(String[] args) {

    StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(new StudyCafeFileHandler());
    studyCafePassMachine.run();
  }

}
