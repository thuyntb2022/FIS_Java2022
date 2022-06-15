package DAO;

import DAO.IDaoInMem.ICriminalCaseDao;
import core.model.CriminalCase;
import core.model.Detective;
import core.model.TrackEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CriminalCaseDaoMem implements ICriminalCaseDao {
    List<CriminalCase> criminalCaseList = new ArrayList<>();
    @Override
    public void add(CriminalCase criminalCase) {
        this.criminalCaseList.add(criminalCase);
    }

    @Override
    public CriminalCase get(long id) {
        Optional<CriminalCase> opt = this.criminalCaseList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<CriminalCase> getAll() {
        return this.criminalCaseList;
    }

    @Override
    public CriminalCase update(CriminalCase updatedcriminalCase) {
        for (int i = 0;i<criminalCaseList.size();i++) {
            if (criminalCaseList.get(i).getId() == updatedcriminalCase.getId()) {
                criminalCaseList.set(i,updatedcriminalCase);
                return updatedcriminalCase;
            }
        }
        return null;
    }

    @Override
    public CriminalCase remove(long id) {
        for (int i = 0;i<criminalCaseList.size();i++) {
            if (criminalCaseList.get(i).getId() == id) {
                CriminalCase criminalCase = criminalCaseList.get(i);
                criminalCaseList.remove(i);
                return criminalCase;
            }
        }
        return null;
    }
}
