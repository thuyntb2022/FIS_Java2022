package DAO;

import core.model.Detective;

public interface IDetective {
    public void add(Detective detective);
    public Object get(long id);
    public Object getAll();
    public Object update(Detective detective);
    public Object remove(long id);
}
