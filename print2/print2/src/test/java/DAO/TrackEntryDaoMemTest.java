package DAO;

import core.model.Detective;
import core.model.TrackEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class TrackEntryDaoMemTest {
    private final static Logger looger = LoggerFactory.getLogger(TrackEntryDaoMemTest.class);
    TrackEntryDaoMem trackEntryDaoMem = new TrackEntryDaoMem();
    @BeforeEach
    void setUp() {
        trackEntryDaoMem.trackEntryList.clear();
        trackEntryDaoMem.trackEntryList.add(new TrackEntry(1, 1));
        trackEntryDaoMem.trackEntryList.add(new TrackEntry(2, 1));
        trackEntryDaoMem.trackEntryList.add(new TrackEntry(3, 1));
    }

    @Test
    void add() {
        trackEntryDaoMem.add(new TrackEntry(4, 1));
        assertEquals(trackEntryDaoMem.trackEntryList.size(), 4);
    }

    @Test
    void get() {
        assertEquals(trackEntryDaoMem.get(1).getId(), 1);
    }

    @Test
    void getAll() {
        assertEquals(trackEntryDaoMem.getAll(), trackEntryDaoMem.trackEntryList);
    }

    @Test
    void update() {
        TrackEntry trackEntry = new TrackEntry(2, 2);
        trackEntryDaoMem.update(trackEntry);
        assertEquals(trackEntryDaoMem.get(2).getVersion(), trackEntry.getVersion());
    }

    @Test
    void remove() {
        trackEntryDaoMem.remove(2);
        assertEquals(trackEntryDaoMem.trackEntryList.size(), 2);
    }
}