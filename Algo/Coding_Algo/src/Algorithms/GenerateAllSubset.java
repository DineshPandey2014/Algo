public class GenerateAllSubset {

public static void main(String args[]) {

	String input = "abc";
	String output = "";
	
	List<String> output = new ArrayList();
	
	generateAllSubsetOfString(input, 0, output, n) 
}


	
void generateAllSubsetOfString(String input, String inputIndex, List<String> outputList) {
  
     if(input.length == 0) {
        System.out.println(output);
     	outputList.add(output);
     }

     generateAllSubsetOfString(input.subString(1), output);
     generateAllSubsetOfString(input.subString(1), output+input[0])
     
  
  }

}


  


