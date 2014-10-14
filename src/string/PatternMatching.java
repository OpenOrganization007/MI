package string;

import java.util.ArrayList;

public class PatternMatching
{
    /**
     * Utility function help finding all String matching indexes in give text as
     * input
     * @param pattern
     * @param text
     * @return
     */
    public static ArrayList<Integer> search(String pattern, String text)
    {
	ArrayList<Integer> list = new ArrayList<Integer>();
	// M is length of pattern
	int M = pattern.length();
	// N is length of given input text
	int N = text.length();
	for (int i = 0; i < N - M; i++)
	{
	    int j;
	    for (j = 0; j < M; j++)
		if (text.charAt(i + j) != pattern.charAt(j))
		    break;
	    if (j == M)
		list.add(i);
	}
	return list;
    }

    public static void main(String[] args)
    {
	String text = "The Colorado River is the principal river of the Southwestern United States and northwest Mexico. Rising in the western Rocky Mountains, the 1,450-mile (2,330 km) river drains a vast arid region of the Colorado Plateau and the Mojave and Sonoran Deserts as it heads towards the Gulf of California. Known for its dramatic scenery (Horseshoe Bend pictured) and its whitewater, the Colorado carves numerous gorges, including the Grand Canyon in northern Arizona. For 8,000 years, the Colorado Basin was only sparsely populated by Native Americans, though some of their ancient civilizations employed advanced irrigation techniques. Even after becoming part of the U.S. in the 1800s, the Colorado River country remained extremely remote until John Wesley Powell's 1869 river-running expedition, which began to open up the river for future development. Since the completion of Hoover Dam in 1935, the Colorado has been tamed by an extensive system of dams and canals, providing for irrigation, cities, and hydropower. Today the Colorado supports 40 million people in seven U.S. and two Mexican states; with every drop of its water allocated, it no longer reaches the sea except in years of heavy runoff";
	String pat = "United";
	ArrayList<Integer> allMatches = search(pat, text);
	for (Integer i : allMatches)
	{
	    System.out.println(i);
	    System.out.println(text.substring(0, i));
	}

    }

}
