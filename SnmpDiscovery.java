package com.example.nms.discovery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.util.SubnetUtils;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Component;

import com.example.nms.inventory.entity.Device;

@Component
public class SnmpDiscovery {

    public List<Device> getAllConnectedDevicesToMyNetwork() {
        return null;
    }

    public static void pingDevice(String ipAddress) {
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            if (inet.isReachable(3000)) {
                System.out.println("Device is reachable: " + ipAddress);
            } else {
                System.out.println("Device is not reachable: " + ipAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getConnectedDevices() {
        List<String> devices = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec("arp -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String ipAddress = extractIpAddress(line);
                System.out.println("ipAddress '" + ipAddress + "' Added to Devices list");
                if (ipAddress != null) {
                    devices.add(ipAddress);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }

    private String extractIpAddress(String line) {
        String regex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public void discoverDevice(String ipAddress) {
        try {
            Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
            snmp.listen();
            CommunityTarget<UdpAddress> target = new CommunityTarget<>();
            target.setCommunity(new OctetString("public"));
            target.setAddress(new UdpAddress(ipAddress + "/161"));
            target.setRetries(2);
            target.setTimeout(1500);
            target.setVersion(SnmpConstants.version2c);
            PDU pdu = new PDU();
            pdu.setType(PDU.GETNEXT);
            // Add OID of interest here
            // pdu.add(new VariableBinding(new OID("1.3.6.1.2.1.1.1.0")));
            // Send request and process response
            // ..
            System.out.println("Target: Object for " + ipAddress + " :: " + target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
