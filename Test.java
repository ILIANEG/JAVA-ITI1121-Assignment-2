class Test
{
	public static void main(String[] args)
	{
	//	char[] arr = new char[]{'1','2','3','4','5','6','7','8','9','X','A','B'};
		char[] arr = new char[]{'1','2','3','4','5','6','7','8','9'};
		int gamelines = 3, gamecolumns = 4;
		String reverseColumns = "", reverseRows = "";

		System.out.println("boardOfGame:");
		for (int i = 0; i < gamelines * gamecolumns; i++)
		{
			if ((i+1) % gamecolumns == 0) System.out.println(arr[i]);
			else System.out.print(arr[i]);
		}

		System.out.println("\nreverseRows:");
		for (int a = gamelines - 1; a > -1; a--) for (int b = 0; b < gamecolumns; b++)
		{
			reverseRows += arr[gamelines*a+b];
		}

		for (int i = 0; i < gamelines * gamecolumns; i++)
		{
			if ((i+1) % gamecolumns == 0) System.out.println(reverseRows.charAt(i));
			else System.out.print(reverseRows.charAt(i));
		}

		System.out.println("\nreverseColumns:");
		for (int c = 0; c < gamecolumns; c++) for (int d = gamelines - 1; d > -1; d--)
		{
			reverseColumns += arr[gamelines*c+d];
		}

		for (int i = 0; i < gamelines * gamecolumns; i++)
		{
			if ((i+1) % gamecolumns == 0) System.out.println(reverseColumns.charAt(i));
			else System.out.print(reverseColumns.charAt(i));
		}
	}
}
