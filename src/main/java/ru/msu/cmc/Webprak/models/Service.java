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
@EqualsAndHashCode
@Table(name = "service", schema = "public", catalog = "postgres")
public class Service implements CommonEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;
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

    @NonNull
    @Column(name = "tariff_fee")
    private Long tariffFee;

    @NonNull
    @Column(name = "max_credit")
    private Long maxCredit;
}
