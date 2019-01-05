package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns = {"/*"})
public class ConnectionDatabase implements Filter {
	private static Connection connection;

    public ConnectionDatabase() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnection.getConnection();
	}

}
