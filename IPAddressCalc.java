package calculator_beta;
import java.util.*;

public class IPAddressCalc {

	public static String binaryToOctal(String binary) {
        // Padding the binary string with leading zeros if necessary
        int length = binary.length();
        if (length % 3 != 0) {
            int padding = 3 - (length % 3);
            binary = "0".repeat(padding) + binary;
        }
        
        StringBuilder octal = new StringBuilder();
        
        // Converting binary to octal in groups of 3 digits
        for (int i = 0; i < binary.length(); i += 3) {
            String group = binary.substring(i, i + 3);
            int decimal = Integer.parseInt(group, 2);
            octal.append(Integer.toOctalString(decimal));
        }
        
        return octal.toString();
    }

	public static String octalToBinary(String octal) {
        StringBuilder binary = new StringBuilder();
        
        // Converting octal to binary digit by digit
        for (int i = 0; i < octal.length(); i++) {
            char digit = octal.charAt(i);
            int decimal = Character.getNumericValue(digit);
            String binaryDigit = Integer.toBinaryString(decimal);
            
            // Padding the binary digit with leading zeros if necessary
            if (i != 0) {
                binaryDigit = "0".repeat(3 - binaryDigit.length()) + binaryDigit;
            }
            
            binary.append(binaryDigit);
        }
        
        return binary.toString();
    }

	public static String getBinaryIpAddress(String ipAddress) {
		String[] ipoctets = ipAddress.split(".");
		String binaryIpAddress = "";
		for(String octet: ipoctets) {
			binaryIpAddress = octalToBinary(octet);
            binaryIpAddress += ".";
		}
        return binaryIpAddress;
	}

    public static String getOctalIpAddress(String binaryIpAddress){
        String[] ipBinaries = binaryIpAddress.split(".");
        String octalIpAddress = "";
        for(String binary: ipBinaries){
            octalIpAddress = binaryToOctal(binary);
            octalIpAddress += ".";
        }
        return octalIpAddress;
    }

    public static String getSubnetMask(int slashValue) {
        if (slashValue < 0 || slashValue > 32) {
            throw new IllegalArgumentException("Invalid slash value. Must be between 0 and 32.");
        }
        
        int[] maskParts = new int[4];
        int fullBytes = slashValue / 8;
        int remainingBits = slashValue % 8;
        
        // Set full bytes to 255 (binary 11111111)
        for (int i = 0; i < fullBytes; i++) {
            maskParts[i] = 255;
        }
        
        // Set the remaining bits
        if (remainingBits > 0) {
            int remainingByte = (1 << remainingBits) - 1;
            remainingByte <<= (8 - remainingBits);
            maskParts[fullBytes] = remainingByte;
        }
        
        // Build the subnet mask string
        StringBuilder subnetMask = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            subnetMask.append(maskParts[i]);
            if (i < 3) {
                subnetMask.append(".");
            }
        }
        
        return subnetMask.toString();
    }

    //This method converts a String with numerics into a integer array 
    public static int[] stringToIntArray(String input) {
        String[] stringArray = input.split("."); // Split the string by whitespace
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }
    
    //This method concatenates two integer arrays
    public static int[] concat(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
    //This method takes in a Integet array input and returns a String
    //with dots between the number values
    //written specifically for this program, don't copy and paste elsewhere
    public static String intArrToString(int[] input){
        String[] withoutDots = new String[5];
        String withDots = "";
        int i = 0;
        for(int inputNum: input){
            withoutDots[i] = Integer.toString(inputNum);
            i++; 
        }
        for(i=0;i<withoutDots.length;i++){
            withDots += withoutDots[i];
            withDots += ".";
        }
        return withDots;
    }
    //This method should take in the IP Address, Number of Subnets, and the Class and
    //return the network IP of the subnetted IP address
    //first the ip address array is divided with the number of subnets
    public static String getNetworkIP(String ipAddress, int numSubnets, String ipClass){
        String networkIP = new String();
        String[] tempArray = ipAddress.split(".");
        int[] ipOctets = new int[5];
        for(int i=0;i<tempArray.length;i++)
        ipOctets[i] = Integer.parseInt(tempArray[i]);
        int[] subnetParts = ipOctets;
        if(ipClass == "B"){
            subnetParts[3] = 255 / numSubnets;
            subnetParts[4] = 0;
        }
        else if (ipClass == "C"){
            subnetParts[4] = 255 / numSubnets;
        }
        else
        {
            subnetParts[2] = 255/ numSubnets;
            subnetParts[3] = 0;
            subnetParts[4] = 0;
        }
        networkIP = intArrToString(subnetParts);
        return networkIP;
    }
    
    public static void main(String[] args) {

        // Get input values from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP class (A, B, or C): ");
        String ipClass = scanner.nextLine().toUpperCase();
        System.out.print("Enter slash value (e.g. 24): ");
        int slashValue = scanner.nextInt();
        System.out.print("Enter IP address (e.g. 192.168.1.1): ");
        String ipAddress = scanner.next();
        scanner.close();

        // Calculate subnet information
        int numSubnets = (int) Math.pow(2, 32 - slashValue);
        int numHosts = (int) Math.pow(2, 32 - slashValue) - 2;
        String subnetMask = getSubnetMask(slashValue);
        String binaryIpAddress = getBinaryIpAddress(ipAddress);
        String networkIP = getNetworkIP(ipAddress, numSubnets, ipClass);
        // Display subnet information
        System.out.println("Subnet information for IP address " + ipAddress + ":");
        System.out.println("IP Address in Binary: " + binaryIpAddress);
        System.out.println("Subnet mask: " + subnetMask);
        System.out.println("Number of subnets: " + numSubnets);
        System.out.println("Number of hosts per subnet: " + numHosts);
        System.out.println("The network IP is: " + networkIP);
    }


}