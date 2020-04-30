// Michael Li - 4/30/2020
// https://github.com/mountainowl/snapcheck-internship-2020/tree/master/backend

public class Encryption {
	// Main function to run the code
	public static void main(String [] args) {
		// Outputs "Cannot encrypt an empty string."
		System.out.println(encrypt(""));
		
		// Outputs "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"
		System.out.println(encrypt("if man was meant to stay on the ground god would have given us roots"));
		
		// Outputs "hae and via ecy"
		System.out.println(encrypt("haveaniceday"));
		
		// Outputs "fto ehg ee dd"
		System.out.println(encrypt("feedthedog"));
		
		// Outputs "clu hlt io"
		System.out.println(encrypt("chillout"));
	}
	
	// Given a string, returns the encrypted version of the string
	public static String encrypt(String stringToEncrypt) {
		// Removes all spaces from the input string
		stringToEncrypt = stringToEncrypt.replaceAll(" ", "");

		int length = stringToEncrypt.length();
		// A check for an empty string input
		if(length == 0) {
			return "Cannot encrypt an empty string.";
		}
		
		// Finds rows and columns needed for matrix
		int rows = (int)Math.floor(Math.sqrt(length));
		int columns = (int)Math.ceil(Math.sqrt(length));
		if((rows * columns) < length) {
			rows = columns;
		}

		// Inserts the index of each char into the matrix
		Integer[][] matrix = new Integer[rows][columns];
		int index = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(index < length) {
					matrix[i][j] = index;
					index++;
				}
			}
		}

		// Runs through the matrix in a vertical fashion
		// Find the character at each index and append it to the StringBuilder 
		StringBuilder outputString = new StringBuilder();
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(matrix[j][i] != null) {
					outputString.append(stringToEncrypt.charAt(matrix[j][i]));
				}
			}
			outputString.append(" ");
		}
		
		// Returns the encrypted string
		return outputString.toString().trim();
	}
}


