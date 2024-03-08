package com.mysite.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;



public class Closing {
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private boolean done=false;
    private StringBuilder sb;

    public Closing(Connection conn, PreparedStatement pstmt) {
        this.conn= conn;
        this.pstmt = pstmt;
        this.sb = new StringBuilder();
        init();
    }

    public Closing(Connection conn, PreparedStatement pstmt,ResultSet rs) {
        this.rs= rs;
        this.conn= conn;
        this.pstmt = pstmt;
        this.sb = new StringBuilder();
        init();
    }

    public Closing(Connection conn, Statement stmt,ResultSet rs) {
        this.rs= rs;
        this.conn= conn;
        this.stmt = stmt;
        this.sb = new StringBuilder();
        init();
    }
    
    public boolean isDone() {
        return done;
    }


    public void setDone(boolean done) {
        this.done = done;
    }
    
 


    public void init() {
        int cnt = 0;
        
        if(this.conn!= null) {
            try {
                this.conn.close();
                this.sb.append("CONN");
                cnt += 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(this.pstmt!= null) {
            try {
                this.pstmt.close();
                this.sb.append(", PSTMT");
                cnt += 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(this.stmt!= null) {
            try {
                this.stmt.close();
                this.sb.append(", PSTMT");
                cnt += 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(this.rs != null) {
            try {
                this.rs.close();
                this.sb.append(",RS...");
                cnt += 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (cnt != 0) {
            setDone(true);
        }
    }

    public void worked() {
        if (isDone()){
            System.out.println("closed . . ." + sb);
        }
    }

    
  
}
