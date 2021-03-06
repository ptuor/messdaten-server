package services;

import model.Device;

import java.util.List;

/**
 * Die Klasse DeviceValidator prüft die Elemente der List<Device> auf Gültigkeit.
 *
 * Created by Nett on 27.05.2017.
 */
public class DeviceValidator {

    public static boolean validateDevice(List<Device> devices, Device newDevice) {

        if (!hasRequieredMembers(newDevice)) {
            return false;
        }
        if (!isIdUnique(devices, newDevice)) {
            return false;
        }
        return true;
    }

    /**
     * Prueft ob alle Bedingungen fuer ein Update des Devices in der Konfiguration erfuellt sind
     *
     * @param devices
     * @param newDevice
     * @return
     */
    public static boolean isValidForUpdate(List<Device> devices, Device newDevice) {

        if (!hasRequieredMembers(newDevice)) {
            return false;
        }
        if (isIdUnique(devices, newDevice)) {
            return false;
        }
        return true;
    }

    /**
     * Prueft ob der neue Device alle Plicht-Eigenschaften beinhaltet
     *
     * @param newDevice
     * @return
     */
    private static boolean hasRequieredMembers(Device newDevice){
        if(newDevice.getName().trim().equals("")){
            return false;
        }
        if(newDevice.getDataSource().trim().equals("")){
            return false;
        }
        return true;
    }

    /**
     * Prueft ob die "id" des neuen Device schon in der Konfiguration enthalten ist.
     *
     * @param devices
     * @param newDevice
     * @return
     */
    private static boolean isIdUnique(List<Device>devices,Device newDevice){

        for(Device device : devices){
            if(device.getName().trim().equals(newDevice.getName().trim())){
                return false;
            }
        }
        return true;
    }


}
