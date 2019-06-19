package jdbc.commons;



import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public abstract class DBHelper {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();


    private DBHelper() {
    }

    public static void openConnection() throws IOException, ClassNotFoundException, SQLException {

        Properties pos = new Properties();
        pos.load(DBHelper.class.getClassLoader().getResourceAsStream("DataSource.properties"));
        Class.forName(pos.getProperty("driver"));
        Connection connection = DriverManager.getConnection(pos.getProperty("url"), pos.getProperty("username"), pos.getProperty("pwd"));

        threadLocal.set(connection);
    }

    public static ResultSet execute(String sql, List params) throws SQLException {
        Connection connection = threadLocal.get();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            ps.execute();
        }

        return null;
    }

    public static void executeQuery(String sql, List params, CallBack cb) throws SQLException {

        Connection connection = threadLocal.get();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                cb.work(rs);
            }
        }


    }

    public static interface CallBack {
        void work(ResultSet rs) throws SQLException;
    }

    public static void close() throws SQLException {

        if (threadLocal.get()==null||threadLocal.get().isClosed()){
            return;
        }
        threadLocal.get().close();

    }
}
