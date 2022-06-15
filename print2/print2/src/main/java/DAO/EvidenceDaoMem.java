package DAO;

import DAO.IDaoInMem.IEvidenceDao;
import core.model.Detective;
import core.model.Evidence;
import core.model.TrackEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvidenceDaoMem implements IEvidenceDao {
    List<Evidence>  evidenceList = new ArrayList<>();
    public EvidenceDaoMem() {}
    @Override
    public void add(Evidence evidence) {
        this.evidenceList.add(evidence);
    }

    @Override
    public Evidence get(long id) {
        Optional<Evidence> opt = this.evidenceList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Evidence> getAll() {
        return this.evidenceList;
    }

    @Override
    public Evidence update(Evidence updateEvidence) {
        for (int i = 0;i<evidenceList.size();i++) {
            if (evidenceList.get(i).getId() == updateEvidence.getId()) {
                evidenceList.set(i,updateEvidence);
                return updateEvidence;
            }
        }
        return null;
    }

    @Override
    public Evidence remove(long id) {
        for (int i = 0;i<evidenceList.size();i++) {
            if (evidenceList.get(i).getId() == id) {
                Evidence evidence = evidenceList.get(i);
                evidenceList.remove(i);
                return evidence;
            }
        }
        return null;
    }
}
