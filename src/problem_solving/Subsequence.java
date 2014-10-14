package problem_solving;

public class Subsequence
{

    /**
     * helper function will return true/false is given string is sub string of
     * other
     * 
     * @param s1
     *            given string for
     * @param s2
     *            matching string
     * @param m
     *            length of given string
     * @param n
     *            length of matching string
     * @return true/false
     */
    public static boolean isSubString(String s1, String s2, int m, int n)
    {
	if (m == -1)
	    return true;
	if (n == -1)
	    return false;
	if (s1.charAt(m) == s2.charAt(n))
	    return isSubString(s1, s2, m - 1, n - 1);
	return isSubString(s1, s2, m - 1, n);
    }

    public static void main(String[] args)
    {

	String[][] testCase = { { "AXY", "ADXCPY" }, { "gksrek", "geeksforgeeks" }, { "AXY", "YADXCP" } };

	for (int i = 0; i < testCase.length; i++)
	{
	    System.out.println(testCase[i][1]+"," +testCase[i][0]+" ===> "+isSubString(testCase[i][1], testCase[i][0], testCase[i][1].length() - 1,
		    testCase[i][0].length() - 1));
	}
    }

}
