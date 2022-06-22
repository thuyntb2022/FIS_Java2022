package dao.jdbc;


import dao.IDaoInMem.ITrackEntryDao;
import model.TrackEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JDBCTrackEntryDAO implements ITrackEntryDao {
    public final static String URL = "jdbc:mysql://localhost:3306/CriminalEvidence";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "root";

    private final static Logger logger = LoggerFactory.getLogger(JDBCTrackEntryDAO.class);

    @Override
    public void add(TrackEntry trackEntry) {

    }

    @Override
    public TrackEntry get(long id) {
        List<TrackEntry> trackEntryList = this.getAll();
        Optional<TrackEntry> opt = trackEntryList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<TrackEntry> getAll() {
        List<TrackEntry> trackEntryList = new ArrayList<>();
        try (Connection con =
                     DriverManager.getConnection (URL, USER_NAME, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM TrackEntry");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                TrackEntry trackEntry = new TrackEntry(rs.getLong("TrackEntry_id"),
                        rs.getInt("number"));
                //CriminalCaseMapper.get(rs);
                trackEntryList.add(trackEntry);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return trackEntryList;
    }

    @Override
    public Object update(TrackEntry trackEntry) {
        return null;
    }

    @Override
    public Object remove(long id) {
        return null;
    }
}
