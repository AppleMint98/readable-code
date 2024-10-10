package cleancode.studycafe.mission.mission7.model;

import java.util.List;

public class StudyCafePasses {

  private List<StudyCafePass> studyCafePasses;

  private StudyCafePasses(List<StudyCafePass> studyCafePasses) {
    this.studyCafePasses = studyCafePasses;
  }

  public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
    return new StudyCafePasses(studyCafePasses);
  }

  public StudyCafePasses getSelectedPasses(StudyCafePassType studyCafePassType) {
    return StudyCafePasses.of(studyCafePasses.stream()
        .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
        .toList());
  }
}
