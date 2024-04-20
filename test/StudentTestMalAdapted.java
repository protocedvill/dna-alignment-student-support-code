/**
 * To test with JUnit, add JUnit to your project. To do this, go to
 * Project->Properties. Select "Java Build Path". Select the "Libraries"
 * tab and "Add Library". Select JUnit, then JUnit 4.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTestMalAdapted {
  @Test
  public void test() {
    defaultJudgeTest();
    customJudgeTest();
    empties();
    singletons();
    // your tests go here
  }

  @Test
  public void defaultJudgeTest() {
    Judge judge = new Judge();
    assertEquals(2, judge.score('A',  'A'));
    assertEquals(2, judge.score("A",  "A"));
  }

  @Test
  public void customJudgeTest() {
    Judge judge = new Judge(3, -3, -2);
    assertEquals(3, judge.score('A',  'A'));
    assertEquals(3, judge.score("A",  "A"));
  }

  /**********************************************
   * Testing SequenceAligner.fillCache()
   **********************************************/
  @Test
  public void empties() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("", "");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
  }

  @Test
  public void singletons() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("A", "A");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
    result = sa.getResult(0, 1);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.LEFT, result.getParent());
    result = sa.getResult(1, 0);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.UP, result.getParent());
    result = sa.getResult(1, 1);
    assertNotNull(result);
    assertEquals(2, result.getScore());
    assertEquals(Direction.DIAGONAL, result.getParent());
  }

  /**********************************************
   * Testing SequenceAligner.traceback()
   **********************************************/
  @Test
  public void simpleAlignment() {
    SequenceAligner sa;
    sa = new SequenceAligner("ACGT", "ACGT");
    assertTrue(sa.isAligned());
    assertEquals("ACGT", sa.getAlignedX());
    assertEquals("ACGT", sa.getAlignedY());
  }


}