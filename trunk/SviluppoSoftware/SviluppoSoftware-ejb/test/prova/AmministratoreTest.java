/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dani1913
 */
public class AmministratoreTest {

    public AmministratoreTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPassword method, of class Amministratore.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Amministratore instance = new Amministratore();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Amministratore.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Amministratore instance = new Amministratore();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCognome method, of class Amministratore.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Amministratore instance = new Amministratore();
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class Amministratore.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Amministratore instance = new Amministratore();
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Amministratore.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Amministratore instance = new Amministratore();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Amministratore.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Amministratore instance = new Amministratore();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Amministratore.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Amministratore instance = new Amministratore();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Amministratore.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Amministratore instance = new Amministratore();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Amministratore.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Amministratore instance = new Amministratore();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Amministratore.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Amministratore instance = new Amministratore();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Amministratore.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Amministratore instance = new Amministratore();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}