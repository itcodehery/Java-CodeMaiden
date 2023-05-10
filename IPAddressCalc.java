import java.net.Inet4Address;
import java.util.Scanner;

public class IPAddressCalc {

	public static String getSubnetMask(int slashValue) {
		double numSubnets = Math.pow(2, 32 - slashValue);
		
	}
	
	public static String getBinaryIpAddress(String ipAddress) {
		String[] ipoctets = ipAddress.split(".");
		String binaryIpAddress = "";
		for(String octet: ipoctets) {
			binaryIpAddress = octet.to
		}
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
        String binaryNetworkAddress = getBinaryNetworkAddress(binaryIpAddress, subnetMask);
        String decimalNetworkAddress = getDecimalIpAddress(binaryNetworkAddress);
        String decimalBroadcastAddress = getDecimalBroadcastAddress(binaryNetworkAddress, subnetMask);

        // Display subnet information
        System.out.println("Subnet information for IP address " + ipAddress + ":");
        System.out.println("Subnet mask: " + subnetMask);
        System.out.println("Number of subnets: " + numSubnets);
        System.out.println("Number of hosts per subnet: " + numHosts);
        System.out.println("Network address: " + decimalNetworkAddress);
        System.out.println("Broadcast address: " + decimalBroadcastAddress);
 

    }


}