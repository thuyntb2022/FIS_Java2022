package DAO;

import DAO.IDaoInMem.IDetectiveDao;
import DAO.jdbc.JDBCCriminalCaseDAO;
import DAO.jdbc.JDBCDetectiveDAO;
import core.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDaoMem implements IDetectiveDao {
    List<Detective> detectiveList = new ArrayList<>();
    public DetectiveDaoMem() {}
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public Boolean add(Detective detective) {
        for (Detective dete : detectiveList) {
            if (dete.getId() == detective.getId()) return false;
        }
        this.detectiveList.add(detective);
        logger.info("Them moi detective");
        return true;
    }

    @Override
    public Detective get(long id) {
        Optional<Detective> opt = this.detectiveList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Detective> getAll() {
        return this.detectiveList;
    }

    @Override
    public Detective update(Detective updatedDetective) {
        for (int i = 0;i<detectiveList.size();i++) {
            if (detectiveList.get(i).getId() == updatedDetective.getId()) {
                detectiveList.set(i,updatedDetective);
                logger.info("Cap nhat detective");
                return updatedDetective;
            }
        }
        return null;
    }

    @Override
    public Detective remove(long id) {
        for (int i = 0;i<detectiveList.size();i++) {
            if (detectiveList.get(i).getId() == id) {
                Detective detective = detectiveList.get(i);
                detectiveList.remove(i);
                logger.info("Da xoa 1 detective");
                return detective;
            }
        }
        return null;
    }
    
}
