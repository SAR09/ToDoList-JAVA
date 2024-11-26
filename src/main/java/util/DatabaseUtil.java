package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseUtil {

    private static HikariDataSource hikariDataSource ;

    static {

        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        String url = dotenv.get("DB_URL");

        HikariDataSource configuration = new HikariDataSource();
        configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");
        configuration.setUsername(username);
        configuration.setPassword(password);
        configuration.setJdbcUrl(url);

        //pool
        configuration.setMaximumPoolSize(10);
        configuration.setMinimumIdle(5);
        configuration.setIdleTimeout(60_000);
        configuration.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(configuration);

    }

    public static HikariDataSource getDataSource(){
        return hikariDataSource;
    }
}
