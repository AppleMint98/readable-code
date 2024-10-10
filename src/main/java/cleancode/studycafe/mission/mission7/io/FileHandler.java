package cleancode.studycafe.mission.mission7.io;

import cleancode.studycafe.mission.mission7.model.StudyCafeLockerPasses;
import cleancode.studycafe.mission.mission7.model.StudyCafePasses;

public interface FileHandler {

  StudyCafePasses readStudyCafePasses();

  StudyCafeLockerPasses readLockerPasses();
}
