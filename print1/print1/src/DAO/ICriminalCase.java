package DAO;

import core.model.CriminalCase;

public interface ICriminalCase {
    public void add(CriminalCase criminalCase);
    public Object get(long id);
    public Object getAll();
    public Object update(CriminalCase criminalCase);
    public Object remove(long id);
}
