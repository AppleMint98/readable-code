package cleancode.studycafe.mission.mission7;

import cleancode.studycafe.mission.mission7.config.AppConfig;
import cleancode.studycafe.mission.mission7.exception.AppException;
import cleancode.studycafe.mission.mission7.io.FileHandler;
import cleancode.studycafe.mission.mission7.io.InputHandler;
import cleancode.studycafe.mission.mission7.io.OutputHandler;
import cleancode.studycafe.mission.mission7.io.StudyCafeFileHandler;
import cleancode.studycafe.mission.mission7.model.*;

import java.util.List;

public class StudyCafePassMachine {

  private final InputHandler inputHandler;
  private final OutputHandler outputHandler;
  private final FileHandler fileHandler;

  public StudyCafePassMachine(AppConfig appConfig) {
    this.inputHandler = appConfig.getInputHandler();
    this.outputHandler = appConfig.getOutputHandler();
    this.fileHandler = appConfig.getFileHandler();
  }

  public void run() {
    try {
      outputHandler.showWelcomeMessage();
      outputHandler.showAnnouncement();
      outputHandler.askPassTypeSelection();
      StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

      if (studyCafePassType == StudyCafePassType.HOURLY) {

        StudyCafePasses studyCafePasses = fileHandler.readStudyCafePasses();
        StudyCafePasses hourlyPasses = studyCafePasses.getSelectedPasses(StudyCafePassType.HOURLY);
        outputHandler.showPassListForSelection(hourlyPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(hourlyPasses);
        outputHandler.showPassOrderSummary(selectedPass, null);
      }

      if (studyCafePassType == StudyCafePassType.WEEKLY) {
        StudyCafePasses studyCafePasses = fileHandler.readStudyCafePasses();
        StudyCafePasses weeklyPasses = studyCafePasses.getSelectedPasses(StudyCafePassType.WEEKLY);
        outputHandler.showPassListForSelection(weeklyPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(weeklyPasses);
        outputHandler.showPassOrderSummary(selectedPass, null);
      }

      if (studyCafePassType == StudyCafePassType.FIXED) {
        StudyCafePasses studyCafePasses = fileHandler.readStudyCafePasses();
        StudyCafePasses fixedPasses = studyCafePasses.getSelectedPasses(StudyCafePassType.FIXED);
        outputHandler.showPassListForSelection(fixedPasses);
        StudyCafePass selectedPass = inputHandler.getSelectPass(fixedPasses);

        StudyCafeLockerPasses lockerPasses = fileHandler.readLockerPasses();
        StudyCafeLockerPass lockerPass = lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(null);

        boolean lockerSelection = false;
        if (lockerPass != null) {
          outputHandler.askLockerPass(lockerPass);
          lockerSelection = inputHandler.getLockerSelection();
        }

        if (lockerSelection) {
          outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } else {
          outputHandler.showPassOrderSummary(selectedPass, null);
        }
      }
    } catch (AppException e) {
      outputHandler.showSimpleMessage(e.getMessage());
    } catch (Exception e) {
      outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
    }
  }


}
