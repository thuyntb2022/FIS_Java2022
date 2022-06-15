package DAO;

import core.ICore.EmploymentStatus;
import core.ICore.Rank;
import core.model.Detective;
import core.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//    private final static Logger logger = LoggerFactory.getLogger(DetectiveDaoMem.class);

class DetectiveDaoMemTest {
    private final static Logger looger = LoggerFactory.getLogger(DetectiveDaoMemTest.class);
    DetectiveDaoMem detectiveDaoMem = new DetectiveDaoMem();

    @BeforeEach
    void setUp() {
        detectiveDaoMem.detectiveList.clear();
        detectiveDaoMem.detectiveList.add(new Detective(1, 1));
        detectiveDaoMem.detectiveList.add(new Detective(2, 1));
        detectiveDaoMem.detectiveList.add(new Detective(3, 1));
    }

    @Test
    void add() {
        detectiveDaoMem.add(new Detective(4, 1));
        assertEquals(detectiveDaoMem.detectiveList.size(), 4);
    }

    @Test
    void get() {
        assertEquals(detectiveDaoMem.get(1).getId(), 1);
    }

    @Test
    void getAll() {
        assertEquals(detectiveDaoMem.getAll(), detectiveDaoMem.detectiveList);
    }

    @Test
    void update() {
        Detective detective = new Detective(2, 2);
        detectiveDaoMem.update(detective);
        assertEquals(detectiveDaoMem.get(2).getVersion(), detective.getVersion());
    }

    @Test
    void remove() {
        detectiveDaoMem.remove(2);
        assertEquals(detectiveDaoMem.detectiveList.size(), 2);
    }
}