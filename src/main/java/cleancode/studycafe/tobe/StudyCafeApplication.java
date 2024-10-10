package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.io.StudyCafeFileHandler;

public class StudyCafeApplication {

  public static void main(String[] args) {

    StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(new StudyCafeFileHandler());
    studyCafePassMachine.run();
  }

}
