package service;

import model.CriminalCase;

public interface CriminalCaseService {

    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase removeCriminalCase(CriminalCase criminalCase);

    CriminalCase updateCriminalCase(CriminalCase criminalCase);
}
