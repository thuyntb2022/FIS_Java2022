package dao.jdbc;


import dao.IDaoInMem.IDetectiveDao;
import model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDao {
    List<Detective> detectiveList = new ArrayList<>();
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public Boolean add(Detective detective)  {

        if (get(detective.getId()) == null) {
            String sql = "INSERT INTO Detective (Detective_id,Detective_number) VALUES (?,?)";
            Connection conn = null;
            try {
                conn = new JDBCConnection().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setLong(1,detective.getId());
                stmt.setInt(2,detective.getVersion());
                stmt.executeUpdate();
                stmt.close();
                logger.info("Them moi detective");
                return true;
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return false;
    }

    @Override
    public Detective get(long id) {
        if (detectiveList.isEmpty()) this.getAll();
        Optional<Detective> opt = detectiveList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Detective> getAll() {
        String sql = "SELECT * FROM Detective";
        try (Connection con = new JDBCConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Detective detective = new Detective(rs.getLong("Detective_id"),
                        rs.getInt("number"));
                detectiveList.add(detective);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
            return detectiveList;

    }

    @Override
    public Object update(Detective detective) {if (get(detective.getId()) == null) {
            String sql = "UPDATE Detective SET Detective_number=" + detective.getVersion() +
                    "FROM Detective where Detective_id=" + detective.getId();
            Connection conn = null;
            try {
                conn = new JDBCConnection().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                stmt.close();
                logger.info("Them moi detective");
                return true;
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return null;
    }

    @Override
    public Object remove(long id) {
        return null;
    }
}
