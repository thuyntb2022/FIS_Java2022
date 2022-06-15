package DAO.jdbc;

import DAO.IDaoInMem.ICriminalCaseDao;
import core.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCaseDAO implements ICriminalCaseDao {
    public final static String URL = "jdbc:mysql://localhost:3306/CriminalEvidence";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "root";

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);
    @Override
    public void add(CriminalCase criminalCase) {

    }

    @Override
    public CriminalCase get(long id) {
        List<CriminalCase> criminalCaseList = this.getAll();
        Optional<CriminalCase> opt = criminalCaseList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCases = new ArrayList<>();
        try (Connection con =
                     DriverManager.getConnection (URL, USER_NAME, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM Evidence");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                CriminalCase criminalCase = new CriminalCase(rs.getLong("Evidence_id"),
                        rs.getInt("number"));
                        //CriminalCaseMapper.get(rs);
                criminalCases.add(criminalCase);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return criminalCases;
    }

    @Override
    public Object update(CriminalCase criminalCase) {
        return null;
    }

    @Override
    public Object remove(long id) {
        return null;
    }
}
