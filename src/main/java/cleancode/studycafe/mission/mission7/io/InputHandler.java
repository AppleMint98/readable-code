package cleancode.studycafe.mission.mission7.io;

import cleancode.studycafe.mission.mission7.model.StudyCafePass;
import cleancode.studycafe.mission.mission7.model.StudyCafePassType;
import cleancode.studycafe.mission.mission7.model.StudyCafePasses;

import java.util.List;

public interface InputHandler {

  StudyCafePassType getPassTypeSelectingUserAction();

  StudyCafePass getSelectPass(StudyCafePasses passes);

  boolean getLockerSelection();
}
