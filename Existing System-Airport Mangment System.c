/* Airport Database System
   Designed by: Irfan Danish(FA15-BEL-012)  */

#include<stdio.h> //It is included to handle Standard I/O operations.
#include<string.h> //It is included to deal with strings and string functions.
#include<stdlib.h> //It is included to use exit statement to terminate the program.
#include<conio.h> //It is included to use Console I/O Functions.
#include<time.h> //It is included to use the "time_t" structure and "ctime" to get the current time.
#include<dos.h> //It is included to use "sleep" to exit the program automatically.
foutput()
{
    /* Design */
	printf("\t\t*********************************************************\n\t\t|\t\t\t\t\t\t\t|\n\t\t");
	printf("|\t\t\t\t\t\t\t|\n\t\t|\t\t     AABII Softwares!   \t\t|\n\t\t|\t\t\t\t\t\t\t|\n\t\t");
	printf("|\t\t\t\t\t\t\t|\n\t\t*********************************************************\n");	
}
main() // Main fuction.
{
	time_t t;//Structure of Time vriable which stores whole date current GMT Time.
    time(&t);//Libray Function to Check Current Time.
    foutput();
	FILE *fi;//Declaring File Pointer
	
	struct fly // Structure Which Caries the Flying Shedule
    {
	    char nam[30];//Name
	    char nat[30];//Nationality
	    char fli[40];//Flight number
	    char date[12];//complete day.
	    char f_tme[10];
	    char airline[30];
	    int s_num;
	    int age;//Age
    };
    struct fly f; // Structure Variable Declaration.
    int recsize=sizeof(f); // Storing the number of bits of structre in recsize.
    
	while(1) //Outer Most While Loop,Which iterates the program continuosly until it reaches any of the exit(0)
	{
		printf("\n\n\n\n\t\t\t\t%s",ctime(&t)); // Prints the Current Time.
		/* Formated Design Output Statements to get input. */
		printf("\n\t\t\t********************************************");
		printf("\n\t\t\t|\t\t\t\t\t   |\n\t\t\t|\t1 for Data Entry.\t\t   |");
		printf("\n\t\t\t|\t2 To Check Record/Your Data.\t   |");
		printf("\n\t\t\t|\t3 to Modify Existing Data.\t   |");
		printf("\n\t\t\t|\t4 to Delete any Record\t\t   |");
		printf("\n\t\t\t|\t5 to Exit Program\t\t   |");
		int cho;// Choice Variable.
		printf("\n\t\t\t|\t\t\t\t\t   |\n\t\t\t|\tEnter Your Choice:");
		scanf("%d",&cho);// Inputs the Choice.
		sleep(0); // Sleep Function that delays the main input for desired amount.
		printf("\t\t\t|\t\t\t\t\t   |\n\t\t\t********************************************\n\n\n\n"); //Formated Design.
		printf("\n*****************************************************************************\n"); //Formated Design.
			
		switch (cho) //Start of Switch Statement (Decision Making Structure).
		{
		    case 1: // Case 1 Which refers to Input data.
		    	{
		    		char chk='y'; // Check Variable used to Iterate the internal loop.
		    		fi=fopen("project.dat","ab"); // Opens the Major file in Write at the end,Binary mode.
		    		
                    if(fi==NULL) //Check the chracter from by comparing with null.
                    {
    	                printf("File Not found!"); //Promts the message of File.
    	                exit(0); //Exit statement with argument 0.
	                } //End of if statement.
	                
		    		while(chk=='y'||chk=='Y') // While checking the Check Variable to iterate the statements or not.
                    {
		                printf("\nEnter Your Name: "); //Prompts the message about name.
		                scanf("%s",f.nam); //Takes the input and store in f.name.
		                printf("Enter Your Nationality: "); //Prompts the message about nationality.
		                scanf("%s",f.nat); //Takes the input and store in f.nat.
		                printf("Enter Your Flight Number: "); //Prompts the message about flight number.
		                scanf("%s",f.fli); //Takes the input and store in f.fli.
		                printf("Enter The Date in this format DD/MM/YYYY: "); //Prompts the message about date.
		                scanf("%s",f.date); //Takes the input and store in f.date.
		                printf("Enter the time of flight in this format HH:MM: "); //Prompts the message about flight time.
		                scanf("%s",f.f_tme); //Takes the input and store in f.f_time.
		                printf("Enter Your Airline: "); //Prompts the message about airline.
		                scanf("%s",f.airline); //Takes the input and store in f.airline.
		                printf("Enter Your Seat Number: "); //Prompts the message about seat number.
		                scanf("%d",&f.s_num); //Takes the input and store in f.s_num.
		                printf("Enter Your Age: "); //Prompts the message about age.
		                scanf("%d",&f.age); //Takes the input and store in f.age.
		                fwrite(&f,recsize,1,fi); //writes the 1 structure at a time,from the Address of 'f' structure in the major data file.
		                printf("Press Y for More N for no: "); // Prompts for further action.
		                fflush(stdin); // Clears the buffer memory and elimnates the chances of 'standard input device' overwriting input error.
		                chk=getche(); // gets the character input for further action & stores it in check variable.
	                } //End of inner while.
	                
	                fclose(fi); //close the major data file.
	                printf("\n\n*****************************************************************************\n"); // Last Formated design output.
				} //End of block of case 1.
		    break; //Break Statement of case 1.
		    
	    	case 2: //Start of Case 2 Which refers to view or check the data in the File.
	    		{
	    			printf("\n\t\t1 to review whole data\n\t\t2 to Search your data of particular person.\n\t\tEnter your Choice:"); //Prompts the information about the sort of data to be displayed.
	                int choice; // Integer type Variable for choice.
	                scanf("%d",&choice); //Taking the input and storing it in "choice" variable.
	                
	    			if(choice==1) //Start of 1st if-statement for choice and comparison is made with 1.
	    			{ //This block execute and display the whole data of the file.
	    				fi=fopen("project.dat","rb+"); // Opens the Major file in Read,Write,Binary mode.
                        if(fi==NULL) //Check the chracter from by comparing with null.
                        {
    	                    printf("File Not found!"); //Promts the message of File.
    	                     exit(0); //Exit statement with argument 0.
	                    } //End of if statement.
	                    printf("\nName\t\tNationality\t\tFlight:\t\tDate\t\tAge"); // Prints the Headings.
	                    while(fread(&f,recsize,1,fi)==1) // While Statements in which reads the content of file until 0 is returned.
	                    {
	                	
						    printf("\n%s",f.nam); //Prints the Name.
						
						    printf(" %s",f.nat); //Prints the Nationality.
						
						    printf(" %s",f.fli); //Prints the Flight Number.
						
						    printf(" %s",f.date); //Prints the Date.
						
						    printf(" %s",f.f_tme); //Prints the Flight Time.
						    
						    printf(" %s",f.airline); //Prints the airline.
						
						    printf(" %d",f.s_num); //Prints the seat number.
						
						    printf(" %d",f.age); //Prints the Age.
	                	
					    } //End of inner while or while(fread(&f,recsize,1,fi)==1).
					    fclose(fi); //close the major data file.
					} //End of 1st condition of if-else-if.
					
					else if(choice==2) //Start of 2nd if-statement for choice and comparison is made with 2.
					{ //This block execute and displays the data of particular person.
						fi=fopen("project.dat","rb"); //Opens the file in Read & Binary Mode.
						
						if(fi==NULL) //Check the chracter from by comparing with null.
                        {
    	                    printf("File Not found!"); //Promts the message of File.
    	                    exit(0); //Exit statement with argument 0.
	                    } //End of if statement.
	                    
	                	printf("\n\t\tEnter the name of person:"); //Prompts for the name of person.
	                	char p_nam[30]; //Declaration of Chracter(String) type variable to store the name.
	                	scanf("%s",p_nam); //Inputs the name and store it in p_nam.
	                	
	                	while(fread(&f,recsize,1,fi)==1) //While statement which reads the file until the all chracters are not read.
	                	{
	                		if(strcmp(p_nam,f.nam)==0) //if-statement in which string comparison is made it become true if comparison returns 0.
	                		{
	                			printf("\n\n\t\t\t**********************\n\t\t\t|   Flying Details:  |\n\t\t\t**********************"); //Formatted Output.
	                			printf("\n\n\t\tYour Flight Number is:   %s",f.fli); //Prints the flight number.
	                			printf("\n\t\tYour Flight Date is:     %s",f.date); //Prints the Date of flight.
	                			printf("\n\t\tYour Flight Time is:     %s",f.f_tme); //Prints the Time of flight.
	                			printf("\n\t\tYour Airline is:\t %s",f.airline); //Prints the Airline Name.
	                			printf("\n\t\tYour Seat Number is:     %d ",f.s_num); //Prints the Seat Number.
	                			printf("\n\t\tYour Age is:   \t\t %d ",f.age); //Prints the age.
							} //End of if statement.
							

						}
						fclose(fi);
					}
					
					else //Else part of if-statement which describes if input is other than desired one which is invalid.
					{
						printf("Wrong Choice:"); //Prompts about input.
					} //End of else and if statement at all.
					printf("\n\n*****************************************************************************\n"); // Last Formated design output.
				} //End of block of case 2.
	    	break; //Break Statement of case 2.
	    	
		    case 3: //Start of Case 3 Which refers to modify the data of File.
		    	{
		    		fi=fopen("project.dat","wb+"); // Opens the Major file in Write,Binary mode.
		    		
		    	    if(fi==NULL) //Check the chracter from by comparing with null.
		    	    {
		    		    printf("File Not Found"); //Promts the message of File.
		    		    exit(0); //Exit statement with argument 0.
				    } //End of if statement.
				    
				    char c='y'; // Check Variable used to Iterate the internal loop.
				    char emp[30]; //String type Variable to store the desired name input from user to delete a record.
				    
				    while(c=='y'||c=='Y') // While checking the Check Variable to iterate the statements or not.
				    {
				    	printf("\nEnter the Name of Employe:"); //Prompts for name.
				    	scanf("%s",emp); ////Inputs the Name of whose record has to be deleted.
				    	
				    	if(strcmp(emp,f.nam)==0) //In if statement string comparison is made between the name stored and entered.
				    	{
				    		printf("\nEnter Your Name:"); //Prompts the message about name.
		                    scanf("%s",f.nam); //Takes the input and store in f.name.
		                    printf("Enter Your Nationality:"); //Prompts the message about nationality.
		                    scanf("%s",f.nat); //Takes the input and store in f.nat.
		                    printf("Enter Your Flight Number:"); //Prompts the message about flight number.
		                    scanf("%s",f.fli); //Takes the input and store in f.fli.
		                    printf("Enter The Date in this format DD/MM/YYYY:"); //Prompts the message about date.
		                    scanf("%s",f.date); //Takes the input and store in f.date.
		                    printf("Enter Your Age:"); //Prompts the message about age.
		                    scanf("%d",&f.age); //Takes the input and store in f.age.
		                    printf("Enter the time of flight in this format HH:MM: "); //Prompts the message about flight time.
		                    scanf("%s",f.f_tme); //Takes the input and store in f.f_time.
		                    printf("Enter Your Airline: "); //Prompts the message about airline.
		                    scanf("%s",f.airline); //Takes the input and store in f.airline.
		                    printf("Enter Your Seat Number: "); //Prompts the message about seat number.
		                    scanf("%d",&f.s_num); //Takes the input and store in f.s_num.
		                    fseek(fi,-recsize,SEEK_CUR); //Changes the current position of cursor by subtracting the size of bytes of the structure. 
				    		fwrite(&f,recsize,1,fi); //writes the 1 structure at a time,from the Address of 'f' structure in the major data file.
				    		break; //breaks the if statement.
						} //End of if statement.
						
						printf("Press Y for More N for no:"); // Prompts for further action.
						fflush(stdin); // Clears the buffer memory and elimnates the chances of 'standard input device' overwriting input error.
						c=getche();	// gets the character input for further action & stores it in check variable.
					} //End of while or while(c=='y'||c=='Y').
					
					fclose(fi); //close the major data file.
					printf("\n\n*****************************************************************************\n"); // Last Formated design output.
				} //End of block of case 3.
		    break; //Break Statement of case 3.
		    
		    case 4: //Start of Case 4 Which refers to Delete Data from File.
		    	{
		    		FILE *ft; //Declaring File Pointer of Temporary File.
			    	char chek='Y';// Check Variable used to Iterate the internal loop.
					char enm[30]; //String type Variable to store the desired name input from user to delete a record.
					
			    	while(chek=='y'||chek=='Y') // While checking the Check Variable to iterate the statements or not.
			    	{
			    		printf("\nEnter the Name of employe to delete his record:"); //Prompts for the name.
			    		scanf("%s",enm); //Inputs the Name of whose record has to be deleted.
			    		ft=fopen("temp.dat","wb"); //Opens the temporay file in write & binary mode.
			    		fi=fopen("project.dat","rb"); //Opens the main data file in read & binary mode.
			    		
			    		while(fread(&f,recsize,1,fi)==1) // While Statements in which reads the content of file until 0 is returned.
			    		{
			    			if(strcmp(f.nam,enm)!=0) // if statement in which string comparison of structure name and name entered are compared and conditon checked
			    		    fwrite(&f,recsize,1,ft); //The function writes all the structures of data to temporary file except the particular structure	
						} //End of nested while or while(fread(&f,recsize,1,fi)==1).
						
						fclose(fi); //close the major data file.
						fclose(ft); // Close the temporay data file.
					    remove("project.dat"); //Removes or Deletes the major data file from memory and also from disk.
					    rename("temp.dat","project.dat"); // Renames the Temporary file and assigned it to the name of major data file.
					    fi=fopen("project.dat","rb+"); // Opens the Major(New Renamed) file in Read,Write,Binary mode.
					    printf("Do you want to delete another record:(y/n):"); // Prompts for further action.
					    fflush(stdin); // Clears the buffer memory and elimnates the chances of 'standard input device' overwriting input error.
					    chek=getche(); // gets the character input for further action & stores it in check variable.
			    	} //End of inner while or while(chek=='y'||chek=='Y').
			    	fclose(fi); //Close the File.
			    	printf("\n\n*****************************************************************************\n"); // Last Formated design output.
				} //End of case 4 block.
		    break; //Break Statement of case 4.
		    
		    case 5: //Start of case 5, which ends or exits the program.
		        printf("\n\n\t\t\t\t\t**************\n\t\t\t\t\t|   Thanks!  |\n\t\t\t\t\t|  Good Bye! |\n\t\t\t\t\t**************"); //Last Formated Output Message.
                exit(0); //Exit statement with argument 0.
		    break; //Break Statement of case 5.
		    
		} //End of Switch Statemnt.
	} //End of outer while or while(1).
	
} //End 

