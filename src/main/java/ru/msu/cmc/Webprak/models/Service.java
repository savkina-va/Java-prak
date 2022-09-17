package ru.msu.cmc.Webprak.models;

import javax.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "service", schema = "public", catalog = "postgres")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;
    @NonNull
    @Column(name = "name_service")
    private String nameService;

    @NonNull
    @Column(name = "number_of_devices")
    private Long numberOfDevices;
    @NonNull
    @Column(name = "minutes")
    private Double minutes;
    @NonNull
    @Column(name = "sms")
    private Long sms;
    @NonNull
    @Column(name = "internet")
    private Double internet;
    @Column(name = "unlimited_apps")
    private String unlimitedApps;
    @NonNull
    @Column(name = "tariff_fee")
    private Long tariffFee;

//    public int getServiceId() {
//        return serviceId;
//    }
//
//    public void setServiceId(int serviceId) {
//        this.serviceId = serviceId;
//    }
//
//    public String getNameService() {
//        return nameService;
//    }
//
//    public void setNameService(String nameService) {
//        this.nameService = nameService;
//    }
//
//    public int getNumberOfDevices() {
//        return numberOfDevices;
//    }
//
//    public void setNumberOfDevices(int numberOfDevices) {
//        this.numberOfDevices = numberOfDevices;
//    }
//
//    public float getMinutes() {
//        return minutes;
//    }
//
//    public void setMinutes(float minutes) {
//        this.minutes = minutes;
//    }
//
//    public int getSms() {
//        return sms;
//    }
//
//    public void setSms(int sms) {
//        this.sms = sms;
//    }
//
//    public float getInternet() {
//        return internet;
//    }
//
//    public void setInternet(float internet) {
//        this.internet = internet;
//    }
//
//    public String getUnlimitedApps() {
//        return unlimitedApps;
//    }
//
//    public void setUnlimitedApps(String unlimitedApps) {
//        this.unlimitedApps = unlimitedApps;
//    }
//
//    public int getTariffFee() {
//        return tariffFee;
//    }
//
//    public void setTariffFee(int tariffFee) {
//        this.tariffFee = tariffFee;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service that = (Service) o;
        return Objects.equals(serviceId, that.serviceId)
                && numberOfDevices.equals(that.numberOfDevices)
                && Double.compare(that.minutes, minutes) == 0
                && sms.equals(that.sms)
                && Double.compare(that.internet, internet) == 0
                && tariffFee.equals(that.tariffFee)
                && Objects.equals(nameService, that.nameService)
                && Objects.equals(unlimitedApps, that.unlimitedApps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, nameService, numberOfDevices, minutes, sms, internet, unlimitedApps, tariffFee);
    }
}
