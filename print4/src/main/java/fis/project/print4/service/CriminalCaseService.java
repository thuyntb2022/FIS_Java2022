package fis.project.print4.service;

import fis.project.print4.model.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    List<CriminalCase> findAll();
    CriminalCase findById(Long id);
    CriminalCase insert(CriminalCase criminalCase);
    CriminalCase update(CriminalCase criminalCase);
    CriminalCase delete(Long id);
}
