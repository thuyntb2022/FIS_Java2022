package DAO;

import DAO.IDaoInMem.ITrackEntryDao;
import core.model.Detective;
import core.model.TrackEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackEntryDaoMem implements ITrackEntryDao {
    List<TrackEntry> trackEntryList = new ArrayList<>();

    @Override
    public void add(TrackEntry trackEntry) {
        this.trackEntryList.add(trackEntry);
    }

    @Override
    public TrackEntry get(long id) {
        Optional<TrackEntry> optTrackEntry = this.trackEntryList.stream()
                .filter(trackEntry -> trackEntry.getId()==id).findFirst();
        return optTrackEntry.get();

    }

    @Override
    public List<TrackEntry> getAll() {
        return this.trackEntryList;
    }

    @Override
    public TrackEntry update(TrackEntry updateTrackEntry) {
        for (int i = 0;i<trackEntryList.size();i++) {
            if (trackEntryList.get(i).getId() == updateTrackEntry.getId()) {
                trackEntryList.set(i,updateTrackEntry);
                return updateTrackEntry;
            }
        }
        return null;
    }

    @Override
    public TrackEntry remove(long id) {
        for (int i = 0;i<trackEntryList.size();i++) {
            if (trackEntryList.get(i).getId() == id) {
                TrackEntry trackEntry = trackEntryList.get(i);
                trackEntryList.remove(i);
                return trackEntry;
            }
        }
        return null;
    }
}
