import java.awt.Font; // Lame GTerm dosn't give us this or is it mentioned in the documentation... Required for SetFont

public class Assignment2WasLame {
	private GTerm gtMain;
	private GTerm gtSub;
	
	private String appName;
	private int titleSize;
	private int gtMainX;
	
	private int mainTableIndex; 
	private String mainTableColumns;
	private int subTableIndex;
	private String subTableColumns;
	
	private int[] inputIndexs;
	private String[] inputData;
	private String[] processedData;
	private int processCounter;
	private int gtMainResetCounter;
	
	
	public Assignment2WasLame() {
		this.gtMainX = 320; // gtMain Window Width
		// Loading Windows in this order as the last to load is on top
		this.gtSub = new GTerm(900,400); // Processed Data Window (SubWindow) 
		this.gtSub.setBackgroundColor(244,241,222); // Set Background Color of Sub Window
		
		this.gtMain = new GTerm(this.gtMainX,500); // Main Application Window
		this.gtMain.setBackgroundColor(244,241,222); // Set Background Color of Main Window

		
		this.titleSize = 18; // Font Size for App Title
		this.appName = new String ("Student Grade Calculator");
		
		this.mainTableColumns = "Grade\tGrade Name\tMark Range (%)";
		this.subTableColumns = "Student\tTutorial effort submissions\tAssignments\tExam\tOveral Mark\tGRADE";
		
		/*** gtMain ***/
		this.gtMain.setTitle(this.appName); // Set Application Window Title
		this.gtMain.setXY(5, 0); //center text
		this.gtMain.addImageIcon("logo.png");
		
		this.gtMain.setXY(10,this.titleSize); // Return X to 0 and adjust Y position, GTERM needs an getY/setY & getX/setX
		this.gtMain.println(""); // Blank line
		
		this.inputIndexs = new int[7]; // Create array size of 7 (keys: 0 - 6)
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Student Name:\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.gtMain.println(""); // Blank line
		this.inputIndexs[0] = this.gtMain.addTextField("Smith, Jane",150);
		//
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nTutorial effort submissions:\n");
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[1] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[2] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		
		//
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nAssignments:\n");
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[3] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[4] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12		
		
		//
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,15); // Set Font: SANS_SERIF, Set BOLD, Size 15
		this.gtMain.print("\n\nExam:\n");
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("Received\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[5] = this.gtMain.addTextField("0",50);
		
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tout of\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.inputIndexs[6] = this.gtMain.addTextField("35",50);
		this.gtMain.setFont("SANS_SERIF",Font.BOLD,12); // Set Font: SANS_SERIF, Set BOLD, Size 12
		this.gtMain.print("\tmarks.\t");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
		this.gtMain.println("\n\n"); // Empty line x2
		this.gtMain.setFontColor(0,100,0); // Green Button Text
		this.gtMain.addButton("Calculate", this, "processTable"); // Process user input
		this.gtMain.print(" "); //Add Whitespace between buttons
		this.gtMain.setFontColor(100,0,0); // Red Button Text
		this.gtMain.addButton("Reset", this, "resetGTMain"); // Reset input form
		this.gtMain.setFontColor(0,0,0); // Green Button Text
		
		this.gtMain.println("\n\n\n\n"); // Empty Line x5
		this.gtMain.setFont("SANS_SERIF",Font.BOLD | Font.ITALIC,12); // Set Font: SANS_SERIF, Set BOLD ITALIC, Size 12
		this.gtMain.println("Grading Table");
		this.gtMain.setFont("SANS_SERIF",Font.PLAIN,12); // Set Font: SANS_SERIF, Set PLAIN, Size 12
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
		this.gtSub.addButton("Delete Row", this, "deleteSubTableRow"); // Delete currently selected row
		this.gtSub.print(" "); //Add Whitespace between buttons
		this.gtSub.addButton("Empty Table", this, "emptySubTableRow"); // Empty entire table contents
		// ADAM!
		//processTable();
		//this.gtSub.getIndexOfSelectedRowFromTable(indexOfTable)
		
		/*** END gtSub ***/
	}
	
	// Add Items to table
	public void processTable() {
		Object[] inputValidation = processInputs(); // Process & Validate Input Fields, Expect a Boolean return value
		boolean valid = (Boolean) inputValidation[0];
		;
		
		if (valid) {
			// Inputs were processed and passed validation
			this.gtMain.showMessageDialog((String) inputValidation[1]);
			// Push Existing Data Array into subTable
			this.gtSub.addRowToTable(this.subTableIndex, this.processedData[0] + "\t" + this.processedData[1] + "\t" + this.processedData[2] + "\t" + this.processedData[3] + "\t" + this.processedData[4] + "\t" + this.processedData[5]);
			// Reset Main Window fields
			resetGTMain();
		} else {
			// Inputs were processed, but failed validation
			this.gtMain.showErrorDialog((String) inputValidation[1]);
		}
	}
	
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
			
			processedData = new String[7]; // Set array size to 7 (0 -6)
			processedData[0] = inputData[0]; // Student Name

			/*	Code Explanation:
			 *  1 - Creating an in line Double array
			 *  2 - Populating in line Double array with this.inputData converted from string to double 
			 *  3 - Pass this in line Double array to the "percentageCalc" method which will return a double
			 *  4 - Taking the double returned by percentageCalc and converting it back to a String
			 *  5 - Store the string in the ProcessedData array
			 */
			processedData[1] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[1]), Double.parseDouble(this.inputData[2])})); // Tutorial Effort Submissions
			processedData[2] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[3]), Double.parseDouble(this.inputData[4])})); // Assignments
			processedData[3] = Double.toString(percentageCalc(new double[] {Double.parseDouble(this.inputData[5]), Double.parseDouble(this.inputData[6])})); // Exams
			
			double tmpTotal = Double.parseDouble(this.inputData[2]) + Double.parseDouble(this.inputData[4]) + Double.parseDouble(this.inputData[6]);   
			double tmpScore = Double.parseDouble(this.inputData[1]) + Double.parseDouble(this.inputData[3]) + Double.parseDouble(this.inputData[5]);
			
			processedData[4] = Double.toString( percentageCalc( new double[] { tmpScore, tmpTotal } ) ); // Exams 
			processedData[5] = finalGrade(Double.parseDouble(processedData[4]));
		}
		return response;
	}
	
	// Reset Input Fields on gtMain 
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
	
	// Calculate percentage using array of results
	public double percentageCalc(double[] results) {
		double result;
		// results[0]; Score
		// results[1]; // Total 
		result = (results[0]/results[1]) * 100; // Calculate the Percentage from the ratio
		
		return result;
	}
	
	// Returns Matching Grade Value
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
