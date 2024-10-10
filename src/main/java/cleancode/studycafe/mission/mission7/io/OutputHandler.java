package cleancode.studycafe.mission.mission7.io;

import cleancode.studycafe.mission.mission7.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.mission7.model.StudyCafePass;
import cleancode.studycafe.mission.mission7.model.StudyCafePasses;

import java.util.List;

public interface OutputHandler {

  void showWelcomeMessage();

  void showAnnouncement();

  void askPassTypeSelection();

  void showPassListForSelection(StudyCafePasses passes);

  void askLockerPass(StudyCafeLockerPass lockerPass);

  void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

  void showSimpleMessage(String message);
}
