package ru.msu.cmc.Webprak.DAO;public class ServiceDAO {
    private int serviceId;
    private String nameService;
    private int numberOfDevices;
    private float minutes;
    private int sms;
    private float internet;
    private String unlimitedApps;
    private int tariffFee;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getNumberOfDevices() {
        return numberOfDevices;
    }

    public void setNumberOfDevices(int numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public float getMinutes() {
        return minutes;
    }

    public void setMinutes(float minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public float getInternet() {
        return internet;
    }

    public void setInternet(float internet) {
        this.internet = internet;
    }

    public String getUnlimitedApps() {
        return unlimitedApps;
    }

    public void setUnlimitedApps(String unlimitedApps) {
        this.unlimitedApps = unlimitedApps;
    }

    public int getTariffFee() {
        return tariffFee;
    }

    public void setTariffFee(int tariffFee) {
        this.tariffFee = tariffFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceDAO that = (ServiceDAO) o;

        if (serviceId != that.serviceId) return false;
        if (numberOfDevices != that.numberOfDevices) return false;
        if (Float.compare(that.minutes, minutes) != 0) return false;
        if (sms != that.sms) return false;
        if (Float.compare(that.internet, internet) != 0) return false;
        if (tariffFee != that.tariffFee) return false;
        if (nameService != null ? !nameService.equals(that.nameService) : that.nameService != null) return false;
        if (unlimitedApps != null ? !unlimitedApps.equals(that.unlimitedApps) : that.unlimitedApps != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + (nameService != null ? nameService.hashCode() : 0);
        result = 31 * result + numberOfDevices;
        result = 31 * result + (minutes != +0.0f ? Float.floatToIntBits(minutes) : 0);
        result = 31 * result + sms;
        result = 31 * result + (internet != +0.0f ? Float.floatToIntBits(internet) : 0);
        result = 31 * result + (unlimitedApps != null ? unlimitedApps.hashCode() : 0);
        result = 31 * result + tariffFee;
        return result;
    }
}
