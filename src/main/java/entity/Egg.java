package entity;


import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Egg")
@Table(name = "Eggs")
public class Egg {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Transient
    private LocalDate twoWeeks;
    @Transient
    private LocalDate FiveWeeks;

    @Column(name = "type")
    private String type;

    @Column(name = "collectedDate")
    private String collectedDate;



    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


    public LocalDate generateNextDate(int time) {
        Logger logger = LogManager.getLogger(this.getClass());
        LocalDate localDate = LocalDate.parse(getCollectedDate());
        logger.debug("local date ="+ localDate);
        LocalDate nextTime = localDate.plusDays(time);
        logger.debug("local date ="+ nextTime);
        return nextTime;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
