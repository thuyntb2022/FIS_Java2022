package dao.IDaoInMem;


import model.CriminalCase;

public interface ICriminalCaseDao {
    void add(CriminalCase criminalCase);
    Object get(long id);
    Object getAll();
    Object update(CriminalCase criminalCase);
    Object remove(long id);
}