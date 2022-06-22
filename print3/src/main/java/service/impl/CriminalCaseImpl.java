package service.impl;

import model.CriminalCase;
import repository.CriminalCaseRepository;
import service.CriminalCaseService;

public class CriminalCaseImpl implements CriminalCaseService {
    private CriminalCaseRepository criminalCaseRepository;

    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase) {
        criminalCaseRepository.save(criminalCase);
        return null;
    }

    @Override
    public CriminalCase removeCriminalCase(CriminalCase criminalCase) {
        return null;
    }

    @Override
    public CriminalCase updateCriminalCase(CriminalCase criminalCase) {
        return null;
    }
}
