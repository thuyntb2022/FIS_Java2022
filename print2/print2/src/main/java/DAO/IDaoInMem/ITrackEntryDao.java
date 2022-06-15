package DAO.IDaoInMem;

import core.model.Evidence;
import core.model.TrackEntry;

public interface ITrackEntryDao {
    void add(TrackEntry trackEntry);
    Object get(long id);
    Object getAll();
    Object update(TrackEntry trackEntry);
    Object remove(long id);
}