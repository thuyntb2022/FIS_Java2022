package dao.IDaoInMem;


import model.Evidence;

public interface IEvidenceDao {
    void add(Evidence evidence);
    Object get(long id);
    Object getAll();
    Object update(Evidence evidence);
    Object remove(long id);
}
