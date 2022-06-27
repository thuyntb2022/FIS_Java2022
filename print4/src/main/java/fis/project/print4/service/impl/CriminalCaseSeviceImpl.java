package fis.project.print4.service.impl;

import fis.project.print4.model.CriminalCase;
import fis.project.print4.repository.CriminalCaseRepository;
import fis.project.print4.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CriminalCaseSeviceImpl implements CriminalCaseService {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase findById(Long id) {
        Optional<CriminalCase> optional = criminalCaseRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new IllegalArgumentException("cannot find criminal case with id" + id);

    }

    @Override
    public CriminalCase insert(CriminalCase criminalCase) {
        Optional<CriminalCase> optional= criminalCaseRepository.findById(criminalCase.getId());
        if (optional.isPresent()) {
            throw new IllegalArgumentException("criminalCase  exit");
        }
        criminalCaseRepository.save(criminalCase);
        return criminalCase;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        CriminalCase criminalCase1 = null;
        Optional<CriminalCase> optional= criminalCaseRepository.findById(criminalCase.getId());
        if (optional.isPresent()) {
            criminalCase1.setId(criminalCase.getId());
            criminalCase1.setVersion(criminalCase.getVersion()+1);
            criminalCaseRepository.save(criminalCase1);
            return criminalCase;
        }
        throw new IllegalArgumentException("criminalCase exit");

    }

    @Override
    public CriminalCase delete(Long id) {
        Optional<CriminalCase> optional = criminalCaseRepository.findById(id);
        if (optional.isPresent()) {
            CriminalCase criminalCase = optional.get();
            criminalCaseRepository.deleteById(id);
            return criminalCase;
        }
        throw new IllegalArgumentException("cannot Criminal case with id " + id);
    }
}
