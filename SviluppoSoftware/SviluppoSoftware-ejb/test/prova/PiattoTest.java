/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.ArrayList;
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
public class PiattoTest {

    public PiattoTest() {
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
     * Test of getUrl_immagine method, of class Piatto.
     */
    @Test
    public void testGetUrl_immagine() {
        System.out.println("getUrl_immagine");
        Piatto instance = new Piatto();
        instance.setUrl_immagine("immagini.com");
        String expResult = "immagini.com";
        String result = instance.getUrl_immagine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl_immagine method, of class Piatto.
     */
    @Test
    public void testSetUrl_immagine() {
        System.out.println("setUrl_immagine");
        String url_immagine = "immagini.com";
        Piatto instance = new Piatto();
        instance.setUrl_immagine(url_immagine);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoria method, of class Piatto.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Piatto instance = new Piatto();
        instance.setCategoria("primi");
        String expResult = "primi";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoria method, of class Piatto.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        String categoria = "primi";
        Piatto instance = new Piatto();
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPossibiliAggiunte method, of class Piatto.
     */
    @Test
    public void testGetListaPossibiliAggiunte() {
        System.out.println("getListaPossibiliAggiunte");
        Piatto instance = new Piatto();
        ArrayList<String> expResult = new ArrayList<String>();
        instance.setListaPossibiliAggiunte(expResult);
        ArrayList<String> result = instance.getListaPossibiliAggiunte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPossibiliAggiunte method, of class Piatto.
     */
    @Test
    public void testSetListaPossibiliAggiunte() {
        System.out.println("setListaPossibiliAggiunte");
        ArrayList<String> listaPossibiliAggiunte = new ArrayList<String>();
        Piatto instance = new Piatto();
        instance.setListaPossibiliAggiunte(listaPossibiliAggiunte);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setListaMaterieNonModificabili method, of class Piatto.
     */
    @Test
    public void testSetListaMaterieNonModificabili() {
        System.out.println("setListaMaterieNonModificabili");
        ArrayList<String> materie = new ArrayList<String>();
        Piatto instance = new Piatto();
        instance.setListaMaterieNonModificabili(materie);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setListaMaterieSottraibili method, of class Piatto.
     */
    @Test
    public void testSetListaMaterieSottraibili() {
        System.out.println("setListaMaterieSottraibili");
        ArrayList<String> materie = new ArrayList<String>();
        Piatto instance = new Piatto();
        instance.setListaMaterieSottraibili(materie);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCosto method, of class Piatto.
     */
    @Test
    public void testGetCosto() {
        System.out.println("getCosto");
        Piatto instance = new Piatto();
        instance.setCosto(16.0);
        Double expResult = 16.0;
        Double result = instance.getCosto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCosto method, of class Piatto.
     */
    @Test
    public void testSetCosto() {
        System.out.println("setCosto");
        Double c = 16.0;
        Piatto instance = new Piatto();
        instance.setCosto(c);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Piatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Piatto instance = new Piatto();
        instance.setNome("spaghetti");
        String expResult = "spaghetti";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Piatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "polpettone";
        Piatto instance = new Piatto();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Piatto.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Piatto instance = new Piatto();
        instance.setId(Long.MIN_VALUE);
        Long expResult = Long.MIN_VALUE;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Piatto.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = Long.MAX_VALUE;
        Piatto instance = new Piatto();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    
    
}