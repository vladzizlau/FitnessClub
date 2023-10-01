package by.pvt.core.domain;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Subselect("select o.id as id, o.name_room as name, o.id_room as inventoryId, o.cost_per_one_hour as price from guest.office o where o.max_count_people < 15")
@Data
@Entity
@Immutable
public class OfficeSubSelect
    {
    @Id
    private long id;
    private String name;
    private long inventoryId;
    private BigDecimal price;

    }
