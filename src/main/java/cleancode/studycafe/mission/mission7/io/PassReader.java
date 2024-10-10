package cleancode.studycafe.mission.mission7.io;

import cleancode.studycafe.mission.mission7.model.pass.StudyCafeSeatPasses;
import cleancode.studycafe.mission.mission7.model.pass.locker.StudyCafeLockerPasses;

public interface PassReader {


  StudyCafeSeatPasses readStudyCafePasses();

  StudyCafeLockerPasses readLockerPasses();

}
