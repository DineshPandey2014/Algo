package Arrays;

import java.util.*;

class PatientManager {

  public static void main(String[] args) {
    System.out.println("Test Pgm");
     //ignore args, get input from readPatientInfoData.
     List<String> patientInfoList = readPatientInfoData();
     Map<Integer, PatientInfoDto> map = new HashMap();
     PatientInfoDto info = null;
     for (String str : patientInfoList) {
       String patientInfo [] = str.split(",");
       info = new PatientInfoDto();
       info.setPatientName(patientInfo[0]);
       info.setDeviceName(patientInfo[2]);
       String [] deviceNumbers = patientInfo[3].split(";");

       System.out.println("deviceNumbers" + deviceNumbers);

       for(String deviceNum : deviceNumbers) {
         info.getDeviceSerialNumbers().add(Long.parseLong(deviceNum));
       }

       populateMapWithPatientInfo(map,deviceNumbers, info);


     }
     System.out.println(info);

  }

  private static void populateMapWithPatientInfo(Map<Integer, PatientInfoDto> map, String [] deviceNumbers,
                                                 PatientInfoDto info) {
    for (String deviceNumber : deviceNumbers) {
      System.out.println("deviceNumber " + deviceNumber);
        if(map.containsKey(deviceNumber) && map.get(deviceNumber).isActive()) {
          info.setActive(false);
          map.get(Integer.parseInt(deviceNumber)).setActive(false);
        } else {
          map.put(Integer.parseInt(deviceNumber), info);
        }
    }
  }

  private static List<String> readPatientInfoData() {
    final List<String> data = new ArrayList<>();
    data.add("Melissa Jones,1010,Version Four,800279;127936;624265");
    //data.add("Brian Shaw,1040,High Output,969951;624912;284194;994309;376148;681565");
    data.add("Walter Smith,1000,Version Four,800279");
    //data.add("Rajish Kampur,1030,Low Profile,259505;732146");
    //data.add("Jessie Chan,1020,High Output,686450;403070;709338;897738;247837");
   // data.add("Heather Chance,Version Five,253350;395038;414444;761589");
    return data;
  }
}

class PatientInfoDto {

  private String patientName;
  private int patientId;
  private String deviceName;
  private List<Long> deviceSerialNumbers = new ArrayList<>();
  private boolean active = true;

  @Override
  public String toString() {
    return "PatientInfoDto{" + "patientName=" + patientName
            + ", patientId=" + patientId
            + ", deviceName=" + deviceName
            + ", deviceSerialNumbers=" + deviceSerialNumbers
            + ", active=" + active + '}';
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(final String patientName) {
    this.patientName = patientName;
  }

  public int getPatientId() {
    return patientId;
  }

  public void setPatientId(final int patientId) {
    this.patientId = patientId;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String setDeviceName(final String deviceName) {
    return this.deviceName = deviceName;
  }

  public List<Long> getDeviceSerialNumbers() {
    return deviceSerialNumbers;
  }

  public void setDeviceSerialNumbers(final List<Long> deviceSerialNumbers) {
    this.deviceSerialNumbers = deviceSerialNumbers;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(final boolean active) {
    this.active = active;
  }
}
