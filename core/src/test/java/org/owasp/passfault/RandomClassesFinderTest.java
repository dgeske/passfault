package org.owasp.passfault;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RandomClassesFinderTest
{

  @Test
  public void test() throws Exception
  {
    RandomClassesFinder finder = new RandomClassesFinder(3);
    MockPasswordResults results = new MockPasswordResults("12345");
    finder.analyze(results);
    List<PasswordPattern> patterns = results.getFoundPatterns();
    assertEquals( 6, patterns.size());
    for(PasswordPattern patt: patterns){
      System.out.println(patt.getMatchString());
    }
  }

  @Test
  public void testTroysPassword() throws Exception
  {
    RandomClassesFinder finder = new RandomClassesFinder(3);
    MockPasswordResults results = new MockPasswordResults("00455455mb17");
    finder.analyze(results);
    List<PasswordPattern> patterns = results.getFoundPatterns();
    assertEquals( 21, patterns.size());
    for(PasswordPattern patt: patterns){
      System.out.println(patt.getMatchString());
    }
  }
  
  @Test
  public void test_large() throws Exception
  {
    RandomClassesFinder finder = new RandomClassesFinder(3);
    MockPasswordResults results = new MockPasswordResults("!@#234#$%1234");
    finder.analyze(results);
    List<PasswordPattern> patterns = results.getFoundPatterns();
    
    for(PasswordPattern patt: patterns){
      System.out.println(patt.getMatchString());
    }
    assertEquals( 6, patterns.size());
  }

  @Test
  public void test_chars() throws Exception
  {
    RandomClassesFinder finder = new RandomClassesFinder(3);
    MockPasswordResults results = new MockPasswordResults("abcdef");
    finder.analyze(results);
    List<PasswordPattern> patterns = results.getFoundPatterns();
    
    for(PasswordPattern patt: patterns){
      System.out.println(patt.getMatchString());
    }
    assertEquals( 0, patterns.size());
  }
}
