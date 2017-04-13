
import java.io.*;

public class LatinSquare 
{
	// Matrix that will be used to hold the Latin square matrix data
	Matrix M;
	
	/*
	 * Read a file as a square matrix
	 */
	public LatinSquare(String filename) throws IOException
	{
		// Open the file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        
        // Read a row of text
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) 
        {
        	// Split the text by tab
            String[] parts = line.split("\t");
            
            // Create the matrix if we haven't from the number of parts
            if (M == null)
            {
            	M = new Matrix(parts.length, parts.length);
            }
            
            // Set the matrix from the line
            for (int j=0; j<parts.length; j++)
            {
            	int value = Integer.parseInt(parts[j]);
                M.setMatrixValue(i, j, value);
            }
            
            // Increment the line number
            i++;
        }
        
        reader.close();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return M.toString();
	}
	
	/*
	 * Find the value in the row. 
	 * Return the column where found or -1 otherwise
	 */
	public int findInRow(int i, int val)
	{
		
		M.getNRows();
		
		for(int j = 0; j<M.getNRows(); j++)
		{
			M.getMatrixValue(i, j);
			if(M.getMatrixValue(i, j) == val)
				return j;
		}
		return -1;
	}
	
	/*
	 * Find the value in the column
	 * Return the row where found or -1 otherwise
	 */
	public int findInColumn(int j, int val)
	{
		M.getNColumns();
		for(int i = 0; i<M.getNColumns(); i++)
		{
			M.getMatrixValue(i,  j);
			if(M.getMatrixValue(i, j) == val)
				return i;
		}
		return -1;
	}
	
	/*
	 * Check if the row is a valid for a Latin square
	 */
	public boolean isRowLatin(int row)
	{
	      for (int i=1; i<=M.getNColumns(); i++)        
	      {
	         if(findInRow(row, i) == -1) return false;
	      }
		return true;
	}
	
	/*
	 * Check if the column is valid for a Latin square
	 */
	public boolean isColumnLatin(int col)
	{
		for(int j=1; j<=M.getNRows(); j++)
		{
			if(findInColumn(col, j) == -1) return false;
		}
		return true;
	}
	public int getNColums()
	{
		return M.getNColumns();
	}
	public int getNRows()
	{
		return M.getNRows();
	}
	
	/*
	 * Check if the matrix is a Latin square
	 */
	public boolean isLatin()
	{
		int[] Size = M.getSize();
		for (int i = 0; i<Size[0]; i++)
		{
			if (isColumnLatin(i) != true) return false;
		}
		for (int j = 0; j<Size[0]; j++)
		{
			if (isRowLatin(j) != true) return false;
		}
		return true;
	}
}
