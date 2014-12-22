
public class Leader
{
    /**
     * leader of array is element who repeated more than n/2 time where n is
     * length of array. it return -1 iff no leader found
     * 
     * @param arr
     * @return
     */
    public static int getLeader(int[] arr)
    {
	int count = 0;
	int pos = (arr.length + 1) / 2;
	int candidate = arr[pos];
	for (int i = 0; i < arr.length; i++)
	{
	    if (candidate == arr[i])
		count++;
	}

	if (count > pos)
	    return candidate;

	return -1;

    }

    public static void main(String[] args)
    {
	int[] test = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 4 };
	System.out.println(getLeader(test));

    }

}
