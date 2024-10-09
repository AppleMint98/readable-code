package cleancode.studycafe.mission.mission7;

import cleancode.studycafe.mission.mission7.exception.AppException;
import cleancode.studycafe.mission.mission7.io.ConsoleInputHandler;
import cleancode.studycafe.mission.mission7.io.ConsoleOutputHandler;
import cleancode.studycafe.mission.mission7.io.StudyCafeFileHandler;
import cleancode.studycafe.mission.mission7.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.mission7.model.StudyCafePass;
import cleancode.studycafe.mission.mission7.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    public void run() {
        try {
            consoleOutputHandler.showWelcomeMessage();
            consoleOutputHandler.showAnnouncement();

            consoleOutputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = consoleInputHandler.getPassTypeSelectingUserAction();

            if (studyCafePassType == StudyCafePassType.HOURLY) {
                StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
                List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
                List<StudyCafePass> hourlyPasses = studyCafePasses.stream()
                    .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.HOURLY)
                    .toList();
                consoleOutputHandler.showPassListForSelection(hourlyPasses);
                StudyCafePass selectedPass = consoleInputHandler.getSelectPass(hourlyPasses);
                consoleOutputHandler.showPassOrderSummary(selectedPass, null);
            } else if (studyCafePassType == StudyCafePassType.WEEKLY) {
                StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
                List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
                List<StudyCafePass> weeklyPasses = studyCafePasses.stream()
                    .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.WEEKLY)
                    .toList();
                consoleOutputHandler.showPassListForSelection(weeklyPasses);
                StudyCafePass selectedPass = consoleInputHandler.getSelectPass(weeklyPasses);
                consoleOutputHandler.showPassOrderSummary(selectedPass, null);
            } else if (studyCafePassType == StudyCafePassType.FIXED) {
                StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
                List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
                List<StudyCafePass> fixedPasses = studyCafePasses.stream()
                    .filter(studyCafePass -> studyCafePass.getPassType() == StudyCafePassType.FIXED)
                    .toList();
                consoleOutputHandler.showPassListForSelection(fixedPasses);
                StudyCafePass selectedPass = consoleInputHandler.getSelectPass(fixedPasses);

                List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();
                StudyCafeLockerPass lockerPass = lockerPasses.stream()
                    .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                            && option.getDuration() == selectedPass.getDuration()
                    )
                    .findFirst()
                    .orElse(null);

                boolean lockerSelection = false;
                if (lockerPass != null) {
                    consoleOutputHandler.askLockerPass(lockerPass);
                    lockerSelection = consoleInputHandler.getLockerSelection();
                }

                if (lockerSelection) {
                    consoleOutputHandler.showPassOrderSummary(selectedPass, lockerPass);
                } else {
                    consoleOutputHandler.showPassOrderSummary(selectedPass, null);
                }
            }
        } catch (AppException e) {
            consoleOutputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            consoleOutputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
