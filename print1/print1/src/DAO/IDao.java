package DAO;

public interface IDao {

    public void add(Object obj);
    public Object get(long id);
    public Object getAll();
    public Object update(Object obj);
    public Object remove(long id);
}
