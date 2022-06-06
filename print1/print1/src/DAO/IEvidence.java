package DAO;

import core.model.Evidence;

public interface IEvidence {
    public void add(Evidence evidence);
    public Object get(long id);
    public Object getAll();
    public Object update(Evidence evidence);
    public Object remove(long id);
}
