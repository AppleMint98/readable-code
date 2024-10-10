package cleancode.studycafe.mission.mission7.io;

import cleancode.studycafe.mission.mission7.model.order.StudyCafePassOrder;
import cleancode.studycafe.mission.mission7.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.mission7.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.mission.mission7.model.pass.locker.StudyCafeLockerPass;

import java.util.List;

public class StudyCafeIOHandler {

  private final InputHandler inputHandler = new InputHandler();
  private final OutputHandler outputHandler = new OutputHandler();

  public void showWelcomeMessage() {
    outputHandler.showWelcomeMessage();
  }

  public void showAnnouncement() {
    outputHandler.showAnnouncement();
  }

  public void showPassOrderSummary(StudyCafePassOrder order) {
    outputHandler.showPassOrderSummary(order);
  }

  public void showSimpleMessage(String message) {
    outputHandler.showSimpleMessage(message);
  }

  public StudyCafePassType askPassTypeSelecting() {
    outputHandler.askPassTypeSelection();
    return inputHandler.getPassTypeSelectingUserAction();
  }

  public StudyCafeSeatPass askPassSelecting(List<StudyCafeSeatPass> passCandidates) {
    outputHandler.showPassListForSelection(passCandidates);
    return inputHandler.getSelectPass(passCandidates);
  }

  public boolean askLockerPass(StudyCafeLockerPass lockerPassCandidate) {
    outputHandler.askLockerPass(lockerPassCandidate);
    return inputHandler.getLockerSelection();
  }
}
