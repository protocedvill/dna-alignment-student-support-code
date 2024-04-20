/**
 * This class is used to score alignments. 
 * 
 * TODO: You are to implement the two score() methods.
 *  
 * @author <put your name here>
 */

public class Judge {

  public static final int DEFAULT_MATCH_COST = 2;
  public static final int DEFAULT_MISMATCH_COST = -2;
  public static final int DEFAULT_GAP_COST = -1;
  
  private int matchCost, mismatchCost, gapCost;
  
  /**
   * Creates the default judge.
   */
  public Judge() {
    this(DEFAULT_MATCH_COST, DEFAULT_MISMATCH_COST, DEFAULT_GAP_COST);
  }
  
  /**
   * Creates a judge using the specified costs.
   */
  public Judge(int matchCost, int mismatchCost, int gapCost) {
    this.matchCost = matchCost;
    this.mismatchCost = mismatchCost;
    this.gapCost = gapCost;
  }
  
  /**
   * Returns the gap cost used by this judge.
   */
  public int getGapCost() {
    return gapCost;
  }
  
  /**
   * Returns the match cost used by this judge.
   */
  public int getMatchCost() {
    return matchCost;
  }
  
  /**
   * Returns the mismatch cost used by this judge.
   */
  public int getMismatchCost() {
    return mismatchCost;
  }
  
  /**
   *
   * modified
   * Returns the score associated with the two characters.
   */
  public int score(char a, char b) {
    if(a == '_' || b == '_') return gapCost;
    if(a == b) return matchCost;
    return mismatchCost;
  }
  
  /**
   * modified
   * 
   * Returns the score associated with the two strings.
   */
  public int score(String s1, String s2) {
    int len = Math.min(s1.length(),s2.length());
    int gap = Math.max(s1.length(),s2.length()) - len;
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();

    //System.out.println(chars1);
    //System.out.println(chars2);
    int score = 0;
    for (int i = 0; i < len; i++) {
      score = score + score(chars1[i],chars2[i]);
    }

    //System.out.println(score);
    // do we care about extra characters?
    //score += gap*gapCost;

    return score;
  }
}
