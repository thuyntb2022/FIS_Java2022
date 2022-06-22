package dao.IDaoInMem;

import model.Detective;

public interface IDetectiveDao {
    Boolean add(Detective detective) ;
    Object get(long id);
    Object getAll();
    Object update(Detective detective);
    Object remove(long id);
}
