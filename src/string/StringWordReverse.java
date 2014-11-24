public class StringWordReverse
{

    private static void reverse(char[] buf, int start, int end)
    {
	for (int i = start, j = end - 1; i < j; i++, j--)
	{
	    char swap = buf[i];
	    buf[i] = buf[j];
	    buf[j] = swap;
	}
    }

    public static String reverseWords(String sentence)
    {
	char[] buf = sentence.toCharArray();

	// Reverse the string, character-wise
	reverse(buf, 0, buf.length);

	// Within each word, reverse the characters again
	int wordEnd = 0;
	for (int wordStart = 0; wordStart < buf.length; wordStart = wordEnd + 1)
	{
	    for (wordEnd = wordStart; wordEnd < buf.length && buf[wordEnd] != ' '; wordEnd++)
	    {

	    }

	    // wordStart is at the start of a word.
	    // wordEnd is just past the end of the word.
	    reverse(buf, wordStart, wordEnd);
	}
	return new String(buf);
    }

    public static void main(String[] args)
    {
	System.out.println(reverseWords("i like programming  so much"));

    }

}
