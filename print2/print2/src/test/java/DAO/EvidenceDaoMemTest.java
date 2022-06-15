package DAO;

import core.model.Detective;
import core.model.Evidence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class EvidenceDaoMemTest {
    private final static Logger looger = LoggerFactory.getLogger(EvidenceDaoMemTest.class);
    EvidenceDaoMem evidenceDaoMem = new EvidenceDaoMem();
    @BeforeEach
    void setUp() {
        evidenceDaoMem.evidenceList.clear();
        evidenceDaoMem.evidenceList.add(new Evidence(1, 1));
        evidenceDaoMem.evidenceList.add(new Evidence(2, 1));
        evidenceDaoMem.evidenceList.add(new Evidence(3, 1));
    }

    @Test
    void add() {
        evidenceDaoMem.add(new Evidence(4, 1));
        assertEquals(evidenceDaoMem.evidenceList.size(), 4);
    }

    @Test
    void get() {
        assertEquals(evidenceDaoMem.get(1).getId(), 1);
    }

    @Test
    void getAll() {
        assertEquals(evidenceDaoMem.getAll(), evidenceDaoMem.evidenceList);
    }

    @Test
    void update() {
        Evidence evidence = new Evidence(2, 2);
        evidenceDaoMem.update(evidence);
        assertEquals(evidenceDaoMem.get(2).getVersion(), evidence.getVersion());
    }

    @Test
    void remove() {
        evidenceDaoMem.remove(2);
        assertEquals(evidenceDaoMem.evidenceList.size(), 2);
    }
}