package DAO;

import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao{
    private Dao dao = new Dao();
    private List<Object> listDao = new ArrayList<>();

    public Dao() {};

    @Override
    public void add(Object obj) {
        this.dao.listDao.add(obj);
    };
    @Override
    public Object get(long id) {
        return null;
    }
    @Override
    public Object getAll() {
        return this.dao.listDao;
    }
    @Override
    public Object update(Object obj) {
        return null;
    }
    @Override
    public Object remove(long id) {
        return null;
    }
}
