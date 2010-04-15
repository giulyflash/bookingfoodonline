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
public class UtenteRegistratoTest {

    public UtenteRegistratoTest() {
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
     * Test of getZona method, of class UtenteRegistrato.
     */
    @Test
    public void testGetZona() {
        System.out.println("getZona");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setZona("Dego");
        String expResult = "Dego";
        String result = instance.getZona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setZona method, of class UtenteRegistrato.
     */
    @Test
    public void testSetZona() {
        System.out.println("setZona");
        String zona = "Saluzzo";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setZona(zona);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getN_acquisti method, of class UtenteRegistrato.
     */
    @Test
    public void testGetN_acquisti() {
        System.out.println("getN_acquisti");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setN_acquisti("12");
        String expResult = "12";
        String result = instance.getN_acquisti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setN_acquisti method, of class UtenteRegistrato.
     */
    @Test
    public void testSetN_acquisti() {
        System.out.println("setN_acquisti");
        String n_acquisti = "10";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setN_acquisti(n_acquisti);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class UtenteRegistrato.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setTelefono("3456839");
        String expResult = "3456839";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class UtenteRegistrato.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "0110011";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIndirizzo method, of class UtenteRegistrato.
     */
    @Test
    public void testGetIndirizzo() {
        System.out.println("getIndirizzo");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setIndirizzo("via saluzzo 33");
        String expResult = "via saluzzo 33";
        String result = instance.getIndirizzo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIndirizzo method, of class UtenteRegistrato.
     */
    @Test
    public void testSetIndirizzo() {
        System.out.println("setIndirizzo");
        String indirizzo = "via allasia 11";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setIndirizzo(indirizzo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getN_cartacredito method, of class UtenteRegistrato.
     */
    @Test
    public void testGetN_cartacredito() {
        System.out.println("getN_cartacredito");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setN_cartacredito("1111");
        String expResult = "1111";
        String result = instance.getN_cartacredito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setN_cartacredito method, of class UtenteRegistrato.
     */
    @Test
    public void testSetN_cartacredito() {
        System.out.println("setN_cartacredito");
        String n_cartacredito = "1111";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setN_cartacredito(n_cartacredito);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class UtenteRegistrato.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setMail("dani1913@gmail.com");
        String expResult = "dani1913@gmail.com";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMail method, of class UtenteRegistrato.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "dani1913@gmail.com";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setMail(mail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCognome method, of class UtenteRegistrato.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setCognome("Melloz");
        String expResult = "Melloz";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class UtenteRegistrato.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Melloz";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class UtenteRegistrato.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setNome("Matteoz");
        String expResult = "Matteoz";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class UtenteRegistrato.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Matteoz";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UtenteRegistrato.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setPassword("123hfr");
        String expResult = "123hfr";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UtenteRegistrato.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "111222";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class UtenteRegistrato.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setId("luca86");
        String expResult = "luca86";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class UtenteRegistrato.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "lucaIengi";
        UtenteRegistrato instance = new UtenteRegistrato();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UtenteRegistrato.
     */
    /*@Test
    public void testHashCode() {
        System.out.println("hashCode");
        UtenteRegistrato instance = new UtenteRegistrato();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of equals method, of class UtenteRegistrato.
     */
    /*@Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UtenteRegistrato instance = new UtenteRegistrato();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of toString method, of class UtenteRegistrato.
     */
    /*@Test
    public void testToString() {
        System.out.println("toString");
        UtenteRegistrato instance = new UtenteRegistrato();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}