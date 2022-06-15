package DAO.IDaoInMem;

import core.model.Detective;

public interface IDetectiveDao {
    Boolean add(Detective detective);
    Object get(long id);
    Object getAll();
    Object update(Detective detective);
    Object remove(long id);
}
