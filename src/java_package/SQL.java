package java_package;

/**
 * Created by Dima on 24.04.2016.
 */

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    void ShowListOfUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String str = rs.getString(1);
                printString(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    void SignUp(String login, String pass) {
        try {
            String request;
            request = "INSERT INTO users VALUES ('" + login + "','" + pass + "'," + 0 + "," + 0 + ")";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    boolean SignIn(String login, String pass) {
        boolean signin = false;
        try {
            String request;
            request = "SELECT * FROM users WHERE name = '" + login + "'";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery(request);
            if(rs.next() && rs.getString(1).equals(login) && rs.getString(2).equals(pass))
                signin = true;
            else
                System.out.println("login or pass is not correct");
            if(rs.getInt(3) != 0) {
                System.out.println("You have been blocked!");
                signin = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
        return signin;
    }

    void ChangePassword(String login, String newpass) {
        try {
            String request;
            request = "UPDATE users SET pass = '" + newpass + "' WHERE name = '" + login + "'";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    void BlockUser(String username) {
        try {
            String request;
            request = "UPDATE users SET isblock = " + 1 + " WHERE name = '" + username + "'";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    void NotAnyPassword(String username) {
        try {
            String request;
            request = "UPDATE users SET notanypass = " + 1 + " WHERE name = '" + username + "'";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    void AddUser(String username) {
        try {
            String request;
            request = "INSERT INTO users (name) VALUES ('" + username + "');";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    void AnyPassword(String username) {
        try {
            String request;
            request = "UPDATE users SET notanypass = " + 0 + " WHERE name = '" + username + "'";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/USERS";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            stmt.executeUpdate(request);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    static void printString(Object s) {
        try {
            System.out.println(new String(s.toString().getBytes("windows-1251"), "windows-1252"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }

}
