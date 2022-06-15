package DAO.jdbc;

import DAO.IDaoInMem.ICriminalCaseDao;
import core.model.CriminalCase;
import org.junit.jupiter.api.Test;

import java.util.List;

class JDBCCriminalCaseDAOTest {
    @Test
    void getAll() {
        //A1
        ICriminalCaseDao criminalCaseDAO = new JDBCCriminalCaseDAO();

        //A2
        List<CriminalCase> criminalCaseList = (List<CriminalCase>) criminalCaseDAO.getAll();

        //A3: Assert
        System.out.println(criminalCaseList);
    }


}