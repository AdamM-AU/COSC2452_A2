import java.awt.Font; // Lame GTerm dosn't give us this or is it mentioned in the documentation... Required for SetFont

public class Assignment2WasLame {
	private GTerm gtMain;
	private GTerm gtSub;
	private String appFont;
	
	private String appName;
	private int titleSize;
	private int gtMainX;
	
	private int mainTableIndex; 
	private String mainTableColumns;
	private int subTableIndex;
	private String subTableColumns;
	
	private int[] inputIndexs; // Array of Index's for input fields
	private String[] inputData; // Array of Data from Index Fields
	private String[] processedData; // Processed and Validated Data From InputData
	private String[][] dataStorage;  // Storage all all data, Multidimensional array
	private int processCounter;
	private int gtMainResetCounter;
	private int counter; // Counter used for dataStorage array rebuilds, table refreshes
	
	
	public Assignment2WasLame() {
		this.dataStorage = new String[0][]; // Initialize dataStorage Array
		this.appFont = "SANS_SERIF"; // Set Default Font
		this.gtMainX = 320; // gtMain Window Width
		
		// Build Our GTerm Windows
		this.gtMain = new GTerm(this.gtMainX,500); // Main Application Window
		this.gtMain.setBackgroundColor(244,241,222); // Set Background Color of Main Window
		
		this.gtSub = new GTerm(900,400); // Processed Data Window (SubWindow) 
		this.gtSub.setBackgroundColor(244,241,222); // Set Background Color of Sub Window
		
		this.titleSize = 18; // Font Size for App Title
		this.appName = new String ("Student Grade Calculator");
		
		this.mainTableColumns = "Grade\tGrade Name\tMark Range (%)";
		this.subTableColumns = "Student\tTutorial effort submissions\tAssignments\tExam\tOveral Mark\tGRADE";
		
		
		/*** gtMain ***/
		this.gtMain.setTitle(this.appName); // Set Application Window Title
		this.gtMain.setXY(5, 0); //center text
		this.gtMain.addImageIcon("logo.png");
		
		/* Building our UI
		 * This Code looks like garbage
		 * Alternative: If the assessment allowed I would shove this into another class under a rug
  		 */
		this.gtMain.setXY(10,this.titleSize); // Return X to 0 and adjust Y position, GTERM needs an getY/setY & getX/setX
		this.gtMain.println(""); // Blank line
		
		this.inputIndexs = new int[7]; // Create array size of 7 (keys: 0 - 6)
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Student Name:\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.gtMain.println(""); // Blank line
		this.inputIndexs[0] = this.gtMain.addTextField("Smith, Jane",150);
		//
		this.gtMain.setFont(this.appFont,Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nTutorial effort submissions:\n");
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[1] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[2] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		
		//
		this.gtMain.setFont(this.appFont,Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nAssignments:\n");
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[3] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[4] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12		
		
		//
		this.gtMain.setFont(this.appFont,Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nExam:\n");
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[5] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[6] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont(this.appFont,Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.gtMain.println("\n\n"); // Empty line x2
		this.gtMain.setFontColor(0,100,0); // Green Button Text
		
		this.gtMain.addButton("Calculate", this, "addData"); // Process user input
		this.gtMain.print(" "); //Add Whitespace between buttons
		this.gtMain.setFontColor(100,0,0); // Red Button Text
		this.gtMain.addButton("Reset", this, "resetGTMain"); // Reset input form
		this.gtMain.setFontColor(0,0,0); // Green Button Text
		
		this.gtMain.println("\n\n\n\n"); // Empty Line x5
		this.gtMain.setFont(this.appFont,Font.BOLD | Font.ITALIC,12); // Set Font: SANS_SERIF, Set BOLD ITALIC, Size 12
		this.gtMain.println("Grading Table");
		this.gtMain.setFont(this.appFont,Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.mainTableIndex = this.gtMain.addTable(290, 120, this.mainTableColumns); // Create Table and Column Names
		this.gtMain.addRowToTable(this.mainTableIndex,"HD\tHigh Distinction\t80 - 100"); 
		this.gtMain.addRowToTable(this.mainTableIndex,"DI\tDistinction\t70 - 79");
		this.gtMain.addRowToTable(this.mainTableIndex,"CR\tCredit\t60 - 69");
		this.gtMain.addRowToTable(this.mainTableIndex,"PA\tPass\t50 - 59");
		this.gtMain.addRowToTable(this.mainTableIndex,"NN\tFail\t0 - 49");
		/*** END gtMain ***/
		
		/*** gtSub **/
		this.gtSub.setTitle(this.appName + " - Results"); // Set Application Window Title
		this.subTableIndex = this.gtSub.addTable(894, 295, this.subTableColumns); // Create Table and Column Names
		this.gtSub.println(""); // Empty Row
		this.gtSub.println(""); // Empty Row
		this.gtSub.addButton("Modify Row", this, "modifySubTableRow"); // Modify currently selected row
		this.gtSub.print(" "); //Add Whitespace between buttons
		this.gtSub.addButton("Delete Row", this, "deleteButtonAction"); // Delete currently selected row
		this.gtSub.print(" "); //Add Whitespace between buttons
		this.gtSub.addButton("Empty Table", this, "emptySubTable"); // Empty entire table contents
		/*** END gtSub ***/
	}
	
	/*
	 * Add Data - Button Action
	 * Simple Button Action to call multiple methods in order to accomplish the task
	 * of adding, validating and processing user supplied information
	 * Alternative: N/A
	 */
	public void addData() {
		Object[] inputValidation = this.processInputs(); // Process inputs from gtMain and validate
		boolean valid = (Boolean) inputValidation[0];
		
		if (valid) {
			// Inputs were processed and passed validation
			this.processData(); // Process the validated data
			this.refreshSubTable(); // Refresh the gtSub Table
			this.resetGTMain(); // Reset Main Window fields
			this.gtMain.showMessageDialog((String) inputValidation[1]); // Show Validation Message
		} else {
			// Inputs were processed, but failed validation
			this.gtMain.showErrorDialog((String) inputValidation[1]); // Show Validation Message
		}
	}

	/*
	 * Process Inputs
	 * Processing inputData array and validating it against validation criteria
	 * on failure we add to the object element 0 - boolean value false and element 1 a targeted error message
	 * on pass we add to the object element 0 - boolean value true and element 1 as success message
	 * We are using an Object array so we can have mixed data types
	 * 
	 * Alternative: We could use try and catch rather then a large if, else if, else statement
	 */
	// Process Data from inputData array and Validate
	public Object[] processInputs() {
		Object[] response = new Object[2]; // Create a Object Array with then size of two  
		
		this.processCounter = 0; // Start counter at 0
		this.inputData = new String[this.inputIndexs.length]; // Set Array Size to length of inputIndex array
		
		while (processCounter < this.inputIndexs.length) {
			// Fetch Data from Input Fields 
			inputData[this.processCounter] = this.gtMain.getTextFromEntry(this.inputIndexs[this.processCounter]).toString();

			processCounter++; // Increment Counter
		}
		// Validate Input Fields
		// Validate Name
		// Changed if else layout for easier reading
		if (inputData[0].isEmpty()) {
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Student Name\" is empty!"; // Error Message
		} 

		// Validate - Tutorial Effort Submissions
		else if (!this.inputData[1].matches("^[0-9]+$") && !this.inputData[1].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Tutorial effort submissions\" Received marks is not a numeric value!"; // Error Message
		}
		else if (!this.inputData[2].matches("^[0-9]+$") && !this.inputData[2].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Tutorial effort submissions\" Received marks is not a numeric value!"; // Error Message
		}
		else if (Double.parseDouble(inputData[1]) > Double.parseDouble(inputData[2])) {
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Tutorial effort submissions\" Received marks is higher than total marks!"; // Error Message		
		} 

		// Validate - Assignments
		else if (!this.inputData[3].matches("^[0-9]+$") && !this.inputData[3].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Assignments\" Received marks is not a numeric value!"; // Error Message
		}
		else if (!this.inputData[4].matches("^[0-9]+$") && !this.inputData[4].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Assignments\" Received marks is not a numeric value!"; // Error Message
		}
		else if (Double.parseDouble(inputData[3]) > Double.parseDouble(inputData[4])) {
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Assignments\" Received marks is higher than total marks!"; // Error Message		
		} 

		// Validate - Exam
		else if (!this.inputData[5].matches("^[0-9]+$") && !this.inputData[5].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Exam\" Received marks is not a numeric value!"; // Error Message
		}
		else if (!this.inputData[6].matches("^[0-9]+$") && !this.inputData[6].matches("^\\d+\\.\\d+")) { // Check if input string is decimal or integer (REGEX)
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Exam\" Received marks is not a numeric value!"; // Error Message
		}
		else if (Double.parseDouble(inputData[5]) > Double.parseDouble(inputData[6])) {
			response[0] = false; // Pass(true) or Fail(false) Validation 
			response[1] = "Input Validation Failed!\nError: \"Exam\" Received marks is higher than total marks!"; // Error Message		
		} 		
		else { 
			response[0] = true; // Pass(true) or Fail(false) Validation 
			response[1] = inputData[0] + ": Successfully Added!"; // User Message
			
			this.processedData = new String[12]; // Set array size to 7 (0 - 11)
			this.processedData[0] = inputData[0]; // Student Name
			/* processData - Contents explained
			 * [0] - Student Name
			 * [1] - Tutorial Efforts Submission - Score
			 * [2] - Tutorial Efforts Submission - Total
			 * [3] - Tutorial Efforts Submission - Percentage Calculated
			 * [4] - Assignments - Score
			 * [5] - Assignments - Total
			 * [6] - Assignments - Percentage Calculated
			 * [7] - Exams - Score
			 * [8] - Exams - Total
			 * [9] - Exams - Percentage Calculated
			 * [10] - Overall Total - Percentage Calculated
			 * [11] - Overall Mark - Matched Data
			 */
			
			
			/*	Code Explanation:
			 *  1 - Creating an in line Double array
			 *  2 - Populating in line Double array with this.inputData converted from string to double 
			 *  3 - Pass this in line Double array to the "percentageCalc" method which will return a double
			 *  4 - Taking the double returned by percentageCalc and converting it back to a String
			 *  5 - Store the string in the ProcessedData array
			 */
			this.processedData[1] = this.inputData[1]; // Tutorial Efforts Submission - Score
			this.processedData[2] = this.inputData[2]; // Tutorial Efforts Submission - Total
			this.processedData[3] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[1]), Double.parseDouble(this.inputData[2])})); // Tutorial Efforts Submission - Percentage
			
			this.processedData[4] = this.inputData[3]; // Assignments - Score
			this.processedData[5] = this.inputData[4]; // Assignments - Total
			this.processedData[6] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[3]), Double.parseDouble(this.inputData[4])})); // Assignments - Percentage

			this.processedData[7] = this.inputData[5]; // Assignments - Score
			this.processedData[8] = this.inputData[6]; // Assignments - Total			
			this.processedData[9] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[5]), Double.parseDouble(this.inputData[6])})); // Exams - Percentage
			
			double tmpTotal = Double.parseDouble(this.inputData[2]) + Double.parseDouble(this.inputData[4]) + Double.parseDouble(this.inputData[6]); // Temp Overall Total   
			double tmpScore = Double.parseDouble(this.inputData[1]) + Double.parseDouble(this.inputData[3]) + Double.parseDouble(this.inputData[5]); // Temp Overall Score
			
			this.processedData[10] = Double.toString( percentageCalc( new double[] { tmpScore, tmpTotal } ) ); // Total - Percentage
			this.processedData[11] = finalGrade(Double.parseDouble(processedData[10])); // 
		}
		return response;
	}
	
	/*
	 * Process Data
	 * This method process inputData[] into dataStorage multidimensional array
	 * Alternative: Lose Marks for using an ArrayList
	 */
	public void processData() {
		/* Rebuild dataStorage */
		int arraySize = this.dataStorage.length + 1; // New Array Size
		
		// Temp Arrays
		String[][] tempDataStorage = new String[arraySize][];
		
		this.counter = 0;
		while (this.counter < this.dataStorage.length) {
			tempDataStorage[this.counter] = this.dataStorage[this.counter];
			this.counter++;
		}
		// Add New Data to the array
		tempDataStorage[this.counter] = processedData;
		// Overwrite dataStorage with contents of tempDataStorage
		this.dataStorage = tempDataStorage;
	}

	/*
	 * Refresh Sub Table
	 * this method empties the gtSub Window Table and populates it with data from
	 * the multidimensional array
	 * Alternative: MutliThread Application and have a refreshTable thread on a clock counter
	 * so we no longer need to call for a refresh, great for multiuser app
	 * 
	 */
	public void refreshSubTable() {
		/* processData - Contents explained
		 * [0] - Student Name
		 * [1] - Tutorial Efforts Submission - Score
		 * [2] - Tutorial Efforts Submission - Total
		 * [3] - Tutorial Efforts Submission - Percentage Calculated
		 * [4] - Assignments - Score
		 * [5] - Assignments - Total
		 * [6] - Assignments - Percentage Calculated
		 * [7] - Exams - Score
		 * [8] - Exams - Total
		 * [9] - Exams - Percentage Calculated
		 * [10] - Overall Total - Percentage Calculated
		 * [11] - Overall Mark - Matched Data
		 */
		this.gtSub.clearRowsOfTable(this.subTableIndex);
		
		this.counter = 0; 
		while (this.dataStorage.length > this.counter) {
			this.gtSub.addRowToTable(this.subTableIndex, 
									 this.dataStorage[this.counter][0] + "\t" + 
									 this.dataStorage[this.counter][3] + "\t" + 
									 this.dataStorage[this.counter][6] + "\t" + 
									 this.dataStorage[this.counter][9] + "\t" + 
									 this.dataStorage[this.counter][10] + "\t" + 
									 this.dataStorage[this.counter][11]);
			this.counter++;
		}
	}

	/*
	 * Reset GT Main
	 * Reset Input Fields on gtMain
	 */
	public void resetGTMain() {
		this.gtMainResetCounter = 0;
		while (this.gtMainResetCounter < this.inputIndexs.length) {
			if (this.gtMainResetCounter == 0) {
				this.gtMain.setTextInEntry(this.inputIndexs[this.gtMainResetCounter], ""); // Reset Name Filed to Empty
			} else {
				this.gtMain.setTextInEntry(this.inputIndexs[this.gtMainResetCounter], "0"); // Reset Mark Fields to 0
			} 
			this.gtMainResetCounter++;
		}
	
	}
	/*
	 *  Delete Sub Table Row - Button Action
	 */
	 public void deleteButtonAction() {
	 	int selectedRow = this.gtSub.getIndexOfSelectedRowFromTable(this.subTableIndex); // Get index of the selected row
	 	this.deleteSubTableRow(selectedRow);
	 }
	
	/*
	 *  Delete Sub Table Row - Method
	 *  Note: Separated from deleteButtonAction so we can recycle this code
	 *
	 *  Here we are deleting the row from the first level of the multidimensional dataStoage array
	 *  Alternatively: if we were using an ArrayList we could simply remove an entry with arraylist.remove()
	 */
	public void deleteSubTableRow(int selectedRow) {
		int newArraySize = this.dataStorage.length - 1; // New Array Size
		
		// Temp Arrays
		String[][] tempDataStorage = new String[newArraySize][];
		
		this.counter = 0;  // Loop Counter
		int newIndex = 0; // New Array Index Key 
		while (this.dataStorage.length > this.counter) {
			if (counter != selectedRow) {
				tempDataStorage[newIndex] = this.dataStorage[this.counter]; // Copy Data using new index
				newIndex++;
			}
			this.counter++; // Increment Loop Counter
	
		}
		// Overwrite dataStorage with contents of tempDataStorage
		this.dataStorage = tempDataStorage; // Copy tempArrayStorage over dataStorage
		this.refreshSubTable(); // Refresh the table :)
	}
	
	/*
	 * Modify gtSub Table Row
	 * Simple Method to copy data from dataStorage array into the inputFields on gtMain
	 * then we delete the data from the dataStorage Array and rebuild table
	 * Alternative: Would love to hear some suggestions on this
	 */
	
	public void modifySubTableRow() {
		int selectedRow = this.gtSub.getIndexOfSelectedRowFromTable(this.subTableIndex); // Get index of the selected row
		
		this.resetGTMain(); // Reset gtMain, for a clean slate
		
		// Unpack data into gtMain input fields
		this.gtMain.setTextInEntry(0, this.dataStorage[selectedRow][0]); // Student Name
		this.gtMain.setTextInEntry(1, this.dataStorage[selectedRow][1]); // Tutorial Efforts Submission - Score
		this.gtMain.setTextInEntry(2, this.dataStorage[selectedRow][2]); // Tutorial Efforts Submission - Total
		this.gtMain.setTextInEntry(3, this.dataStorage[selectedRow][4]); // Assignments - Score
		this.gtMain.setTextInEntry(4, this.dataStorage[selectedRow][5]); // Assignments - Total
		this.gtMain.setTextInEntry(5, this.dataStorage[selectedRow][7]); // Exam - Score
		this.gtMain.setTextInEntry(6, this.dataStorage[selectedRow][8]); // Exam - Total
		
		// Delete Select Row From dataStorage & Refresh Table i none hit
		this.deleteSubTableRow(selectedRow);
	}
	
	/*
	 * Empty Sub Table - Button Action
	 * Simple Button Action to clear table and empty the multidimensional dataStorage Array
	 * Alternative: not use GTerm
	 */
	public void emptySubTable() {
		this.gtSub.clearRowsOfTable(subTableIndex); // Get Current Row Index
		
		// Empty Arrays
		this.dataStorage = new String[0][]; // Empty data Storage
	}
	
	
	/*
	 * Percentage Calculator
	 * Simple Math method to take two doubles in an array
	 * and calculate the percentage
	 * Alternative: None
	 */
	public double percentageCalc(double[] results) {
		double result;
		// results[0]; Score
		// results[1]; // Total 
		result = (results[0]/results[1]) * 100; // Calculate the Percentage from the ratio
		
		return result;
	}

	/*
	 * Final Grade
	 * Takes double input and returns the matching grade
	 * Alternative: None
	 */
	public String finalGrade(double total) {
		/*
		 * HD (High Distinction) = 80 - 100%
		 * DI (Distinction) = 70 - 79%
		 * CR (Credit) = 60 - 69%
		 * PA (Pass) = 50 - 59%
		 * NN (Fail) = 0 - 49%
		 */
		String result;
		if (total >= 80) {
			result = "HD";
		} else if ((total >= 70) && (total < 80)) {
			result = "DI";
		} else if ((total >= 60) && (total < 70)) {
			result = "CR";
		} else if ((total >= 50) && (total < 60)) {
			return "PA";
		} else {
			result = "NN";
		}
		return result;
	}
	
	// Main
	public static void main(String[] args) {
		Assignment2WasLame a2obj = new Assignment2WasLame();
	}
}
