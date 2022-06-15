package DAO;

import core.model.CriminalCase;
import core.model.Detective;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CriminalCaseDaoMemTest {
    private final static Logger looger = LoggerFactory.getLogger(CriminalCaseDaoMemTest.class);
    CriminalCaseDaoMem criminalCaseDaoMem = new CriminalCaseDaoMem();
    @BeforeEach
    void setUp() {
        criminalCaseDaoMem.criminalCaseList.clear();
        criminalCaseDaoMem.criminalCaseList.add(new CriminalCase(1, 1));
        criminalCaseDaoMem.criminalCaseList.add(new CriminalCase(2, 1));
        criminalCaseDaoMem.criminalCaseList.add(new CriminalCase(3, 1));
    }

    @Test
    void add() {
        criminalCaseDaoMem.add(new CriminalCase(4, 1));
        assertEquals(criminalCaseDaoMem.criminalCaseList.size(), 4);
    }

    @Test
    void get() {
        assertEquals(criminalCaseDaoMem.get(1).getId(), 1);
    }

    @Test
    void getAll() {
        assertEquals(criminalCaseDaoMem.getAll(), criminalCaseDaoMem.criminalCaseList);
    }

    @Test
    void update() {
        CriminalCase criminalCase = new CriminalCase(2, 2);
        criminalCaseDaoMem.update(criminalCase);
        assertEquals(criminalCaseDaoMem.get(2).getVersion(), criminalCase.getVersion());
    }

    @Test
    void remove() {
        criminalCaseDaoMem.remove(2);
        assertEquals(criminalCaseDaoMem.criminalCaseList.size(), 2);
    }
}