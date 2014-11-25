package com.adm.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adm.vo.State;

@Service
public class States {

    private List<State> states;

    public States() {
    }

    /**
     * Gets the state data from the database and returns the results as a list
     * of State objects.
     * 
     * @return a list of State objects.
     */
    public List<State> asList() {
	Connection connect = null;
	try {
	    System.out.println("States::as list -Start");
	    Class.forName("com.mysql.jdbc.Driver");
	    // setup the connection with the DB.
	    connect = DriverManager
		    .getConnection("jdbc:mysql://localhost/states?"
			    + "user=isys622&password=p@ssw0rd");
	    Statement statement = connect.createStatement();
	    
	    ResultSet resultSet = statement
		    .executeQuery("select * from STATES.states");

	    states = new ArrayList<State>();
	    while (resultSet.next()) {
		String code = resultSet.getString("code");
		String name = resultSet.getString("name");
		State state = new State(code, name);
		
		states.add(state);
	    }
	    printStateList();
	    connect.close();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	System.out.println("States::as list -End");
	return states;
    }
    
    public void printStateList(){
	System.out.println("List of States :");
	for (State state : states) {
	  System.out.println("Code: " + state.getCode() + " Name: " + state.getName());
	}
    }

}
