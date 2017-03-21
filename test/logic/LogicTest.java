/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pacho
 */
public class LogicTest {
    
    public LogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testProcessOperations() {
        System.out.println("processOperations");
        int matrixSize = 4;
        int operationsNumber = 5;
        ArrayList<String> operations = new ArrayList<>();
        
        operations.add("UPDATE 2 2 2 4");
        operations.add("QUERY 1 1 1 3 3 3");
        operations.add("UPDATE 1 1 1 23");
        operations.add("QUERY 2 2 2 4 4 4");
        operations.add("QUERY 1 1 1 3 3 3");
        
        Logic instance = new Logic();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("update");
        expResult.add("4");
        expResult.add("update");
        expResult.add("4");
        expResult.add("27");
        
        ArrayList<String> result = instance.processOperations(matrixSize, operationsNumber, operations);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testProcessOperations2() {
        System.out.println("processOperations 2");
        int matrixSize = 4;
        int operationsNumber = 5;
        ArrayList<String> operations = new ArrayList<>();
        
        operations.add("UPDATE 2 2 2 1");
        operations.add("QUERY 1 1 1 1 1 1");
        operations.add("QUERY 1 1 1 2 2 2");
        operations.add("QUERY 2 2 2 2 2 2");
        
        Logic instance = new Logic();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("update");
        expResult.add("0");
        expResult.add("1");
        expResult.add("1");
        
        ArrayList<String> result = instance.processOperations(matrixSize, operationsNumber, operations);
        assertEquals(expResult, result);
        
    }
    
}
