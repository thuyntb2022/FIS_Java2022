package DAO.jdbc;

import DAO.IDaoInMem.IDetectiveDao;
import core.model.CriminalCase;
import core.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDao {
    public final static String URL = "jdbc:mysql://localhost:3306/CriminalEvidence";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "root";

    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public Boolean add(Detective detective) {
        List<Detective> detectiveList = this.getAll();
        for (Detective dete : detectiveList) {
            if (dete.getId() == detective.getId()) return false;
        }
        detectiveList.add(detective);
        logger.info("Them moi detective");
        return true;
    }

    @Override
    public Detective get(long id) {
        List<Detective> detectiveList = this.getAll();
        Optional<Detective> opt = detectiveList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Detective> getAll() {
        List<Detective> detectiveList = new ArrayList<>();
        try (Connection con =
                     DriverManager.getConnection (URL, USER_NAME, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM Detective");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                Detective detective = new Detective(rs.getLong("Detective_id"),
                        rs.getInt("number"));
                //CriminalCaseMapper.get(rs);
                detectiveList.add(detective);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return detectiveList;
    }

    @Override
    public Object update(Detective detective) {
        return null;
    }

    @Override
    public Object remove(long id) {
        return null;
    }
}
