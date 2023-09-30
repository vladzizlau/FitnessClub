package by.pvt.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "guest", name = "post")
public class Posts {
    @Id
    @GeneratedValue
    long id;
    long client_id;
    long id_office;
    LocalDate post_data;
    Time post_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "post_user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "post_office_id")
    private Office office;

    public Posts(long client_id, long id_office, LocalDate post_data, Time post_time) {
        this.client_id = client_id;
        this.id_office = id_office;
        this.post_data = post_data;
        this.post_time = post_time;
    }
}
