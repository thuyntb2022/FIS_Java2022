package DAO.jdbc;

import DAO.IDaoInMem.IEvidenceDao;
import core.model.CriminalCase;
import core.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCEvidenceDAO implements IEvidenceDao {
    public final static String URL = "jdbc:mysql://localhost:3306/CriminalEvidence";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "root";

    private final static Logger logger = LoggerFactory.getLogger(JDBCEvidenceDAO.class);
    @Override
    public void add(Evidence evidence) {

    }

    @Override
    public Evidence get(long id) {
        List<Evidence> evidenceList = this.getAll();
        Optional<Evidence> opt = evidenceList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Evidence> getAll() {
        List<Evidence> evidenceList = new ArrayList<>();
        try (Connection con =
                     DriverManager.getConnection (URL, USER_NAME, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM Evidence");
             ResultSet rs = stmt.executeQuery ()) {
            while (rs.next()) {
                Evidence evidence = new Evidence(rs.getLong("Evidence_id"),
                        rs.getInt("number"));
                //CriminalCaseMapper.get(rs);
                evidenceList.add(evidence);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return evidenceList;
    }

    @Override
    public Evidence update(Evidence evidence) {
        return null;
    }

    @Override
    public Evidence remove(long id) {
        return null;
    }
}
