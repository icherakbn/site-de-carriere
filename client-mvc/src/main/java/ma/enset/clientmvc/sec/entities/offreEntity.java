package ma.enset.clientmvc.sec.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity ()
@Table(name = "offre")
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class offreEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int Id;
    @Column
    private String offre;
    @Column
    private Date date;
    @Column
    private int disabled;
}
